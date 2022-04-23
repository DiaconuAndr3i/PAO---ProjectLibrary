package com.springboot.system.Library.repository;

import com.springboot.system.Library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
