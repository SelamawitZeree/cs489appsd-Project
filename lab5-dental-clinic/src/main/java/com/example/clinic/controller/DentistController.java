package com.example.clinic.controller;

import com.example.clinic.domain.Dentist;
import com.example.clinic.service.DentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dentists")
public class DentistController {
    private final DentistService service;
    public DentistController(DentistService service) { this.service = service; }

    @GetMapping public List<Dentist> all() { return service.findAll(); }
    @GetMapping("/{dentId}") public ResponseEntity<Dentist> one(@PathVariable String dentId) {
        return service.findById(dentId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Dentist create(@RequestBody Dentist obj) { return service.save(obj); }
    @PutMapping("/{dentId}") public ResponseEntity<Dentist> update(@PathVariable String dentId, @RequestBody Dentist obj) {
        return service.findById(dentId).map(e -> { obj.setDentId(dentId); return ResponseEntity.ok(service.save(obj)); })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{dentId}") public ResponseEntity<Void> delete(@PathVariable String dentId) {
        if (!service.existsById(dentId)) return ResponseEntity.notFound().build();
        service.deleteById(dentId); return ResponseEntity.noContent().build();
    }
}
