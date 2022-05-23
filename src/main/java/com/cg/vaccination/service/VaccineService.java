package com.cg.vaccination.service;

import java.util.List;
import java.util.Optional;

import com.cg.vaccination.model.Vaccine;

public interface VaccineService {
	public List<Vaccine> allVaccine();

	public Optional<Vaccine> getVaccineByName(String vaccineName);

	public Optional<Vaccine> getVaccineById(Integer vaccineId);

	public Vaccine addVaccine(Vaccine vaccine);

	public Vaccine updateVaccine(Vaccine vaccine);

	public void deleteVaccine(Vaccine vaccine);
}
