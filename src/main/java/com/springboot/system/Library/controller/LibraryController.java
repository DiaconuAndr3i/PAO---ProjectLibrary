package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.services.LibraryService;
import com.springboot.system.Library.services.interfaces.LibrarianInterfaceService;
import com.springboot.system.Library.services.interfaces.LibraryInterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryInterfaceService libraryInterfaceService;

    public LibraryController(LibraryInterfaceService libraryInterfaceService){
        this.libraryInterfaceService = libraryInterfaceService;
    }

    @GetMapping("/get")
    private List<Library> getLibrary(){
        return this.libraryInterfaceService.getAllLibraries();
    }

    @PostMapping("/create")
    public Library createLibrary(@RequestBody Library library){
        return this.libraryInterfaceService.createLibrary(library);
    }
}
