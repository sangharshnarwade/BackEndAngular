package com.cg.vaccination.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
	private long bookingId;
	private long mobileNo;
	private LocalDate dateOfBooking;
    private int centerCode;
    private int  memberIdCard;
	private String slot;
	

}

