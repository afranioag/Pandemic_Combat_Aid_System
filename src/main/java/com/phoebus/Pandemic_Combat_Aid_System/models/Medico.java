package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Medico")
public class Medico extends Recurso{
	
	public Medico() {
		
	}
	
	public Medico(int quantidade) {
		super(quantidade);
	}
	
	@Override
	public int getPontos() {
		return 3 * super.getQuantidade();
	}

}
