
package com.esi.ms_ordonnance.Proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esi.ms_ordonnance.DTOs.RemboursementDTO;

/**
 * Remboursement
 */
@FeignClient(name = "ms-remboursement")
public interface Remboursement {

    @GetMapping("/remboursements/search/findRemboursementByIdOrdonnance?idOrdonnance={id}")
    public RemboursementDTO getRemboursement(@PathVariable(name = "id") Long id);

}
