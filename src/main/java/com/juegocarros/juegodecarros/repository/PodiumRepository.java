package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Podium;
/**
 *
 * @author dickdelv
 */
@Repository
public interface PodiumRepository extends JpaRepository<Podium, Long> {

}
