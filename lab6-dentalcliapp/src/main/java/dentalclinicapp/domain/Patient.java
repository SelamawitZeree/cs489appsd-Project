
package edu.miu.cs.cs489.lesson6.dentalclinicapp.domain;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String patientNo;
    private String firstName; private String lastName;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name="address_id")
    private Address address;
    public Patient(){}
    public Patient(Long id,String patientNo,String firstName,String lastName,Address address){this.id=id;this.patientNo=patientNo;this.firstName=firstName;this.lastName=lastName;this.address=address;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getPatientNo(){return patientNo;} public void setPatientNo(String patientNo){this.patientNo=patientNo;}
    public String getFirstName(){return firstName;} public void setFirstName(String firstName){this.firstName=firstName;}
    public String getLastName(){return lastName;} public void setLastName(String lastName){this.lastName=lastName;}
    public Address getAddress(){return address;} public void setAddress(Address address){this.address=address;}
}
