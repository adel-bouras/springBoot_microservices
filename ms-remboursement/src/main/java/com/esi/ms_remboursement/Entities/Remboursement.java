package com.esi.ms_remboursement.Entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Remboursement
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remboursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idREmboursement;

    private LocalDate dateRemboursement;

    private Double montant;

    @ManyToOne
    private Assure assure;

    private Long idOrdonnance;
}
