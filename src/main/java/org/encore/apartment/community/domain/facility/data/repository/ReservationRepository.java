package org.encore.apartment.community.domain.facility.data.repository;

import org.encore.apartment.community.domain.facility.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    //reservation_user_id(user_id)로 본인 예약 찾기 (완전 id가 동일해야함)
    public List<Reservation> findAllByReservationUserId(String userId);
}
