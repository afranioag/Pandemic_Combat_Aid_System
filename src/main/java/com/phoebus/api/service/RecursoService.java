package com.phoebus.api.service;

import java.util.List;

import com.phoebus.api.models.Recurso;
import com.phoebus.api.models.hospitalDTO.HospitalCriacaoDTO;

public interface RecursoService {

	List<Recurso> adicionarRecurso(HospitalCriacaoDTO hospitalCriacaoDTO);
}
