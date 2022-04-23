package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.Address;
import com.springboot.system.Library.entities.Audit;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.AddressRepository;
import com.springboot.system.Library.services.interfaces.AddressInterfaceService;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Component
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
            this.auditInterfaceService.createRecord(new Audit("gel all addresses", new Timestamp(System.currentTimeMillis())));
        }
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
            this.auditInterfaceService.createRecord(new Audit("create address", new Timestamp(System.currentTimeMillis())));
        }
    }
}
