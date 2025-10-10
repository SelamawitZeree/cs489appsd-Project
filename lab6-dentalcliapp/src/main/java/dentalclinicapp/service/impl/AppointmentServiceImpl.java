
package edu.miu.cs.cs489.lesson6.dentalclinicapp.service.impl;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Appointment;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.DentistRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repo;
    private final DentistRepository dentistRepo;
    public AppointmentServiceImpl(AppointmentRepository repo, DentistRepository dentistRepo){this.repo=repo;this.dentistRepo=dentistRepo;}
    public Appointment save(Appointment a){return repo.save(a);}
    public java.util.List<Appointment> findByDentistLastName(String lastName){
        var dentists = dentistRepo.findByLastName(lastName);
        java.util.List<Appointment> out = new java.util.ArrayList<>();
        for (var d: dentists) out.addAll(repo.findByDentistId(d.getId()));
        return out;
    }
}
