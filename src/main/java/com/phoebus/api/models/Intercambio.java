package com.phoebus.api.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

	@OneToOne
	private Hospital hospital;

	public Intercambio(int medico, int enfermeiro, int tomografo, int ambulancia, int respirador, Hospital hospital) {
		this.ambulancia = ambulancia;
		this.enfermeiro = enfermeiro;
		this.tomografo = tomografo;
		this.respirador = respirador;
		this.medico = medico;
		this.hospital = hospital;
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getPontos() {
		List<Recurso> recursos = hospital.getRecursos();

		int pontos = 0;
		pontos += recursos.get(0).getPontos() * this.medico;
		pontos += recursos.get(1).getPontos() * this.enfermeiro;
		pontos += recursos.get(2).getPontos() * this.tomografo;
		pontos += recursos.get(3).getPontos() * this.respirador;
		pontos += recursos.get(4).getPontos() * this.ambulancia;
		
		return pontos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intercambio other = (Intercambio) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
