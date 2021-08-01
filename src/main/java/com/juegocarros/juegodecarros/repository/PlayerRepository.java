package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Player;
/**
 *
 * @author dickdelv
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
