package com.esi.ms_ordonnance;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.esi.ms_ordonnance.Entities.Medicament;
import com.esi.ms_ordonnance.Entities.Ordonnance;
import com.esi.ms_ordonnance.Repository.MedicamentRepository;
import com.esi.ms_ordonnance.Repository.OrdonnanceRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class MsOrdonnanceApplication implements CommandLineRunner {
    private final OrdonnanceRepository ordonnanceRepository;
    private final MedicamentRepository medicamentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsOrdonnanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Ordonnance or1 = this.ordonnanceRepository.save(new Ordonnance(null, LocalDate.now(), null, 1L, null, null));
        Ordonnance or2 = this.ordonnanceRepository.save(new Ordonnance(null, LocalDate.now(), null, 2L, null, null));

        medicamentRepository.save(new Medicament(null, "Medicament1", 5, "200mg", 10.0, or1));
        medicamentRepository.save(new Medicament(null, "Medicament2", 3, "150mg", 5.0, or1));

        medicamentRepository.save(new Medicament(null, "Medicament3", 7, "20mg", 15.0, or2));
        medicamentRepository.save(new Medicament(null, "Medicament4", 8, "50mg", 19.0, or2));

    }

}
