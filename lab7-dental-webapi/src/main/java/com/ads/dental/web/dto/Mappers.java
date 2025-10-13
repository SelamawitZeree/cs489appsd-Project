package com.ads.dental.web.dto;

import com.ads.dental.domain.Address;
import com.ads.dental.domain.Patient;

public class Mappers {

    public static PatientDTO toPatientDTO(Patient p) {
        if (p == null) return null;
        PatientDTO dto = new PatientDTO();
        dto.patientId = p.getPatientId();
        dto.firstName = p.getFirstName();
        dto.lastName = p.getLastName();
        dto.email = p.getEmail();
        dto.phone = p.getPhone();
        dto.dateOfBirth = p.getDateOfBirth();
        dto.primaryAddress = toAddressDTO(p.getPrimaryAddress(), false);
        return dto;
    }

    public static AddressDTO toAddressDTO(Address a, boolean includePatient) {
        if (a == null) return null;
        AddressDTO dto = new AddressDTO();
        dto.addressId = a.getAddressId();
        dto.street = a.getStreet();
        dto.city = a.getCity();
        dto.state = a.getState();
        dto.zipCode = a.getZipCode();
        if (includePatient && a.getPatient() != null) {
            dto.patientId = a.getPatient().getPatientId();
            dto.patientFullName = a.getPatient().getFirstName() + " " + a.getPatient().getLastName();
        }
        return dto;
    }
}
