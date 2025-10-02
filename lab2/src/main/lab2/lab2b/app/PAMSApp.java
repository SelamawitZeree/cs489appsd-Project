package main.lab2.lab2b.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab2b.model.Patient;
//import lab2b.app.patientmanagement.model.Patient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [cite_start]Main executable class for the Patient Appointment Management System (PAMS). [cite: 78]
 */
public class PAMSApp {

    public static void main(String[] args) {
//        [cite_start]// Create an array of Patient objects using the data from the lab document. [cite: 78, 79]
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)));
        patients.add(new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)));
        patients.add(new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)));
        patients.add(new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)));
        patients.add(new Patient(5, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31)));

//        [cite_start]// Sort the patients by their current age in descending order. [cite: 81]
        List<Patient> sortedPatients = patients.stream()
                .sorted(Comparator.comparing(Patient::getAge).reversed())
                .collect(Collectors.toList());

//        [cite_start]// Write the sorted data into a JSON file. [cite: 81]
        writePatientsToJsonFile(sortedPatients, "output/patients.json");
    }

    private static void writePatientsToJsonFile(List<Patient> patients, String filePath) {
        System.out.println("Writing sorted patient data to JSON file...");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            Files.createDirectories(Paths.get(filePath).getParent());
            String json = mapper.writeValueAsString(patients);
            Files.writeString(Paths.get(filePath), json);

            System.out.println("Successfully generated JSON file at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing JSON to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}