package com.esi.ms_ordonnance.DTOs;

/**
 * RemboursementDTO
 */
public record RemboursementDTO(
        Double montant,
        AssureDTO assure) {
}
