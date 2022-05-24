package com.cg.vaccination.model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;

	private long mobileNo;
  
	private LocalDate  dateOfBooking;
	private String slot;
	
	@OneToOne
	@JoinColumn(name = "member_id")
	private MemberStatus memberStatus;
	
	@OneToOne
	@JoinColumn (name = "center_code")
	private VaccinationCenter vaccinationCenter;
	
}


