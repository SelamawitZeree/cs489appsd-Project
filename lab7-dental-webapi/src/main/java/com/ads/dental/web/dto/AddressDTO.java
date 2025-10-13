package com.ads.dental.web.dto;

public class AddressDTO {
    public Long addressId;
    public String street;
    public String city;
    public String state;
    public String zipCode;

    // Optional minimal patient info for /addresses endpoint
    public Long patientId;
    public String patientFullName;
}
