package com.santoscastillo.apirestfulservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "medic")
public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name = "dni")
	private String dni;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@JsonIgnoreProperties("medic")
	@OneToMany(mappedBy = "medic", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	List<Patient> patients;
	

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void addPatient(Patient patient) {
		if(!patients.contains(patient)) {
			patients.add(patient);
			patient.setMedic(this);
		}
	}
	public void removePatient(Patient patient) {
		if(!patients.contains(patient)) {
			patients.add(patient);
			patient.setMedic(null);
		}
	}
	
	
	
	
	
	

	
	
}
