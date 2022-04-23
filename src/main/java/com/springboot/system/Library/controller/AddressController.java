package com.springboot.system.Library.controller;


import com.springboot.system.Library.entities.Address;
import com.springboot.system.Library.services.AddressService;
import com.springboot.system.Library.services.interfaces.AddressInterfaceService;
import com.springboot.system.Library.testare.PentruAfterReturning;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address){
        return this.addressInterfaceService.createAddress(address);
    }
}
