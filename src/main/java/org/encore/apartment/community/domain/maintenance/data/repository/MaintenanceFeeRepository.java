package org.encore.apartment.community.domain.maintenance.data.repository;

import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceFeeRepository extends JpaRepository<MaintenanceFee, Long> {

}
