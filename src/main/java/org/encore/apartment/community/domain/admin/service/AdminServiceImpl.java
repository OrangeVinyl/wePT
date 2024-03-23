package org.encore.apartment.community.domain.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.admin.data.dto.AdminNumberRequestDTO;
import org.encore.apartment.community.domain.admin.data.repository.AdminRepository;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Override
    public String getAdminContactNumber(AdminNumberRequestDTO requestDTO) {
        return adminRepository.getAdminContactNumber(requestDTO.getApartmentId());
    }
}
