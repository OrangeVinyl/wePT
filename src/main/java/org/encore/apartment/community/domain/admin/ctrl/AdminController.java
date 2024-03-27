package org.encore.apartment.community.domain.admin.ctrl;

import org.encore.apartment.community.domain.admin.service.AdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

	private final AdminServiceImpl service;

	@Transactional
	@GetMapping("/AdminContactNumber")
	public ResponseEntity<String> findAdminContactNumberByUserId(String userId) {
		System.out.println("Admin Controller find");
		String adminContactNumber = service.findAdminContactNumberByUserId(userId);
		System.out.println("admin contact number = " + adminContactNumber);
		return new ResponseEntity<>(adminContactNumber, HttpStatus.OK);
	}

}
