package org.encore.apartment.community.domain.maintenance.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.maintenance.data.dto.ItemPercentage;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceFeeDto;
import org.encore.apartment.community.domain.maintenance.data.dto.ResponseMaintenanceFeeDto;
import org.encore.apartment.community.domain.maintenance.service.MaintenanceFeeService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenanceFee")
public class MaintenanceFeeController {
	private final MaintenanceFeeService maintenanceFeeService;

	@Autowired
	public MaintenanceFeeController(MaintenanceFeeService maintenanceFeeService) {
		this.maintenanceFeeService = maintenanceFeeService;
	}

	@PostMapping("/insert")
	public ApiResponse<ResponseMaintenanceFeeDto> insertMaintainFee(@RequestBody ResponseMaintenanceFeeDto body) {
		maintenanceFeeService.save(body);

		return ApiResponse.createSuccess(body);
	}

	//관리비 조회
	@GetMapping("/checkMaintenanceFee/{userId}")
	public Integer findMaintenanceFeeByUserId(@PathVariable("userId") String userId) {
		Integer tmp = 0;
		tmp = maintenanceFeeService.findMaintenanceFeeByUserId(userId);
		return tmp;
	}

	//관리비 내역 별 비중 조회
	@GetMapping("/percentages/{userId}")
	public List<ItemPercentage> getItemPercentages(@PathVariable("userId") String userId) {
		return maintenanceFeeService.getItemPercentages(userId);
	}

	//관리비 증감액 비교
	@GetMapping("/difference")
	public ResponseEntity<MaintenanceFeeDto> compareLastMonth() {
		MaintenanceFeeDto feeDifference = maintenanceFeeService.getFeeDifference();

		if (feeDifference != null) {
			return ResponseEntity.ok(feeDifference);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
