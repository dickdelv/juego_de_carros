package com.juegocarros.juegodecarros.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
@MappedSuperclass
public class Player {
	
	@Id
	@Column (name = "id_player")
	private long idPlayer;

	@Column (name = "name_player")
	private String namePlayer;
}