package com.cg.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vaccination.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
