package com.juegocarros.juegodecarros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 *
 * @author dickdelv
 */
@Data
@Entity
@Table(name = "podium")
public class Podium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_podium")
	private long idPodium;
	
	@Column (name = "id_game")
	private long idGame;
	
	@Column (name = "id_track")
	private long idTrack;
	
	@Column (name = "id_first_place")
	private long idFirstPlace;
	
	@Column (name = "id_second_place")
	private long idSecondPlace;
	
	@Column (name = "id_third_place")
	private long idThirdPlace;
}