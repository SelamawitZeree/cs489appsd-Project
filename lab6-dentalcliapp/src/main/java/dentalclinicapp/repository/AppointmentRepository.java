
package edu.miu.cs.cs489.lesson6.dentalclinicapp.repository;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Appointment;
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    java.util.List<Appointment> findByDentistId(Long dentistId);
    java.util.List<Appointment> findByDate(LocalDate date);
}
