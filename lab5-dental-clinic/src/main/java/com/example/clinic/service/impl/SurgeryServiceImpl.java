package com.example.clinic.service.impl;

import com.example.clinic.domain.Surgery;
import com.example.clinic.repository.SurgeryRepository;
import com.example.clinic.service.SurgeryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private final SurgeryRepository repository;
    public SurgeryServiceImpl(SurgeryRepository repository) { this.repository = repository; }

    @Override public List<Surgery> findAll() { return repository.findAll(); }
    @Override public Optional<Surgery> findById(String id) { return repository.findById(id); }
    @Override public Surgery save(Surgery entity) { return repository.save(entity); }
    @Override public void deleteById(String id) { repository.deleteById(id); }
    @Override public boolean existsById(String id) { return repository.existsById(id); }
}
