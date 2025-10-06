package com.example.clinic.controller;

import com.example.clinic.domain.Surgery;
import com.example.clinic.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/surgeries")
public class SurgeryController {
    private final SurgeryService service;
    public SurgeryController(SurgeryService service) { this.service = service; }

    @GetMapping public List<Surgery> all() { return service.findAll(); }
    @GetMapping("/{surgeryId}") public ResponseEntity<Surgery> one(@PathVariable String surgeryId) {
        return service.findById(surgeryId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Surgery create(@RequestBody Surgery obj) { return service.save(obj); }
    @PutMapping("/{surgeryId}") public ResponseEntity<Surgery> update(@PathVariable String surgeryId, @RequestBody Surgery obj) {
        return service.findById(surgeryId).map(e -> { obj.setSurgeryId(surgeryId); return ResponseEntity.ok(service.save(obj)); })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{surgeryId}") public ResponseEntity<Void> delete(@PathVariable String surgeryId) {
        if (!service.existsById(surgeryId)) return ResponseEntity.notFound().build();
        service.deleteById(surgeryId); return ResponseEntity.noContent().build();
    }
}
