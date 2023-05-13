package com.the2ang.cardmemory.repository.card.impl;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MiddleCategoryRepositoryImpl
        extends BaseCardRepositoryImpl<MiddleCategory, Integer> implements MiddleCategoryRepository {
    public MiddleCategoryRepositoryImpl(EntityManager em) {
        super(MiddleCategory.class, em);
    }

    @Override
    public List<MiddleCategory> findByName(String name) {
        return jpaQueryFactory.selectFrom(middleCategory)
                .where(middleCategory.name.eq(name))
                .fetch();
    }

    @Override
    public List<MiddleCategory> findByMainCategory(Integer id) {
        return jpaQueryFactory.selectFrom(middleCategory)
                .where(middleCategory.mainCategory.id.eq(id))
                .orderBy(middleCategory.id.asc())
                .fetch();
    }

    @Override
    public List<MiddleCategory> findAllMiddleCategoryFetchJoin() {
        return jpaQueryFactory.selectFrom(middleCategory)
                .join(middleCategory.mainCategory, mainCategory).fetchJoin()
                .orderBy(middleCategory.id.asc())
                .fetch();
    }





}
