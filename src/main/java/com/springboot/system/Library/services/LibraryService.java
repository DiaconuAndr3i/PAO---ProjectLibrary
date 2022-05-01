package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Library;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.LibraryRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.LibraryInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements LibraryInterfaceService {

    @Autowired
    private final LibraryRepository libraryRepository;
    @Autowired
    private final AuditInterfaceService auditInterfaceService;

    public LibraryService(LibraryRepository libraryRepository,
                          AuditInterfaceService auditInterfaceService){
        this.libraryRepository = libraryRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<Library> getAllLibraries(){
        try{
            return this.libraryRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get all libraries");
        }
    }

    @Override
    public Library createLibrary(Library library){
        try{
            return this.libraryRepository.save(library);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create library");
        }
    }

    @Override
    public ResponseEntity<Library> updateLibrary(Long id, Library newLibrary) throws NotFound {
        Library library = this.libraryRepository.findById(id).orElseThrow(() -> new NotFound("Library with id " + id + " doesn't exist"));

        library.setAddress(newLibrary.getAddress());
        library.setName(newLibrary.getName());

        this.auditInterfaceService.createAction("library updated");

        return ResponseEntity.ok(this.libraryRepository.save(library));
    }

}
