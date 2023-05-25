package com.zayver.parcialweb.service;

import com.zayver.parcialweb.repository.BookRepository;
import com.zayver.parcialweb.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void addBook(Book book){
        this.bookRepository.save(book);
    }

    public Iterable<Book> listBooks(){
        return this.bookRepository.findAll();
    }
}
