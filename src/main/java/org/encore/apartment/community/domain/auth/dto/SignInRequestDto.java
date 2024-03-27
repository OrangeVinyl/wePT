package org.encore.apartment.community.domain.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInRequestDto(
	@Schema(description = "회원 아이디", example = "wept7Tester")
	String userId,
	@Schema(description = "회원 비밀번호", example = "test1234")
	String userPassword
) {
}
