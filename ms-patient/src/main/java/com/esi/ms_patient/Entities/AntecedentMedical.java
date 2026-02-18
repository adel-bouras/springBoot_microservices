package com.esi.ms_patient.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AntecedentMedical
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntecedentMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedent;

    private String maladie;

    private LocalDate dateDiagnostic;

    @ManyToOne
    private Patient patient;

}
