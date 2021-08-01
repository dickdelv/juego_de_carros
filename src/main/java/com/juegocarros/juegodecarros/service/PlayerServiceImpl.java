package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


import com.juegocarros.juegodecarros.entity.Player;
import com.juegocarros.juegodecarros.repository.PlayerRepository;
/**
 *
 * @author dickdelv
 */
public class PlayerServiceImpl implements PlayerService{
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Player> findAll() {
		
		return playerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Player> findAll(Pageable pageable) {
		
		return playerRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Player> findById(Long id) {
		
		return playerRepository.findById(id);
	}

	@Override
	@Transactional
	public Player Save(Player player) {
		
		return playerRepository.save(player);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		playerRepository.deleteById(id);
		
	}

}
