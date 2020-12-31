package com.phoebus.api.models.hospitalDTO;

import java.util.List;

import com.phoebus.api.models.Negociacao;

public class RelatorioDTO {

	private double porcentagemMaior;
	
	private double porcentagemMenor;
	
	private double mediaMedico;
	
	private double mediaEnfermeiro;
	
	private double mediaTomografo;
	
	private double mediaRespirador;
	
	private double mediaAmbulancia;
	
	private List<Negociacao> relatorioNegociacao;

	public RelatorioDTO(double porcentagemMaior, double porcentagemMenor, double mediaMedico, double mediaEnfermeiro,
			double mediaTomografo, double mediaRespirador, double mediaAmbulancia,
			List<Negociacao> relatorioNegociacao) {
		super();
		this.porcentagemMaior = porcentagemMaior;
		this.porcentagemMenor = porcentagemMenor;
		this.mediaMedico = mediaMedico;
		this.mediaEnfermeiro = mediaEnfermeiro;
		this.mediaTomografo = mediaTomografo;
		this.mediaRespirador = mediaRespirador;
		this.mediaAmbulancia = mediaAmbulancia;
		this.relatorioNegociacao = relatorioNegociacao;
	}

	public double getPorcentagemMaior() {
		return porcentagemMaior;
	}

	public void setPorcentagemMaior(double porcentagemMaior) {
		this.porcentagemMaior = porcentagemMaior;
	}

	public double getPorcentagemMenor() {
		return porcentagemMenor;
	}

	public void setPorcentagemMenor(double porcentagemMenor) {
		this.porcentagemMenor = porcentagemMenor;
	}

	public double getMediaMedico() {
		return mediaMedico;
	}

	public void setMediaMedico(double mediaMedico) {
		this.mediaMedico = mediaMedico;
	}

	public double getMediaEnfermeiro() {
		return mediaEnfermeiro;
	}

	public void setMediaEnfermeiro(double mediaEnfermeiro) {
		this.mediaEnfermeiro = mediaEnfermeiro;
	}

	public double getMediaTomografo() {
		return mediaTomografo;
	}

	public void setMediaTomografo(double mediaTomografo) {
		this.mediaTomografo = mediaTomografo;
	}

	public double getMediaRespirador() {
		return mediaRespirador;
	}

	public void setMediaRespirador(double mediaRespirador) {
		this.mediaRespirador = mediaRespirador;
	}

	public double getMediaAmbulancia() {
		return mediaAmbulancia;
	}

	public void setMediaAmbulancia(double mediaAmbulancia) {
		this.mediaAmbulancia = mediaAmbulancia;
	}

	public List<Negociacao> getRelatorioNegociacao() {
		return relatorioNegociacao;
	}

	public void setRelatorioNegociacao(List<Negociacao> relatorioNegociacao) {
		this.relatorioNegociacao = relatorioNegociacao;
	}
	
	
	
	
}
