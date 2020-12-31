package com.phoebus.api.service;

import java.util.List;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Recurso;
import com.phoebus.api.models.hospitalDTO.HospitalAtualizaDTO;
import com.phoebus.api.models.hospitalDTO.HospitalCriacaoDTO;

public interface HospitalService {
	Hospital adicionaHospital(HospitalCriacaoDTO hospitalCriacaoDTO, List<Recurso> listaRecurso);

	Hospital recuperaHospital(Long id);

	List<Hospital> listaHospitais();

	Hospital removeHospital(Long id);
	
	Hospital atualizaHospital(long id, HospitalAtualizaDTO hospitalDTO);
	
}
