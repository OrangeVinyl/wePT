package org.encore.apartment.community.domain.admin.data.repository;

import org.encore.apartment.community.domain.admin.data.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	//기능 1: 사용자 거주 아파트의 관리실 전화번호 조회
	@Query("SELECT adminContactNumber FROM Admin WHERE apartment=:apartmentId")
	String findAdminContactNumberByApartmentId(@Param("apartmentId") Integer apartmentId);
}
