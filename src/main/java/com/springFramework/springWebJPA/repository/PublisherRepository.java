package com.springFramework.springWebJPA.repository;

import com.springFramework.springWebJPA.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
