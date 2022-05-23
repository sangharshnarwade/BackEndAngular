package com.cg.vaccination.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberStatus {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;

	private Boolean dose1status;
	private Boolean dose2status;
	private LocalDate dose1date;
	private LocalDate dose2date;
	
	@OneToOne
	private Member member;
	
	@ManyToOne
	@JoinColumn(name= "mobile_reg_no")
	private VaccineRegistration registration;

	@OneToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
}
