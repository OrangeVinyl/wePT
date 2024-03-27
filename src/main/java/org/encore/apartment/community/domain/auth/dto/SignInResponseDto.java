package org.encore.apartment.community.domain.auth.dto;

import org.encore.apartment.community.domain.user.common.UserType;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInResponseDto(
	@Schema(description = "회원 고유 키", example = "41")
	Long userIdx,
	@Schema(description = "회원 아이디", example = "SignTester")
	String userId,
	@Schema(description = "회원 유형", example = "USER")
	UserType userType,
	String accessToken,
	String refreshToken
) {
}
