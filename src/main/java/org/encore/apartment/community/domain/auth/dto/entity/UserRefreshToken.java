package org.encore.apartment.community.domain.auth.dto.entity;

import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
@Entity
public class UserRefreshToken {

	@Id
	private Long userIdx;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "user_idx")
	private User user;

	private String refreshToken;

	private int reissueCount = 0;

	public UserRefreshToken(User user, String refreshToken) {
		this.user = user;
		this.refreshToken = refreshToken;
	}

	public void updateRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public boolean validateRefreshToken(String refreshToken) {
		return this.refreshToken.equals(refreshToken);
	}

	public void increaseReissueCount() {
		this.reissueCount++;
	}
}