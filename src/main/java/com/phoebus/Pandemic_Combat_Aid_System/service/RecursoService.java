package com.phoebus.Pandemic_Combat_Aid_System.service;

import java.util.List;

import com.phoebus.Pandemic_Combat_Aid_System.models.Recurso;
import com.phoebus.Pandemic_Combat_Aid_System.models.hospitalDTO.HospitalCriacaoDTO;

public interface RecursoService {

	List<Recurso> adicionarRecurso(HospitalCriacaoDTO hospitalCriacaoDTO);
}
