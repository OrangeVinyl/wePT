package org.encore.apartment.community.domain.maintenance.data.entity;

import java.io.Serializable;
import java.util.Date;

import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@IdClass(MaintenanceFeeId.class)
@Table(name = "maintenanceFee_tbl")
public class MaintenanceFee implements Serializable {

	/*
	복합키(include 외래키) : PK는 paymentDate from this tbl & userIdx from user_tbl
	표현법 : by using @embeddable
	*/

	@Id
	@Column(name = "payment_date")
	private Date paymentDate;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_idx", referencedColumnName = "user_idx")
	private User user;

	@NotNull
	@Column(name = "general_maintenance_fee")
	private Integer generalMaintenanceFee;

	@NotNull
	@Column(name = "security_service_fee")
	private Integer securityServiceFee;

	@NotNull
	@Column(name = "disinfection_fee")
	private Integer disinfectionFee;

	@NotNull
	@Column(name = "elevator_maintenance_fee")
	private Integer elevatorMaintenanceFee;

	@NotNull
	@Column(name = "intelligent_maintenance_fee")
	private Integer intelligentMaintenanceFee;

	@NotNull
	@Column(name = "heating_maintenance_fee")
	private Integer heatingMaintenanceFee;

	@NotNull
	@Column(name = "hot_water_supply_fee")
	private Integer hotWaterSupplyFee;

	@NotNull
	@Column(name = "repair_fee")
	private Integer repairFee;

	@NotNull
	@Column(name = "entrusted_management_fee")
	private Integer entrustedManagementFee;

	@NotNull
	@Column(name = "cleaning_fee")
	private Integer cleaningFee;

	@Column(name = "membership_fee")
	private Integer membershipFee;

	public MaintenanceFee() {
	}

	@Builder
	public MaintenanceFee(Date paymentDate, User user, Integer generalMaintenanceFee, Integer securityServiceFee,
		Integer disinfectionFee, Integer elevatorMaintenanceFee, Integer intelligentMaintenanceFee,
		Integer heatingMaintenanceFee, Integer hotWaterSupplyFee, Integer repairFee, Integer entrustedManagementFee,
		Integer cleaningFee, Integer membershipFee) {
		this.paymentDate = paymentDate;
		this.user = user;
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
}
