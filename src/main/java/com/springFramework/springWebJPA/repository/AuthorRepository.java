package com.springFramework.springWebJPA.repository;

import com.springFramework.springWebJPA.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
