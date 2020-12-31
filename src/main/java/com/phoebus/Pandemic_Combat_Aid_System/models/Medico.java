package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Medico")
public class Medico extends Recurso{
	
	private int pontos;
	
	public Medico() {
		
	}
	
	public Medico(int quantidade) {
		super(quantidade);
		this.pontos = 3;
	}
	
	@Override
	public int getPontuacao() {
		return this.pontos * super.getQuantidade();
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	
}
