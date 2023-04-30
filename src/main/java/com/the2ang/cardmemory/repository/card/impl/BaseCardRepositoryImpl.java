package com.the2ang.cardmemory.repository.card.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.the2ang.cardmemory.entity.bookstore.QAuthor;
import com.the2ang.cardmemory.entity.bookstore.QBook;
import com.the2ang.cardmemory.entity.card.QMainCategory;
import com.the2ang.cardmemory.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public abstract class BaseCardRepositoryImpl<T,ID>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;


    protected final QMainCategory mainCategory = QMainCategory.mainCategory;

    public BaseCardRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id " + id));
    }
}
