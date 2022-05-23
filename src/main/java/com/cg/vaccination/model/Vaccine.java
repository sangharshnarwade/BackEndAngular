package com.cg.vaccination.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String vaccineName;
	private String description;

	
}
