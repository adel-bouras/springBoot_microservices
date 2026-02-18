
package com.esi.ms_patient.DTOs;

/**
 * OrdonnanceDTO
 */
public record OrdonnanceDTO(
        Long idOrdonnance,
        MedicamentDTO[] medicaments) {
}
