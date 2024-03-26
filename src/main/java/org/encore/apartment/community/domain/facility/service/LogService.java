package org.encore.apartment.community.domain.facility.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.facility.data.dto.LogDto;
import org.encore.apartment.community.domain.facility.data.entity.Log;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LogService {
    //추가 (exit_time = null) -> userID & facilityID 필요
    public void addLog(Integer facilityId, String userId);

    //조회 (전체 확인용)
    public List<LogDto> readAllLog();

    //시설 아이디로 조회 (들어가 있는 사람 조회)(exit_time = null)
    public List<LogDto> readAllByFacilityUsers(Integer facilityId);

    //사용자 아이디로 조회 (exit_time = null)
    public List<LogDto> readAllByUsers(String userId);

    //수정 : 사용자가 나가는 경우 (exit_time = sysdate) facility_id
    public void updateUserExit(String userId);
}
