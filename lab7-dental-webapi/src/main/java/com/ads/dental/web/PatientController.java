package com.ads.dental.web;

import com.ads.dental.domain.Patient;
import com.ads.dental.service.PatientService;
import com.ads.dental.web.dto.Mappers;
import com.ads.dental.web.dto.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // 1. GET /patients sorted by lastName asc
    @GetMapping("/patients")
    public List<PatientDTO> getAllPatients() {
        return patientService.findAllSortedByLastName()
                .stream().map(Mappers::toPatientDTO).collect(Collectors.toList());
    }

    // 2. GET /patients/{id}
    @GetMapping("/patients/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return Mappers.toPatientDTO(patientService.findById(id));
    }

    // 3. POST /patients
    @PostMapping("/patients")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody Patient patient) {
        Patient created = patientService.create(patient);
        return ResponseEntity
                .created(URI.create("/adsweb/api/v1/patients/" + created.getPatientId()))
                .body(Mappers.toPatientDTO(created));
    }

    // 4. PUT /patient/{id}
    @PutMapping("/patient/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody Patient patch) {
        return Mappers.toPatientDTO(patientService.update(id, patch));
    }

    // 5. DELETE /patient/{id}
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 6. /patient/search/{searchString}
    @GetMapping("/patient/search/{searchString}")
    public List<PatientDTO> searchPatients(@PathVariable String searchString) {
        return patientService.search(searchString).stream()
                .map(Mappers::toPatientDTO).collect(Collectors.toList());
    }
}
