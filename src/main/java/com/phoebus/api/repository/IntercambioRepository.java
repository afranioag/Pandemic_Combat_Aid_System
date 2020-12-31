package com.phoebus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoebus.api.models.Intercambio;

@Repository
public interface IntercambioRepository extends JpaRepository<Intercambio, Long>{

}
