package com.juegocarros.juegodecarros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author dickdelv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_track")
	private long idTrack;

	@Column (name = "name_track")
	private String nameTrack;
	
	@Column (name = "distance_track")
	private long distanceTrack;
}