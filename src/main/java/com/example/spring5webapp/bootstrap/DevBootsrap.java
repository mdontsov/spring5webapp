package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.model.repositories.AuthorRepository;
import com.example.spring5webapp.model.repositories.BookRepository;
import com.example.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by maxim on 31.05.2018.
 */
@Component
public class DevBootsrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootsrap(AuthorRepository authorRepository, BookRepository bookRepository,
                       PublisherRepository publiserRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publiserRepository;
    }

    private void initData() {

        Publisher publisher1 = new Publisher("Rahva Raamat", "Endla 45");
//        publisher1.setName("Rahva Raamat");
        Author DS = new Author("Dan", "Simmons");
        Book terror = new Book("The Terror", "123456", publisher1);

        DS.getBooks().add(terror);
        terror.getAuthors().add(DS);

        authorRepository.save(DS);
        bookRepository.save(terror);
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher("Koolibri", "Rottermani 10");
//        publisher2.setName("Koolibri");
        Author SK = new Author("Stephen", "King");
        Book it = new Book("It", "654321", publisher2);

        SK.getBooks().add(it);
        it.getAuthors().add(SK);

        authorRepository.save(SK);
        bookRepository.save(it);
        publisherRepository.save(publisher2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
