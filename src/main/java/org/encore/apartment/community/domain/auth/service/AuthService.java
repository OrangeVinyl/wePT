package org.encore.apartment.community.domain.auth.service;

import static java.lang.String.*;

import org.encore.apartment.community.domain.auth.dto.SignInRequestDto;
import org.encore.apartment.community.domain.auth.dto.SignInResponseDto;
import org.encore.apartment.community.domain.security.provider.TokenProvider;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;

	private final PasswordEncoder encoder;

	private final TokenProvider tokenProvider;

	@Transactional(readOnly = true)
	public SignInResponseDto signIn(SignInRequestDto request) {
		User member =  userRepository.findByUserId(request.userId())
				.filter(it -> encoder.matches(request.userPassword(), it.getUserPassword()))
				.orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

		String token = tokenProvider.createToken(String.format("%s", member.getUserId()));

		return new SignInResponseDto(member.getUserIdx(), member.getUserId(), valueOf(member.getUserType()), token);
	}
}