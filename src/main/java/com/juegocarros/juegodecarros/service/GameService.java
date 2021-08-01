package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juegocarros.juegodecarros.entity.Game;
/**
 *
 * @author dickdelv
 */
public interface GameService {
	
	public Iterable<Game> findAll();
	
	public Page<Game> findAll(Pageable pageable);
	
	public Optional<Game> findById(Long id);
	
	public Game Save(Game game);
	
	public void deleteById(Long id);

}
