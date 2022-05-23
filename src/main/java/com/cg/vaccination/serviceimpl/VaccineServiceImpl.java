package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.Vaccine;
import com.cg.vaccination.repository.VaccineRepository;
import com.cg.vaccination.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepository vaccineRepository;

	@Override
	public List<Vaccine> allVaccine() {
		return vaccineRepository.findAll();
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String vaccineName) {
		return vaccineRepository.findByVaccineName(vaccineName);
	}

	@Override
	public Optional<Vaccine> getVaccineById(Integer vaccineId) {
		return vaccineRepository.findById(vaccineId);
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}

	@Override
	public void deleteVaccine(Vaccine vaccine) {
		vaccineRepository.delete(vaccine);
	}

	

	

}
