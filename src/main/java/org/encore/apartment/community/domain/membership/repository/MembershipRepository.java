package org.encore.apartment.community.domain.membership.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.membership.data.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

	@Transactional
	@Query("SELECT m FROM Membership m WHERE m.user.userIdx = :userIdx")
	Optional<Membership> findByUserIdx(Long userIdx);

	@Transactional
	@Modifying
	@Query("DELETE FROM Membership m WHERE m.user.userIdx = :userIdx")
	void deleteByUserIdx(Long userIdx);
}
