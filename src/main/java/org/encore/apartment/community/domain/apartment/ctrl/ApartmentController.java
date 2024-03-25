package org.encore.apartment.community.domain.apartment.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;
import org.encore.apartment.community.domain.apartment.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/apartment")
public class ApartmentController {

	@Resource(name = "apartment")
	private ApartmentService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertApartmentInfo(@RequestBody RequestApartmentDto params) {
		service.insertApartmentInfo(params);
		log.info("ApartmentController insertApartmentInfo = {}", params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseApartmentDto>> findApartmentInfo(@PathVariable Long id) {
		Optional<ResponseApartmentDto> dto = service.findApartmentInfo(id);
		log.info("ApartmentController findApartmentInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseApartmentDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ResponseApartmentDto>> findApartmentInfoList() {
		List<ResponseApartmentDto> dto = service.findApartmentInfoList();
		log.info("ApartmentController findApartmentInfoList = {}", dto);

		return new ResponseEntity<List<ResponseApartmentDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateApartmentInfo(@PathVariable("id") Long id,
		@RequestBody UpdateApartmentDto params) {
		log.info("ApartmentController updateApartmentInfo = {}", params);
		service.updateApartmentInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteApartmentInfo(@PathVariable Long id) {
		log.info("ApartmentController deleteApartmentInfo = {}", id);
		service.deleteApartmentInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}