package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder.In;

@Entity
public class Intercambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int medico;

	private int enfermeiro;

	private int tomografo;

	private int ambulancia;

	private int respirador;

	public Intercambio(int medico, int enfermeiro, int tomografo, int ambulancia, int respirador) {
		this.ambulancia = ambulancia;
		this.enfermeiro = enfermeiro;
		this.tomografo = tomografo;
		this.respirador = respirador;
		this.medico = medico;
	}

	public Intercambio() {

	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}

	public int getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(int enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public int getTomografo() {
		return tomografo;
	}

	public void setTomografo(int tomografo) {
		this.tomografo = tomografo;
	}

	public int getAmbulancia() {
		return ambulancia;
	}

	public void setAmbulancia(int ambulancia) {
		this.ambulancia = ambulancia;
	}

	public int getRespirador() {
		return respirador;
	}

	public void setRespirador(int respirador) {
		this.respirador = respirador;
	}

	public long getId() {
		return id;
	}

}
