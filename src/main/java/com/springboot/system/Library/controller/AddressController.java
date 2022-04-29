package com.springboot.system.Library.controller;


import com.springboot.system.Library.entities.Address;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.services.interfaces.AddressInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressInterfaceService addressInterfaceService;

    public AddressController(AddressInterfaceService addressInterfaceService){
        this.addressInterfaceService = addressInterfaceService;
    }

    @GetMapping("/get")
    public List<Address> getAddress(){
        return this.addressInterfaceService.getAllAddress();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long id) throws NotFound {
        return this.addressInterfaceService.getAddressById(id);
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address){
        return this.addressInterfaceService.createAddress(address);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long id, @Valid @RequestBody Address address) throws NotFound {
        return this.addressInterfaceService.updateAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long id) throws NotFound {
        return this.addressInterfaceService.deleteAddress(id);
    }
}
