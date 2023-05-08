package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.BaseRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.CardSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface MemoryCardRepository extends BaseRepository<MemoryCard, Integer> {

    public List<MemoryCard> findByMiddleCategory(Integer id);

    public List<MemoryCard> findByMiddleCategoryFechJoin(Integer id);

    public List<MemoryCard> findByQuestion_dsl(String question);

    public List<MemoryCard> findByQuestion_dsl2(String question);

    public Slice<MemoryCard> searchBySlice(Long lastCardId, CardSearchCondition condition, Pageable pageable);

    public Page<MemoryCard> searchMemoryCardPage(CardSearchCondition condition, Pageable pageable);


}
