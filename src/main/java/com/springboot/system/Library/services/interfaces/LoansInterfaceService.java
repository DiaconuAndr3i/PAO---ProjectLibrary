package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.entities.Loans;
import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.error.status.NotFound;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LoansInterfaceService {

    List<Loans> getAllLoans();
    Map<String, Boolean> writeLoansInCSV();
    Loans createLoan(Loans loan);
    List<Loans> getLoansWhereReturnDateGreaterThanExpectationDate();
    Map<String, Boolean> deleteLoan(Long id) throws NotFound;
    Map<String, Boolean> assignLibraryForLoan(Long id, Loans loan) throws NotFound;
    Map<String, Boolean> assignSubscriberForLoan(Long id, Loans loan) throws NotFound;
    Map<String, Boolean> assignBookForLoan(Long id, Loans loan) throws NotFound;
}
