package com.cg.vaccination.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberStatusDto {
	
	private int memberId;
    private Boolean dose1status;
	private Boolean dose2status;
    private LocalDate dose1date;
	private LocalDate dose2date;
	private int memberIdCard;
    private long mobileRegNo;
	private int vaccineId;
	
}
