package com.santoscastillo.apirestfulservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.santoscastillo.apirestfulservice.model.Medic;
import com.santoscastillo.apirestfulservice.model.Patient;
import com.santoscastillo.apirestfulservice.exception.RecordNotFoundException;

import com.santoscastillo.apirestfulservice.services.MedicService;
import com.santoscastillo.apirestfulservice.services.PatientService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
@RestController
@RequestMapping("/patient")
public class PatientServiceController
{
    @Autowired
    PatientService service;
 
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> list = service.getAllPatient();
 
        return new ResponseEntity<List<Patient>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id)
                                                    throws Exception {
    	Patient entity = service.getPatientById(id);
 
        return new ResponseEntity<Patient>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Patient> getPatientByDni(@PathVariable("dni") String dni)
                                                    throws Exception {
    	Patient entity = service.getPatientByDni(dni);
 
        return new ResponseEntity<Patient>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Patient>> getPatientByName(@PathVariable("name") String name)
       {
    	List <Patient> list = service.getPatientByName(name);
 
        return new ResponseEntity <List<Patient>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
  
 
   @PostMapping
    public ResponseEntity<Patient> createMedic(@Valid @RequestBody Patient myPatient){
	   Patient created = service.createPatient(myPatient);
        return new ResponseEntity<Patient>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Patient> UpdatePatient(@Valid @RequestBody Patient myPatient)
                                                    throws Exception {
    	Patient updated = service.UpdatePatient(myPatient);
        return new ResponseEntity<Patient>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deletePatientById(@PathVariable("id") Integer id)
                                                    throws Exception {
        service.deletePatientById(id);
        return HttpStatus.ACCEPTED;
    }
 
}