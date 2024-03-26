package org.encore.apartment.community.domain.user.data.dto.membership;

import java.time.LocalDateTime;

import org.encore.apartment.community.domain.user.data.entity.Membership;
import org.encore.apartment.community.domain.user.data.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseMembershipDto {
	private Long membershipId;
	private Long userIdx;
	private LocalDateTime membershipJoinDate;
	private LocalDateTime membershipExpiredDate;

	private String userId;
	private String userNickname;

	public ResponseMembershipDto(Membership params, String userId, String userNickname) {
		this.membershipId = params.getMembershipId();
		this.userIdx = params.getUser().getUserIdx();
		this.membershipJoinDate = params.getMembershipJoinDate();
		this.membershipExpiredDate = params.getMembershipExpiredDate();
		this.userId = userId;
		this.userNickname = userNickname;
	}
}
