package org.encore.apartment.community.domain.admin.service;

public interface AdminService {

	//사용자의 거주 아파트 관리실 전화번호 조회
	String findAdminContactNumberByUserId(String userId);
}
