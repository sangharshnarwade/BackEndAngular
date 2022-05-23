package com.cg.vaccination.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.vaccination.model.Member;
import com.cg.vaccination.model.MemberStatus;

public interface MemberStatusRepository extends JpaRepository<MemberStatus,Integer>{
	//public Optional<MemberStatus> getMemberByIdCard(int idCardId);
//	@Query(value="select * from id_card where pan_no=?1", nativeQuery = true)
//	public Optional<Member>getMemberByPanNo(String panNo);
//	@Query(value="select * from id_card where adhar_no=?1", nativeQuery = true)
//	public Optional<Member> getMemberByAdharNo(long adharNo);
}