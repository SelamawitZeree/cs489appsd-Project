
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Appointment;
public interface AppointmentService {
    Appointment save(Appointment a);
    java.util.List<Appointment> findByDentistLastName(String lastName);
}
