package com.cg.vaccination.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vaccination.model.VaccinationCenter;



public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
	public Optional <VaccinationCenter> getByPinCode(String pinCode);
	public Optional <VaccinationCenter> getByDistrict(String district); 
}
