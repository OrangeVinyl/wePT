package org.encore.apartment.community.domain.facility.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RealtimeFacility {

    @Id //facility tbl에 facility_id와 함께
    @Column(name = "realtime_facility_id", nullable = false)
    private Integer realtimeFacilityId;

    @Column(name = "realtime_facility_current_users", nullable = false)
    private Integer realtimeFacilityCurrentUsers;

    @Builder
    public RealtimeFacility(
            Integer realtimeFacilityId,
            Integer realtimeFacilityCurrentUsers
    ){
        this.realtimeFacilityId = realtimeFacilityId;
        this.realtimeFacilityCurrentUsers = realtimeFacilityCurrentUsers;
    }
}