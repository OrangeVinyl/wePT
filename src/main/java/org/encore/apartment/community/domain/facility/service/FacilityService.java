package org.encore.apartment.community.domain.facility.service;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;

import java.util.List;

public interface FacilityService {
    public void createFacility(FacilityDto params);

    //전체
    public List<FacilityDto> readAllFacility();
}
