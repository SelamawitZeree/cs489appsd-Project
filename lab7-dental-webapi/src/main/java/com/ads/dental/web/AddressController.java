package com.ads.dental.web;

import com.ads.dental.service.AddressService;
import com.ads.dental.web.dto.AddressDTO;
import com.ads.dental.web.dto.Mappers;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // 7. GET /addresses sorted by city asc including patient data
    @GetMapping("/addresses")
    public List<AddressDTO> getAllAddresses() {
        return addressService.findAllSortedByCity().stream()
                .map(a -> Mappers.toAddressDTO(a, true))
                .collect(Collectors.toList());
    }
}
