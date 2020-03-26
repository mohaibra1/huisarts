package com.mohamed.huisarts.repositories;

import com.mohamed.huisarts.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    Patient findByLastName(String lastName);
}
