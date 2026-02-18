package com.esi.ms_patient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.ms_patient.Entities.Patient;

/**
 * PatientRepository
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
