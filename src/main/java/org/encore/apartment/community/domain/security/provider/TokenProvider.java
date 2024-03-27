package org.encore.apartment.community.domain.security.provider;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.encore.apartment.community.domain.auth.dto.entity.UserRefreshToken;
import org.encore.apartment.community.domain.auth.repository.UserRefreshTokenRepository;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("tokenProvider")
@PropertySource("classpath:jwt.yml")
public class TokenProvider {

	private final String secretKey;
	private final long expirationMinutes;
	private final long refreshExpirationHours;
	private final String issuer;
	private final long reissueLimit;
	private final UserRefreshTokenRepository userRefreshTokenRepository;
	private final UserRepository userRepository;

	private final ObjectMapper objectMapper = new ObjectMapper(); // JWT 역직렬화를 위한 ObjectMapper


	public TokenProvider(
		@Value("${secret-key}") String secretKey,
		@Value("${expiration-minutes}") long expirationMinutes,
		@Value("${refresh-expiration-hours}") long refreshExpirationHours,
		@Value("${issuer}") String issuer,
		UserRefreshTokenRepository userRefreshTokenRepository,
		UserRepository userRepository
	) {
		this.secretKey = secretKey;
		this.expirationMinutes = expirationMinutes;
		this.refreshExpirationHours = refreshExpirationHours;
		this.issuer = issuer;
		this.userRefreshTokenRepository = userRefreshTokenRepository;
		this.userRepository = userRepository;
		reissueLimit = refreshExpirationHours * 60 / expirationMinutes; // 재발급 한도
	}

	/**
	 * JWT 토큰 생성
	 * @param userSpecification - 사용자 정보
	 * HS512 알고리즘을 사용하여 secretKey 를 이용해 서명
	 * setSubject() - JWT 토큰 제목
	 * setIssuer() - JWT 토큰 발급자
	 * setIssuedAt() - JWT 토큰 발급 시간
	 *
	 * @return JWT 토큰
	 */

	public String createAccessToken(String userSpecification) {
		return Jwts.builder()
			.signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName()))
			.setSubject(userSpecification)
			.setIssuer(issuer)
			.setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
			.setExpiration(Date.from(Instant.now().plus(expirationMinutes, ChronoUnit.MINUTES)))
			.compact();
	}

	public String createRefreshToken() {
		return Jwts.builder()
			.signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName()))
			.setIssuer(issuer)
			.setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
			.setExpiration(Date.from(Instant.now().plus(refreshExpirationHours, ChronoUnit.HOURS)))
			.compact();
	}

	/**
	 * JWT 토큰 유효성 검사 및 제목 반환(복호화 함수)
	 * @param token
	 * @return
	 */

	public String validateTokenAndGetSubject(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(secretKey.getBytes())
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

	@Transactional
	public String recreateAccessToken(String oldAccessToken) throws JsonProcessingException {
		String subject = decodeJwtPayloadSubject(oldAccessToken);

		System.out.println("::::::::::::: recreateAccessToken ::::::::::::::");
		System.out.println("subject = " + subject);
		userRefreshTokenRepository.findByUserIdxAndReissueCountLessThan(userRepository.findByUserId(subject.split(":")[0]).get()
				.getUserIdx(), reissueLimit)
			.ifPresentOrElse(
				UserRefreshToken::increaseReissueCount,
				() -> { throw new ExpiredJwtException(null, null, "Refresh token expired."); }
			);


		return createAccessToken(subject);
	}

	@Transactional(readOnly = true)
	public void validateRefreshToken(String refreshToken, String oldAccessToken) throws JsonProcessingException {
		validateAndParseToken(refreshToken);
		String userId = decodeJwtPayloadSubject(oldAccessToken).split(":")[0];
		userRefreshTokenRepository.findByUserIdxAndReissueCountLessThan(userRepository.findByUserId(userId).get()
				.getUserIdx(), reissueLimit)
			.filter(UserRefreshToken -> UserRefreshToken.validateRefreshToken(refreshToken))
			.orElseThrow(() -> new ExpiredJwtException(null, null, "Refresh token expired."));
	}

	private Jws<Claims> validateAndParseToken(String token) throws JsonProcessingException {	// validateTokenAndGetSubject 에서 따로 분리
		return Jwts.parserBuilder()
			.setSigningKey(secretKey.getBytes())
			.build()
			.parseClaimsJws(token);
	}

	private String decodeJwtPayloadSubject(String oldAccessToken) throws JsonProcessingException {
		return objectMapper.readValue(
			new String(Base64.getDecoder().decode(oldAccessToken.split("\\.")[1]), StandardCharsets.UTF_8),
			Map.class
		).get("sub").toString();
	}
}
