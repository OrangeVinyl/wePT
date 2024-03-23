package org.encore.apartment.community.domain.apartment.data.dto;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RequestApartmentDto {

    @NotBlank
    private String apartmentName;

    @NotBlank
    private String apartmentAddress;
    private Integer apartmentTotalHousehold;

    public static Apartment toEntity(RequestApartmentDto dto) {
        return Apartment.builder()
                .apartmentName(dto.apartmentName)
                .apartmentAddress(dto.apartmentAddress)
                .apartmentTotalHousehold(dto.apartmentTotalHousehold)
                .build();
    }
}