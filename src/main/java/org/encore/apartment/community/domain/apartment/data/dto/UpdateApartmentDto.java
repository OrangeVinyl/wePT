package org.encore.apartment.community.domain.apartment.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateApartmentDto {
	@NotNull
	private Long apartmentId;

	@NotBlank
	private String apartmentName;

	@NotBlank
	private String apartmentAddress;
	private Integer apartmentTotalHousehold;
}