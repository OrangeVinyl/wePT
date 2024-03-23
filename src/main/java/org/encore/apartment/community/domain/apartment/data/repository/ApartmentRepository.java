package org.encore.apartment.community.domain.apartment.data.repository;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}