package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AddressRepository extends JpaRepository<Address, Long> {
}
