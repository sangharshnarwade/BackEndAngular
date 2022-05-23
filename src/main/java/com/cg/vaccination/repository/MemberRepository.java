package com.cg.vaccination.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.vaccination.model.Member;
import com.cg.vaccination.model.MemberStatus;
import com.cg.vaccination.model.VaccineRegistration;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	//@Query(value="select * from id_card where pan_no=?1", nativeQuery = true)
	//public Optional<Member> getIdCardByPanNo(String panNo);
	//@Query(value="select * from id_card where adhar_no=?1", nativeQuery = true)
	//public Optional<Member> getIdCardByAdharNo(long adharNo);
//	public Optional<Member>getMemberByPanNo(String panNo);
//	public Optional<Member> getMemberByAdharNo(long adharNo);
	
	
}
