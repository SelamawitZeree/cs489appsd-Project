package com.example.clinic.service.impl;

import com.example.clinic.domain.Dentist;
import com.example.clinic.repository.DentistRepository;
import com.example.clinic.service.DentistService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    private final DentistRepository repository;
    public DentistServiceImpl(DentistRepository repository) { this.repository = repository; }

    @Override public List<Dentist> findAll() { return repository.findAll(); }
    @Override public Optional<Dentist> findById(String id) { return repository.findById(id); }
    @Override public Dentist save(Dentist entity) { return repository.save(entity); }
    @Override public void deleteById(String id) { repository.deleteById(id); }
    @Override public boolean existsById(String id) { return repository.existsById(id); }
}
