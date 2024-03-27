package org.encore.apartment.community.domain.auth.service;

import org.encore.apartment.community.domain.auth.dto.SignInRequestDto;
import org.encore.apartment.community.domain.auth.dto.SignInResponseDto;
import org.encore.apartment.community.domain.auth.dto.entity.UserRefreshToken;
import org.encore.apartment.community.domain.security.provider.TokenProvider;
import org.encore.apartment.community.domain.auth.repository.UserRefreshTokenRepository;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;

	private final UserRefreshTokenRepository userRefreshTokenRepository;

	private final PasswordEncoder encoder;

	private final TokenProvider tokenProvider;

	@Transactional
	public SignInResponseDto signIn(SignInRequestDto request) {
		User member =  userRepository.findByUserId(request.userId())
				.filter(it -> encoder.matches(request.userPassword(), it.getUserPassword()))
				.orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

		String accessToken = tokenProvider.createAccessToken(String.format("%s:%s", member.getUserId(), member.getUserType()));
		String refreshToken = tokenProvider.createRefreshToken();

		// 리프레시 토큰이 이미 있으면 토큰을 갱신하고 없으면 토큰을 추가
		userRefreshTokenRepository.findById(member.getUserIdx())
			.ifPresentOrElse(
				it -> it.updateRefreshToken(refreshToken),
				() -> userRefreshTokenRepository.save(new UserRefreshToken(member, refreshToken))
			);

		return new SignInResponseDto(member.getUserIdx(), member.getUserId(), member.getUserType(), accessToken, refreshToken);
	}


	@Transactional
	public void signOut(String accessToken) {
		String userId = tokenProvider.validateTokenAndGetSubject(accessToken).split(":")[0];
		log.info("==== signOut userId: {}", userId);

		// 사용자를 가져와서 사용자의 idx를 얻기
		User user = userRepository.findByUserId(userId)
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

		// 사용자와 연관된 리프레시 토큰을 삭제
		userRefreshTokenRepository.deleteByUserIdx(user.getUserIdx());
	}
}
