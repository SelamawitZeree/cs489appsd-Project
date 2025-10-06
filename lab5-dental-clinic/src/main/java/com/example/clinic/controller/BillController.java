package com.example.clinic.controller;

import com.example.clinic.domain.Bill;
import com.example.clinic.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    private final BillService service;
    public BillController(BillService service) { this.service = service; }

    @GetMapping public List<Bill> all() { return service.findAll(); }
    @GetMapping("/{billId}") public ResponseEntity<Bill> one(@PathVariable String billId) {
        return service.findById(billId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Bill create(@RequestBody Bill obj) { return service.save(obj); }
    @PutMapping("/{billId}") public ResponseEntity<Bill> update(@PathVariable String billId, @RequestBody Bill obj) {
        return service.findById(billId).map(e -> { obj.setBillId(billId); return ResponseEntity.ok(service.save(obj)); })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{billId}") public ResponseEntity<Void> delete(@PathVariable String billId) {
        if (!service.existsById(billId)) return ResponseEntity.notFound().build();
        service.deleteById(billId); return ResponseEntity.noContent().build();
    }
}
