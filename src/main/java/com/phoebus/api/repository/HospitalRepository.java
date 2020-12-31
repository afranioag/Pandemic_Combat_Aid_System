package com.phoebus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoebus.api.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
