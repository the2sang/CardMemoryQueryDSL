package com.the2ang.cardmemory.repository.bookstore.impl;

import com.querydsl.core.types.Projections;
import com.the2ang.cardmemory.dto.AuthorStatistic;
import com.the2ang.cardmemory.entity.bookstore.Author;
import com.the2ang.cardmemory.repository.bookstore.AuthorRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl extends BaseBookstoreRepositoryImpl<Author, Integer> implements AuthorRepository {

    public AuthorRepositoryImpl(EntityManager em) {
        super(Author.class, em);
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(author)
                        .from(author)
                        .where(author.email.equalsIgnoreCase(email))
                        .fetchFirst()
        );
    }

    @Override
    public List<AuthorStatistic> getAuthorStatistic() {
        return jpaQueryFactory
                .from(author)
                .innerJoin(author.books, book)
                .groupBy(author.name)
                .select(Projections.constructor(AuthorStatistic.class, author.name, book.count())).fetch();
    }

    @Override
    public List<Author> getAuthors() {
        return jpaQueryFactory
                .select(author)
                .distinct()
                .from(author)
                .innerJoin(author.books, book)
                .fetchJoin().fetch();
    }


}
