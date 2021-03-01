package com.santoscastillo.apirestfulservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "medicines")
public class Medicines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@JsonIgnoreProperties("medicines")
	@ManyToMany(mappedBy = "medicines", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Patient> patients;
	
	
	
	
	
	
	
	
	public void addPatient(Patient patient){
        if(this.patients == null){
            this.patients = new ArrayList<Patient>();
        }
        this.patients.add(patient);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		patients.forEach(p->{
			addPatient(p);
		});
	}
	
	
   

}
