package org.encore.apartment.community.domain.maintenance.data.dto;

import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;

import lombok.Data;

@Data
public class ResponseMaintenanceFeeDto {
	private Integer generalMaintenanceFee;
	private Integer securityServiceFee;
	private Integer disinfectionFee;
	private Integer elevatorMaintenanceFee;
	private Integer intelligentMaintenanceFee;
	private Integer heatingMaintenanceFee;
	private Integer hotWaterSupplyFee;
	private Integer repairFee;
	private Integer entrustedManagementFee;
	private Integer cleaningFee;
	private Integer membershipFee;

	public ResponseMaintenanceFeeDto(Integer generalMaintenanceFee, Integer securityServiceFee, Integer disinfectionFee,
		Integer elevatorMaintenanceFee,
		Integer intelligentMaintenanceFee, Integer heatingMaintenanceFee, Integer hotWaterSupplyFee, Integer repairFee,
		Integer entrustedManagementFee, Integer cleaningFee, Integer membershipFee) {
		this.generalMaintenanceFee = generalMaintenanceFee;
		this.securityServiceFee = securityServiceFee;
		this.disinfectionFee = disinfectionFee;
		this.elevatorMaintenanceFee = elevatorMaintenanceFee;
		this.intelligentMaintenanceFee = intelligentMaintenanceFee;
		this.heatingMaintenanceFee = heatingMaintenanceFee;
		this.hotWaterSupplyFee = hotWaterSupplyFee;
		this.repairFee = repairFee;
		this.entrustedManagementFee = entrustedManagementFee;
		this.cleaningFee = cleaningFee;
		this.membershipFee = membershipFee;
	}

	public MaintenanceFee toEntity(ResponseMaintenanceFeeDto maintenanceFeeDto) {
		return MaintenanceFee.builder()
			.generalMaintenanceFee(maintenanceFeeDto.getGeneralMaintenanceFee())
			.securityServiceFee(maintenanceFeeDto.getSecurityServiceFee())
			.disinfectionFee(maintenanceFeeDto.getDisinfectionFee())
			.elevatorMaintenanceFee(maintenanceFeeDto.getElevatorMaintenanceFee())
			.intelligentMaintenanceFee(maintenanceFeeDto.getIntelligentMaintenanceFee())
			.heatingMaintenanceFee(maintenanceFeeDto.getHeatingMaintenanceFee())
			.hotWaterSupplyFee(maintenanceFeeDto.getHotWaterSupplyFee())
			.repairFee(maintenanceFeeDto.getRepairFee())
			.entrustedManagementFee(maintenanceFeeDto.getEntrustedManagementFee())
			.cleaningFee(maintenanceFeeDto.getCleaningFee())
			.membershipFee(maintenanceFeeDto.getMembershipFee())
			.build();
	}
}
