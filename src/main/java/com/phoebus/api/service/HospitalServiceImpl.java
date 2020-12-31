package com.phoebus.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Recurso;
import com.phoebus.api.models.hospitalDTO.HospitalAtualizaDTO;
import com.phoebus.api.models.hospitalDTO.HospitalCriacaoDTO;
import com.phoebus.api.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public Hospital adicionaHospital(HospitalCriacaoDTO hospitalCriacaoDTO, List<Recurso> listaRecurso) {

		return hospitalRepository.save(hospitalCriacaoDTO.converteHospital(listaRecurso));

	}

	@Override
	public Hospital recuperaHospital(Long id) {

		Optional<Hospital> hospitalOpt = hospitalRepository.findById(id);

		if (!hospitalOpt.isPresent()) {
			return null;
		}

		return hospitalOpt.get();
	}

	@Override
	public List<Hospital> listaHospitais() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital removeHospital(Long id) {
		Optional<Hospital> hospitalOpt = hospitalRepository.findById(id);

		if (hospitalOpt.isPresent()) {
			hospitalRepository.deleteById(id);
			return hospitalOpt.get();
		}
		
		return null;

	}

	@Override
	public Hospital atualizaHospital(long id, HospitalAtualizaDTO hospitalDTO) {

		Hospital hospital = recuperaHospital(id);

		if (hospital == null) {
			return null;
		}

		hospitalDTO.converteHospital(hospital);

		hospitalRepository.save(hospital);

		return hospital;

	}

}
