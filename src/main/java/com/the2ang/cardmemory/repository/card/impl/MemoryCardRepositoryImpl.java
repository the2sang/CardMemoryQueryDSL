package com.the2ang.cardmemory.repository.card.impl;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MemoryCardRepositoryImpl
        extends BaseCardRepositoryImpl<MemoryCard, Long> implements MemoryCardRepository {
    public MemoryCardRepositoryImpl(EntityManager em) {
        super(MemoryCard.class, em);
    }

    @Override
    public List<MemoryCard> findByMiddleCategory(Long id) {
        return jpaQueryFactory.selectFrom(memoryCard)
                .where(memoryCard.middleCategory.id.eq(id))
                .fetch();
    }

}
