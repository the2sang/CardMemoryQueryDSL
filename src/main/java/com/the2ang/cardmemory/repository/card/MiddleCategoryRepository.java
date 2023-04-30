package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.BaseRepository;

import java.util.List;

public interface MiddleCategoryRepository extends BaseRepository<MiddleCategory, Long> {

    public List<MiddleCategory> findByName(String name);

    public List<MiddleCategory> findByMainCategory(Long id);


}
