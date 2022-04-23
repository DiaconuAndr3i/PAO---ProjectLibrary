package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Library;

import java.util.List;

public interface LibraryInterfaceService {

    List<Library> getAllLibraries();

    Library createLibrary(Library library);
}
