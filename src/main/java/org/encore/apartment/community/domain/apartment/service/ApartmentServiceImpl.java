package org.encore.apartment.community.domain.apartment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateRequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("apartment")
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
	private final ApartmentRepository apartmentRepository;

	@Override
	public void insertApartmentInfo(@Valid RequestApartmentDto params) {
		Apartment apt = RequestApartmentDto.toEntity(params);
		apartmentRepository.save(apt);
		log.info("insertApartmentInfo = {}", apt);
	}

	@Override
	public Optional<ResponseApartmentDto> findApartmentInfo(Long id) {
		Optional<Apartment> apt = apartmentRepository.findById(id);
		log.info("findApartmentInfo = {}", apt);

		return apt.map(ResponseApartmentDto::new);
	}

	@Override
	public List<ResponseApartmentDto> findApartmentInfoList() {
		List<Apartment> aptList = apartmentRepository.findAll();
		log.info("findApartmentInfoList = {}", aptList);

		return aptList.stream().map(ResponseApartmentDto::new).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ResponseApartmentDto updateApartmentInfoById(@Valid Long id, UpdateRequestApartmentDto params) {
		Apartment entity = apartmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아파트 정보가 없습니다."));
		entity.update(params.getApartmentName(), params.getApartmentAddress(), params.getApartmentTotalHousehold());
		log.info("updateApartmentInfo = {}", params);
		apartmentRepository.update(entity.getApartmentId(), entity.getApartmentName(), entity.getApartmentAddress(), entity.getApartmentTotalHousehold());

		Apartment apartment = apartmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아파트 정보가 없습니다."));
		return new ResponseApartmentDto(apartment);
	}

	@Override
	@Transactional
	public void deleteApartmentInfo(Long id) {
		apartmentRepository.deleteById(id);
		log.info("deleteApartmentInfo = {}", id);
	}
}
