package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.Member;
import com.cg.vaccination.repository.MemberRepository;
import com.cg.vaccination.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		return memberRepository.save(member) ;
	}

	@Override
	public List<Member> allMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Optional<Member> getMemberByIdCard(int idCard) {
		return memberRepository.findById(idCard);
	}

	@Override
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public void deleteMember(Member member) {
	memberRepository.delete(member);
		
	}


	



	

	
}
