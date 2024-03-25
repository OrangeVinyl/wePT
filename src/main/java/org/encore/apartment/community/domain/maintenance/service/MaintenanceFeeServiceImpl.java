package org.encore.apartment.community.domain.maintenance.service;

import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceFeeDto;
import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;
import org.encore.apartment.community.domain.maintenance.data.repository.MaintenanceFeeRepository;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("maintenanceFee")
public class MaintenanceFeeServiceImpl implements MaintenanceFeeService {

	private final MaintenanceFeeRepository maintenanceFeeRepository;
	private final UserRepository userRepository;

	@Autowired
	public MaintenanceFeeServiceImpl(MaintenanceFeeRepository maintenanceFeeRepository, UserRepository userRepository) {
		this.maintenanceFeeRepository = maintenanceFeeRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Integer findGeneralMaintenanceFeeByUserId(String userId) {
		Long userIdx = userRepository.findUserIdxByUserId(userId);
		return maintenanceFeeRepository.findGeneralMaintenanceFeeByUserIdx(userIdx);
	}

	@Override
	@Transactional(readOnly = true)
	public MaintenanceFeeDto getFeeDifference() {
		List<MaintenanceFee> pastFees = maintenanceFeeRepository.findByOrderByPaymentDateDesc();

		if (pastFees.size() >= 2) {
			MaintenanceFee currentMonthFee = pastFees.get(0);
			MaintenanceFee lastMonthFee = pastFees.get(1);

			int currentMonthGeneralFee = currentMonthFee.getGeneralMaintenanceFee();
			int lastMonthGeneralFee = lastMonthFee.getGeneralMaintenanceFee();

			MaintenanceFeeDto maintenanceFeeDto = new MaintenanceFeeDto();
			maintenanceFeeDto.setPaymentDate(currentMonthFee.getPaymentDate());
			maintenanceFeeDto.setUserIdx(currentMonthFee.getUser().getUserIdx());
			maintenanceFeeDto.setGeneralMaintenanceFee(currentMonthGeneralFee);

			int feeDifference = currentMonthGeneralFee - lastMonthGeneralFee;
			maintenanceFeeDto.setFeeDifference(feeDifference);

			return maintenanceFeeDto;
		}

		return null;
	}
}
