
package edu.miu.cs.cs489.lesson6.dentalclinicapp.domain;

import jakarta.persistence.*;

@Entity
public class Surgery {
    @Id
    private String id;
    private String name;
    public Surgery(){}
    public Surgery(String id,String name){this.id=id;this.name=name;}
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
}
