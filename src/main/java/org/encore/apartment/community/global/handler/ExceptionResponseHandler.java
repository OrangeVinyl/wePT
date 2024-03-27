package org.encore.apartment.community.global.handler;


import java.util.NoSuchElementException;

import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice(basePackages = "org.encore.apartment.community")
public class ExceptionResponseHandler {
	@ExceptionHandler({IllegalArgumentException.class, NoSuchElementException.class})
	public ResponseEntity<ApiResponse<?>> handleCommonException(Exception e) {
		return ResponseEntity.badRequest().body(ApiResponse.createError(e.getMessage()));
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponse<?>> handleAccessDeniedException() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.createError("접근이 거부되었습니다."));
	}

	// @ExceptionHandler(Exception.class)
	// public ResponseEntity<ApiResponse<?>> handleUnexpectedException() {
	// 	return ResponseEntity.internalServerError().body(ApiResponse.createError("서버에 문제가 발생했습니다."));
	// }

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<ApiResponse<?>> handleDuplicatedUserException(RuntimeException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.createError(exception.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<?>> handleValidationExceptions(BindingResult bindingResult) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.createFail(bindingResult));
	}

	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<ApiResponse<?>> handleSignatureException() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("토큰이 유효하지 않습니다."));
	}

	@ExceptionHandler(MalformedJwtException.class)
	public ResponseEntity<ApiResponse<?>> handleMalformedJwtException() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("올바르지 않은 토큰입니다."));
	}

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<ApiResponse<?>> handleExpiredJwtException() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.createError("토큰이 만료되었습니다. 다시 로그인해주세요."));
	}
}
