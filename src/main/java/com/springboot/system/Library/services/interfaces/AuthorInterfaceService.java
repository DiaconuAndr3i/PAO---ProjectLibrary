package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AuthorInterfaceService {
    List<Author> getAllAuthors();
    Author createAuthor(Author author);
    ResponseEntity<Author> getAuthorById(Long id) throws NotFound;
    ResponseEntity<Author> updateAuthor(Long id, Author newAuthor) throws NotFound;
    Map<String, Boolean> deleteAuthor(Long id) throws NotFound;
}
