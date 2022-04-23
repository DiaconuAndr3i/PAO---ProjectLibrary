package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.repository.AuthorRepository;
import com.springboot.system.Library.services.interfaces.AuthorInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements AuthorInterfaceService {

   @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author){
        return this.authorRepository.save(author);
    }
}
