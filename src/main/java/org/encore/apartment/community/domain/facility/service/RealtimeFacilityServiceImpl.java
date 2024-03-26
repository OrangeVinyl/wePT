package org.encore.apartment.community.domain.facility.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;
import org.encore.apartment.community.domain.facility.data.entity.RealtimeFacility;
import org.encore.apartment.community.domain.facility.data.repository.RealtimeFacilityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("realtimefacility")
@RequiredArgsConstructor
public class RealtimeFacilityServiceImpl implements RealtimeFacilityService {

    private final RealtimeFacilityRepository realtimeFacilityRepository;
    private final LogServiceImpl logService;
    private final FacilityServiceImpl facilityService;

    // 전체 시설의 사용자 수 조회
    @Override
    public List<RealtimeFacilityDto> userCnt(){
        List<RealtimeFacility> list = realtimeFacilityRepository.findAll();
        return list.stream().map(RealtimeFacilityDto::new).collect(Collectors.toList());
    }

    // 특정 시설의 사용자 수 조회
    @Override
    public RealtimeFacilityDto userCntFacilityId(Integer realtimeFacilityId){
        RealtimeFacility tmp = realtimeFacilityRepository.findByRealtimeFacilityId(realtimeFacilityId);
        return new RealtimeFacilityDto(tmp);
    }

    //사용자 수 업데이트 (facility_id 지정)
    @Override
    public void updateUserCnt(Integer realtimeFacilityId) {
        Integer nums = logService.readAllByFacilityUsers(realtimeFacilityId).size();
        RealtimeFacility tmp = RealtimeFacility.builder()
                .realtimeFacilityId(realtimeFacilityId)
                .realtimeFacilityCurrentUsers(nums)
                .build();
        realtimeFacilityRepository.save(tmp);
    }

    @Override
    public void updateUserCntAll(){
        List<Integer> facilityId = new ArrayList<>();
        for(FacilityDto facility : facilityService.readAllFacility()){
            if (facility.getFacilityMembershipYn() == true){
                Integer id = facility.getFacilityId();
                facilityId.add(id);
            }
        }

        for (Integer id : facilityId)
            updateUserCnt(id);
    }

}