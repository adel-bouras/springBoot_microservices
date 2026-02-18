package com.esi.ms_remboursement;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esi.ms_remboursement.Entities.Assure;
import com.esi.ms_remboursement.Entities.Remboursement;
import com.esi.ms_remboursement.Repository.AssureRepository;
import com.esi.ms_remboursement.Repository.RemboursementRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MsRemboursementApplication implements CommandLineRunner {
    private final RemboursementRepository remboursementRepository;
    private final AssureRepository assureRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsRemboursementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Assure a1 = assureRepository.save(new Assure(1L, "99774422", 2000D, null));
        Assure a2 = assureRepository.save(new Assure(2L, "62365525", 6000D, null));

        remboursementRepository.save(new Remboursement(null, LocalDate.now(), 540D, a2, 2L));
        remboursementRepository.save(new Remboursement(null, LocalDate.now(), 700D, a1, 1L));
        remboursementRepository.save(new Remboursement(null, LocalDate.now(), 80D, a1, 3L));

    }

}
