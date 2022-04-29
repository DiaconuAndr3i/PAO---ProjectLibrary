package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Librarian;
import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LibrarianInterfaceService {

    List<Librarian> getAllLibrarians();
    Librarian createLibrarian(Librarian librarian);
    ResponseEntity<Librarian> getLibrarianById(Long id) throws NotFound;
    ResponseEntity<Librarian> updateLibrarian(Long id, Librarian newLibrarian) throws NotFound;
    Map<String, Boolean> deleteLibrarian(Long id) throws NotFound;
}
