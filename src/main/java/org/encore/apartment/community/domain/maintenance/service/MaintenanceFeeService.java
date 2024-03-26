package org.encore.apartment.community.domain.maintenance.service;

import java.util.Date;
import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.dto.ItemPercentage;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceFeeDto;

public interface MaintenanceFeeService {

	//기능 1: 관리비 조회
	public Integer findGeneralMaintenanceFeeByUserId(String userId);

	//기능 2: 관리비 항목별 비중 조회
	public List<ItemPercentage> getItemPercentages(Date paymentDate);

	//기능 3: 해당 월과 전월의 관리비 비교(증감액)
	public MaintenanceFeeDto getFeeDifference();

}
