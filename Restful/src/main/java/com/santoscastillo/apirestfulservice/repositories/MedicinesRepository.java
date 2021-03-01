package com.santoscastillo.apirestfulservice.repositories;


import com.santoscastillo.apirestfulservice.model.Medicines;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 

@Repository
public interface MedicinesRepository
        extends JpaRepository<Medicines, Integer> {

    @Query(
    		value="SELECT * FROM medicines AS m WHERE m.name LIKE %?1% ",
    		nativeQuery = true)
    		
    		

   
    public List<Medicines> getByName(String name);
    
    @Query(
    		value="SELECT m.* FROM medicines AS m JOIN patient_medicine ON m.id=patient_medicine.id_medicine WHERE patient_medicine.id_patient = ?1 ",
    				 
    		nativeQuery = true)
   
    public List<Medicines> getMedicinesByPatient(Integer name);
    
    
    @Query(value = "INSERT INTO patient_medicine(id_patient, id_medicine)" +
            "VALUES (?1, ?2) RETURNING id_patient", nativeQuery = true)
    Integer addMedicineToPatient(Integer idpatient, Integer idmedicine);
    
    
}