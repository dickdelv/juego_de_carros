package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Driver;
import java.util.List;

/**
 *
 * @author dickdelv
 */	
    @Repository
	public interface DriverRepository extends JpaRepository<Driver, Long>{
    	
    	@Query(value= "SELECT * FROM driver", nativeQuery = true)
        public List <Driver> latestIdDriver();

}