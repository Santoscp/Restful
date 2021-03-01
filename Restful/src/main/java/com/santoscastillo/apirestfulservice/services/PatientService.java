package com.santoscastillo.apirestfulservice.services;

import com.santoscastillo.apirestfulservice.exception.RecordNotFoundException;

import com.santoscastillo.apirestfulservice.model.Medic;
import com.santoscastillo.apirestfulservice.model.Patient;

import com.santoscastillo.apirestfulservice.repositories.MedicRepository;
import com.santoscastillo.apirestfulservice.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	  @Autowired
	    PatientRepository repository;
	     
	    public List<Patient> getAllPatient()
	    {
	        List<Patient> patientList = repository.findAll();
	         
	        if(patientList.size() > 0) {
	            return patientList;
	        } else {
	            return new ArrayList<Patient>();
	        }
	    }
	    
	     
	    public Patient getPatientById(Integer id) throws Exception
	    {
	        Optional<Patient> patient = repository.findById(id);
	         
	        if(patient.isPresent()) {
	            return patient.get();
	        } else {
	            throw new RecordNotFoundException("No patient record exist for given id",id);
	        }
	    }
	    public Patient createPatient(Patient entity){
	        entity = repository.save(entity);
	        return entity;
	    }
	    public Patient UpdatePatient(Patient entity) throws Exception
	    {
	    	    	
	    	if(entity.getId()!=0)
	    	{
	    	  Optional<Patient> patient = repository.findById(entity.getId());
	        
	            if(patient.isPresent())
	            {
	            	Patient newEntity = patient.get();
	                //newEntity.setId(entity.getId());
	                newEntity.setAllegerns(entity.getAllegerns());
	                newEntity.setName(entity.getName());
	                newEntity.setDni(entity.getDni());

	                newEntity = repository.save(newEntity);

	                return newEntity;
	            } else {
	                throw new RecordNotFoundException("Patient not found",entity.getId());
	            }
	        }else{
	    		throw new RecordNotFoundException("No id of patient given",0);
	    	}	    
	 }
	     
	    public void deletePatientById(Integer id) throws Exception
	    {
	        Optional<Patient> patient = repository.findById(id);
	         
	        if(patient.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No patient record exist for given id",id);
	        }
	    }

	    public List<Patient> getPatientByName(String name) {
	    	List<Patient> patientList = repository.getByName(name);
	        
	        if(patientList.size() > 0) {
	            return patientList;
	        } else {
	            return new ArrayList<Patient>();
	        }
	        
	    }
	    public Patient getPatientByDni(String dni) {
	    	Patient patientByDni= repository.getByDni(dni);
	        
	       
	            return patientByDni;
	        
	        
	    }
	}