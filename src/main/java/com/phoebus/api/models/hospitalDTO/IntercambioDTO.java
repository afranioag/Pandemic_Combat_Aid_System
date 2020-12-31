package com.phoebus.api.models.hospitalDTO;

import java.util.List;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Intercambio;
import com.phoebus.api.models.Recurso;

public class IntercambioDTO {

	private int medico;

	private int enfermeiro;

	private int tomografo;

	private int ambulancia;

	private int respirador;

	public IntercambioDTO(int medico, int enfermeiro, int tomografo, int ambulancia, int respirador) {
		this.ambulancia = ambulancia;
		this.enfermeiro = enfermeiro;
		this.tomografo = tomografo;
		this.respirador = respirador;
		this.medico = medico;
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

	public Intercambio intercambioCriacaoDTO(Hospital hospital) {
		
		// caso a quantidade de algum recurso para intercambio for menor que a
		// quantidade existente será retornado null
		List<Recurso> recursos = hospital.getRecursos();
		if (recursos.get(0).getQuantidade() < medico || recursos.get(1).getQuantidade() < enfermeiro
				|| recursos.get(2).getQuantidade() < tomografo || recursos.get(3).getQuantidade() < respirador
				|| recursos.get(4).getQuantidade() < ambulancia) {

			return null;

		}

		Intercambio intercambio = new Intercambio(medico, enfermeiro, tomografo, respirador, ambulancia, hospital);

		return intercambio;
	}
}
