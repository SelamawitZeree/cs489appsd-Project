package com.ads.dental.web.dto;

import java.time.LocalDate;

public class PatientDTO {
    public Long patientId;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public LocalDate dateOfBirth;
    public AddressDTO primaryAddress;
}
