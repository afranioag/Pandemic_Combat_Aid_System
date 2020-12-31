package com.phoebus.api.models.hospitalDTO;

import com.phoebus.api.models.Hospital;

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
