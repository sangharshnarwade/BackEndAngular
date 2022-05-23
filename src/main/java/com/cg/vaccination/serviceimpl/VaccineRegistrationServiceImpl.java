package com.cg.vaccination.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vaccination.model.VaccineRegistration;
import com.cg.vaccination.repository.VaccineRegistrationRepository;
import com.cg.vaccination.service.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Autowired
	private VaccineRegistrationRepository vaccineRegistrationRepository;

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) {
		return vaccineRegistrationRepository.save(reg);
	}

}
