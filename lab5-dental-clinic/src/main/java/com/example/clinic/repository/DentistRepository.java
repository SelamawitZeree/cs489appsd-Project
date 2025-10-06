package com.example.clinic.repository;

import com.example.clinic.domain.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, String> {
}
