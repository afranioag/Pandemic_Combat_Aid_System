package com.phoebus.api.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Respirador")
public class Respirador extends Recurso {

	private int pontos;

	public Respirador() {

	}

	public Respirador(int quantidade) {
		super(quantidade);
		this.pontos = 5;
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
