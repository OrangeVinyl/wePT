package org.encore.apartment.community.domain.user.data.dto.user;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.user.data.entity.User;

import lombok.Data;

@Data
public class ResponseUserDto {
	private Long userIdx;
	private String userId;
	private String userNickname;
	private String userEmail;
	private String userMobile;
	private Integer userBuildingNumber;
	private Integer userHouseNumber;
	private Boolean userHeadHouseHoldYn;

	private Long apartmentId;
	private String apartmentName;
	private String apartmentAddress;

	public ResponseUserDto(User user) {
		this.userIdx = user.getUserIdx();
		this.userId = user.getUserId();
		this.userNickname = user.getUserNickname();
		this.userEmail = user.getUserEmail();
		this.userMobile = user.getUserMobile();
		this.userBuildingNumber = user.getUserBuildingNumber();
		this.userHouseNumber = user.getUserHouseNumber();
		this.userHeadHouseHoldYn = user.getUserHeadHouseHoldYn();
	}

	public void setApartmentInfo(Apartment apartment) {
		this.apartmentId = apartment.getApartmentId();
		this.apartmentName = apartment.getApartmentName();
		this.apartmentAddress = apartment.getApartmentAddress();
	}
}
