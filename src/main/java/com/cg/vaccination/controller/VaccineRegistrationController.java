package com.cg.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vaccination.model.VaccineRegistration;
import com.cg.vaccination.service.VaccineRegistrationService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/user")
public class VaccineRegistrationController {
	
	@Autowired
	private VaccineRegistrationService vaccineRegistrationService;
	
	@PostMapping("/vaccine/registration/new")
	public VaccineRegistration addVaccineRegistration(@RequestBody VaccineRegistration reg) {
		return vaccineRegistrationService.addVaccineRegistration(reg);
	}
}
