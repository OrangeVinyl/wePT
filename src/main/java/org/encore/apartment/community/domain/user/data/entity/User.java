package org.encore.apartment.community.domain.user.data.entity;

import java.time.LocalDateTime;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.user.data.dto.user.UpdateRequestUserDto;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_idx")
	private Long userIdx;

	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;

	@Column(name = "user_password", nullable = false)
	private String userPassword;

	@Column(name = "user_nickname", nullable = false)
	private String userNickname;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_mobile", unique = true, nullable = false)
	private String userMobile;

	@Column(name = "user_building_number", nullable = false)
	private Integer userBuildingNumber;

	@Column(name = "user_house_number", nullable = false)
	private Integer userHouseNumber;

	@Column(name = "user_head_household_yn", nullable = false, columnDefinition = "boolean default true")
	@ColumnDefault("true")
	private Boolean userHeadHouseHoldYn;

	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@Column(name = "delete_yn", columnDefinition = "boolean default false")
	private Boolean deleteYn;

	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	private Apartment apartment;

	@Builder
	public User(
		String userId, String userPassword, String userNickname, String userEmail, String userMobile,
		Integer userBuildingNumber, Integer userHouseNumber, Boolean userHeadHouseHoldYn, LocalDateTime createdAt,
		LocalDateTime updatedAt, Boolean deleteYn) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userBuildingNumber = userBuildingNumber;
		this.userHouseNumber = userHouseNumber;
		this.userHeadHouseHoldYn = userHeadHouseHoldYn;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deleteYn = deleteYn;
	}

	public void update(UpdateRequestUserDto params) {
		this.userNickname = params.getUserNickname();
		this.userEmail = params.getUserEmail();
		this.userMobile = params.getUserMobile();

		this.updatedAt = LocalDateTime.now();
	}

	public void updateDeleteYn() {
		this.deleteYn = true;
		this.updatedAt = LocalDateTime.now();
	}
}
