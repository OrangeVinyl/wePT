package org.encore.apartment.community.domain.apartment.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateRequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

public interface ApartmentService {
	void insertApartmentInfo(RequestApartmentDto params);

	Optional<ResponseApartmentDto> findApartmentInfo(Long id);

	List<ResponseApartmentDto> findApartmentInfoList();

	ResponseApartmentDto updateApartmentInfoById(Long id, UpdateRequestApartmentDto params);

	void deleteApartmentInfo(Long id);
}
