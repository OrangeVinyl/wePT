package org.encore.apartment.community.domain.maintenance.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPercentage {
	@NotBlank
	private String itemName;
	@NotNull
	private double percentage;
}
