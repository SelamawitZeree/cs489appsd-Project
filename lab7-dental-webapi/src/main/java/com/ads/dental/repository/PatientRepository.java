package com.ads.dental.repository;

import com.ads.dental.domain.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    default List<Patient> findAllSortedByLastNameAsc() {
        return findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    @Query("SELECT p FROM Patient p WHERE " +
           "lower(p.firstName) LIKE lower(concat('%', :q, '%')) OR " +
           "lower(p.lastName)  LIKE lower(concat('%', :q, '%')) OR " +
           "lower(p.email)     LIKE lower(concat('%', :q, '%')) OR " +
           "lower(p.phone)     LIKE lower(concat('%', :q, '%'))")
    List<Patient> search(@Param("q") String q);
}
