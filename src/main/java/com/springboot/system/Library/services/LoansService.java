package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.entities.Loans;
import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.model.FineForSubscriber;
import com.springboot.system.Library.repository.BookCopyRepository;
import com.springboot.system.Library.repository.LibraryRepository;
import com.springboot.system.Library.repository.LoansRepository;
import com.springboot.system.Library.repository.SubscriberRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.LibraryInterfaceService;
import com.springboot.system.Library.services.interfaces.LoansInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@Service
public class LoansService implements LoansInterfaceService {

    @Autowired
    private final LoansRepository loansRepository;
    @Autowired
    private final AuditInterfaceService auditInterfaceService;
    @Autowired
    private final LibraryRepository libraryRepository;
    @Autowired
    private final SubscriberRepository subscriberRepository;
    @Autowired
    private final BookCopyRepository bookCopyRepository;

    public LoansService(LoansRepository loansRepository,
                        AuditInterfaceService auditInterfaceService,
                        LibraryRepository libraryRepository,
                        SubscriberRepository subscriberRepository,
                        BookCopyRepository bookCopyRepository){
        this.loansRepository = loansRepository;
        this.auditInterfaceService = auditInterfaceService;
        this.libraryRepository = libraryRepository;
        this.subscriberRepository = subscriberRepository;
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public List<Loans> getAllLoans() {
        try{
            return this.loansRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get all loans");
        }
    }

    @Override
    public Loans createLoan(Loans loan) {
        try{
            return this.loansRepository.save(loan);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create loan record");
        }
    }

    @Override
    public List<Loans> getLoansWhereReturnDateGreaterThanExpectationDate(){
        List<Loans> loans = this.loansRepository.findLoansWhereReturnDateGreaterThanExpectationDate();
        this.auditInterfaceService.createAction("get loans where return date > expect date");
        return loans;
    }

    @Override
    public Map<String, Boolean> deleteLoan(Long id) throws NotFound {
        Loans loan = this.loansRepository.findById(id).orElseThrow(() -> new NotFound("Loan with id " + id + " doesn't exist"));
        this.loansRepository.delete(loan);

        Map<String, Boolean> res = new HashMap<>();
        res.put("Loan deleted", Boolean.TRUE);

        this.auditInterfaceService.createAction("loan deleted");

        return res;
    }

    @Override
    public Map<String, Boolean> assignLibraryForLoan(Long id, Loans loan) throws NotFound {
        Library library = this.libraryRepository.findById(id).orElseThrow(() -> new NotFound("Library with id " + id + " doesn't exist"));

        library.addLoan(loan);

        this.libraryRepository.save(library);

        this.auditInterfaceService.createAction("assign library for loan");
        Map<String, Boolean>res = new HashMap<>();
        res.put("Library assigned", Boolean.TRUE);

        return res;
    }

    @Override
    public Map<String, Boolean> assignSubscriberForLoan(Long id, Loans loan) throws NotFound {
        Subscriber subscriber = this.subscriberRepository.findById(id).orElseThrow(() -> new NotFound("Subscriber with id " + id + " doesn't exist"));

        subscriber.addLoan(loan);

        this.subscriberRepository.save(subscriber);

        this.auditInterfaceService.createAction("assign subscriber for loan");
        Map<String, Boolean>res = new HashMap<>();
        res.put("Subscriber assigned", Boolean.TRUE);

        return res;
    }

    @Override
    public Map<String, Boolean> assignBookForLoan(Long id, Loans loan) throws NotFound {
        BookCopy bookCopy = this.bookCopyRepository.findById(id).orElseThrow(() -> new NotFound("Book with id " + id + " doesn't exist"));

        bookCopy.addLoan(loan);

        this.bookCopyRepository.save(bookCopy);

        this.auditInterfaceService.createAction("assign book for loan");
        Map<String, Boolean>res = new HashMap<>();
        res.put("Book assigned", Boolean.TRUE);

        return res;
    }
/*
    public FineForSubscriber calculateFine(Long idSubscriber){
        List<Loans> loans = this.getLoansWhereReturnDateGreaterThanExpectationDate();

        for(var loan: loans){
            if(loan.getSubscriber() == idSubscriber)
        }

    }*/

}
