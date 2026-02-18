
package com.esi.ms_patient.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.ms_patient.DTOs.OrdonnanceDTO;
import com.esi.ms_patient.Entities.Patient;
import com.esi.ms_patient.Proxies.OrdonnenceProxy;
import com.esi.ms_patient.Repository.PatientRepository;

import lombok.RequiredArgsConstructor;

/**
 * PatientController
 */
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientRepository patientRepository;
    private final HttpGraphQlClient ordonnenceClient;
    private final HttpGraphQlClient rembourcementClient;

    public PatientController(@Qualifier("ordonnenceClient") HttpGraphQlClient ordonnenceClient,
            @Qualifier("rembourecementClient") HttpGraphQlClient rembourcementClient,
            PatientRepository patientrepo) {
        this.patientRepository = patientrepo;
        this.ordonnenceClient = ordonnenceClient;
        this.rembourcementClient = rembourcementClient;
    }

    @GetMapping("/patient")
    public List<Patient> getOrdonnenceByPatientId() {
        List<Patient> pat = this.patientRepository.findAll();

        for (Patient patient : pat) {
            String query = "{getOrdonnanceByIdPatient(idPatient: " + patient.getIdPatient() +
                    ") {idOrdonnance medicaments { nom cout }}}";

            List<OrdonnanceDTO> ordos = this.ordonnenceClient.document(query).retrieve("getOrdonnanceByIdPatient")
                    .toEntityList(OrdonnanceDTO.class)
                    .block();

            patient.setOrdonnances(ordos);
        }
        return pat;

    }

}
