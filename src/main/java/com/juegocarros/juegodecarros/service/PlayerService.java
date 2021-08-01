package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juegocarros.juegodecarros.entity.Player;
/**
 *
 * @author dickdelv
 */
public interface PlayerService {

	public Iterable<Player> findAll();
	
	public Page<Player> findAll(Pageable pageable);
	
	public Optional<Player> findById(Long id);
	
	public Player Save(Player player);
	
	public void deleteById(Long id);


}
