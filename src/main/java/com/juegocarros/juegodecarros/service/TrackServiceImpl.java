package com.juegocarros.juegodecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.juegocarros.juegodecarros.entity.Track;
import com.juegocarros.juegodecarros.repository.TrackRepository;
/**
 *
 * @author dickdelv
 */
@Service
public class TrackServiceImpl implements TrackService {
	
	@Autowired
	private TrackRepository trackRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Track> findAll() {
		
		return trackRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Track> findAll(Pageable pageable) {
		
		return trackRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Track> findById(Long id) {
		
		return trackRepository.findById(id);
	}

	@Override
	@Transactional
	public Track Save(Track track) {
		
		return trackRepository.save(track);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		trackRepository.deleteById(id);
		
	
	}

	@Override
	public void updateDistanciaPista(int longitudPista) {
		
		trackRepository.updateDistanciaPista(longitudPista);
		
	}

	@Override
	@Transactional(readOnly = true)
	public int countTrack() {
 
		return trackRepository.countTrack();
		
	}

}
