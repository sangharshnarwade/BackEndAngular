package com.cg.vaccination.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vaccination.exception.MemberNotFoundException;
import com.cg.vaccination.model.Member;
import com.cg.vaccination.service.MemberService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/new")
	public Member addMember(@RequestBody Member member) {
		return memberService.addMember(member);

	}
	@GetMapping("/all")
	public List<Member> allVaccine() {
		return memberService.allMembers();
	}
	
	@GetMapping("/idcard/{idCard}")
	public ResponseEntity<Member> getMemberByIdCard(@PathVariable (value = "idCard") int idCard) 
		throws MemberNotFoundException {
     	Member member = memberService.getMemberByIdCard(idCard)
					.orElseThrow(() -> new MemberNotFoundException ("No Member Found with this idCard " + idCard));
			return ResponseEntity.ok().body(member);
		
	}

	@PutMapping("/update/idcard/{idCard}")
	public ResponseEntity<Member> updateMember(@PathVariable (value = "idCard") Integer idCard, @RequestBody Member memberDatails ) 
		throws MemberNotFoundException {

			Member member = memberService.getMemberByIdCard(idCard)
					.orElseThrow(() -> new MemberNotFoundException ("No Member Found with this idCard " + idCard) );
	  
			member.setName(memberDatails.getName());
			member.setDob(memberDatails.getDob());
			member.setGender(memberDatails.getGender());
			member.setCity(memberDatails.getCity());
			member.setState(memberDatails.getState());
			member.setAdharNo(memberDatails.getAdharNo());
	  
			Member updatedMember = memberService.updateMember(member);
	    
			return ResponseEntity.ok(updatedMember);	
	}

	
}
