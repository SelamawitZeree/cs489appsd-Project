
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service.impl;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Surgery;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.SurgeryRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.SurgeryService;
@Service
public class SurgeryServiceImpl implements SurgeryService {
    private final SurgeryRepository repo;
    public SurgeryServiceImpl(SurgeryRepository repo){this.repo=repo;}
    public Surgery save(Surgery s){return repo.save(s);}
}
