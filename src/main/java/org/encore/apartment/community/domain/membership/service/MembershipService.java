package org.encore.apartment.community.domain.membership.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.membership.data.entity.Membership;
import org.encore.apartment.community.domain.membership.data.dto.MembershipResponseDto;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.membership.repository.MembershipRepository;
import org.encore.apartment.community.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("member")
@RequiredArgsConstructor
public class MembershipService {

	private final MembershipRepository membershipRepository;

	private final UserRepository userRepository;

	public void insertMembership(Long idx) {
		userRepository.findById(idx).ifPresent(user -> {
			Membership membership = new Membership(LocalDateTime.now());
			membership.setUser(user);
			membershipRepository.save(membership);
		});
	}

	public MembershipResponseDto findMembership(Long idx) {
		Optional<Membership> membership = membershipRepository.findByUserIdx(idx);
		if (Objects.nonNull(membership)) {
			Optional<User> user = userRepository.findById(membership.get().getUser().getUserIdx());
			return new MembershipResponseDto(membership.get(), user.get().getUserId(), user.get().getUserNickname());
		}
		return null;
	}

	public List<MembershipResponseDto> findMembershipList() {
		List<Membership> membershipList = membershipRepository.findAll();

		return membershipList.stream().map(membership -> {
			Optional<User> user = userRepository.findById(membership.getUser().getUserIdx());
			return new MembershipResponseDto(membership, user.get().getUserId(), user.get().getUserNickname());
		}).collect(Collectors.toList());
	}

	public MembershipResponseDto updateMembership(Long idx) {
		Optional<Membership> membership = membershipRepository.findByUserIdx(idx);
		if (Objects.nonNull(membership)) {
			membership.get().updateMembershipDate(LocalDateTime.now());
			membershipRepository.save(membership.get());
			Optional<User> user = userRepository.findById(membership.get().getUser().getUserIdx());
			return new MembershipResponseDto(membership.get(), user.get().getUserId(), user.get().getUserNickname());
		}
		return null;
	}

	public void deleteMembership(Long idx) {
		membershipRepository.deleteByUserIdx(idx);
	}
}
