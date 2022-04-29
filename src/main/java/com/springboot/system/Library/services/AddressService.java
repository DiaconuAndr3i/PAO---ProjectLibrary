package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.Address;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.AddressRepository;
import com.springboot.system.Library.services.interfaces.AddressInterfaceService;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService implements AddressInterfaceService {

    @Autowired
    private final AddressRepository addressRepository;

    private final AuditInterfaceService auditInterfaceService;

    public AddressService(AddressRepository addressRepository, AuditInterfaceService auditInterfaceService){
        this.addressRepository = addressRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<Address> getAllAddress(){
        try{
            return this.addressRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("gel all addresses");
        }
    }

    @Override
    public ResponseEntity<Address> getAddressById(Long id) throws NotFound {
        Address address = this.addressRepository.findById(id).orElseThrow(() -> new NotFound("Address with id " + id + " doesn't exist"));
        this.auditInterfaceService.createAction("get address by id");
        return ResponseEntity.ok().body(address);
    }

    @Override
    public Address createAddress(Address address) {
        try {
            return this.addressRepository.save(address);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create address");
        }
    }

    @Override
    public ResponseEntity<Address> updateAddress(Long id, Address newAddress) throws NotFound {
        Address address = this.addressRepository.findById(id).orElseThrow(() -> new NotFound("Address with id " + id + " doesn't exist"));

        address.setCity(newAddress.getCity());
        address.setCountry(newAddress.getCountry());
        address.setNumber(newAddress.getNumber());
        address.setStreet(newAddress.getStreet());

        this.auditInterfaceService.createAction("Address updated");

        return ResponseEntity.ok(this.addressRepository.save(address));
    }

    @Override
    public Map<String, Boolean> deleteAddress(Long id) throws NotFound {
        Address address = this.addressRepository.findById(id).orElseThrow(() -> new NotFound("Address with id " + id + " doesn't exist"));

        this.addressRepository.delete(address);

        Map<String, Boolean> res = new HashMap<>();
        res.put("Address deleted", Boolean.TRUE);

        this.auditInterfaceService.createAction("Address deleted");

        return res;
    }
}
