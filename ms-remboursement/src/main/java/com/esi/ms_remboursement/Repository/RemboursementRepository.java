package com.esi.ms_remboursement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.esi.ms_remboursement.Entities.Remboursement;

/**
 * Remboursement
 */
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    Remboursement findRemboursementByIdOrdonnance(@Param("idOrdonnance") Long idOrdonnance);
}
