package org.encore.apartment.community.domain.maintenance.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPercentage {
	private String itemName;
	private double percentage;
}
