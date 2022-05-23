package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.Appointment;
import com.cg.vaccination.repository.AppointmentRepository;
import com.cg.vaccination.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment app) {
		return appointmentRepository.save(app);
	}

	@Override
	public List<Appointment> allAppointment() {
		return appointmentRepository.findAll();
	}

	

	@Override
	public Appointment updateAppointment(Appointment app) {
		return appointmentRepository.save(app);
	}

	@Override
	public void deleteAppointment(Appointment app) {
		appointmentRepository.delete(app);

	}

	@Override
	public Optional<Appointment> getAppointmentByBookingId(Long bookingId) {
		return appointmentRepository.findById(bookingId);
	}

}
