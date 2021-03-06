package com.phoebus.api.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Ambulancia")
public class Ambulancia extends Recurso {

	private int pontos;

	public Ambulancia() {

	}

	public Ambulancia(int quantidade) {
		super(quantidade);
		this.pontos = 10;
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
