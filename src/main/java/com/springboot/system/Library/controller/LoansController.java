package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.Loans;
import com.springboot.system.Library.services.interfaces.LoansInterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoansController {

    private final LoansInterfaceService loansInterfaceService;

    public LoansController(LoansInterfaceService loansInterfaceService){
        this.loansInterfaceService = loansInterfaceService;
    }

    @GetMapping("/get")
    public List<Loans> getAllLoans(){
        return this.loansInterfaceService.getAllLoans();
    }

    @PostMapping("/create")
    public Loans createLoan(@RequestBody Loans loan){
        return this.loansInterfaceService.createLoan(loan);
    }
}
