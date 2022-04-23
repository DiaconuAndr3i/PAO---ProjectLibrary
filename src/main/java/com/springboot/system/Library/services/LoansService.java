package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Loans;
import com.springboot.system.Library.repository.LoansRepository;
import com.springboot.system.Library.services.interfaces.LoansInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LoansService implements LoansInterfaceService {

    @Autowired
    private final LoansRepository loansRepository;

    public LoansService(LoansRepository loansRepository){
        this.loansRepository = loansRepository;
    }

    @Override
    public List<Loans> getAllLoans() {
        return this.loansRepository.findAll();
    }

    @Override
    public Loans createLoan(Loans loan) {
        return this.loansRepository.save(loan);
    }
}
