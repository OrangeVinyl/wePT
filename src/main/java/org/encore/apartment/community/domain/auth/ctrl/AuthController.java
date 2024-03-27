package org.encore.apartment.community.domain.auth.ctrl;

import java.util.Optional;

import org.encore.apartment.community.domain.auth.dto.SignInRequestDto;
import org.encore.apartment.community.domain.auth.dto.SignInResponseDto;
import org.encore.apartment.community.domain.auth.service.AuthService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

	private final AuthService authService;

	@Operation(summary = "로그인")
	@PostMapping("/sign-in")
	public ApiResponse<SignInResponseDto> signIn(@RequestBody SignInRequestDto params) {
		log.info("==== AuthController signIn() params: {}", params);
		return ApiResponse.createSuccess(authService.signIn(params));
	}

	@Operation(summary = "로그아웃")
	@GetMapping("/sign-out")
	public ApiResponse<?> signOut(HttpServletRequest request){
		log.info("==== AuthController signOut() : {}", request);
		String accessToken = parseBearerToken(request);
		log.info("accessToken = {}", accessToken);

		authService.signOut(accessToken);
		return ApiResponse.createSuccessWithNoContent();
	}

	private static String parseBearerToken(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
			.filter(token -> token.substring(0, 7).equalsIgnoreCase("Bearer "))
			.map(token -> token.substring(7))
			.orElse(null);
	}
}
