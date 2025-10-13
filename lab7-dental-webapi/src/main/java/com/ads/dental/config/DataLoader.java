package com.ads.dental.config;

import com.ads.dental.domain.Address;
import com.ads.dental.domain.Patient;
import com.ads.dental.repository.AddressRepository;
import com.ads.dental.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadSampleData(PatientRepository patients, AddressRepository addresses) {
        return args -> {
            if (patients.count() > 0) return;

            Patient p1 = new Patient();
            p1.setFirstName("Alice");
            p1.setLastName("Brown");
            p1.setEmail("alice.brown@example.com");
            p1.setPhone("214-555-0101");
            p1.setDateOfBirth(LocalDate.of(1990, 3, 14));
            patients.save(p1);

            Address a1 = new Address();
            a1.setStreet("101 Main St");
            a1.setCity("Dallas");
            a1.setState("TX");
            a1.setZipCode("75201");
            a1.setPatient(p1);
            addresses.save(a1);
            p1.setPrimaryAddress(a1);
            patients.save(p1);

            Patient p2 = new Patient();
            p2.setFirstName("Brian");
            p2.setLastName("Clark");
            p2.setEmail("brian.clark@example.com");
            p2.setPhone("469-555-0112");
            p2.setDateOfBirth(LocalDate.of(1985, 7, 2));
            patients.save(p2);

            Address a2 = new Address();
            a2.setStreet("22 Elm Ave");
            a2.setCity("Allen");
            a2.setState("TX");
            a2.setZipCode("75002");
            a2.setPatient(p2);
            addresses.save(a2);
            p2.setPrimaryAddress(a2);
            patients.save(p2);

            Patient p3 = new Patient();
            p3.setFirstName("Cynthia");
            p3.setLastName("Davis");
            p3.setEmail("cynthia.davis@example.com");
            p3.setPhone("972-555-0199");
            p3.setDateOfBirth(LocalDate.of(1993, 12, 25));
            patients.save(p3);

            Address a3 = new Address();
            a3.setStreet("9 Lakeview Blvd");
            a3.setCity("Plano");
            a3.setState("TX");
            a3.setZipCode("75023");
            a3.setPatient(p3);
            addresses.save(a3);
            p3.setPrimaryAddress(a3);
            patients.save(p3);
        };
    }
}
