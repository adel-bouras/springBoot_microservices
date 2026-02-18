package com.esi.ms_remboursement.Proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OrdonnenceProxy
 */
@FeignClient(name = "ms-ordonnance", url = "http://localhost:8082")
public interface OrdonnenceProxy {

    // @GetMapping("/ordonnences/{id}")
    // public OrdonnanceDTO getOrdonnenceById(@PathVariable(name = "id") Long id);
}
