package com.the2ang.cardmemory.repository.card;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.BaseRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.MiddleCategorySearchCondition;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MiddleCategoryRepository extends BaseRepository<MiddleCategory, Integer> {

    public List<MiddleCategory> findByName(String name);

    public List<MiddleCategory> findByMainCategory(Integer id);

    public List<MiddleCategory> findAllMiddleCategoryFetchJoin();

    public List<MiddleCategory> findByMainCategorySearch(MiddleCategorySearchCondition condition);


}
