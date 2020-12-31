package com.phoebus.Pandemic_Combat_Aid_System.service;

import java.util.List;

import com.phoebus.Pandemic_Combat_Aid_System.models.Intercambio;
import com.phoebus.Pandemic_Combat_Aid_System.models.Negociacao;

public interface IntercambioService {

	Intercambio criaIntercambio(int medico, int enfermeio, int respirador, int tomografo, int ambulancia);
	
	Intercambio recuperaIntercambio(long id);
	
	Intercambio deletaIntercambio(long id);
	
	Intercambio atualizaIntercambio(Intercambio intercambio);
	
	Negociacao criaNegociacao(Intercambio intercambio1, Intercambio intercambio2);
	
	Negociacao recuperaNegociacao(long id);
	
	List<Negociacao> recuperacaNegociacoes();
	
}
