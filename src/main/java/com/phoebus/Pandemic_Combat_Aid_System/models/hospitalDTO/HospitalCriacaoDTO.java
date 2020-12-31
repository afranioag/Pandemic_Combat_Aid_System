package com.phoebus.Pandemic_Combat_Aid_System.models.hospitalDTO;

import java.util.List;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;
import com.phoebus.Pandemic_Combat_Aid_System.models.Medico;
import com.phoebus.Pandemic_Combat_Aid_System.models.Recurso;

public class HospitalCriacaoDTO {
	private String nome;

	private String cnpj;

	private String endereco;

	private String localizacao;

	private Double ocupacao;

	private List<Integer> recursos;
	
	public HospitalCriacaoDTO() {
		super();
	}

	public HospitalCriacaoDTO(Hospital hospital) {
		this.nome = hospital.getNome();
		this.cnpj = hospital.getCnpj();
		this.endereco = hospital.getEndereco();
		this.localizacao = hospital.getLocalizacao();
		this.ocupacao = hospital.getOcupacao();
	}

	public Hospital converteHospital(List<Recurso> listaRecurso) {

		Hospital hospital = new Hospital(nome, cnpj, endereco, localizacao, ocupacao);
		
		hospital.setRecursos(listaRecurso);

		return hospital;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Double ocupacao) {
		this.ocupacao = ocupacao;
	}

	public List<Integer> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Integer> recursos) {
		this.recursos = recursos;
	}

}
