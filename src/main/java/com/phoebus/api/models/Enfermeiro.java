package com.phoebus.api.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Enfermeiro")
public class Enfermeiro extends Recurso {

	private int pontos;

	public Enfermeiro() {

	}

	public Enfermeiro(int quantidade) {
		super(quantidade);
		this.pontos = 3;
	}

	@Override
	public int getPontuacao() {
		return this.pontos * super.getQuantidade();
	}

	@Override
	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
