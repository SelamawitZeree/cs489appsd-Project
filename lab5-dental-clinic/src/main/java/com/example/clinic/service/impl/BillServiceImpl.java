package com.example.clinic.service.impl;

import com.example.clinic.domain.Bill;
import com.example.clinic.repository.BillRepository;
import com.example.clinic.service.BillService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository repository;
    public BillServiceImpl(BillRepository repository) { this.repository = repository; }

    @Override public List<Bill> findAll() { return repository.findAll(); }
    @Override public Optional<Bill> findById(String id) { return repository.findById(id); }
    @Override public Bill save(Bill entity) { return repository.save(entity); }
    @Override public void deleteById(String id) { repository.deleteById(id); }
    @Override public boolean existsById(String id) { return repository.existsById(id); }
}
