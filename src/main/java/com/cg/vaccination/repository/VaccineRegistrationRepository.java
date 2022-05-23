package com.cg.vaccination.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.vaccination.model.VaccineRegistration;

public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Integer> {

}
