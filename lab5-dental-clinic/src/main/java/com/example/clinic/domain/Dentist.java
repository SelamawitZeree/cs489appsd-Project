package com.example.clinic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity @Table(name = "dentist")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Dentist {
    @Id
    @Column(name="dentId", length=45, nullable=false)
    private String dentId;

    @Column(name="dentFirstName", length=45, nullable=false)
    private String dentFirstName;

    @Column(name="dentLastName", length=45, nullable=false)
    private String dentLastName;

    @Column(name="dentPhoneNum", length=45)
    private String dentPhoneNum;

    @Email
    @Column(name="dentEmail", length=45)
    private String dentEmail;

    @Column(name="specialization", length=45)
    private String specialization;
}
