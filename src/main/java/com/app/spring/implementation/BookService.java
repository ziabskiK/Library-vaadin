package com.app.spring.implementation;

import com.app.spring.data.Book;
import com.app.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }
    public Book addNewBook(Book book){
        return repository.save(book);
    }

}
