package com.cg.vaccination.service;

import java.util.List;
import java.util.Optional;

import com.cg.vaccination.model.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(Appointment app);

	public List<Appointment> allAppointment();

	public Optional<Appointment> getAppointmentByBookingId(Long bookingId);

	public Appointment updateAppointment(Appointment app);

	public void deleteAppointment(Appointment app);

}
