package com.phoebus.Pandemic_Combat_Aid_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;
import com.phoebus.Pandemic_Combat_Aid_System.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public Hospital adicionaHospital(Hospital hospital) {
		hospitalRepository.save(hospital);

		return hospital;
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
	public void removeHospital(Long id) {
		Optional<Hospital> hospitalOpt = hospitalRepository.findById(id);

		if (hospitalOpt.isPresent()) {
			hospitalRepository.deleteById(id);
		}

	}

	@Override
	public Hospital atualizaHospital(Hospital hospital) {
		Hospital hospitalAtual = hospitalRepository.findById(hospital.getId()).get();
		hospitalAtual.setEndereco(hospital.getEndereco());
		
	}

}
