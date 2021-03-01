package com.santoscastillo.apirestfulservice.repositories;





import com.santoscastillo.apirestfulservice.model.Medic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 

@Repository
public interface MedicRepository
        extends JpaRepository<Medic, Integer> {
	 @Query(
	    		value="SELECT * FROM Medic as m WHERE m.name LIKE %?1% ",
	    		nativeQuery = true)
	    		
	    		

	   
	    public List<Medic> getByName(String name);
	
	 
	 @Query(
	    		value="SELECT * FROM Medic as m WHERE m.dni LIKE ?1 ",
	    		nativeQuery = true)
	 public Medic getByDni(String dni);
	 
	 @Query(
	    		value="SELECT m.* FROM Medic AS m WHERE patient.id LIKE ?1 ",
	    		nativeQuery = true)
	 public Medic getByPatient(Integer id);
	 
	

}