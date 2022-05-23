package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.MemberStatus;
import com.cg.vaccination.repository.MemberStatusRepository;
import com.cg.vaccination.service.MemberStatusService;
@Service
public class MemberStatusServiceImpl implements MemberStatusService{

	@Autowired
	private MemberStatusRepository memberStatusRepository;
	
	

	@Override
	public MemberStatus addMemberStatus(MemberStatus memberStatus) {
		return memberStatusRepository.save(memberStatus);
	}

	@Override
	public List<MemberStatus> allMemberStatus() {
		return memberStatusRepository.findAll();
	}

	
	

	@Override
	public MemberStatus updateMemberStatus(MemberStatus memberStatus) {
		return memberStatusRepository.save(memberStatus);
	}

	@Override
	public void deleteMember(MemberStatus memberStatus) {
		memberStatusRepository.delete(memberStatus);
		
	}

	@Override
	public Optional<MemberStatus> getMemberStatusByMemberId(Integer memberStatusId) {
		return memberStatusRepository.findById(memberStatusId);
	}

	

	
	
}
