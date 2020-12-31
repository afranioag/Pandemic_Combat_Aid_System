package com.phoebus.Pandemic_Combat_Aid_System.models.hospitalDTO;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;

public class HospitalAtualizaDTO {

	private Double ocupacao;

	public HospitalAtualizaDTO() {
		super();
	}

	public HospitalAtualizaDTO(Hospital hospital) {
		this.ocupacao = hospital.getOcupacao();
	}

	public Double getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Double ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Hospital converteHospital(Hospital hospital) {

		hospital.setOcupacao(ocupacao);

		return hospital;

	}

}
