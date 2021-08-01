package com.juegocarros.juegodecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juegocarros.juegodecarros.entity.Car;
/**
 *
 * @author dickdelv
 */
 public interface CarService {
	
	    public List<Car> findAll();
		
		public Page<Car> findAll(Pageable pageable);
		
		public Optional<Car> findById(Long id);
		
		public Car Save(Car car);
		
		public void deleteById(Long id);

}
