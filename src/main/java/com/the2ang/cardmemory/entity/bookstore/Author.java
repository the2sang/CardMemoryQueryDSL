package com.the2ang.cardmemory.entity.bookstore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private int authorId;
    private String name;
    private String email;

    @OneToMany(targetEntity = Book.class,
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private List<Book> books;
}
