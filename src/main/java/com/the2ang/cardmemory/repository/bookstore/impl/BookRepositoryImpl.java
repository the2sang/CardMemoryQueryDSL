package com.the2ang.cardmemory.repository.bookstore.impl;

import com.the2ang.cardmemory.entity.bookstore.Book;
import com.the2ang.cardmemory.repository.bookstore.BookRepository;
import jakarta.persistence.EntityManager;

public class BookRepositoryImpl extends BaseBookstoreRepositoryImpl<Book, Integer> implements BookRepository {
    public BookRepositoryImpl(EntityManager em) {
        super(Book.class, em);
    }


}
