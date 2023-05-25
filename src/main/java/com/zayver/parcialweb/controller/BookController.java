package com.zayver.parcialweb.controller;

import com.zayver.parcialweb.entity.Book;
import com.zayver.parcialweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("all")
    public Iterable<Book> getAllBooks(){
        return this.bookService.listBooks();
    }

    @PostMapping("create")
    public void addBook(@RequestBody Book book){
        this.bookService.addBook(book);
    }

}
