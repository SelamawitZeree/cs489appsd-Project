package com.example.clinic.service.impl;

import com.example.clinic.domain.Patient;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    public PatientServiceImpl(PatientRepository repository) { this.repository = repository; }

    @Override public List<Patient> findAll() { return repository.findAll(); }
    @Override public Optional<Patient> findById(String id) { return repository.findById(id); }
    @Override public Patient save(Patient entity) { return repository.save(entity); }
    @Override public void deleteById(String id) { repository.deleteById(id); }
    @Override public boolean existsById(String id) { return repository.existsById(id); }
}
