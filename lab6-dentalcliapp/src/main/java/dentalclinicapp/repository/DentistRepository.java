
package edu.miu.cs.cs489.lesson6.dentalclinicapp.repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Dentist;
public interface DentistRepository extends CrudRepository<Dentist, Long> {
    java.util.List<Dentist> findByLastName(String lastName);
}
