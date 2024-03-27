package org.encore.apartment.community.domain.membership.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.membership.service.MembershipService;
import org.encore.apartment.community.domain.membership.data.dto.MembershipResponseDto;
import org.encore.apartment.community.global.annotation.AdminAuthorize;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MembershipController {

	private final MembershipService membershipService;

	@Operation(summary = "멤버십 추가")
	@PostMapping("/insert")
	@AdminAuthorize
	public ApiResponse<?> insertMembership(@RequestBody Long idx) {
		membershipService.insertMembership(idx);

		return ApiResponse.createSuccessWithNoContent();
	}

	@Operation(summary = "멤버십 리스트 조회")
	@GetMapping("/list")
	@AdminAuthorize
	public ApiResponse<List<MembershipResponseDto>> findMembershipList() {
		return ApiResponse.createSuccess(membershipService.findMembershipList());
	}

	@Operation(summary = "멤버십 조회")
	@GetMapping("/find")
	@AdminAuthorize
	public ApiResponse<MembershipResponseDto> findMembership(@RequestParam Long idx) {
		MembershipResponseDto result = membershipService.findMembership(idx);

		return ApiResponse.createSuccess(result);
	}

	@Operation(summary = "멤버십 수정")
	@PostMapping("/update")
	@AdminAuthorize
	public ApiResponse<MembershipResponseDto> updateMembership(@RequestBody Long idx) {
		MembershipResponseDto result = membershipService.updateMembership(idx);

		return ApiResponse.createSuccess(result);
	}

	@Operation(summary = "멤버십 삭제")
	@DeleteMapping("/delete")
	@AdminAuthorize
	public ApiResponse<?> deleteMembership(@RequestParam Long idx) {
		membershipService.deleteMembership(idx);

		return ApiResponse.createSuccessWithNoContent();
	}
}
