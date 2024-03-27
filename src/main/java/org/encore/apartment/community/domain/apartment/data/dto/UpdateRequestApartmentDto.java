package org.encore.apartment.community.domain.apartment.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateRequestApartmentDto {

	@NotBlank
	@Schema(description = "아파트 이름", example = "변경된 아파트 테스트")
	private String apartmentName;

	@NotBlank
	@Schema(description = "아파트 주소", example = "엔코아시 엔코아동 56-75")
	private String apartmentAddress;
	@Schema(description = "아파트 총 세대수", example = "1000")
	private Integer apartmentTotalHousehold;
}
