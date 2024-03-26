package org.encore.apartment.community.domain.facility.service;

import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;

import java.util.List;

public interface RealtimeFacilityService {

    // 전체 시설의 사용자 수 조회
    public List<RealtimeFacilityDto> userCnt();

    // 특정 시설의 사용자 수 조회
    public RealtimeFacilityDto userCntFacilityId(Integer facilityId);

    //사용자 수 업데이트 (특정 시설)
    public void updateUserCnt(Integer facilityId);

    //사용자 수 업데이트 (전체 시설)
    public void updateUserCntAll();
}