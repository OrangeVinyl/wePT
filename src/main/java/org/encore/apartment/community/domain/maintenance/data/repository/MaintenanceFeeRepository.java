package org.encore.apartment.community.domain.maintenance.data.repository;

import java.util.Date;
import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaintenanceFeeRepository extends JpaRepository<MaintenanceFee, Date> {

	//당월 관리비 조회
	@Query("SELECT m FROM MaintenanceFee m where m.user.userIdx = :userIdx ")
	MaintenanceFee findMaintenanceFeeByUserIdx(@Param("userIdx") Long userIdx);
	//public MaintenanceFee findByUserIdx(Long userIdx);

	// - - 관리비 조회 - 관리비 받아오기
	//public MaintenanceFee saveMaintenanceFee(String userId);

	//관리비 내역별 비중 조회
	@Query("SELECT m FROM MaintenanceFee m WHERE m.user.userIdx = :userIdx")
	MaintenanceFee findByPaymentDate(@Param("userId") String userId);

	//관리비 증감액 비교
	@Query("SELECT m FROM MaintenanceFee m ORDER BY m.paymentDate DESC")
	List<MaintenanceFee> findByOrderByPaymentDateDesc();

}
