package org.encore.apartment.community.domain.facility.ctrl;


import jakarta.annotation.Resource;
import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;
import org.encore.apartment.community.domain.facility.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/reservation")
public class ReservationController {
    // 작성, 조회, 삭제

    @Resource(name = "reservation")
    private ReservationService service;

    //예약서 작성
    @PostMapping(value = "/add-reservation", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto params) {
        service.createReservation(params);

        return new ResponseEntity<ReservationDto>(HttpStatus.OK);
    }

    //전체 예약목록 확인
    @GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ReservationDto>> readAllReservation() {
        List<ReservationDto> list = service.readAllReservation();
        return new ResponseEntity<List<ReservationDto>>(list, HttpStatus.OK);
    }

    //본인 예약목록 확인
    @GetMapping(value = "/myinfo/{reservationUserId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ReservationDto>> readMyReservation(@PathVariable("reservationUserId") String reservationUserId ) {
        List<ReservationDto> list = service.readMyReservation(reservationUserId);
        return new ResponseEntity<List<ReservationDto>>(list, HttpStatus.OK);
    }

    //본인 에약목록 삭제 (deleteYn update)
    @PostMapping(value = "/delete/{reservationUserId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMyReservation(@PathVariable("reservationUserId") String reservationUserId){
        service.deleteReservation(reservationUserId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
