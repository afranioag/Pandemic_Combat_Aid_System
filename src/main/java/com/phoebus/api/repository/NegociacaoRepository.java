package com.phoebus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoebus.api.models.Negociacao;

@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long>{

}
