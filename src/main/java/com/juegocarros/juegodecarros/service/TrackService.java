package com.juegocarros.juegodecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juegocarros.juegodecarros.entity.Track;
/**
 *
 * @author dickdelv
 */
public interface TrackService {
	
	public List<Track> findAll();
	
	public Page<Track> findAll(Pageable pageable);
	
	public Optional<Track> findById(Long id);
	
	public Track Save(Track track);
	
	public void deleteById(Long id);
	
	public void updateDistanciaPista(int longitudPista);
	
	public int countTrack();

}