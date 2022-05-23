package com.cg.vaccination.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vaccination.dto.MemberStatusDto;

import com.cg.vaccination.exception.MemberStatusNotFoundException;
import com.cg.vaccination.model.Member;
import com.cg.vaccination.model.MemberStatus;
import com.cg.vaccination.model.VaccinationCenter;
import com.cg.vaccination.model.Vaccine;
import com.cg.vaccination.model.VaccineRegistration;
import com.cg.vaccination.service.MemberStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/member/status")
public class MemberStatusController {

	@Autowired
	private MemberStatusService memberStatusService;

	@PostMapping("/new")
	public MemberStatus addMemberStatus(@RequestBody MemberStatusDto memberStatus) {
		Member member = new Member();
	 VaccineRegistration registration = new VaccineRegistration();
	    Vaccine vaccine = new Vaccine();
		member.setIdCard(memberStatus.getMemberIdCard());
		vaccine.setId(memberStatus.getVaccineId());
		registration.setMobileNo(memberStatus.getMobileRegNo());
	    
		MemberStatus status = new MemberStatus(memberStatus.getMemberId(),memberStatus.getDose1status(),memberStatus.getDose2status(),
				memberStatus.getDose1date(),memberStatus.getDose2date(),member,registration,vaccine);
		return memberStatusService.addMemberStatus(status);

	}
	
	
	@GetMapping("/all")
	private List<MemberStatusDto> allMemberStatus() {
		List<MemberStatus> mList = memberStatusService.allMemberStatus();
		List<MemberStatusDto> mDtoList = new ArrayList<MemberStatusDto>();
		Iterator<MemberStatus> membersStatus = mList.iterator();
		while(membersStatus.hasNext()) {
			MemberStatus ac = membersStatus.next();
			MemberStatusDto ad = new MemberStatusDto();
			ad.setMemberId(ac.getMemberId());
			ad.setDose1status(ac.getDose1status());
			ad.setDose2status(ac.getDose2status());
			ad.setDose1date(ac.getDose1date());
			ad.setDose2date(ac.getDose2date());
			ad.setMemberIdCard(ac.getMember().getIdCard());
			ad.setMobileRegNo(ac.getRegistration().getMobileNo());
			mDtoList.add(ad);
		}
		return mDtoList;
		
	}


	@GetMapping("/memberStatusId/{memberStatusId}")
	public ResponseEntity<MemberStatus> getMemberById(@PathVariable( value = "memberStatusId") Integer memberStatusId)
			throws MemberStatusNotFoundException {
		MemberStatus memberStatus = memberStatusService.getMemberStatusByMemberId(memberStatusId)
				.orElseThrow(() -> new MemberStatusNotFoundException("No Member Found with this idCardId " + memberStatusId));
		return ResponseEntity.ok().body(memberStatus);
	}
	
	@PutMapping("/update/memberStatusId/{memberStatusId}")
	public ResponseEntity<MemberStatus> updateMember(@PathVariable(value = "memberStatusId") Integer memberStatusId, @RequestBody MemberStatus memberDetails)
			throws MemberStatusNotFoundException {
		MemberStatus memberStatus = memberStatusService.getMemberStatusByMemberId(memberStatusId)
				.orElseThrow(() -> new MemberStatusNotFoundException("No Member Found with this idCardId " + memberStatusId));
	
		memberStatus.setDose1status(memberDetails.getDose1status());
		memberStatus.setDose2status(memberDetails.getDose2status());
		memberStatus.setDose1date(memberDetails.getDose1date());
		memberStatus.setDose2date(memberDetails.getDose2date());
		MemberStatus updatedMemberStatus = memberStatusService.updateMemberStatus(memberStatus);
		return ResponseEntity.ok().body(updatedMemberStatus);
	}

	@DeleteMapping("/delete/memberStatusId/{memberStatusId}")
	public Map<String, Boolean> deleteMember(@PathVariable(value = "memberStatusId") int memberStatusId)
			throws MemberStatusNotFoundException {
		MemberStatus memberStatus = memberStatusService.getMemberStatusByMemberId(memberStatusId)
				.orElseThrow(() -> new MemberStatusNotFoundException("No Member Found with this idCardId " + memberStatusId));
		memberStatusService.deleteMember(memberStatus);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}
