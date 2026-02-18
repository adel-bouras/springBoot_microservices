
package com.esi.ms_patient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.ms_patient.Entities.AntecedentMedical;

/**
 * AntecedentRepository
 */
public interface AntecedentRepository extends JpaRepository<AntecedentMedical, Long> {

}
