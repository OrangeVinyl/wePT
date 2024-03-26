package org.encore.apartment.community.domain.facility.data.repository;


import org.encore.apartment.community.domain.facility.data.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{
    public List<Log> findAllByLogFacilityId(Integer facilityId);

    public List<Log> findAllByLogUserId(String userId);
}