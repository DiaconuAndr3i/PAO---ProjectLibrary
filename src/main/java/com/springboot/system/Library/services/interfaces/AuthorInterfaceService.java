package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Author;

import java.util.List;

public interface AuthorInterfaceService {
    List<Author> getAllAuthors();

    Author createAuthor(Author author);
}
