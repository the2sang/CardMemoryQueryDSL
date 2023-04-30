package com.the2ang.cardmemory.repository.bookstore;


import com.the2ang.cardmemory.dto.AuthorStatistic;
import com.the2ang.cardmemory.entity.bookstore.Author;
import com.the2ang.cardmemory.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author, Integer> {

    public Optional<Author> findAuthorByEmail(String email);

    public List<AuthorStatistic> getAuthorStatistic();

    public List<Author> getAuthors();

}
