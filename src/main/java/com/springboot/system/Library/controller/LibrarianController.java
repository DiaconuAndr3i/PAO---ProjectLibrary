package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Librarian;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.services.LibrarianService;
import com.springboot.system.Library.services.interfaces.LibrarianInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/get/{id}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable(value = "id") Long id) throws NotFound {
        return this.librarianInterfaceService.getLibrarianById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable(value = "id") Long id, @Valid @RequestBody Librarian librarian) throws NotFound {
        return this.librarianInterfaceService.updateLibrarian(id, librarian);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteLibrarian(@PathVariable(value = "id") Long id) throws NotFound {
        return this.librarianInterfaceService.deleteLibrarian(id);
    }

}
