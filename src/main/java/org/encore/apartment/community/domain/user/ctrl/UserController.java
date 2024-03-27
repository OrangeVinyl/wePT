package org.encore.apartment.community.domain.user.ctrl;

import java.util.Map;

import org.encore.apartment.community.domain.user.data.dto.UserRequestDto;
import org.encore.apartment.community.domain.user.data.dto.UserResponseDto;
import org.encore.apartment.community.domain.user.data.dto.UserUpdateRequestDto;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.service.UserService;
import org.encore.apartment.community.global.annotation.MemberAuthorize;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource(name = "user")
	private UserService service;

	@Operation(summary = "회원 가입")
	@PostMapping(value = "/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Map<String, Long>> createUser(@RequestBody UserRequestDto params) {
		Long idx = service.createUser(params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}


	@Operation(summary = "회원 정보 조회")
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	@MemberAuthorize
	public ApiResponse<UserResponseDto> getUserInfo(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
		System.out.println("::::::::::::controller " + user.getUsername());
		log.info("getUserInfo = {} ", user.getUsername());
		UserResponseDto entity = service.findUserInfo(user.getUsername());

		return ApiResponse.createSuccess(entity);
	}

	@Operation(summary = "회원 정보 수정")
	@PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
	@MemberAuthorize
	public ApiResponse<Map<String, Long>> updateUserInfo(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user, @RequestBody UserUpdateRequestDto params) {
		Long idx = service.updateUserInfo(user.getUsername(), params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}

	@Operation(summary = "회원 삭제")
	@DeleteMapping("/delete")
	@MemberAuthorize
	public ApiResponse<Map<String, Long>> deleteUser(@AuthenticationPrincipal User user) {
		Long userIdx = service.deleteUser(user.getUserIdx());
		Map<String, Long> map = Map.of("userIdx", userIdx);

		return ApiResponse.createSuccess(map);
	}
}
