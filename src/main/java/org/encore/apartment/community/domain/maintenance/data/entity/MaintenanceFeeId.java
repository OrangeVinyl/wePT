package org.encore.apartment.community.domain.maintenance.data.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MaintenanceFeeId implements Serializable {
	private Date paymentDate;
	private Long user;
}
