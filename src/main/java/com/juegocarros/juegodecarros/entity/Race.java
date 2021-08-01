package com.juegocarros.juegodecarros.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author dickdelv
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race {
	
	private Driver driverRace;
	private int distancia_avanzada;

	
}
