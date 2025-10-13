package com.ads.dental.repository;

import com.ads.dental.domain.Address;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    default List<Address> findAllSortedByCityAsc() {
        return findAll(Sort.by(Sort.Direction.ASC, "city"));
    }
}
