package org.encore.apartment.community.domain.user.service;

import java.util.Optional;

import org.encore.apartment.community.domain.apartment.repository.ApartmentRepository;
import org.encore.apartment.community.domain.user.data.dto.UserRequestDto;
import org.encore.apartment.community.domain.user.data.dto.UserResponseDto;
import org.encore.apartment.community.domain.user.data.dto.UserUpdateRequestDto;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	private final PasswordEncoder encoder;

	@Override
	@Transactional
	public Long createUser(UserRequestDto params) {
		User user = UserRequestDto.toEntity(params, encoder);
		apartmentRepository.findById(params.getApartmentId()).ifPresent(user::setApartment);
		log.info("createUser = {}", user);

		return userRepository.save(user).getUserIdx();
	}

	@Override
	public UserResponseDto findUserInfo(String userId) {
		Optional<User> user = userRepository.findByUserId(userId);
		UserResponseDto userResponseDto = new UserResponseDto(user.get());
		userResponseDto.setApartmentInfo(user.get().getApartment());
		log.info("findUserInfo = {}", user);

		return userResponseDto;
	}

	@Override
	public Long updateUserInfo(String userId, UserUpdateRequestDto params) {
		Optional<User> user = userRepository.findByUserId(userId);
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
