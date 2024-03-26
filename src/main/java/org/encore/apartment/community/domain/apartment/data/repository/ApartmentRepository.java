package org.encore.apartment.community.domain.apartment.data.repository;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
