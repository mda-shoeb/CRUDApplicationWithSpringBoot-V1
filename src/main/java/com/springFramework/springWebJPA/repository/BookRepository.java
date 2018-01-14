package com.springFramework.springWebJPA.repository;

import com.springFramework.springWebJPA.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {

}
