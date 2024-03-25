package org.encore.apartment.community.domain.maintenance.data.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceFeeDto {
	private Date paymentDate;
	private Long userIdx;
	private Integer generalMaintenanceFee;
	private Integer feeDifference;

}
