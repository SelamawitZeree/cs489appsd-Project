package com.example.clinic.controller;

import com.example.clinic.domain.Patient;
import com.example.clinic.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @GetMapping public List<Patient> all() { return service.findAll(); }
    @GetMapping("/{patId}") public ResponseEntity<Patient> one(@PathVariable String patId) {
        return service.findById(patId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Patient create(@RequestBody Patient obj) { return service.save(obj); }
    @PutMapping("/{patId}") public ResponseEntity<Patient> update(@PathVariable String patId, @RequestBody Patient obj) {
        return service.findById(patId).map(e -> { obj.setPatId(patId); return ResponseEntity.ok(service.save(obj)); })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{patId}") public ResponseEntity<Void> delete(@PathVariable String patId) {
        if (!service.existsById(patId)) return ResponseEntity.notFound().build();
        service.deleteById(patId); return ResponseEntity.noContent().build();
    }
}
