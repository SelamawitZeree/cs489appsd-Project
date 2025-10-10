
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service.impl;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Patient;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.PatientRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repo;
    public PatientServiceImpl(PatientRepository repo){this.repo=repo;}
    public Patient save(Patient p){return repo.save(p);}
}
