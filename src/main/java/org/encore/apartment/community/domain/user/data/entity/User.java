package org.encore.apartment.community.domain.user.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

@Getter
@Entity
@Table(name = "user_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@Column(name = "user_idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userIdx;

	@ManyToOne
	@JoinColumn(name = "apartment_id")
	private Apartment apartment;

	@NotNull
	@Column(name = "user_id")
	private String userId;

	@NotNull
	@Column(name = "user_password")
	private String userPassword;

	@NotNull
	@Column(name = "user_nickname")
	private String userNickname;

	@NotNull
	@Email
	@Column(name = "user_email")
	private String userEmail;

	@NotNull
	@Column(name =  "user_mobile")
	@Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호는 010-XXXX-XXXX 형식이어야 합니다.")
	private String userMobile;

	@NotNull
	@Column(name = "user_building_number")
	private Integer userBuildingNumber;

	@NotNull
	@Column(name = "user_house_number")
	private Integer userHouseNumber;

	@NotNull
	@Column(name = "user_head_household_yn", columnDefinition = "boolean default true")
	private Boolean userHeadHouseHoldYn;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "delete_yn", columnDefinition = "boolean default false")
	private Boolean deleteYn;

	@Builder

	public User(Long userIdx, Apartment apartment, String userId, String userPassword, String userNickname, String userEmail, String userMobile, Integer userBuildingNumber, Integer userHouseNumber, Boolean userHeadHouseHoldYn, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean deleteYn) {
		this.userIdx = userIdx;
		this.apartment = apartment;
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
}
