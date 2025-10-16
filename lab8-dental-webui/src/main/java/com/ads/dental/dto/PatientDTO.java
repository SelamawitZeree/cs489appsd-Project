package com.ads.dental.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientDTO {
  public Long patientId;
  @NotBlank @Size(max=60) public String firstName;
  @NotBlank @Size(max=60) public String lastName;
  @Email public String email;
  public String phone;
  public LocalDate dateOfBirth;
  public AddressDTO primaryAddress = new AddressDTO();
}
