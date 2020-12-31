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
	
	private Hospital hospital;
	
	private int pontos;

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
		return pontos;
	}

	public void setPontos(int pontos) {
		
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
