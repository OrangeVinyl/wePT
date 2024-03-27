package org.encore.apartment.community.domain.maintenance.data.dto;

import org.encore.apartment.community.domain.maintenance.data.entity.MaintenanceFee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResponseMaintenanceFeeDto {
	@Schema(description = "일반 관리비", example = "10")
	private Integer generalMaintenanceFee;
	@Schema(description = "1 관리비", example = "10")
	private Integer securityServiceFee;
	@Schema(description = "1 관리비", example = "10")
	private Integer disinfectionFee;
	@Schema(description = "2 관리비", example = "10")
	private Integer elevatorMaintenanceFee;
	@Schema(description = "3 관리비", example = "10")
	private Integer intelligentMaintenanceFee;
	@Schema(description = "4 관리비", example = "10")
	private Integer heatingMaintenanceFee;
	@Schema(description = "5 관리비", example = "10")
	private Integer hotWaterSupplyFee;
	@Schema(description = "일반 관리비", example = "10")
	private Integer repairFee;
	@Schema(description = "일반 관리비", example = "10")
	private Integer entrustedManagementFee;
	@Schema(description = "일반 관리비", example = "10")
	private Integer cleaningFee;
	@Schema(description = "일반 관리비", example = "10")
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
