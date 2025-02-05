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
public class MedicService {
	  @Autowired
	    MedicRepository repository;
	  
	  @Autowired
	  PatientRepository repositorypatient;
	     
	    public List<Medic> getAllMedic()
	    {
	        List<Medic> medicList = repository.findAll();
	         
	        if(medicList.size() > 0) {
	            return medicList;
	        } else {
	            return new ArrayList<Medic>();
	        }
	    }
	    
	     
	    public Medic getMedicById(Integer id) throws Exception
	    {
	        Optional<Medic> medic = repository.findById(id);
	        
	        if(medic.isPresent()) {
	        	
	            return medic.get();
	        } else {
	            throw new RecordNotFoundException("No medic record exist for given id",id);
	        }
	    }
	    public Medic createMedic(Medic entity){
	        entity = repository.save(entity);
	        return entity;
	    }
	    public Medic UpdateMedic(Medic entity) throws Exception
	    {
	    	    	
	    	if(entity.getId()!=0)
	    	{
	    	  Optional<Medic> medic = repository.findById(entity.getId());
	        
	            if(medic.isPresent())
	            {
	                Medic newEntity = medic.get();
	                //newEntity.setId(entity.getId());
	                newEntity.setDni(entity.getDni());
	                newEntity.setName(entity.getName());

	                newEntity = repository.save(newEntity);

	                return newEntity;
	            } else {
	                throw new RecordNotFoundException("Medic not found",entity.getId());
	            }
	        }else{
	    		throw new RecordNotFoundException("No id of medic given",0);
	    	}	    
	 }
	     
	    public void deleteMedicById(Integer id) throws Exception
	    {
	        Optional<Medic> medic = repository.findById(id);
	         
	        if(medic.isPresent())
	        {
	        	if(medic.get().getPatients()!=null && medic.get().getPatients().size()>0) {
	        		throw new RecordNotFoundException("Delete patient first",id);
	        	}else {
	        		repository.deleteById(id);
	        	}
	        } else {
	            throw new RecordNotFoundException("No medic record exist for given id",id);
	        }
	    }

	    public List<Medic> getMedicByName(String name) {
	    	List<Medic> medicList = repository.getByName(name);
	        
	        if(medicList.size() > 0) {
	            return medicList;
	        } else {
	            return new ArrayList<Medic>();
	        }
	        
	    }
	    public Medic getMedicByDni(String dni) {
	    	Medic medicByDni= repository.getByDni(dni);
	        
	       
	            return medicByDni;
	        
	        
	    }
	    public Medic addPatientToMedic(Integer id_patient, Integer id_medic){

	        Optional<Medic> medic = repository.findById(id_medic);
	        Optional<Patient> patient = repositorypatient.findById(id_patient);

	        medic.get().addPatient(patient.get());
	        repositorypatient.save(patient.get());

	        return medic.get();
	    }
	    
	   
	   
	}





