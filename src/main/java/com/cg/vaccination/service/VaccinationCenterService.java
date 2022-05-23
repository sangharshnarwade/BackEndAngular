package com.cg.vaccination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.vaccination.model.VaccinationCenter;

public interface VaccinationCenterService {
	public List<VaccinationCenter> allVaccineCenters();

	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationcenter);

	public Optional<VaccinationCenter> getVaccinationCenterbyId(int centerid);

	public VaccinationCenter updateVaccinationCenter(VaccinationCenter vaccinationcenter);

	public void deleteVaccinationCenter(VaccinationCenter vaccinationCenter);
	
	public Optional<VaccinationCenter> getVaccinationCenterbyPinCode(String pinCode);
	
	public Optional <VaccinationCenter> getVaccinationCenterByDistrict(String district); 

}
