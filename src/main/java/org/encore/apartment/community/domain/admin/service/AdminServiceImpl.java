package org.encore.apartment.community.domain.admin.service;

import org.encore.apartment.community.domain.admin.data.repository.AdminRepository;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("admin")
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;

	@Override
	public String findAdminContactNumberByUserId(String userId) {
		Integer apartmentId = userRepository.findApartmentIdByUserId(userId);
		return adminRepository.findAdminContactNumberByApartmentId(apartmentId);
	}
}
