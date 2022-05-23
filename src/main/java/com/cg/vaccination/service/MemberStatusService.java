package com.cg.vaccination.service;

import java.util.List;
import java.util.Optional;


import com.cg.vaccination.model.MemberStatus;

public interface MemberStatusService {

	public List<MemberStatus> allMemberStatus();

	public MemberStatus addMemberStatus(MemberStatus memberStatus);

	public Optional<MemberStatus> getMemberStatusByMemberId(Integer memberStatusId);

	public MemberStatus updateMemberStatus(MemberStatus memberStatus);

	public void deleteMember(MemberStatus memberStatus);
}
