package org.encore.apartment.community.domain.auth.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.auth.dto.entity.UserRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshToken, Long> {
	Optional<UserRefreshToken> findByUserIdxAndReissueCountLessThan(Long userIdx, long reissueCount);

	void deleteByUserIdx(Long userIdx);
}
