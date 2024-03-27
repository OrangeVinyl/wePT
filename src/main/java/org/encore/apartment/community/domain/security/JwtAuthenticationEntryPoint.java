package org.encore.apartment.community.domain.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Spring security 에서 인증과 관련된 예외가 발생했을 떄 이를 처리하기 위한 로직 를 통해 예외 처리
	 * HandlerExceptionResolver 의 빈이 두 종류가 있기 때문에 @Qualifier 를 통해 명시적으로 주입
	 */

	private final HandlerExceptionResolver resolver;

	public JwtAuthenticationEntryPoint(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
		this.resolver = resolver;
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
		// JwtAuthenticationFilter에서 request에 담아서 보내준 예외를 처리
		resolver.resolveException(request, response, null, (Exception) request.getAttribute("exception"));
	}
}
