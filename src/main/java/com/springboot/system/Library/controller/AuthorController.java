package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.Author;
import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.services.interfaces.AuthorInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorInterfaceService authorInterfaceService;

    public AuthorController(AuthorInterfaceService authorInterfaceService){
        this.authorInterfaceService = authorInterfaceService;
    }

    @GetMapping("/get")
    public List<Author> getAllAuthors(){
        return this.authorInterfaceService.getAllAuthors();
    }

    @PostMapping("/create")
    public Author createAuthor(@RequestBody Author author){
        return this.authorInterfaceService.createAuthor(author);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long id) throws NotFound {
        return this.authorInterfaceService.getAuthorById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long id, @Valid @RequestBody Author author) throws NotFound {
        return this.authorInterfaceService.updateAuthor(id, author);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable(value = "id") Long id) throws NotFound {
        return this.authorInterfaceService.deleteAuthor(id);
    }
}
