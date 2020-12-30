package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String cnpj;
	
	private String endereco;
	
	private String localizacao;

	private Double ocupacao;
	
	public Hospital() {
		
	}

	public Hospital(String nome, String cnpj, String endereco, String localizacao, Double ocupacao) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.localizacao = localizacao;
		this.ocupacao = ocupacao;
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

	public long getId() {
		return id;
	}
	
	public Double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Double ocupacao) {
		this.ocupacao = ocupacao;
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
		Hospital other = (Hospital) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospital [nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + "]";
	}
	
	
	
}
