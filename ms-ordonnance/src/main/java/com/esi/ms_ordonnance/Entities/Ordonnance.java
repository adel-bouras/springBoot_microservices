package com.esi.ms_ordonnance.Entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.esi.ms_ordonnance.DTOs.PatientDTO;
import com.esi.ms_ordonnance.DTOs.RemboursementDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Ordonnance
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdonnance;

    private LocalDate dateOrdonnance;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "ordonnance", cascade = CascadeType.ALL)
    private List<Medicament> medicaments;

    private Long idPatient;

    @Transient
    private PatientDTO patient;

    @Transient
    private RemboursementDTO remboursement;
}
