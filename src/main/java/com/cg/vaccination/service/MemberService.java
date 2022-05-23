package com.cg.vaccination.service;

import java.util.List;
import java.util.Optional;

import com.cg.vaccination.model.Member;

public interface MemberService {
	
	public Member addMember(Member member);

	public List<Member> allMembers();

	public Optional<Member> getMemberByIdCard(int idCard);

	public Member updateMember(Member member);

	public void deleteMember(Member member);


}
