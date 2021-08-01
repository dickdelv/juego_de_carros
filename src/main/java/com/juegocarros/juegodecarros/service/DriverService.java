package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juegocarros.juegodecarros.entity.Driver;
/**
 *
 * @author dickdelv
 */
public interface DriverService {
	
    public Iterable<Driver> findAll();
	
	public Page<Driver> findAll(Pageable pageable);
	
	public Optional<Driver> findById(Long id);
	
	public Driver Save(Driver driver);
	
	public void deleteById(Long id);
	
	public int latestIdDriver();

}
