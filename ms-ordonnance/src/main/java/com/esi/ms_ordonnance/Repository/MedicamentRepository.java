
package com.esi.ms_ordonnance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.ms_ordonnance.Entities.Medicament;

/**
 * MedicamentRepository
 */
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
