package org.encore.apartment.community.domain.user.service;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.dto.UserDto;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("user")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void createUser(UserDto params) {
		User user = UserDto.toEntity(params);
		userRepository.save(user);
		log.info("user saved : {}", user);
	}

	@Override
	public Optional<UserDto> readUser(String userId) {
		return Optional.empty();
	}
}
