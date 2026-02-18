
package com.esi.ms_ordonnance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.ms_ordonnance.Entities.Ordonnance;

/**
 * OrdonnanceRepository
 */
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {
    public List<Ordonnance> findByIdPatient(Long idPatient);
}
