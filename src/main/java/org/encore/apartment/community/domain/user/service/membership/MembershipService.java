package org.encore.apartment.community.domain.user.service.membership;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.user.data.dto.membership.ResponseMembershipDto;
import org.encore.apartment.community.domain.user.data.entity.Membership;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.encore.apartment.community.domain.user.data.repository.MembershipRepository;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
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

	public ResponseMembershipDto findMembership(Long idx) {
		Optional<Membership> membership = membershipRepository.findByUserIdx(idx);
		if (Objects.nonNull(membership)) {
			Optional<User> user = userRepository.findById(membership.get().getUser().getUserIdx());
			return new ResponseMembershipDto(membership.get(), user.get().getUserId(), user.get().getUserNickname());
		}
		return null;
	}

	public List<ResponseMembershipDto> findMembershipList() {
		List<Membership> membershipList = membershipRepository.findAll();

		return membershipList.stream().map(membership -> {
			Optional<User> user = userRepository.findById(membership.getUser().getUserIdx());
			return new ResponseMembershipDto(membership, user.get().getUserId(), user.get().getUserNickname());
		}).collect(Collectors.toList());
	}

	public ResponseMembershipDto updateMembership(Long idx) {
		Optional<Membership> membership = membershipRepository.findByUserIdx(idx);
		if (Objects.nonNull(membership)) {
			membership.get().updateMembershipDate(LocalDateTime.now());
			membershipRepository.save(membership.get());
			Optional<User> user = userRepository.findById(membership.get().getUser().getUserIdx());
			return new ResponseMembershipDto(membership.get(), user.get().getUserId(), user.get().getUserNickname());
		}
		return null;
	}

	public void deleteMembership(Long idx) {
		membershipRepository.deleteByUserIdx(idx);
	}
}
