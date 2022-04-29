package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Address;
import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AddressInterfaceService {
    List<Address> getAllAddress();

    Address createAddress(Address address);

    public ResponseEntity<Address> getAddressById(Long id) throws NotFound;

    ResponseEntity<Address> updateAddress(Long id, Address newAddress) throws NotFound;

    Map<String, Boolean> deleteAddress(Long id) throws NotFound;
}
