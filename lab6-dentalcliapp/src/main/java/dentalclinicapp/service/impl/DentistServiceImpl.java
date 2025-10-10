
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service.impl;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Dentist;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.DentistRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.DentistService;
@Service
public class DentistServiceImpl implements DentistService {
    private final DentistRepository repo;
    public DentistServiceImpl(DentistRepository repo){this.repo=repo;}
    public Dentist save(Dentist d){return repo.save(d);}
    public java.util.List<Dentist> findByLastName(String ln){return repo.findByLastName(ln);}
}
