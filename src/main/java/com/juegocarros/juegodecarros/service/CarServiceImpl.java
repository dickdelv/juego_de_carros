package com.juegocarros.juegodecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juegocarros.juegodecarros.entity.Car;
import com.juegocarros.juegodecarros.repository.CarRepository;
/**
 *
 * @author dickdelv
 */
@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Car> findAll(Pageable pageable) {
		
		return carRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Car> findById(Long id) {
		
		return carRepository.findById(id);
	}

	@Override
	@Transactional
	public Car Save(Car car) {
		
		return carRepository.save(car);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		carRepository.deleteById(id);
		
	
	}

}
