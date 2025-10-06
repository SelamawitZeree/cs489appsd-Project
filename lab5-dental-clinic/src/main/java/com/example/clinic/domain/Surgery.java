package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "surgery")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Surgery {
    @Id
    @Column(name="surgeryId", length=45, nullable=false)
    private String surgeryId;

    @Column(name="surgName", length=45)
    private String surgName;

    @Column(name="surgLocation", length=45)
    private String surgLocation;

    @Column(name="surgPhoneNum")
    private Integer surgPhoneNum;
}
