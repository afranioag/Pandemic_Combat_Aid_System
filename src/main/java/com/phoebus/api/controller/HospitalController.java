package com.phoebus.api.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.phoebus.api.models.Hospital;
import com.phoebus.api.models.Negociacao;
import com.phoebus.api.models.Recurso;
import com.phoebus.api.models.hospitalDTO.HospitalAtualizaDTO;
import com.phoebus.api.models.hospitalDTO.HospitalCriacaoDTO;
import com.phoebus.api.models.hospitalDTO.RelatorioDTO;
import com.phoebus.api.service.HospitalService;
import com.phoebus.api.service.IntercambioService;
import com.phoebus.api.service.RecursoService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private RecursoService recursoService;

	@Autowired
	private IntercambioService IntercambioService;

	@GetMapping("/hospitais")
	public ResponseEntity<List<Hospital>> listaHospitais() {

		return ResponseEntity.ok(hospitalService.listaHospitais());

	}

	@GetMapping("/hospitais/{id}")
	public ResponseEntity<Hospital> recuperaHospital(@PathVariable long id) {

		Hospital hospital = hospitalService.recuperaHospital(id);

		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(hospital);
	}

	@Transactional
	@PostMapping("/hospitais")
	public ResponseEntity<?> adicionaHospital(@RequestBody HospitalCriacaoDTO hospitalCriacaoDTO,
			UriComponentsBuilder uri) {

		List<Recurso> listaRecurso = recursoService.adicionarRecurso(hospitalCriacaoDTO);

		if (listaRecurso == null) {
			return ResponseEntity.badRequest().body(
					new String("Voce preencheu o array de recursos de forma errada.\n Deve conter 5 valores positivos\n"
							+ "exemplo [2,3,5,0,6]"));
		}

		Hospital hospital = hospitalService.adicionaHospital(hospitalCriacaoDTO, listaRecurso);

		URI url = uri.path("/hospitais/{id}").buildAndExpand(hospital.getId()).toUri();

		return ResponseEntity.created(url).body(hospital);
	}

	@GetMapping("/hospitais/{id}/ocupacao")
	public ResponseEntity<HospitalAtualizaDTO> exibeOcupacaoHospital(@PathVariable long id) {

		Hospital hospital = hospitalService.recuperaHospital(id);

		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(new HospitalAtualizaDTO(hospital));
	}

	@Transactional
	@PutMapping("/hospitais/{id}")
	public ResponseEntity<Hospital> atualizaOcupacao(@PathVariable long id,
			@RequestBody HospitalAtualizaDTO hospitalAtualizaDTO) {

		Hospital hospital = hospitalService.atualizaHospital(id, hospitalAtualizaDTO);

		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(hospital);
	}

	@Transactional
	@DeleteMapping("/hospitais/{id}")
	public ResponseEntity<Hospital> deleteHospital(@PathVariable long id) {
		Hospital hospital = hospitalService.removeHospital(id);

		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(hospital);
	}

	@GetMapping("/hospitais/relatorios")
	public ResponseEntity<?> exibeRelatorio() {
		List<Hospital> hospitais = hospitalService.listaHospitais();

		int maior = 0;
		int menor = 0;

		for (Hospital hospital : hospitais) {
			if (hospital.getOcupacao() >= 90) {
				maior += 1;
			} else {
				menor += 1;
			}
		}

		double porcentagemMaior = (maior * 100) / hospitais.size();
		double porcentamMenor = (menor * 100) / hospitais.size();

		int medico = 0;
		int enfermeiro = 0;
		int tomografo = 0;
		int respirador = 0;
		int ambulancia = 0;

		for (Hospital hospital : hospitais) {
			medico += hospital.getRecursos().get(0).getQuantidade();
			enfermeiro += hospital.getRecursos().get(1).getQuantidade();
			tomografo += hospital.getRecursos().get(2).getQuantidade();
			respirador += hospital.getRecursos().get(3).getQuantidade();
			ambulancia += hospital.getRecursos().get(4).getQuantidade();
		}

		double mediaMedico = medico / hospitais.size();
		double mediaEnfermeiro = enfermeiro / hospitais.size();
		double mediaTomografo = tomografo / hospitais.size();
		double mediaRespirador = respirador / hospitais.size();
		double mediaAmbulancia = ambulancia / hospitais.size();

		List<Negociacao> negociacaoRelatorio = IntercambioService.recuperacaNegociacoes();

		RelatorioDTO relatorioDTO = new RelatorioDTO(porcentagemMaior, porcentamMenor, mediaMedico, mediaEnfermeiro,
				mediaTomografo, mediaRespirador, mediaAmbulancia, negociacaoRelatorio);

		return ResponseEntity.ok(relatorioDTO);
	}

}
