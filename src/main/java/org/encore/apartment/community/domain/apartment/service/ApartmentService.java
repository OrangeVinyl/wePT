package org.encore.apartment.community.domain.apartment.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;

public interface ApartmentService {
    public void insertApartmentInfo(RequestApartmentDto params);

    public Optional<ResponseApartmentDto> findApartmentInfo(Integer id);

    public List<ResponseApartmentDto> findApartmentInfoList();

    public void updateApartmentInfoById(Integer id, UpdateApartmentDto params);

    public void deleteApartmentInfo(Integer id);
}