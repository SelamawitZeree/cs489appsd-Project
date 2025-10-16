package com.ads.dental.dto;
public class AddressDTO {
  public Long addressId;
  public String street, city, state, zipCode;
  public Long patientId;      // for /addresses page
  public String patientFullName;
}
