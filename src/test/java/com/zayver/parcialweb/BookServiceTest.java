package com.zayver.parcialweb;

import com.zayver.parcialweb.entity.Book;
import com.zayver.parcialweb.repository.BookRepository;
import com.zayver.parcialweb.service.BookService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookServiceTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void saveBook(){
        val book = Book.builder().author("test").title("Libro").location("Here").reference("Ref").build();
        this.bookService.addBook(book);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void getBooks(){
        val books = List.of(
                Book.builder().author("test").title("Libro").location("Here").reference("Ref").build(),
                Book.builder().author("test2").title("Libro2").location("Here2").reference("Ref2").build()
        );
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        val res = bookService.listBooks();
        assertTrue(StreamSupport.stream(res.spliterator(), false)
                .toList().containsAll(books));
    }
}
