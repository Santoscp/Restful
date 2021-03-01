package com.santoscastillo.apirestfulservice.services;

import com.santoscastillo.apirestfulservice.exception.RecordNotFoundException;

import com.santoscastillo.apirestfulservice.model.Medic;
import com.santoscastillo.apirestfulservice.model.Medicines;
import com.santoscastillo.apirestfulservice.model.Patient;

import com.santoscastillo.apirestfulservice.repositories.MedicRepository;
import com.santoscastillo.apirestfulservice.repositories.MedicinesRepository;
import com.santoscastillo.apirestfulservice.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicinesService {
	  @Autowired
	    MedicinesRepository repository;
	     
	    public List<Medicines> getAllMedicines()
	    {
	        List<Medicines> medicinesList = repository.findAll();
	         
	        if(medicinesList.size() > 0) {
	            return medicinesList;
	        } else {
	            return new ArrayList<Medicines>();
	        }
	    }
	    
	     
	    public Medicines getMedicinesById(Integer id) throws Exception
	    {
	        Optional<Medicines> medicine = repository.findById(id);
	         
	        if(medicine.isPresent()) {
	            return medicine.get();
	        } else {
	            throw new RecordNotFoundException("No medicine record exist for given id",id);
	        }
	    }
	    public Medicines createMedicine(Medicines entity){
	        entity = repository.save(entity);
	        return entity;
	    }
	    public Medicines UpdateMedicines(Medicines entity) throws Exception
	    {
	    	    	
	    	if(entity.getId()!=0)
	    	{
	    	  Optional<Medicines> medicines = repository.findById(entity.getId());
	        
	            if(medicines.isPresent())
	            {
	            	Medicines newEntity = medicines.get();
	                //newEntity.setId(entity.getId());
	                newEntity.setName(entity.getName());

	                newEntity = repository.save(newEntity);

	                return newEntity;
	            } else {
	                throw new RecordNotFoundException("Medicines not found",entity.getId());
	            }
	        }else{
	    		throw new RecordNotFoundException("No id of medicines given",0);
	    	}	    
	 }
	     
	    public void deleteMedicinesById(Integer id) throws Exception
	    {
	        Optional<Medicines> medicines = repository.findById(id);
	         
	        if(medicines.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No medicine record exist for given id",id);
	        }
	    }

	    public List<Medicines> getMedicinesByName(String name) {
	    	List<Medicines> medicinesList = repository.getByName(name);
	        
	        if(medicinesList.size() > 0) {
	            return medicinesList;
	        } else {
	            return new ArrayList<Medicines>();
	        }
	        
	    }
	    public List<Medicines> getMedicinesByPatient(Integer id) {
	    	List<Medicines> medicinesList = repository.getMedicinesByPatient(id);
	        
	        if(medicinesList.size() > 0) {
	            return medicinesList;
	        } else {
	            return new ArrayList<Medicines>();
	        }
	        
	    }
	    public Integer addMedicineToPatient(Integer idpatient, Integer idmedicine) {
	        repository.addMedicineToPatient(idpatient,idmedicine);
	        return idpatient;
	    }
	  
	}