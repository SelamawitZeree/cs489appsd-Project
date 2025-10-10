
package edu.miu.cs.cs489.lesson6.dentalclinicapp.repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Patient;
public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findByLastName(String lastName);
    Patient findByPatientNo(String patientNo);
}
