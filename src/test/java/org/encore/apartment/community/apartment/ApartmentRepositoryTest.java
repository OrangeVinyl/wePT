package org.encore.apartment.community.apartment;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.apartment.data.repository.ApartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApartmentRepositoryTest {

	@Autowired
	ApartmentRepository apartmentRepository;

	@Test
	void findAll() {
		System.out.println("======== findAll() test ========");

		List<Apartment> list =  apartmentRepository.findAll();
		for (Apartment apartment : list) {
			System.out.println("======== apartment value():" + apartment);
		}
	}

	@Test
	void findById() {
		System.out.println("======== findById() test ========");

		Optional<Apartment> apt = apartmentRepository.findById(1L);
		System.out.println("======== apartment value():" + apt);
	}

	@Test
	void save() {
		System.out.println("======== save() test ========");

		Apartment.builder()
			.apartmentName("무궁화 아파트")
			.apartmentAddress("서울특별시 광진구 뚝섬로 123-1")
			.apartmentTotalHousehold(1700)
			.build();
	}

	@Test
	void deleteById() {
		System.out.println("======== delete() test ========");
		apartmentRepository.deleteById(1L);
	}

	@Test
	void update() {
		System.out.println("======== update() test ========");
		apartmentRepository.updateEntity(7L, "업데이트 아파트", "부산광역시 동구 해운대로 56-12", 1563);
	}

}
