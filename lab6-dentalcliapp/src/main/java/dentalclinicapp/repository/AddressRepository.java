
package edu.miu.cs.cs489.lesson6.dentalclinicapp.repository;
import org.springframework.data.repository.CrudRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Address;
public interface AddressRepository extends CrudRepository<Address, Long> {}
