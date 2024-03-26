package org.encore.apartment.community.domain.facility.data.repository;

import org.encore.apartment.community.domain.facility.data.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {

}