package org.encore.apartment.community.domain.facility.data.repository;

import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;
import org.encore.apartment.community.domain.facility.data.entity.Facility;
import org.encore.apartment.community.domain.facility.data.entity.RealtimeFacility;
import org.encore.apartment.community.domain.facility.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealtimeFacilityRepository extends JpaRepository<RealtimeFacility, Integer> {
    public List<RealtimeFacility> findAllByRealtimeFacilityId(Integer realtimeFacilityId);
    public RealtimeFacility findByRealtimeFacilityId(Integer realtimeFacilityId);
}
