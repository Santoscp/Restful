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
import com.santoscastillo.apirestfulservice.model.Medicines;
import com.santoscastillo.apirestfulservice.exception.RecordNotFoundException;

import com.santoscastillo.apirestfulservice.services.MedicService;
import com.santoscastillo.apirestfulservice.services.MedicinesService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
 
@RestController
@RequestMapping("/medicines")
public class MedicinesServiceController
{
    @Autowired
    MedicinesService service;
 
    @GetMapping
    public ResponseEntity<List<Medicines>> getAllMedicines() {
        List<Medicines> list = service.getAllMedicines();
 
        return new ResponseEntity<List<Medicines>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Medicines> getMedicinesById(@PathVariable("id") Integer id)
                                                    throws Exception {
    	Medicines entity = service.getMedicinesById(id);
 
        return new ResponseEntity<Medicines>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Medicines>> getMedicinesByName(@PathVariable("name") String name)
       {
    	List <Medicines> list = service.getMedicinesByName(name);
 
        return new ResponseEntity <List<Medicines>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
  
 
   @PostMapping
    public ResponseEntity<Medicines> createMedicines(@Valid @RequestBody Medicines myMedicines){
    	Medicines created = service.createMedicine(myMedicines);
        return new ResponseEntity<Medicines>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Medicines> UpdateMedicines(@Valid @RequestBody Medicines myMedicines)
                                                    throws Exception {
    	Medicines updated = service.UpdateMedicines(myMedicines);
        return new ResponseEntity<Medicines>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteMedicineById(@PathVariable("id") Integer id)
                                                    throws Exception {
        service.deleteMedicinesById(id);
        return HttpStatus.ACCEPTED;
    }
 
}