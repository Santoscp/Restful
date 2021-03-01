package com.santoscastillo.apirestfulservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.santoscastillo.apirestfulservice.model.Medic;
import com.santoscastillo.apirestfulservice.model.Medicines;
import com.santoscastillo.apirestfulservice.model.Patient;

@Repository
public interface PatientRepository
        extends JpaRepository<Patient, Integer> {
	 @Query(
	    		value="SELECT * FROM Patient as p WHERE p.name LIKE %?1% ",
	    		nativeQuery = true)
	    		
	    		

	   
	    public List<Patient> getByName(String name);
	 
	 @Query(
	    		value="SELECT * FROM Patient as p WHERE p.dni LIKE ?1 ",
	    		nativeQuery = true)
	 public Patient getByDni(String dni);
	 
	 
	 @Query(
	    		value="SELECT p.* FROM Patient as p WHERE id_medic = ?1 ",
	    		nativeQuery = true)
	 public List<Patient> getByMedic(Integer id);

	 
	


}