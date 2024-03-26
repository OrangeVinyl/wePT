package org.encore.apartment.community.domain.facility.ctrl;

import jakarta.annotation.Resource;
import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;
import org.encore.apartment.community.domain.facility.service.FacilityService;
import org.encore.apartment.community.domain.facility.service.RealtimeFacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/realtimefacility")
public class RealtimeFacilityController {

    @Resource(name = "realtimefacility")
    private RealtimeFacilityService service;

    //기본은 다 0으로 넣어주기
    // 전체 시설의 사용자 수 조회
    @GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RealtimeFacilityDto>> userCnt() {
        List<RealtimeFacilityDto> list = service.userCnt();
        return new ResponseEntity<List<RealtimeFacilityDto>>(list, HttpStatus.OK);
    }

    // 특정 시설 사용자 수 조회
    @GetMapping(value = "/info/{facilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RealtimeFacilityDto> userCnt(@PathVariable("facilityId") String facilityId ) {
        RealtimeFacilityDto dto = service.userCntFacilityId(Integer.parseInt(facilityId));
        return new ResponseEntity<RealtimeFacilityDto>(dto, HttpStatus.OK);
    }

    //사용자수 업데이트 (특정 시설)
    @PostMapping(value = "/update/{realtimeFacilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateByFacilityId(@PathVariable("realtimeFacilityId") String realtimeFacilityId){
        service.updateUserCnt(Integer.parseInt(realtimeFacilityId));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //사용자수 업데이트 (모든 시설)
    @PostMapping(value = "/update-all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateAll(){
        service.updateUserCntAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
