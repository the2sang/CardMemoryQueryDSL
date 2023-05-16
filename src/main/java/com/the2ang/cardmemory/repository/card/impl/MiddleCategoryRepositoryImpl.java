package com.the2ang.cardmemory.repository.card.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.MiddleCategorySearchCondition;
import jakarta.persistence.EntityManager;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.util.StringUtils;

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
                .join(middleCategory.mainCategory, mainCategory).fetchJoin()
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

    @Override
    public List<MiddleCategory> findByMainCategorySearch(MiddleCategorySearchCondition condition) {
        List<MiddleCategory> content = jpaQueryFactory.selectFrom(middleCategory)
                .join(middleCategory.mainCategory, mainCategory).fetchJoin()
                .where(
                        idEq(condition.getId()),
                        nameLike(condition.getName())
                )
                .orderBy(middleCategory.id.asc())
                .fetch();

        return content;
    }

    private BooleanExpression idEq(Integer id) {
        return id != null ? middleCategory.mainCategory.id.eq(id) : null;
    }

    private BooleanExpression nameLike(String name) {
        return StringUtils.hasText(name) ? middleCategory.name.like("%" + name + "%") : null;
    }

    @Override
    public MiddleCategory getMiddleCategoryByKey(Integer id) {
        return jpaQueryFactory.selectFrom(middleCategory)
                .where(middleCategory.id.eq(id)).fetchOne();
    }




}
