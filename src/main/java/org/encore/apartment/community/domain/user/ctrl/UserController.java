package org.encore.apartment.community.domain.user.ctrl;

import java.util.Map;

import org.encore.apartment.community.domain.user.data.dto.user.RequestUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.ResponseUserDto;
import org.encore.apartment.community.domain.user.data.dto.user.UpdateRequestUserDto;
import org.encore.apartment.community.domain.user.service.user.UserService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Resource(name = "user")
	private UserService service;

	@PostMapping(value = "/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Map<String, Long>> createUser(@RequestBody RequestUserDto params) {
		Long idx = service.createUser(params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}

	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<ResponseUserDto> getUserInfo(@RequestParam Long idx, @RequestParam String id) {
		log.info("getUserInfo = {} {}", idx, id);
		ResponseUserDto user = service.findUserInfo(idx);

		return ApiResponse.createSuccess(user);
	}

	@PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Map<String, Long>> updateUserInfo(@RequestBody UpdateRequestUserDto params) {
		Long idx = service.updateUserInfo(params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}

	@DeleteMapping("/delete")
	public ApiResponse<Map<String, Long>> deleteUser(@RequestParam Long idx) {
		Long userIdx = service.deleteUser(idx);
		Map<String, Long> map = Map.of("userIdx", userIdx);

		return ApiResponse.createSuccess(map);
	}
}
