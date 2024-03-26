package org.encore.apartment.community.domain.user.service.user;

import org.encore.apartment.community.domain.user.data.dto.user.RequestUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.ResponseUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.UpdateRequestUserDto;

public interface UserService {
	public Long createUser(RequestUserDto params);

	public ResponseUserDto findUserInfo(Long idx);

	public Long updateUserInfo(UpdateRequestUserDto params);

	public Long deleteUser(Long idx);
}
