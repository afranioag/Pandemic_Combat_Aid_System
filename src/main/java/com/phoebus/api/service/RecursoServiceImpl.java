package com.phoebus.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.api.models.Ambulancia;
import com.phoebus.api.models.Enfermeiro;
import com.phoebus.api.models.Medico;
import com.phoebus.api.models.Recurso;
import com.phoebus.api.models.Respirador;
import com.phoebus.api.models.Tomografo;
import com.phoebus.api.models.hospitalDTO.HospitalCriacaoDTO;
import com.phoebus.api.repository.RecursoRepository;

@Service
public class RecursoServiceImpl implements RecursoService{

	@Autowired
	private RecursoRepository recursoRepository;
	
	@Override
	public List<Recurso> adicionarRecurso(HospitalCriacaoDTO hospitalCriacaoDTO) {
		
		List<Integer> recursos = hospitalCriacaoDTO.getRecursos();
		
		List<Recurso> listaRecursosHospital = new ArrayList<>();
		
		if(recursos.size() != 5) {
			return null;
		}
		
		for(Integer valor:recursos) {
			if(valor < 0) {
				return null;
			}
		}
		
		Recurso medico = new Medico(recursos.get(0));
		Recurso enfermeiro = new Enfermeiro(recursos.get(1));
		Recurso respirador = new Respirador(recursos.get(2));
		Recurso tomografo = new Tomografo(recursos.get(3));
		Recurso ambulancia = new Ambulancia(recursos.get(4));
		
		
		listaRecursosHospital.add(medico);
		listaRecursosHospital.add(enfermeiro);
		listaRecursosHospital.add(respirador);
		listaRecursosHospital.add(tomografo);
		listaRecursosHospital.add(ambulancia);
		
		recursoRepository.saveAll(listaRecursosHospital);
		
		return listaRecursosHospital;
		
	}

}
