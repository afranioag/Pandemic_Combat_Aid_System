package com.phoebus.api.service;

import java.util.List;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Intercambio;
import com.phoebus.api.models.Negociacao;
import com.phoebus.api.models.hospitalDTO.IntercambioDTO;

public interface IntercambioService {

	Intercambio criaIntercambio(IntercambioDTO intercambioDTO, long idHospital);
	
	void deletaIntercambio(Hospital hospital);
		
	Negociacao criaNegociacao(long idHospital1, long idHospital2);
	
	Negociacao recuperaNegociacao(long id);
	
	List<Negociacao> recuperacaNegociacoes();
	
}
