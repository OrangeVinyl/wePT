package org.encore.apartment.community.domain.user.ctrl;

import org.encore.apartment.community.domain.user.data.dto.UserDto;
import org.encore.apartment.community.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/*
* 	예시 코드
 */

@RestController
/* swagger 에 명시하고 싶으면 RequestMapping 에 /api 를 명시 */
@RequestMapping("/api/user")
public class UserController {

	@Resource(name = "user")
	private UserService service;

	@PostMapping(value = "/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto params) 	{
		service.createUser(params);

		return new ResponseEntity<UserDto>(HttpStatus.OK);
	}

	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> getUserInfo() {
		return null;
	}

}
