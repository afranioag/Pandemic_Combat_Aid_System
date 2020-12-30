package com.phoebus.Pandemic_Combat_Aid_System.service;

import java.util.List;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;

public interface HospitalService {
	Hospital adicionaHospital(Hospital hospital);

	Hospital recuperaHospital(Long id);

	List<Hospital> listaHospitais();

	void removeHospital(Long id);
	
	Hospital atualizaHospital(Hospital hospital);
	
	
}
