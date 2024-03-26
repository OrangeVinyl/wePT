package org.encore.apartment.community.domain.facility.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.encore.apartment.community.domain.facility.data.entity.Facility;

@Getter
@Setter
public class FacilityDto {
    @NotNull
    private Integer facilityId;

    @NotNull
    private String facilityName;

    @NotNull
    private Integer facilityOperatingTime;

    @NotNull
    private Boolean facilityMembershipYn;

    @NotNull
    private Integer facilityFee;

    private Integer facilityReservationAvailbleTime;

    public static Facility toEntity(FacilityDto facilityDto) {
        return Facility.builder()
                .facilityId(facilityDto.getFacilityId())
                .facilityName(facilityDto.getFacilityName())
                .facilityOperatingTime(facilityDto.getFacilityOperatingTime())
                .facilityMembershipYn(facilityDto.getFacilityMembershipYn())
                .facilityFee(facilityDto.getFacilityFee())
                .facilityReservationAvailbleTime(facilityDto.getFacilityReservationAvailbleTime())
                .build();
    }

    public FacilityDto(Facility facility) {
        this.facilityId = facility.getFacilityId();
        this.facilityName = facility.getFacilityName();
        this.facilityFee = facility.getFacilityFee();
        this.facilityOperatingTime = facility.getFacilityOperatingTime();
        this.facilityMembershipYn = facility.getFacilityMembershipYn();
        this.facilityReservationAvailbleTime = facility.getFacilityReservationAvailbleTime();
    }
}

/*
facility_id (String)
facility_name
facility_operating_time
facility_membership_yn
facility_fee
facility_reservation_availble_time
 */