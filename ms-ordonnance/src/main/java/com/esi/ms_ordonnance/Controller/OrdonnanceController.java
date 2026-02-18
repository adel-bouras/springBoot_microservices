
package com.esi.ms_ordonnance.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.ms_ordonnance.Entities.Ordonnance;
import com.esi.ms_ordonnance.Proxies.OrdonnanceProxy;
import com.esi.ms_ordonnance.Proxies.Remboursement;
import com.esi.ms_ordonnance.Repository.OrdonnanceRepository;

import lombok.RequiredArgsConstructor;

/**
 * OrdonnanceController
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrdonnanceController {
    private final OrdonnanceRepository ordonnanceRepository;
    private final OrdonnanceProxy ordonnanceProxy;
    private final Remboursement remboursement;

    @GetMapping("/ordonnance")
    public List<Ordonnance> getOrdonnanceById() {
        List<Ordonnance> or = this.ordonnanceRepository.findAll();
        for (Ordonnance ordonnance : or) {
            ordonnance.setPatient(ordonnanceProxy.getPatientById(ordonnance.getIdPatient()));
        }
        return or;
    }

    @GetMapping("/ordonnance/remb")
    public List<Ordonnance> getOrdoWithRembourcement() {
        List<Ordonnance> or = this.ordonnanceRepository.findAll();

        for (Ordonnance ordonnance : or) {
            ordonnance.setRemboursement(this.remboursement.getRemboursement(ordonnance.getIdOrdonnance()));
        }

        return or;
    }
}
