package org.encore.apartment.community.domain.admin.data.repository;

import org.encore.apartment.community.domain.admin.data.dto.AdminNumberRequestDTO;
import org.encore.apartment.community.domain.admin.data.entity.Admin;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query("SELECT A.adminContactNumber FROM Admin A WHERE A.apartmentId = :apartmentId")
    String getAdminContactNumber(@Param("apartmentId") String apartmentId);

}
