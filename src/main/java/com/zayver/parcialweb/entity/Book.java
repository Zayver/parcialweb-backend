package com.zayver.parcialweb.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Libro_szunigam")
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String reference;
    private String author;
    private Double price;
    private String location;
}
