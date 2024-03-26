package org.encore.apartment.community.domain.user.service.user;

import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.repository.ApartmentRepository;
import org.encore.apartment.community.domain.user.data.dto.user.RequestUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.ResponseUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.UpdateRequestUserDto;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
import org.encore.apartment.community.domain.user.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("user")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final ApartmentRepository apartmentRepository;

	@Override
	@Transactional
	public Long createUser(RequestUserDto params) {
		User user = RequestUserDto.toEntity(params);
		apartmentRepository.findById(params.getApartmentId()).ifPresent(user::setApartment);
		log.info("createUser = {}", user);

		return userRepository.save(user).getUserIdx();
	}

	@Override
	public ResponseUserDto findUserInfo(Long idx) {
		Optional<User> user = userRepository.findById(idx);
		ResponseUserDto responseUserDto = new ResponseUserDto(user.get());
		responseUserDto.setApartmentInfo(user.get().getApartment());
		log.info("findUserInfo = {}", user);

		return responseUserDto;
	}

	@Override
	public Long updateUserInfo(UpdateRequestUserDto params) {
		Optional<User> user = userRepository.findById(params.getUserIdx());
		user.ifPresent(u -> u.update(params));
		log.info("updateUserInfo = {}", user);
		userRepository.save(user.get());

		return user.get().getUserIdx();
	}

	@Override
	public Long deleteUser(Long idx) {
		Optional<User> user = userRepository.findById(idx);
		user.get().updateDeleteYn();
		userRepository.save(user.get());

		return user.get().getUserIdx();
	}
}
