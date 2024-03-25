package org.encore.apartment.community.domain.maintenance.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;
import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaintenanceFeeRepository extends JpaRepository<MaintenanceFee, MaintenanceFeeId> {
	@Query("SELECT generalMaintenanceFee FROM MaintenanceFee m WHERE userIdx=:userIdx")
	Integer findGeneralMaintenanceFeeByUserIdx(@Param("userIdx") Long userIdx);

	@Query("SELECT m FROM MaintenanceFee m ORDER BY m.paymentDate DESC")
	List<MaintenanceFee> findByOrderByPaymentDateDesc();
}
