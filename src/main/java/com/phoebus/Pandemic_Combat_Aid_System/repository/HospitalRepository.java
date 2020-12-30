package com.phoebus.Pandemic_Combat_Aid_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoebus.Pandemic_Combat_Aid_System.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
