package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juegocarros.juegodecarros.entity.Game;
import com.juegocarros.juegodecarros.repository.GameRepository;
/**
 *
 * @author dickdelv
 */
@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Game> findAll() {
		
		return gameRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Game> findAll(Pageable pageable) {
		
		return gameRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Game> findById(Long id) {
		
		return gameRepository.findById(id);
	}

	@Override
	@Transactional
	public Game Save(Game game) {
		
		return gameRepository.save(game);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		gameRepository.deleteById(id);
		
	}

}
