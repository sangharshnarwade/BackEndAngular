package com.cg.vaccination.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vaccination.model.Vaccine;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

	public Optional<Vaccine> findByVaccineName(String vaccineName);
	
}
