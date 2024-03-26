package org.encore.apartment.community.domain.facility.ctrl;

import jakarta.annotation.Resource;
import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.service.FacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/facility")
public class FacilityController {

    @Resource(name = "facility")
    private FacilityService service;

    // ㅅㅣ설 추가 (관리자용) 혹시 몰라서 생성해둠 & 테스트용
    @PostMapping(value = "/add-facility", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FacilityDto> createFacility(@RequestBody FacilityDto params) 	{
        service.createFacility(params);

        return new ResponseEntity<FacilityDto>(HttpStatus.OK);
    }

    // 모든 시설 출력 (entity to dto)
    @GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FacilityDto>> readAllFacility() {
        List<FacilityDto> list = service.readAllFacility();
        return new ResponseEntity<List<FacilityDto>>(list, HttpStatus.OK);
    }
}