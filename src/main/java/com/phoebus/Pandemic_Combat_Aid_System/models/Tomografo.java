package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Tomografo")
public class Tomografo extends Recurso {

	public Tomografo() {
		
	}
	
	public Tomografo(int quantidade) {
		super(quantidade);
	}

	@Override
	public int getPontos() {

		return 12 * super.getQuantidade();
	}
}
