package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Lane;

/**
 *
 * @author dickdelv
 */
@Repository
public interface LaneRepository extends JpaRepository<Lane, Long>{

}
