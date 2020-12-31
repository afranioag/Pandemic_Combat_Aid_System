package com.phoebus.api.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Tomografo")
public class Tomografo extends Recurso {

	private int pontos;

	public Tomografo() {

	}

	public Tomografo(int quantidade) {
		super(quantidade);
		this.pontos = 12;
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
