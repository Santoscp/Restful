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
import com.santoscastillo.apirestfulservice.exception.RecordNotFoundException;

import com.santoscastillo.apirestfulservice.services.MedicService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
@RestController
@RequestMapping("/medic")
public class MedicServiceController
{
    @Autowired
    MedicService service;
 
    @GetMapping
    public ResponseEntity<List<Medic>> getAllMedics() {
        List<Medic> list = service.getAllMedic();
 
        return new ResponseEntity<List<Medic>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Medic> getMedicById(@PathVariable("id") Integer id)
                                                    throws Exception {
    	Medic entity = service.getMedicById(id);
 
        return new ResponseEntity<Medic>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Medic> getMedicByDni(@PathVariable("dni") String dni)
                                                    throws Exception {
    	Medic entity = service.getMedicByDni(dni);
 
        return new ResponseEntity<Medic>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Medic>> getMedicByName(@PathVariable("name") String name)
       {
    	List <Medic> list = service.getMedicByName(name);
 
        return new ResponseEntity <List<Medic>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
  
 
   @PostMapping
    public ResponseEntity<Medic> createMedic(@Valid @RequestBody Medic myMedic){
    	Medic created = service.createMedic(myMedic);
        return new ResponseEntity<Medic>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Medic> UpdateMedic(@Valid @RequestBody Medic myMedic)
                                                    throws Exception {
    	Medic updated = service.UpdateMedic(myMedic);
        return new ResponseEntity<Medic>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteMedicById(@PathVariable("id") Integer id)
                                                    throws Exception {
        service.deleteMedicById(id);
        return HttpStatus.ACCEPTED;
    }
 
}