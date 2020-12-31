package com.phoebus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoebus.api.models.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long>{

}
