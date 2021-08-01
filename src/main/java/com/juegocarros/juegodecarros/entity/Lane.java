package com.juegocarros.juegodecarros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
/**
 *
 * @author dickdelv
 */
@Builder
@Data
@Entity
@Table(name = "lane")
public class Lane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_lane")
	private long idLane;
	
	@Column (name = "id_track")
	private long idTrack;
}