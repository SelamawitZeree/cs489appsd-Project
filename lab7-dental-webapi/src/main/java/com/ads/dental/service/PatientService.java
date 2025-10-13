package com.ads.dental.service;

import com.ads.dental.domain.Address;
import com.ads.dental.domain.Patient;
import com.ads.dental.repository.AddressRepository;
import com.ads.dental.repository.PatientRepository;
import com.ads.dental.web.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepo;
    private final AddressRepository addressRepo;

    public PatientService(PatientRepository patientRepo, AddressRepository addressRepo) {
        this.patientRepo = patientRepo;
        this.addressRepo = addressRepo;
    }

    public List<Patient> findAllSortedByLastName() {
        return patientRepo.findAllSortedByLastNameAsc();
    }

    public Patient findById(Long id) {
        return patientRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Patient with id " + id + " not found"));
    }

    @Transactional
    public Patient create(Patient toCreate) {
        Address pa = toCreate.getPrimaryAddress();
        if (pa != null) {
            pa.setPatient(toCreate);
        }
        Patient saved = patientRepo.save(toCreate);
        if (pa != null) {
            addressRepo.save(pa);
            saved.setPrimaryAddress(pa);
        }
        return saved;
    }

    @Transactional
    public Patient update(Long id, Patient patch) {
        Patient existing = findById(id);
        if (patch.getFirstName() != null) existing.setFirstName(patch.getFirstName());
        if (patch.getLastName() != null) existing.setLastName(patch.getLastName());
        if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
        if (patch.getPhone() != null) existing.setPhone(patch.getPhone());
        if (patch.getDateOfBirth() != null) existing.setDateOfBirth(patch.getDateOfBirth());

        if (patch.getPrimaryAddress() != null) {
            Address incoming = patch.getPrimaryAddress();
            Address pa = existing.getPrimaryAddress();
            if (pa == null) {
                incoming.setPatient(existing);
                pa = addressRepo.save(incoming);
                existing.setPrimaryAddress(pa);
            } else {
                if (incoming.getStreet() != null) pa.setStreet(incoming.getStreet());
                if (incoming.getCity() != null) pa.setCity(incoming.getCity());
                if (incoming.getState() != null) pa.setState(incoming.getState());
                if (incoming.getZipCode() != null) pa.setZipCode(incoming.getZipCode());
            }
        }
        return patientRepo.save(existing);
    }

    public void delete(Long id) {
        Patient p = findById(id);
        patientRepo.delete(p);
    }

    public List<Patient> search(String q) {
        return patientRepo.search(q);
    }
}
