package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryInterfaceService {

    List<Library> getAllLibraries();
    Library createLibrary(Library library);
    ResponseEntity<Library> updateLibrary(Long id, Library newLibrary) throws NotFound;
}
