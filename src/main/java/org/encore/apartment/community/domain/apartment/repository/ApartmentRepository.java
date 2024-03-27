package org.encore.apartment.community.domain.apartment.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

	@Modifying
	@Query("UPDATE Apartment a SET a.apartmentName = :apartmentName, a.apartmentAddress = :apartmentAddress, a.apartmentTotalHousehold = :apartmentTotalHousehold WHERE a.apartmentId = :apartmentId")
	void update(Long apartmentId, String apartmentName, String apartmentAddress, Integer apartmentTotalHousehold);
}
