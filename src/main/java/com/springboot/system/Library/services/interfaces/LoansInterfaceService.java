package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Loans;

import java.util.List;

public interface LoansInterfaceService {

    List<Loans> getAllLoans();

    Loans createLoan(Loans loan);
}
