package org.encore.apartment.community.domain.membership.data.entity;

import java.time.LocalDateTime;

import org.encore.apartment.community.domain.user.data.entity.User;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membership_id")
	private Long membershipId;

	@Column(name = "membership_join_date", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime membershipJoinDate;

	@Column(name = "membership_expired_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private LocalDateTime membershipExpiredDate;

	@Setter
	@OneToOne
	@JoinColumn(name = "user_idx", nullable = false) // User 엔티티의 userIdx와 매핑
	private User user;

	public Membership() {
		this.membershipJoinDate = LocalDateTime.now();
		this.membershipExpiredDate = this.membershipJoinDate.plusYears(1);
	}

	@Builder
	public Membership(LocalDateTime membershipJoinDate) {
		this.membershipJoinDate = membershipJoinDate;
		this.membershipExpiredDate = membershipJoinDate.plusYears(1); // membershipJoinDate로부터 1년 후로 설정
	}


	public void updateMembershipDate(LocalDateTime updateDate) {
		this.membershipJoinDate = updateDate;
		this.membershipExpiredDate = updateDate.plusYears(1);
	}

}
