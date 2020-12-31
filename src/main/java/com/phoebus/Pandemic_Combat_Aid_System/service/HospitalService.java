package com.phoebus.Pandemic_Combat_Aid_System.service;

import java.util.List;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;
import com.phoebus.Pandemic_Combat_Aid_System.models.Recurso;
import com.phoebus.Pandemic_Combat_Aid_System.models.hospitalDTO.HospitalAtualizaDTO;
import com.phoebus.Pandemic_Combat_Aid_System.models.hospitalDTO.HospitalCriacaoDTO;

public interface HospitalService {
	Hospital adicionaHospital(HospitalCriacaoDTO hospitalCriacaoDTO, List<Recurso> listaRecurso);

	Hospital recuperaHospital(Long id);

	List<Hospital> listaHospitais();

	Hospital removeHospital(Long id);
	
	Hospital atualizaHospital(long id, HospitalAtualizaDTO hospitalDTO);
	
}
