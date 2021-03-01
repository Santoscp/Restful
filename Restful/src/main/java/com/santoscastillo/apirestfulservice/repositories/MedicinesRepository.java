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
    		value="SELECT * FROM Medicines as m WHERE m.name LIKE %?1% ",
    		nativeQuery = true)
    		
    		

   
    public List<Medicines> getByName(String name);
}