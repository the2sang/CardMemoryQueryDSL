package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.repository.BaseRepository;

import java.util.List;

public interface MainCategoryRepository extends BaseRepository<MainCategory, Integer> {

    public List<MainCategory> findByName(String name);

    public MainCategory getMainCategoryByKey(Integer id);
}
