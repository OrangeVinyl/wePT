package org.encore.apartment.community.domain.user.data.dto.user;

import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class RequestUserDto {

	@NotBlank
	private String userId;

	@NotBlank
	private String userPassword;

	@NotBlank
	private String userNickname;

	@Email
	private String userEmail;

	@NotBlank
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다.")
	private String userMobile;

	@NotNull
	private Integer userBuildingNumber;

	@NotNull
	private Integer userHouseNumber;

	@NotNull
	private Boolean userHeadHouseHoldYn;

	private Long apartmentId;

	public static User toEntity(RequestUserDto requestUserDto) {
		return User.builder()
					.userId(requestUserDto.getUserId())
					.userPassword(requestUserDto.getUserPassword())
					.userNickname(requestUserDto.getUserNickname())
					.userEmail(requestUserDto.getUserEmail())
					.userMobile(requestUserDto.getUserMobile())
					.userBuildingNumber(requestUserDto.getUserBuildingNumber())
					.userHouseNumber(requestUserDto.getUserHouseNumber())
					.userHeadHouseHoldYn(requestUserDto.getUserHeadHouseHoldYn())
					.build();
	}
}
