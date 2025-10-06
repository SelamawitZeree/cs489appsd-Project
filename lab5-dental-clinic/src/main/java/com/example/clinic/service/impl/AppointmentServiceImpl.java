package com.example.clinic.service.impl;

import com.example.clinic.domain.Appointment;
import com.example.clinic.repository.AppointmentRepository;
import com.example.clinic.service.AppointmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    public AppointmentServiceImpl(AppointmentRepository repository) { this.repository = repository; }

    @Override public List<Appointment> findAll() { return repository.findAll(); }
    @Override public Optional<Appointment> findById(String id) { return repository.findById(id); }
    @Override public Appointment save(Appointment entity) { return repository.save(entity); }
    @Override public void deleteById(String id) { repository.deleteById(id); }
    @Override public boolean existsById(String id) { return repository.existsById(id); }
}
