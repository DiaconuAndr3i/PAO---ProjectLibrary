package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.repository.LibraryRepository;
import com.springboot.system.Library.services.interfaces.LibraryInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements LibraryInterfaceService {

    @Autowired
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibraries(){
        return this.libraryRepository.findAll();
    }

    public Library createLibrary(Library library){
        return this.libraryRepository.save(library);
    }
}
