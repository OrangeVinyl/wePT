package org.encore.apartment.community.domain.maintenance.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.dto.ItemPercentage;
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

	//기능 : 관리비 조회
	@Override
	public Integer findGeneralMaintenanceFeeByUserId(String userId) {
		Long userIdx = userRepository.findUserIdxByUserId(userId);
		return maintenanceFeeRepository.findGeneralMaintenanceFeeByUserIdx(userIdx);
	}

	//기능 : 관리비 내역 별 비중 조회( 총 관리비 계산 + 관리비 내 각 항목의 비중 계산 + 계산된 값의 percentage화 )
	@Override
	public List<ItemPercentage> getItemPercentages(Date paymentDate) {
		MaintenanceFee maintenanceFee = maintenanceFeeRepository.findByPaymentDate(paymentDate);
		List<ItemPercentage> itemPercentages = new ArrayList<>();

		// 총 관리비 계산
		int totalMaintenanceFee = calculateTotalMaintenanceFee(maintenanceFee);

		// 각 항목의 비중 계산하여 리스트에 추가
		itemPercentages.add(new ItemPercentage("generalMaintenanceFee",
			calculatePercentage(maintenanceFee.getGeneralMaintenanceFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("securityServiceFee",
			calculatePercentage(maintenanceFee.getSecurityServiceFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("disinfectionFee",
			calculatePercentage(maintenanceFee.getDisinfectionFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("elevatorMaintenanceFee",
			calculatePercentage(maintenanceFee.getElevatorMaintenanceFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("intelligentMaintenanceFee",
			calculatePercentage(maintenanceFee.getIntelligentMaintenanceFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("heatingMaintenanceFee",
			calculatePercentage(maintenanceFee.getHeatingMaintenanceFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("hotWaterSupplyFee",
			calculatePercentage(maintenanceFee.getHotWaterSupplyFee(), totalMaintenanceFee)));
		itemPercentages.add(
			new ItemPercentage("repairFee", calculatePercentage(maintenanceFee.getRepairFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("entrustedManagementFee",
			calculatePercentage(maintenanceFee.getEntrustedManagementFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("cleaningFee",
			calculatePercentage(maintenanceFee.getCleaningFee(), totalMaintenanceFee)));
		itemPercentages.add(new ItemPercentage("membershipFee",
			calculatePercentage(maintenanceFee.getMembershipFee(), totalMaintenanceFee)));

		return itemPercentages;
	}

	// MaintenanceFee 객체의 각 항목을 합산하여 총 관리비를 반환하는 메서드
	private int calculateTotalMaintenanceFee(MaintenanceFee maintenanceFee) {
		return maintenanceFee.getGeneralMaintenanceFee() +
			maintenanceFee.getSecurityServiceFee() +
			maintenanceFee.getDisinfectionFee() +
			maintenanceFee.getElevatorMaintenanceFee() +
			maintenanceFee.getIntelligentMaintenanceFee() +
			maintenanceFee.getHeatingMaintenanceFee() +
			maintenanceFee.getHotWaterSupplyFee() +
			maintenanceFee.getRepairFee() +
			maintenanceFee.getEntrustedManagementFee() +
			maintenanceFee.getCleaningFee() +
			maintenanceFee.getMembershipFee();
	}

	//percentage로 변환 - method name : calculatePercentage
	private double calculatePercentage(int itemPercentages, int totalMaintenanceFee) {
		return (double)itemPercentages / totalMaintenanceFee * 100;
	}

	//기능 : 증감액 비교
	@Override
	@Transactional(readOnly = true)
	public MaintenanceFeeDto getFeeDifference() {
		List<MaintenanceFee> pastFees = maintenanceFeeRepository.findByOrderByPaymentDateDesc();

		if (pastFees.size() >= 2) {
			MaintenanceFee currentMonthFee = pastFees.get(0);
			MaintenanceFee lastMonthFee = pastFees.get(1);

			int currentMonthGeneralFee = currentMonthFee.getGeneralMaintenanceFee();
			int lastMonthGeneralFee = lastMonthFee.getGeneralMaintenanceFee();

			// 전월과 당월의 관리비
			int totalCurrentMonthFee = calculateTotalFee(currentMonthFee);
			int totalLastMonthFee = calculateTotalFee(lastMonthFee);

			MaintenanceFeeDto maintenanceFeeDto = new MaintenanceFeeDto();
			maintenanceFeeDto.setPaymentDate(currentMonthFee.getPaymentDate());
			maintenanceFeeDto.setUserIdx(currentMonthFee.getUser().getUserIdx());

			// 총 관리비를 MaintenanceFeeDto에 설정함
			maintenanceFeeDto.setGeneralMaintenanceFee(totalCurrentMonthFee);

			int feeDifference = totalCurrentMonthFee - totalLastMonthFee;
			maintenanceFeeDto.setFeeDifference(feeDifference);

			return maintenanceFeeDto;
		}

		return null;
	}

	// MaintenanceFee 객체의 각 항목을 합산하여 총 관리비를 반환하는 메서드 - 위와 중복...
	private int calculateTotalFee(MaintenanceFee maintenanceFee) {
		return maintenanceFee.getGeneralMaintenanceFee() +
			maintenanceFee.getSecurityServiceFee() +
			maintenanceFee.getDisinfectionFee() +
			maintenanceFee.getElevatorMaintenanceFee() +
			maintenanceFee.getIntelligentMaintenanceFee() +
			maintenanceFee.getHeatingMaintenanceFee() +
			maintenanceFee.getHotWaterSupplyFee() +
			maintenanceFee.getRepairFee() +
			maintenanceFee.getEntrustedManagementFee() +
			maintenanceFee.getCleaningFee() +
			maintenanceFee.getMembershipFee();
	}

}
