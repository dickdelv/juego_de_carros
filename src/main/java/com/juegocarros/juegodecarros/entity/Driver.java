package com.juegocarros.juegodecarros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
/**
 *
 * @author dickdelv
 */
@Data
@Entity
@Table (name = "driver")
public class Driver extends Player {
	
	Driver() {
		
	}
	
	public Driver(long idPlayer, String namePlayer) {
		super(idPlayer, namePlayer);
	}

	@Column (name = "id_car")
	private long idCar;
}