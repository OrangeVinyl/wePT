package org.encore.apartment.community.domain.admin.service;

import org.encore.apartment.community.domain.admin.data.dto.AdminNumberRequestDTO;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

public interface AdminService {

    String getAdminContactNumber(AdminNumberRequestDTO requestDTO);
}
