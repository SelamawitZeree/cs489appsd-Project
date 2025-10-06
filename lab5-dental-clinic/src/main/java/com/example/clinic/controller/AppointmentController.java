package com.example.clinic.controller;

import com.example.clinic.domain.Appointment;
import com.example.clinic.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;
    public AppointmentController(AppointmentService service) { this.service = service; }

    @GetMapping public List<Appointment> all() { return service.findAll(); }
    @GetMapping("/{appointmentId}") public ResponseEntity<Appointment> one(@PathVariable String appointmentId) {
        return service.findById(appointmentId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Appointment create(@RequestBody Appointment obj) { return service.save(obj); }
    @PutMapping("/{appointmentId}") public ResponseEntity<Appointment> update(@PathVariable String appointmentId, @RequestBody Appointment obj) {
        return service.findById(appointmentId).map(e -> { obj.setAppointmentId(appointmentId); return ResponseEntity.ok(service.save(obj)); })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{appointmentId}") public ResponseEntity<Void> delete(@PathVariable String appointmentId) {
        if (!service.existsById(appointmentId)) return ResponseEntity.notFound().build();
        service.deleteById(appointmentId); return ResponseEntity.noContent().build();
    }
}
