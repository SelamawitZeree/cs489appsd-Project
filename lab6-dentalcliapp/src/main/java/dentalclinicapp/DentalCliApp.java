package edu.miu.cs.cs489.lesson6.dentalclinicapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.*;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.*;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DentalCliApp {
    public static void main(String[] args) { SpringApplication.run(DentalCliApp.class, args); }

    @Bean
    CommandLineRunner run(AddressService addressService,
                          PatientService patientService,
                          DentistService dentistService,
                          SurgeryService surgeryService,
                          AppointmentService appointmentService) {
        return args -> {
            Address a1 = addressService.save(new Address(null, "12 Bay St", "Dallas", "TX", "75001"));
            Address a2 = addressService.save(new Address(null, "34 Lake Ave", "Dallas", "TX", "75002"));
            Address a3 = addressService.save(new Address(null, "56 King Rd", "Dallas", "TX", "75003"));
            Address a4 = addressService.save(new Address(null, "78 Pine Dr", "Dallas", "TX", "75004"));

            Patient p100 = patientService.save(new Patient(null, "P100", "Gillian", "White", a1));
            Patient p105 = patientService.save(new Patient(null, "P105", "Jill", "Bell", a2));
            Patient p108 = patientService.save(new Patient(null, "P108", "Ian", "MacKay", a3));
            Patient p110 = patientService.save(new Patient(null, "P110", "John", "Walker", a4));

            Dentist dTony  = dentistService.save(new Dentist(null, "Tony",  "Smith"));
            Dentist dHelen = dentistService.save(new Dentist(null, "Helen", "Pearson"));
            Dentist dRobin = dentistService.save(new Dentist(null, "Robin", "Plevin"));

            Surgery s10 = surgeryService.save(new Surgery("S10", "Room 10"));
            Surgery s13 = surgeryService.save(new Surgery("S13", "Room 13"));
            Surgery s15 = surgeryService.save(new Surgery("S15", "Room 15"));

            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,12), LocalTime.of(10,0), dTony, p100, s15));
            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,12), LocalTime.of(12,0), dTony, p105, s15));
            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,12), LocalTime.of(10,0), dHelen, p108, s10));
            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,14), LocalTime.of(13,0), dHelen, p108, s10));
            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,14), LocalTime.of(16,30), dRobin, p105, s13));
            appointmentService.save(new Appointment(null, LocalDate.of(2013,9,15), LocalTime.of(18,0), dRobin, p110, s13));

            System.out.println("Appointments for Tony Smith:");
            for (Appointment a : appointmentService.findByDentistLastName("Smith")) { System.out.println(a); }
        };
    }
}
