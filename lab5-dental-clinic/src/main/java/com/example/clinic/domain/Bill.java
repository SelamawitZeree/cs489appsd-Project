package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "bill")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id
    @Column(name="billId", length=45, nullable=false)
    private String billId;

    @ManyToOne(optional=false)
    @JoinColumn(name="patId", referencedColumnName="patId")
    private Patient patient;

    @Column(name="amount", length=45)
    private String amount;

    @Column(name="billDueDate", length=45)
    private String billDueDate;

    @Column(name="notes", length=45)
    private String notes;

    @Column(name="status", length=45)
    private String status;
}
