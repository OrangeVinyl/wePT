package org.encore.apartment.community.domain.facility.service;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    // 예약서 작성 (예약 추가)
    public void createReservation(ReservationDto params);

    //전체 예약목록 확인
    public List<ReservationDto> readAllReservation();

    //예약서 조회(본인의 갓만 확인 가능)
    public List<ReservationDto> readMyReservation(String reservationUserId);

    //본인 에약목록 삭제 (deleteYn update)
    public void deleteReservation(String reservationUserId);
}
