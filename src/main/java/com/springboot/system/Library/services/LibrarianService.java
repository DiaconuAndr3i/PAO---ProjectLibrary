package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Librarian;
import com.springboot.system.Library.repository.LibrarianRepository;
import com.springboot.system.Library.services.interfaces.LibrarianInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibrarianService implements LibrarianInterfaceService {

    @Autowired
    private final LibrarianRepository librarianRepository;

    public LibrarianService(LibrarianRepository librarianRepository){
        this.librarianRepository = librarianRepository;
    }

    public List<Librarian> getAllLibrarians(){
        return this.librarianRepository.findAll();
    }

    public Librarian createLibrarian(Librarian librarian){
        return this.librarianRepository.save(librarian);
    }
}
