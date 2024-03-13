package org.encore.apartment.community.domain.user.data.dto;

import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private String userId;

	@NotNull
	private String userPassword;

	@NotNull
	private String userNickname;

	@NotNull
	@Email
	private String userEmail;

	@NotNull
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다.")
	private String userMobile;

	@NotNull
	private Integer userBuildingNumber;

	@NotNull
	private Integer userHouseNumber;

	@NotNull
	private Boolean userHeadHouseHoldYn;

	public static User toEntity(UserDto userDto) {
		return User.builder()
					.userId(userDto.getUserId())
					.userPassword(userDto.getUserPassword())
					.userNickname(userDto.getUserNickname())
					.userEmail(userDto.getUserEmail())
					.userMobile(userDto.getUserMobile())
					.userBuildingNumber(userDto.getUserBuildingNumber())
					.userHouseNumber(userDto.getUserHouseNumber())
					.userHeadHouseHoldYn(userDto.getUserHeadHouseHoldYn())
					.build();
	}
}
