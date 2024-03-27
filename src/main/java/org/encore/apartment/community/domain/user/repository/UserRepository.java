package org.encore.apartment.community.domain.user.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserId(String userId);

	@Query("SELECT apartment FROM User U WHERE userId=:userId")
	Integer findApartmentIdByUserId(@Param("userId") String userId);

	@Query("SELECT userIdx FROM User U WHERE userId=:userId")
	Long findUserIdxByUserId(@Param("userId") String userId);
}
