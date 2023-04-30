package com.the2ang.cardmemory.service;

import com.the2ang.cardmemory.dto.AuthorStatistic;
import com.the2ang.cardmemory.entity.bookstore.Author;
import com.the2ang.cardmemory.entity.bookstore.Book;
import com.the2ang.cardmemory.repository.bookstore.AuthorRepository;
import com.the2ang.cardmemory.repository.bookstore.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthBookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> saveAuthorsWithBooks(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic() {
        return authorRepository.getAuthorStatistic();
    }

    public List<Author> getAuthorsWithFetchJoin() {
        return authorRepository.getAuthors();
    }

}
