package org.encore.apartment.community.domain.apartment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.apartment.data.repository.ApartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("apartment")
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Override
    public void insertApartmentInfo(RequestApartmentDto params) {
        Apartment apt = RequestApartmentDto.toEntity(params);
        apartmentRepository.save(apt);
        log.info("insertApartmentInfo = {}", apt);
    }

    @Override
    public Optional<ResponseApartmentDto> findApartmentInfo(Integer id) {
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
    public void updateApartmentInfoById(Integer id, UpdateApartmentDto params) {
        Apartment apartment = apartmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아파트 정보가 없습니다."));
        apartment.update(apartment.getApartmentName(), apartment.getApartmentAddress(), apartment.getApartmentTotalHousehold());
        log.info("updateApartmentInfo = {}", params);
    }

    @Override
    public void deleteApartmentInfo(Integer id) {
        apartmentRepository.deleteById(id);
        log.info("deleteApartmentInfo = {}", id);
    }
}