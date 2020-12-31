package com.phoebus.Pandemic_Combat_Aid_System.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Negociacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Intercambio intercambio1;

	private Intercambio intercambio2;

	public Negociacao(Intercambio intercambio1, Intercambio intercambio2) {
		this.intercambio1 = intercambio1;
		this.intercambio2 = intercambio2;
	}

	public Negociacao() {

	}

	public Intercambio getIntercambio1() {
		return intercambio1;
	}

	public void setIntercambio1(Intercambio intercambio1) {
		this.intercambio1 = intercambio1;
	}

	public Intercambio getIntercambio2() {
		return intercambio2;
	}

	public void setIntercambio2(Intercambio intercambio2) {
		this.intercambio2 = intercambio2;
	}

	public long getId() {
		return id;
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
		Negociacao other = (Negociacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
