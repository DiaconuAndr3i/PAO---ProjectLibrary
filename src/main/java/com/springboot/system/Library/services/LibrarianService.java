package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Librarian;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.LibrarianRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.LibrarianInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LibrarianService implements LibrarianInterfaceService {

    @Autowired
    private final LibrarianRepository librarianRepository;
    @Autowired
    private final AuditInterfaceService auditInterfaceService;

    public LibrarianService(LibrarianRepository librarianRepository,
                            AuditInterfaceService auditInterfaceService){
        this.librarianRepository = librarianRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<Librarian> getAllLibrarians(){
        try {
            return this.librarianRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get all librarians");
        }
    }

    @Override
    public Librarian createLibrarian(Librarian librarian){
        try{
            return this.librarianRepository.save(librarian);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create librarian");
        }
    }

    @Override
    public ResponseEntity<Librarian> getLibrarianById(Long id) throws NotFound {
        Librarian librarian = this.librarianRepository.findById(id).orElseThrow(() -> new NotFound("Librarian with id " + id + " doesn't exist"));
        this.auditInterfaceService.createAction("get librarian by id");
        return ResponseEntity.ok().body(librarian);
    }

    @Override
    public ResponseEntity<Librarian> updateLibrarian(Long id, Librarian newLibrarian) throws NotFound{
        Librarian librarian = this.librarianRepository.findById(id).orElseThrow(() -> new NotFound("Librarian with id " + id + " doesn't exist"));

        librarian.setAddress(newLibrarian.getAddress());
        librarian.setFirstName(newLibrarian.getFirstName());
        librarian.setLastName(newLibrarian.getLastName());
        librarian.setPhoneNumber(newLibrarian.getPhoneNumber());

        this.auditInterfaceService.createAction("update librarian");

        return ResponseEntity.ok(this.librarianRepository.save(librarian));
    }

    @Override
    public Map<String, Boolean> deleteLibrarian(Long id) throws NotFound{
        Librarian librarian = this.librarianRepository.findById(id).orElseThrow(() -> new NotFound("Librarian with id " + id + " doesn't exist"));
        this.librarianRepository.delete(librarian);

        Map<String, Boolean> res = new HashMap<>();
        res.put("Librarian deleted", Boolean.TRUE);

        this.auditInterfaceService.createAction("delete librarian");

        return res;
    }


}
