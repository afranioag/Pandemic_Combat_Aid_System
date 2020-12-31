package com.phoebus.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Intercambio;
import com.phoebus.api.models.Negociacao;
import com.phoebus.api.models.hospitalDTO.IntercambioDTO;
import com.phoebus.api.service.HospitalService;
import com.phoebus.api.service.IntercambioService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class IntercambioController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private IntercambioService intercambioService;

	@Transactional
	@PostMapping("/intercambios/{id}")
	public ResponseEntity<?> adicionaIntercambio(@PathVariable long id, @RequestBody IntercambioDTO intercambioDTO) {

		Intercambio intercambio = intercambioService.criaIntercambio(intercambioDTO, id);

		if (intercambio == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(intercambio);

	}

	@DeleteMapping("/intercambios/{id}")
	public ResponseEntity<Hospital> deletaIntercambio(@PathVariable long id) {

		Hospital hospital = hospitalService.recuperaHospital(id);

		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}

		intercambioService.deletaIntercambio(hospital);

		return ResponseEntity.ok(hospital);

	}

	// ------ negociação ---------

	@GetMapping("/negociacao/{id}")
	public ResponseEntity<Negociacao> recuperaNegociacao(@PathVariable long id) {
		Negociacao negociacao = intercambioService.recuperaNegociacao(id);

		if (negociacao == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(negociacao);
	}

	@GetMapping("/negociacao")
	public ResponseEntity<List<Negociacao>> recuperaNegociacoes() {
		return ResponseEntity.ok(intercambioService.recuperacaNegociacoes());
	}

	@Transactional
	@PostMapping("/negociacao/{idH1}/{idH2}")
	public ResponseEntity<Negociacao> criaNegociacao(@PathVariable long idH1, @PathVariable long idH2) {

		Negociacao negociacao = intercambioService.criaNegociacao(idH1, idH2);

		if (negociacao == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(negociacao);
	}
}
