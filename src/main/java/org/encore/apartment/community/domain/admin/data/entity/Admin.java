package org.encore.apartment.community.domain.admin.data.entity;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;

	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	private Apartment apartment;

	@NotNull
	@Column(name = "admin_password")
	private String adminPassword;

	@NotNull
	@Column(name = "admin_contact_number")
	private String adminContactNumber;

	public Admin() {
	}

	@Builder
	public Admin(Long adminId, Apartment apartment, String adminPassword, String adminContactNumber) {
		this.adminId = adminId;
		this.apartment = apartment;
		this.adminPassword = adminPassword;
		this.adminContactNumber = adminContactNumber;
	}
}
