package org.encore.apartment.community.domain.user.data.dto;

import org.encore.apartment.community.domain.user.common.UserType;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequestDto {

	@NotBlank
	@Schema(description = "회원 아이디", example = "wept7Tester")
	private String userId;

	@NotBlank
	@Schema(description = "회원 비밀번호", example = "test1234")
	private String userPassword;

	@NotBlank
	@Schema(description = "회원 닉네임", example = "테스터")
	private String userNickname;

	@Email
	@NotBlank
	@Schema(description = "회원 이메일", example = "wept7777@google.com")
	private String userEmail;

	@NotBlank
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다.")
	@Schema(description = "회원 전화번호", example = "010-7381-2945")
	private String userMobile;

	@NotNull
	@Schema(description = "회원 건물번호", example = "101")
	private Integer userBuildingNumber;

	@NotNull
	@Schema(description = "회원 호수", example = "901")
	private Integer userHouseNumber;

	@NotNull
	@Schema(description = "대표세대주 여부", example = "true")
	private Boolean userHeadHouseHoldYn;

	@Schema(description = "아파트 ID", example = "9")
	private Long apartmentId;

	public static User toEntity(UserRequestDto userRequestDto, PasswordEncoder encoder) {
		return User.builder()
					.userId(userRequestDto.getUserId())
					.userPassword(encoder.encode(userRequestDto.getUserPassword()))
					.userNickname(userRequestDto.getUserNickname())
					.userEmail(userRequestDto.getUserEmail())
					.userMobile(userRequestDto.getUserMobile())
					.userBuildingNumber(userRequestDto.getUserBuildingNumber())
					.userHouseNumber(userRequestDto.getUserHouseNumber())
					.userHeadHouseHoldYn(userRequestDto.getUserHeadHouseHoldYn())
					.userType(UserType.MEMBER)
					.build();
	}
}
