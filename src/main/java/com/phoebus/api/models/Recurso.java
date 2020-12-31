package com.phoebus.api.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Recurso implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantidade;

	public Recurso() {
		
	}
	
	public Recurso(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void adicionaRecurso(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void subtraiRecurso(int quantidade) {
		this.quantidade -= quantidade;
	}

	public abstract int getPontuacao();
	
	public abstract int getPontos();

	public Long getId() {
		return id;
	}
	
}
