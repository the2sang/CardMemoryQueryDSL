package com.the2ang.cardmemory.repository.card.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.searchCondition.CardSearchCondition;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.*;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

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

    @Override
    public List<MemoryCard> findByMiddleCategoryFechJoin(Integer id) {
       return jpaQueryFactory.selectFrom(memoryCard)
               .join(memoryCard.middleCategory, middleCategory).fetchJoin()
               .where(memoryCard.middleCategory.id.eq(id))
               .orderBy(memoryCard.id.asc())
               .fetch();
    }

    @Override
    public Slice<MemoryCard> searchBySlice(Long lastCardId, CardSearchCondition condition, Pageable pageable) {
        List<MemoryCard> results = jpaQueryFactory.selectFrom(memoryCard)
                .join(memoryCard.middleCategory, middleCategory).fetchJoin()
                .where(
                    ltCardId(lastCardId),

                    //기타 조건
                    questionLike(condition.getQuestion()),
                    questionTypeEq(condition.getQuestionType())
                )
                .orderBy(memoryCard.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();

        return checkLastPage(pageable, results);
    }

    @Override
    public Page<MemoryCard> searchMemoryCardPage(CardSearchCondition condition, Pageable pageable) {

       List<MemoryCard> content = getMemoryCardPage(condition, pageable);

       //Long count = getMemoryCardPageCount(condition);
        JPAQuery<Long> countQuery = getMemoryCardPageOptCount(condition);

        return PageableExecutionUtils.getPage(content, pageable, ()-> countQuery.fetchOne());
        //return new PageImpl<>(content, pageable, count);
    }


    private List<MemoryCard> getMemoryCardPage(CardSearchCondition condition, Pageable pageable) {
        List<MemoryCard> content = jpaQueryFactory.selectFrom(memoryCard)
                .join(memoryCard.middleCategory, middleCategory).fetchJoin()
                .where(
                        middleCategoryEq(condition.getMiddleCategoryId()),
                        questionLike(condition.getQuestion()),
                        questionTypeEq(condition.getQuestionType()),
                        mainCategoryEq(condition.getMainCategorId())
                )
                .orderBy(memoryCard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return content;
    }

//    private Long getMemoryCardPageCount(CardSearchCondition condition) {
//       Long count = jpaQueryFactory
//               .select(memoryCard.count())
//               .from(memoryCard)
//               .where(
//                       questionLike(condition.getQuestion()),
//                       questionTypeEq(condition.getQuestionType())
//               )
//               .fetchOne();
//       return count;
//    }

    //count 최적화 - 마지막 페이지일 경우 카운트 하지 않음
    private JPAQuery<Long> getMemoryCardPageOptCount(CardSearchCondition condition) {
        JPAQuery<Long> countQuery = jpaQueryFactory
                .select(memoryCard.count())
                .from(memoryCard)
                .where(
                        middleCategoryEq(condition.getMiddleCategoryId()),
                        questionLike(condition.getQuestion()),
                        questionTypeEq(condition.getQuestionType()),
                        mainCategoryEq(condition.getMainCategorId())
                );
        return countQuery;
    }


    private Slice<MemoryCard> checkLastPage(Pageable pageable, List<MemoryCard> results) {
        boolean hasNext = false;

        if (results.size() > pageable.getPageSize()) {
            hasNext = true;
            results.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(results, pageable, hasNext);
    }


    private BooleanExpression ltCardId(Long cardId) {
        if (cardId == null) {
            return null;
        }

        return memoryCard.id.lt(cardId);
    }

    private BooleanExpression questionLike(String question) {
        return StringUtils.hasText(question) ? memoryCard.question.like(question) : null;
    }

    private BooleanExpression questionTypeEq(String questionType) {
        return StringUtils.hasText(questionType) ? memoryCard.questionType.eq(questionType) : null;
    }

    private BooleanExpression mainCategoryEq(String mainCategoryId ) {
        return mainCategoryId != null ? memoryCard.middleCategory.mainCategory.id.eq(Integer.valueOf(mainCategoryId)) : null;
    }

    private BooleanExpression middleCategoryEq(String middleCategoryId) {
        return middleCategoryId != null ? memoryCard.middleCategory.id.eq(Integer.valueOf(middleCategoryId)) : null;
    }




}
