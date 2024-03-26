package org.encore.apartment.community.domain.facility.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.encore.apartment.community.domain.facility.data.entity.Facility;
import org.encore.apartment.community.domain.facility.data.entity.RealtimeFacility;

@Getter
@Setter
public class RealtimeFacilityDto {

    //facility facility_id
    @NotNull
    private Integer realtimeFacilityId;

    @NotNull
    private Integer realtimeFacilityCurrentUsers;

    public static RealtimeFacility toEntity(RealtimeFacilityDto realtimeFacilityDto) {
        return RealtimeFacility.builder()
                .realtimeFacilityId(realtimeFacilityDto.getRealtimeFacilityId())
                .realtimeFacilityCurrentUsers(realtimeFacilityDto.getRealtimeFacilityCurrentUsers())
                .build();
    }

    public RealtimeFacilityDto(RealtimeFacility realtimeFacility) {
        this.realtimeFacilityId = realtimeFacility.getRealtimeFacilityId();
        this.realtimeFacilityCurrentUsers = realtimeFacility.getRealtimeFacilityCurrentUsers();
    }
}