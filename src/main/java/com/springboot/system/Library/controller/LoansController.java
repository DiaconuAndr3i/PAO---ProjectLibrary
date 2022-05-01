package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.*;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.services.interfaces.LoansInterfaceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/getLoansReturnDateGreaterExpectedDate")
    public List<Loans> getLoansReturnDateGreaterExpectedDate(){
        return this.loansInterfaceService.getLoansWhereReturnDateGreaterThanExpectationDate();
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteLoan(@PathVariable(value = "id") Long id) throws NotFound {
        return this.loansInterfaceService.deleteLoan(id);
    }

    @PutMapping("/assignLibrary/{id}")
    public Map<String, Boolean> assignLibrary(@PathVariable(value = "id") Long id, @Valid @RequestBody Loans loan) throws NotFound {
        return this.loansInterfaceService.assignLibraryForLoan(id, loan);
    }

    @PutMapping("/assignSubscriber/{id}")
    public Map<String, Boolean> assignSubscriber(@PathVariable(value = "id") Long id, @Valid @RequestBody Loans loan) throws NotFound {
        return this.loansInterfaceService.assignSubscriberForLoan(id, loan);
    }

    @PutMapping("/assignBook/{id}")
    public Map<String, Boolean> assignBook(@PathVariable(value = "id") Long id, @Valid @RequestBody Loans loan) throws NotFound {
        return this.loansInterfaceService.assignBookForLoan(id, loan);
    }
}
