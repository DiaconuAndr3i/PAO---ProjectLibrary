package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.AuthorRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.AuthorInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService implements AuthorInterfaceService {

   @Autowired
    private final AuthorRepository authorRepository;
   @Autowired
    private final AuditInterfaceService auditInterfaceService;

    public AuthorService(AuthorRepository authorRepository,
                         AuditInterfaceService auditInterfaceService){
        this.authorRepository = authorRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author){
        return this.authorRepository.save(author);
    }

    @Override
    public ResponseEntity<Author> getAuthorById(Long id) throws NotFound {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new NotFound("Author with id " + id + " doesn't exist"));
        this.auditInterfaceService.createAction("get author by id");
        return ResponseEntity.ok().body(author);
    }

    @Override
    public ResponseEntity<Author> updateAuthor(Long id, Author newAuthor) throws NotFound {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new NotFound("Author with id " + id + " doesn't exist"));

        author.setAddress(newAuthor.getAddress());
        author.setFirstName(newAuthor.getFirstName());
        author.setLastName(newAuthor.getLastName());
        author.setPhoneNumber(newAuthor.getPhoneNumber());
        author.setBookCopies(newAuthor.getBookCopies());

        this.auditInterfaceService.createAction("author updated");

        return ResponseEntity.ok(this.authorRepository.save(author));
    }

    @Override
    public Map<String, Boolean> deleteAuthor(Long id) throws NotFound {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new NotFound("Author with id " + id + " doesn't exist"));

        this.authorRepository.deleteFromBooksAuthors(id);
        this.authorRepository.delete(author);

        Map<String, Boolean> res = new HashMap<>();

        res.put("Author deleted", Boolean.TRUE);

        return res;
    }
}
