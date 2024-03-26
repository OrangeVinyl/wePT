package org.encore.apartment.community.domain.facility.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.encore.apartment.community.domain.facility.data.entity.Log;

import java.util.Date;

@Getter
@Setter
public class LogDto {

    @NotNull
    private Integer logId;

    @NotNull
    private Date logEntryTime;

    private Date logExitTime;
    @NotNull
    private Integer logFacilityId;
    @NotNull
    private String logUserId;

    public static Log toEntity(LogDto logDto) {
        return Log.builder()
                .logId(logDto.getLogId())
                .logEntryTime(logDto.getLogEntryTime())
                .logExitTime(logDto.getLogExitTime())
                .logFacilityId(logDto.getLogFacilityId())
                .logUserId(logDto.getLogUserId())
                .build();
    }

    public LogDto(Log log) {
        this.logId = log.getLogId();
        this.logEntryTime = log.getLogEntryTime();
        this.logExitTime = log.getLogExitTime();
        this.logFacilityId = log.getLogFacilityId();
        this.logUserId = log.getLogUserId();
    }
}