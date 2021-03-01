package com.santoscastillo.apirestfulservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
    @NotBlank
    @Column(name="dni")
    private String dni;
    
    @Column(name="allergens")
    private String allegerns;
    
    
    
    @ManyToMany(cascade=CascadeType.MERGE)
    @JsonIgnoreProperties("patients")
    @JoinTable(
            name = "patient_medicine",
            joinColumns = @JoinColumn(name = "id_patient"),
            inverseJoinColumns = @JoinColumn(name = "id_medicine")
    )
    private List<Medicines> medicines;
    
    
    
    @JsonIgnoreProperties("patients")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medic")
    private Medic medic;
    
    
    
    public Medic getMedic() {
		return medic;
	}

    public void setMedic(Medic medic) {

        this.medic=medic;
         
       }
	public void addMedicine(Medicines medicine){
        if(this.medicines == null){
            this.medicines = new ArrayList<Medicines>();
        }
        this.medicines.add(medicine);
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAllegerns() {
		return allegerns;
	}

	public void setAllegerns(String allegerns) {
		this.allegerns = allegerns;
	}

	public List<Medicines> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicines> medicines) {
		medicines.forEach(m->{
			addMedicine(m);
		});
	}
	
	
	
    
   

}
