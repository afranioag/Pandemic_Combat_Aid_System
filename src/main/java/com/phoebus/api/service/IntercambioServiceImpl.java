package com.phoebus.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Intercambio;
import com.phoebus.api.models.Negociacao;
import com.phoebus.api.models.hospitalDTO.IntercambioDTO;
import com.phoebus.api.repository.HospitalRepository;
import com.phoebus.api.repository.IntercambioRepository;
import com.phoebus.api.repository.NegociacaoRepository;

@Service
public class IntercambioServiceImpl implements IntercambioService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private NegociacaoRepository negociacaoRepository;
	
	@Autowired
	private IntercambioRepository intercambioRepository;

	@Override
	public Intercambio criaIntercambio(IntercambioDTO intercambioDTO, long idHospital) {

		Optional<Hospital> hospitalOpt = hospitalRepository.findById(idHospital);

		if (!hospitalOpt.isPresent()) {
			return null;
		}

		Intercambio intercambio = intercambioDTO.intercambioCriacaoDTO(hospitalOpt.get());

		hospitalOpt.get().setIntercambio(intercambio);
		
		return intercambioRepository.save(intercambio);

	}

	@Override
	public void deletaIntercambio(Hospital hospital) {
		hospital.setIntercambio(null);
	}

	@Override
	public Negociacao criaNegociacao(long idHospital1, long idHospital2) {

		Optional<Hospital> hospitalOpt1 = hospitalRepository.findById(idHospital1);
		Optional<Hospital> hospitalOpt2 = hospitalRepository.findById(idHospital2);

		if (!hospitalOpt1.isPresent() || !hospitalOpt2.isPresent()) {
			return null;
		}

		Negociacao negociacao = null;

		// intercambio para pontuação igual
		if (hospitalOpt1.get().getIntercambio().getPontos() == hospitalOpt2.get().getIntercambio().getPontos()) {

			negociacao = new Negociacao(hospitalOpt1.get().getIntercambio(), hospitalOpt2.get().getIntercambio());

			intercambioRecurso(hospitalOpt1.get(), hospitalOpt2.get());
			intercambioRecurso(hospitalOpt2.get(), hospitalOpt1.get());
		}

		else if (hospitalOpt1.get().getOcupacao() >= 90 || hospitalOpt2.get().getOcupacao() >= 90) {

			negociacao = new Negociacao(hospitalOpt1.get().getIntercambio(), hospitalOpt2.get().getIntercambio());

			intercambioRecurso(hospitalOpt1.get(), hospitalOpt2.get());
			intercambioRecurso(hospitalOpt2.get(), hospitalOpt1.get());
		}

		if (negociacao == null) {
			return null;
		}

		return negociacaoRepository.save(negociacao);

	}

	@Override
	public Negociacao recuperaNegociacao(long id) {
		Optional<Negociacao> negociacaoOpt = negociacaoRepository.findById(id);

		if (!negociacaoOpt.isPresent()) {
			return null;
		}

		return negociacaoOpt.get();
	}

	@Override
	public List<Negociacao> recuperacaNegociacoes() {
		return negociacaoRepository.findAll();
	}

	private void intercambioRecurso(Hospital hospital, Hospital hospitalSubtrai) {

		Intercambio intercambio = hospitalSubtrai.getIntercambio();

		// adiciona ao primeiro hospital os recursos entregues pelo segungo hospital
		hospital.getRecursos().get(0).adicionaRecurso(intercambio.getMedico());
		hospital.getRecursos().get(1).adicionaRecurso(intercambio.getEnfermeiro());
		hospital.getRecursos().get(2).adicionaRecurso(intercambio.getTomografo());
		hospital.getRecursos().get(3).adicionaRecurso(intercambio.getRespirador());
		hospital.getRecursos().get(4).adicionaRecurso(intercambio.getAmbulancia());

		// remove os recursos do hospital que foi doado ao outro hospital
		hospitalSubtrai.getRecursos().get(0).adicionaRecurso(intercambio.getMedico());
		hospitalSubtrai.getRecursos().get(1).adicionaRecurso(intercambio.getEnfermeiro());
		hospitalSubtrai.getRecursos().get(2).adicionaRecurso(intercambio.getTomografo());
		hospitalSubtrai.getRecursos().get(3).adicionaRecurso(intercambio.getRespirador());
		hospitalSubtrai.getRecursos().get(4).adicionaRecurso(intercambio.getAmbulancia());

		// zera o intercambio do segundo hospital
		hospitalSubtrai.setIntercambio(null);

	}

}
