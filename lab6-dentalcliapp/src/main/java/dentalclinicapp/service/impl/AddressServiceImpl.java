package edu.miu.cs.cs489.lesson6.dentalclinicapp.service.impl;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.domain.Address;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson6.dentalclinicapp.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repo;
    public AddressServiceImpl(AddressRepository repo){this.repo=repo;}
    public Address save(Address a){return repo.save(a);}
}
