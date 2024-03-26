package org.encore.apartment.community.domain.facility.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;
import org.encore.apartment.community.domain.facility.data.entity.Reservation;
import org.encore.apartment.community.domain.facility.data.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service("reservation")
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    // 작성, 조회, 삭제

    private final ReservationRepository reservationRepository;

    //ㅇㅖ약서 작성 (추가)
    @Override
    public void createReservation(ReservationDto params){
        Reservation reservation = ReservationDto.toEntity(params);
        reservationRepository.save(reservation);
        log.info("facility saved : {}", reservation);
    }

    //에약서 조회(전체, 관리자용)
    @Override
    public List<ReservationDto> readAllReservation(){
        List<Reservation> list = reservationRepository.findAll();
        List<Reservation> result = new ArrayList<>();
        for (Reservation res : list){
            if (res.getDeleteYn() == false)
                result.add(res);
        }
        return result.stream().map(ReservationDto::new).collect(Collectors.toList());
    }

    //예약서 조회(본인의 갓만 확인 가능)
    //reservation user id(string)으로 검색
    public List<ReservationDto> readMyReservation(String reservationUserId){
        List<Reservation> list = reservationRepository.findAllByReservationUserId(reservationUserId);
        List<Reservation> result = new ArrayList<>();;
        for (Reservation res : list){
            if (res.getDeleteYn() == false)
                result.add(res);
        }
        return result.stream().map(ReservationDto::new).collect(Collectors.toList());
    }


    //예약서 삭제 (id 확인 && reservationStartTime이 현재 시간 이전인 경우 확인 필요)
    // 엥 여러개면 어쩌지?
    public void deleteReservation(String reservationUserId){
        List<Reservation> list = reservationRepository.findAllByReservationUserId(reservationUserId);
        List<Reservation> result = new ArrayList<>();
        for (Reservation res : list){
            if (res.getDeleteYn() == false)
                result.add(res);
        }
        for (Reservation res : result){
            LocalDateTime starttime = res.getReservationStartTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            if (starttime.isAfter(LocalDateTime.now())){
                Reservation input = Reservation.builder()
                        .reservationId(res.getReservationId())
                        .reservationUserId(res.getReservationUserId())
                        .reservationFacilityId(res.getReservationId())
                        .reservationStartTime(res.getReservationStartTime())
                        .reservationEndTime(res.getReservationEndTime())
                        .reservationHeadcount(res.getReservationHeadcount())
                        .deleteYn(true)
                        .build();
                reservationRepository.save(input);
            }
        }
    }
}
