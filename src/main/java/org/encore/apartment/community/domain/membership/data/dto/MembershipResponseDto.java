package org.encore.apartment.community.domain.membership.data.dto;

import java.time.LocalDateTime;

import org.encore.apartment.community.domain.membership.data.entity.Membership;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembershipResponseDto {
	private Long membershipId;
	private Long userIdx;
	private LocalDateTime membershipJoinDate;
	private LocalDateTime membershipExpiredDate;

	private String userId;
	private String userNickname;

	public MembershipResponseDto(Membership params, String userId, String userNickname) {
		this.membershipId = params.getMembershipId();
		this.userIdx = params.getUser().getUserIdx();
		this.membershipJoinDate = params.getMembershipJoinDate();
		this.membershipExpiredDate = params.getMembershipExpiredDate();
		this.userId = userId;
		this.userNickname = userNickname;
	}
}
