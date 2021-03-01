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
	 
	

}