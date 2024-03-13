package org.encore.apartment.community.domain.user.service;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.dto.UserDto;
import org.encore.apartment.community.domain.user.data.entity.User;

public interface UserService {
	public void createUser(UserDto params);

	public Optional<UserDto> readUser(String userId);
}
