package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Ambulancia")
public class Ambulancia extends Recurso {

	public Ambulancia() {

	}

	public Ambulancia(int quantidade) {
		super(quantidade);
	}

	@Override
	public int getPontos() {

		return 10 * super.getQuantidade();
	}
}
