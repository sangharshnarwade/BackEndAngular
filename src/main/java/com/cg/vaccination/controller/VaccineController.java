package com.cg.vaccination.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cg.vaccination.exception.VaccineNotFoundException;
import com.cg.vaccination.model.Vaccine;
import com.cg.vaccination.service.VaccineService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/admin")
public class VaccineController {


	@Autowired
	private VaccineService vaccineService;

	@PostMapping("/vaccine/add")
	private Vaccine addVaccine(@RequestBody Vaccine vaccine) {
		return vaccineService.addVaccine(vaccine);
	}

	@PutMapping("/id/vaccine/update/{id}")
	public ResponseEntity<Vaccine> updateVaccine(@PathVariable(value = "id") Integer vaccineId,
			@RequestBody Vaccine vaccineDetails) throws VaccineNotFoundException {
		Vaccine vaccine = vaccineService.getVaccineById(vaccineId)
				.orElseThrow(() -> new VaccineNotFoundException("No Vaccine Found with this id:" + vaccineId));
		vaccine.setVaccineName(vaccineDetails.getVaccineName());
		vaccine.setDescription(vaccineDetails.getDescription());
		Vaccine updateVaccine = vaccineService.updateVaccine(vaccine);
		return ResponseEntity.ok(updateVaccine);
	}

	@GetMapping("/vaccine")
	private List<Vaccine> getAllVaccine() {
		return vaccineService.allVaccine();
	}

	@GetMapping("/vaccines/{vaccineId}")
	private ResponseEntity<Vaccine> getVaccineById(@PathVariable(value = "vaccineId") Integer vaccineId)
			throws VaccineNotFoundException {

		Vaccine vaccine = vaccineService.getVaccineById(vaccineId)
				.orElseThrow(() -> new VaccineNotFoundException("No Vaccine Found with this id " + vaccineId));
		return ResponseEntity.ok().body(vaccine);
	}

	@DeleteMapping("vaccine/delete/{id}")
	private Map<String, Boolean> deleteVaccineByVaccineId(@PathVariable(value = "id") Integer vaccineId)
			throws VaccineNotFoundException {
		Vaccine vaccine = vaccineService.getVaccineById(vaccineId)
				.orElseThrow(() -> new VaccineNotFoundException("No Vaccine Found with this ID:" + vaccineId));
		vaccineService.deleteVaccine(vaccine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/name/{vaccineName}")
	private ResponseEntity<Vaccine> getVaccineByName(@PathVariable(value = "vaccineName") String vaccineName)
			throws VaccineNotFoundException {
		Vaccine vaccine = vaccineService.getVaccineByName(vaccineName)
				.orElseThrow(() -> new VaccineNotFoundException("No Vaccine Found with this id " + vaccineName));
		return ResponseEntity.ok().body(vaccine);
	}
}
