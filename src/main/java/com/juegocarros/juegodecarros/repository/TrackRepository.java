package com.juegocarros.juegodecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juegocarros.juegodecarros.entity.Track;

/**
 *
 * @author dickdelv
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
	
	@Query(value= "UPDATE track SET distance = :distanceTrack", nativeQuery = true)
	public void updateDistanciaPista(@Param("distanceTrack") Integer distanceTrack);
	
	@Query(value= "SELECT count(id_track) FROM track", nativeQuery = true)
	public int countTrack();
	
}