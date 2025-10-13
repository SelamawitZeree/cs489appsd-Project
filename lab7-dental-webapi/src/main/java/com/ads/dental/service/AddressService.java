package com.ads.dental.service;

import com.ads.dental.domain.Address;
import com.ads.dental.repository.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepo;

    public AddressService(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    public List<Address> findAllSortedByCity() {
        return addressRepo.findAllSortedByCityAsc();
    }
}
