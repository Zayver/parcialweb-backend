package com.zayver.parcialweb.repository;

import com.zayver.parcialweb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
