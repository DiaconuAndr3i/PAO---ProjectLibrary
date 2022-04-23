package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.Librarian;
import com.springboot.system.Library.services.LibrarianService;
import com.springboot.system.Library.services.interfaces.LibrarianInterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    private final LibrarianInterfaceService librarianInterfaceService;

    public LibrarianController(LibrarianInterfaceService librarianInterfaceService){
        this.librarianInterfaceService = librarianInterfaceService;
    }

    @GetMapping("/get")
    public List<Librarian> getAllLibrarians(){
        return this.librarianInterfaceService.getAllLibrarians();
    }

    @PostMapping("/create")
    public Librarian createLibrarian(@RequestBody Librarian librarian){
        return this.librarianInterfaceService.createLibrarian(librarian);
    }

}
