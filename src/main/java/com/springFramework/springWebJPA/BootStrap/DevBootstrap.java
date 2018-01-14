package com.springFramework.springWebJPA.BootStrap;

import com.springFramework.springWebJPA.model.Author;
import com.springFramework.springWebJPA.model.Books;
import com.springFramework.springWebJPA.model.Publisher;
import com.springFramework.springWebJPA.repository.AuthorRepository;
import com.springFramework.springWebJPA.repository.BookRepository;
import com.springFramework.springWebJPA.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.awt.print.Book;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setAddress("123 Main Street, CA");
        publisher.setName("Harper Collins");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Books ddd = new Books("Domain Driven Design", "1334",publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //2nd Author and Book
        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("J2EE Development", "234565", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);




    }

}
