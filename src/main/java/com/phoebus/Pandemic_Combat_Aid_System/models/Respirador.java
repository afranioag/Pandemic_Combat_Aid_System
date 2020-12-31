package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Respirador")
public class Respirador extends Recurso {

	public Respirador() {
		
	}
	
	public Respirador(int quantidade) {
		super(quantidade);
	}

	@Override
	public int getPontos() {

		return 5 * super.getQuantidade();
	}

}
