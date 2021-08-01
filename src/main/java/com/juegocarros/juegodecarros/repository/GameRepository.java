package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Game;
/**
 *
 * @author dickdelv
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	
}
