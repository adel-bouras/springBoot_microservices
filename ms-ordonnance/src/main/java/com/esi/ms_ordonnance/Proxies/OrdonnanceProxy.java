package com.esi.ms_ordonnance.Proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esi.ms_ordonnance.DTOs.PatientDTO;

/**
 * OrdonnanceProxy
 */
@FeignClient(name = "ms-patient", url = "http://localhost:8081")
public interface OrdonnanceProxy {
    @GetMapping("/patients/{id}")
    public PatientDTO getPatientById(@PathVariable(name = "id") Long id);
}
