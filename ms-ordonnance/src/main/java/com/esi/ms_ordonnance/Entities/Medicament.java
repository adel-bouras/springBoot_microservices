package com.esi.ms_ordonnance.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Medicament
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicament;

    private String nom;

    private int duree;
    private String dosage;
    private double cout;

    @ManyToOne
    private Ordonnance ordonnance;

}
