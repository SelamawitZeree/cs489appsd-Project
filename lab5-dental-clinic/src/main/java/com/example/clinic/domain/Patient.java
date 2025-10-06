package com.example.clinic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity @Table(name = "patient")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id
    @Column(name="patId", length=45, nullable=false)
    private String patId;

    @Column(name="patFirstName", length=45, nullable=false)
    private String patFirstName;

    @Column(name="patLastName", length=45, nullable=false)
    private String patLastName;

    @Column(name="patPhoneNum", length=45)
    private String patPhoneNum;

    @Email
    @Column(name="patEmail", length=45)
    private String patEmail;

    @Column(name="patMailingAddress", length=45)
    private String patMailingAddress;

    @Column(name="patDateOfBirth", length=45)
    private String patDateOfBirth;
}
