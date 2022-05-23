package com.cg.vaccination.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vaccination.dto.AppointmentDto;
import com.cg.vaccination.exception.AppointmentNotFoundException;
import com.cg.vaccination.model.Appointment;
import com.cg.vaccination.model.MemberStatus;
import com.cg.vaccination.model.VaccinationCenter;
import com.cg.vaccination.service.AppointmentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/admin")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/appointment/new")
	private Appointment addAppointment(@RequestBody AppointmentDto app) {
	VaccinationCenter center = new VaccinationCenter();
	MemberStatus memberStatus = new MemberStatus();
	center.setCode(app.getCenterCode());
	memberStatus.setMemberId(app.getMemberIdCard());
	Appointment appointment = new Appointment(app.getBookingId(),app.getMobileNo(),app.getDateOfBooking(),app.getSlot(), memberStatus, center);
	return appointmentService.addAppointment(appointment);

	}

	@GetMapping("/appointment/all")
	public List<AppointmentDto> allAppointment() {
	List<Appointment> aList = appointmentService.allAppointment();
	List<AppointmentDto> aDtoList = new ArrayList<AppointmentDto>();
	Iterator<Appointment> appointments = aList.iterator();
	while(appointments.hasNext()) {
	Appointment ac = appointments.next();
	AppointmentDto ad = new AppointmentDto();
	ad.setBookingId(ac.getBookingId());
	ad.setDateOfBooking(ac.getDateOfBooking());
	ad.setMobileNo(ac.getMobileNo());
	ad.setSlot(ac.getSlot());
	ad.setCenterCode(ac.getVaccinationCenter().getCode());
	ad.setMemberIdCard(ac.getMemberStatus().getMemberId());
	aDtoList.add(ad);
	}
	return aDtoList;
	}


	@GetMapping("/appointment/bookingId/{bookingId}")
	public ResponseEntity<AppointmentDto> getAppointmentByBookingId(@PathVariable(value = "bookingId") long bookingId)
			throws AppointmentNotFoundException {
		Appointment app = appointmentService.getAppointmentByBookingId(bookingId).orElseThrow(
				() -> new AppointmentNotFoundException("No appoinment found with this booking id " + bookingId));
		AppointmentDto appdto = new AppointmentDto();
		appdto.setBookingId(app.getBookingId());
		appdto.setDateOfBooking(app.getDateOfBooking());
		appdto.setMobileNo(app.getMobileNo());
		appdto.setSlot(app.getSlot());
		appdto.setCenterCode(app.getVaccinationCenter().getCode());
		appdto.setMemberIdCard(app.getMemberStatus().getMemberId());
		return ResponseEntity.ok().body(appdto);
	}

	@PutMapping("/appointment/update/{bookingId}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable(value = "bookingId") long bookingId,
			@RequestBody Appointment appDetails) throws AppointmentNotFoundException {
		Appointment app = appointmentService.getAppointmentByBookingId(bookingId).orElseThrow(
				() -> new AppointmentNotFoundException("No appoinment found with this booking id " + bookingId));
		app.setDateOfBooking(appDetails.getDateOfBooking());
		app.setMobileNo(appDetails.getMobileNo());
		Appointment updatedAppoinment = appointmentService.updateAppointment(app);
		return ResponseEntity.ok().body(updatedAppoinment);
		
	}
	@DeleteMapping("/appointment/delete/{bookingId}")
	public Map<String, Boolean> deleteAppointment(@PathVariable(value = "bookingId") long bookingId)
			throws AppointmentNotFoundException {
		Appointment app = appointmentService.getAppointmentByBookingId(bookingId).orElseThrow(
				() -> new AppointmentNotFoundException("No appoinment found with this booking id " + bookingId));
		appointmentService.deleteAppointment(app);
		Map<String, Boolean> response = new HashMap();
		response.put("Deleted", true);
		return response;
	}




	}



