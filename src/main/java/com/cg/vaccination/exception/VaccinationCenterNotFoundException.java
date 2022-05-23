package com.cg.vaccination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VaccinationCenterNotFoundException extends Exception {

	public VaccinationCenterNotFoundException() {
	}

	public VaccinationCenterNotFoundException(String message) {
		super(message);

	}

}
