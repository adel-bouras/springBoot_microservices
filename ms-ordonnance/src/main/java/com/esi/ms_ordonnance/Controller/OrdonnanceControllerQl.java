package com.esi.ms_ordonnance.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.esi.ms_ordonnance.Entities.Medicament;
import com.esi.ms_ordonnance.Entities.Ordonnance;
import com.esi.ms_ordonnance.Repository.OrdonnanceRepository;

import lombok.RequiredArgsConstructor;

/**
 * OrdonnanceControllerQl
 */
@Controller
@RequiredArgsConstructor
public class OrdonnanceControllerQl {
    private final OrdonnanceRepository ordonnanceRepository;

    @QueryMapping
    public List<Ordonnance> getOrdonnanceByIdPatient(@Argument Long idPatient) {
        return this.ordonnanceRepository.findByIdPatient(idPatient);
    }

    @SchemaMapping(typeName = "Ordonnance", field = "medicaments")
    public List<Medicament> getMedicaments(Ordonnance ordonnance) {
        return ordonnance.getMedicaments();
    }
}
