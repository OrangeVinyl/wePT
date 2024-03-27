package org.encore.apartment.community.domain.user.service;

import org.encore.apartment.community.domain.user.data.dto.UserRequestDto;
import org.encore.apartment.community.domain.user.data.dto.UserResponseDto;
import org.encore.apartment.community.domain.user.data.dto.UserUpdateRequestDto;

public interface UserService {
	public Long createUser(UserRequestDto params);

	public UserResponseDto findUserInfo(String userId);

	public Long updateUserInfo(String userId, UserUpdateRequestDto params);

	public Long deleteUser(Long idx);
}
