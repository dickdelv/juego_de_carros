package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Car;

/**
 *
 * @author dickdelv
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
