package com.the2ang.cardmemory.repository.card.impl;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainCategoryRepositoryImpl
        extends BaseCardRepositoryImpl<MainCategory, Integer > implements MainCategoryRepository {
    public MainCategoryRepositoryImpl(EntityManager em) {
        super(MainCategory.class, em);
    }

    @Override
    public List<MainCategory> findByName(String name) {
        return jpaQueryFactory.selectFrom(mainCategory)
                .where(mainCategory.name.eq(name))
                .fetch();
    }



}
