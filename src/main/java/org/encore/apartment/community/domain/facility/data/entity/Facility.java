package org.encore.apartment.community.domain.facility.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Facility {

    @Id
    @Column(name = "facility_id", nullable = false)
    private Integer facilityId;

    @Column(name = "facility_name", nullable = false)
    private String facilityName;

    @Column(name = "facility_operating_time", nullable = false)
    private Integer facilityOperatingTime;

    @Column(name = "facility_membership_yn", nullable = false)
    private Boolean facilityMembershipYn;

    @Column(name = "facility_fee", nullable = false)
    private Integer facilityFee;

    @Column(name = "facility_reservation_availble_time")
    private Integer facilityReservationAvailbleTime;

    @Builder
    public Facility(
            Integer facilityId,
            String facilityName,
            Integer facilityOperatingTime,
            Boolean facilityMembershipYn,
            Integer facilityFee,
            Integer facilityReservationAvailbleTime
    ){
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityOperatingTime = facilityOperatingTime;
        this.facilityMembershipYn = facilityMembershipYn;
        this.facilityFee = facilityFee;
        this.facilityReservationAvailbleTime = facilityReservationAvailbleTime;
    }
}
