package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.BaseRepository;

import java.util.List;

public interface MemoryCardRepository extends BaseRepository<MemoryCard, Long> {

    public List<MemoryCard> findByMiddleCategory(Long id);
}
