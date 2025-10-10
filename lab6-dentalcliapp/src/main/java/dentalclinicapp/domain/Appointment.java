package edu.miu.cs.cs489.lesson6.dentalclinicapp.domain;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date; private LocalTime time;
    @ManyToOne(optional=false) @JoinColumn(name="dentist_id")
    private Dentist dentist;
    @ManyToOne(optional=false) @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne(optional=false) @JoinColumn(name="surgery_id")
    private Surgery surgery;
    public Appointment(){}
    public Appointment(Long id, LocalDate date, LocalTime time, Dentist dentist, Patient patient, Surgery surgery){this.id=id;this.date=date;this.time=time;this.dentist=dentist;this.patient=patient;this.surgery=surgery;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public LocalDate getDate(){return date;} public void setDate(LocalDate date){this.date=date;}
    public LocalTime getTime(){return time;} public void setTime(LocalTime time){this.time=time;}
    public Dentist getDentist(){return dentist;} public void setDentist(Dentist dentist){this.dentist=dentist;}
    public Patient getPatient(){return patient;} public void setPatient(Patient patient){this.patient=patient;}
    public Surgery getSurgery(){return surgery;} public void setSurgery(Surgery surgery){this.surgery=surgery;}
    @Override public String toString(){return "Appointment{id="+id+", "+date+" "+time+", dentist="+dentist.getLastName()+", patient="+patient.getPatientNo()+", surgery="+surgery.getId()+"}";}
}
