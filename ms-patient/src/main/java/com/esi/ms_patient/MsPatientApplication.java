package com.esi.ms_patient;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esi.ms_patient.Entities.AntecedentMedical;
import com.esi.ms_patient.Entities.Patient;
import com.esi.ms_patient.Repository.AntecedentRepository;
import com.esi.ms_patient.Repository.PatientRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MsPatientApplication implements CommandLineRunner {
    private final PatientRepository patientRepository;
    private final AntecedentRepository antecedentRepository;
    private final RepositoryRestConfiguration conf;

    public static void main(String[] args) {
        SpringApplication.run(MsPatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        this.conf.exposeIdsFor(Patient.class);

        Patient patient1 = this.patientRepository.save(new Patient(null, "karim", null, null));
        Patient patient2 = this.patientRepository.save(new Patient(null, "reda", null, null));

        this.antecedentRepository.save(new AntecedentMedical(null, "Asthm", LocalDate.now(), patient1));
        this.antecedentRepository.save(new AntecedentMedical(null, "Diabete", LocalDate.now(), patient1));
        this.antecedentRepository.save(new AntecedentMedical(null, "Grippe", LocalDate.now(), patient2));
    }

}
