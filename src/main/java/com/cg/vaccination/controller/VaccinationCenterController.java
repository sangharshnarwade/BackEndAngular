package com.cg.vaccination.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.cg.vaccination.exception.VaccinationCenterNotFoundException;
import com.cg.vaccination.model.VaccinationCenter;
import com.cg.vaccination.service.VaccinationCenterService;

@RestController
@RequestMapping("/api")
@CrossOrigin (origins = "http://localhost:4200")
public class VaccinationCenterController {

	
	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@PostMapping("/vaccination/center/new")
	public VaccinationCenter addVaccinationCenter(@Valid @RequestBody VaccinationCenter vaccinationCenter) {
		return vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
	}
	
	@GetMapping("/vaccination/center/all")
	public List<VaccinationCenter> allVaccinationCenter() {
		return vaccinationCenterService.allVaccineCenters();
	}
	@GetMapping("/vaccination/center/centerid/{centerId}")
	public ResponseEntity<VaccinationCenter> getVaccinationCenterById(@PathVariable(value = "centerId") Integer centerid)
			throws VaccinationCenterNotFoundException {
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterbyId(centerid).orElseThrow(
				() -> new VaccinationCenterNotFoundException("No Vaccination Center found with id :  " + centerid));
		return ResponseEntity.ok().body(vaccinationCenter);
	}
	@PutMapping("/vaccination/center/update/{centerid}")
	public ResponseEntity<VaccinationCenter> updateVaccinationCenter(@PathVariable(value = "centerid") Integer centerid,
			@Valid @RequestBody VaccinationCenter centerDetails) throws VaccinationCenterNotFoundException {
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterbyId(centerid).orElseThrow(
				() -> new VaccinationCenterNotFoundException("No Vaccination Center found with id :  " + centerid));
		vaccinationCenter.setCenterName(centerDetails.getCenterName());
		vaccinationCenter.setAddress(centerDetails.getAddress());
		vaccinationCenter.setDistrict(centerDetails.getDistrict());
		vaccinationCenter.setState(centerDetails.getState());
		vaccinationCenter.setPinCode(centerDetails.getPinCode());
		VaccinationCenter updatedCenter = vaccinationCenterService.updateVaccinationCenter(vaccinationCenter);
		return ResponseEntity.ok(updatedCenter); // Response entity means sending respons with data and status and also header
	}
	@DeleteMapping("/vaccination/center/delete/{centerid}")
	public Map<String, Boolean> deleteVaccinationCenter(@PathVariable(value = "centerid") Integer centerId)
			throws VaccinationCenterNotFoundException {
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterbyId(centerId).orElseThrow(
				() -> new VaccinationCenterNotFoundException("No Vaccination Center found with id :  " + centerId));
		vaccinationCenterService.deleteVaccinationCenter(vaccinationCenter);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		return response;

	}
}
