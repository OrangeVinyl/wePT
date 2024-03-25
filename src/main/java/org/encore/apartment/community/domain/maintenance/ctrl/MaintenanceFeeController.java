package org.encore.apartment.community.domain.maintenance.ctrl;

import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceFeeDto;
import org.encore.apartment.community.domain.maintenance.service.MaintenanceFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
