package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Librarian;

import java.util.List;

public interface LibrarianInterfaceService {

    List<Librarian> getAllLibrarians();

    Librarian createLibrarian(Librarian librarian);
}
