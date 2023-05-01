package com.the2ang.cardmemory.repository.card.impl;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MemoryCardRepositoryImpl
        extends BaseCardRepositoryImpl<MemoryCard, Integer> implements MemoryCardRepository {
    public MemoryCardRepositoryImpl(EntityManager em) {
        super(MemoryCard.class, em);
    }

    @Override
    public List<MemoryCard> findByMiddleCategory(Integer id) {
        return jpaQueryFactory.selectFrom(memoryCard)
                .where(memoryCard.middleCategory.id.eq(id))
                .fetch();
    }

    @Override
    public List<MemoryCard> findByQuestion_dsl(String question) {
       return  jpaQueryFactory.selectFrom(memoryCard)
               .where(memoryCard.question.like("%" + question + "%"))
               .fetch();
    }

    @Override
    public List<MemoryCard> findByQuestion_dsl2(String question) {
        return jpaQueryFactory.selectFrom(memoryCard)
                .join(memoryCard.middleCategory, middleCategory).fetchJoin()
                .where(memoryCard.question.like("%" + question + "%"))
                .fetch();
    }



}
