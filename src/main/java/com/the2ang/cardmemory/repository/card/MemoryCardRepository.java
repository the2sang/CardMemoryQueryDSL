package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.BaseRepository;

import java.util.List;

public interface MemoryCardRepository extends BaseRepository<MemoryCard, Integer> {

    public List<MemoryCard> findByMiddleCategory(Integer id);

    public List<MemoryCard> findByQuestion_dsl(String question);
}
