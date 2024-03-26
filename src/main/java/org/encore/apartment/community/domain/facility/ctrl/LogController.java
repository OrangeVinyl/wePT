package org.encore.apartment.community.domain.facility.ctrl;

import jakarta.annotation.Resource;
import org.encore.apartment.community.domain.facility.data.dto.LogDto;
import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;
import org.encore.apartment.community.domain.facility.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/log")
public class LogController {

    @Resource(name = "log")
    private LogService service;

    //추가 (exit_time = null) -> userID & facilityID 필요
    @PostMapping(value = "/entry/{facilityId}/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> createReservation(@PathVariable("facilityId") String facilityId, @PathVariable("userId") String userId) {
        service.addLog(Integer.parseInt(facilityId), userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //조회 (전체 확인용)
    @GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<LogDto>> readAllLog() {
        List<LogDto> list = service.readAllLog();
        return new ResponseEntity<List<LogDto>>(list, HttpStatus.OK);
    }

    //시설 아이디로 조회 (들어가 있는 사람 조회)(exit_time = null)
    @GetMapping(value = "/info-facility/{facilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<LogDto>> readAllByFacilityId(@PathVariable("facilityId") String facilityId) {
        List<LogDto> list = service.readAllByFacilityUsers(Integer.parseInt(facilityId));
        return new ResponseEntity<List<LogDto>>(list, HttpStatus.OK);
    }

    //사용자 아이디로 조회 (exit_time = null) 만약 dto가 1개 이상 출력되면 오류(중복 입장)
    @GetMapping(value = "/info-user/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<LogDto>> readAllByUsers(@PathVariable("userId") String userId) {
        List<LogDto> list = service.readAllByUsers(userId);
        return new ResponseEntity<List<LogDto>>(list, HttpStatus.OK);
    }

    //수정 (exit_time = sysdate) facility_id
    @PostMapping(value = "/out/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateUserNums(@PathVariable("userId") String userId){
        service.updateUserExit(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
