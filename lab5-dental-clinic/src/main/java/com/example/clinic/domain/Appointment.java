package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "appointment")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment {
    @Id
    @Column(name="appointmentId", length=45, nullable=false)
    private String appointmentId;

    @ManyToOne(optional=false)
    @JoinColumn(name="dentId", referencedColumnName="dentId")
    private Dentist dentist;

    @ManyToOne(optional=false)
    @JoinColumn(name="patId", referencedColumnName="patId")
    private Patient patient;

    @ManyToOne(optional=false)
    @JoinColumn(name="surgeryId", referencedColumnName="surgeryId")
    private Surgery surgery;

    @Column(name="appDate", length=45)
    private String appDate;

    @Column(name="appTime", length=45)
    private String appTime;
}
