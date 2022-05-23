package com.cg.vaccination.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.vaccination.model.VaccinationCenter;
import com.cg.vaccination.repository.VaccinationCenterRepository;
import com.cg.vaccination.service.VaccinationCenterService;



@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepository centerRepository;

	@Override
	public List<VaccinationCenter> allVaccineCenters() {
		return centerRepository.findAll();
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationcenter) {
		return centerRepository.save(vaccinationcenter);
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter vaccinationcenter) {
		return centerRepository.save(vaccinationcenter);
	}

	@Override
	public void deleteVaccinationCenter(VaccinationCenter vaccinationCenter) {
		centerRepository.delete(vaccinationCenter);
	}

	@Override
	public Optional<VaccinationCenter> getVaccinationCenterbyId(int centerid) {
		return centerRepository.findById(centerid);
	}

	@Override
	public Optional<VaccinationCenter> getVaccinationCenterbyPinCode(String pinCode) {
		return centerRepository.getByPinCode(pinCode);
	}

	@Override
	public Optional<VaccinationCenter> getVaccinationCenterByDistrict(String district) {
		return centerRepository.getByDistrict(district);
	}

}
