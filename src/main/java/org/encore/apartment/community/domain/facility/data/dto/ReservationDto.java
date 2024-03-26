package org.encore.apartment.community.domain.facility.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.encore.apartment.community.domain.facility.data.entity.Reservation;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationDto {
    @NotNull
    private Integer reservationId;

    @NotNull
    private String reservationUserId;

    @NotNull
    private Integer reservationFacilityId;

    @NotNull
    private Date reservationStartTime;

    @NotNull
    private Date reservationEndTime;

    @NotNull
    private Integer reservationHeadcount;

    @Builder
    public static Reservation toEntity(ReservationDto reservationDto) {
        return Reservation.builder()
                .reservationId(reservationDto.getReservationId())
                .reservationUserId(reservationDto.getReservationUserId())
                .reservationFacilityId(reservationDto.getReservationFacilityId())
                .reservationStartTime(reservationDto.getReservationStartTime())
                .reservationEndTime(reservationDto.getReservationEndTime())
                .reservationHeadcount(reservationDto.getReservationHeadcount())
                .deleteYn(false)
                .build();
    }//

    @Builder
    public ReservationDto(Reservation reservation) {
        this.reservationId = reservation.getReservationId();
        this.reservationUserId = reservation.getReservationUserId();
        this.reservationFacilityId = reservation.getReservationFacilityId();
        this.reservationStartTime = reservation.getReservationStartTime();
        this.reservationEndTime = reservation.getReservationEndTime();
        this.reservationHeadcount = reservation.getReservationHeadcount();
    }
}

/*
reservation_id
reservation_user_id
reservation_facility_id
reservation_start_time
reservation_end_time
 */
