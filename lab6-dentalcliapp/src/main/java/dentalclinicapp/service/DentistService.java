
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Dentist;
public interface DentistService { Dentist save(Dentist d); java.util.List<Dentist> findByLastName(String lastName); }
