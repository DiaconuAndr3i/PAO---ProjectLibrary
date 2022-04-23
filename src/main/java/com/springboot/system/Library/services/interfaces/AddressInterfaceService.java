package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Address;

import java.util.List;

public interface AddressInterfaceService {
    List<Address> getAllAddress();

    Address createAddress(Address address);
}
