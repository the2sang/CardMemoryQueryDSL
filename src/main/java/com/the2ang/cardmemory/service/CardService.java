package com.the2ang.cardmemory.service;

import com.the2ang.cardmemory.entity.card.MainCategory;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import com.the2ang.cardmemory.entity.card.MiddleCategory;
import com.the2ang.cardmemory.repository.card.MainCategoryRepository;
import com.the2ang.cardmemory.repository.card.MemoryCardRepository;
import com.the2ang.cardmemory.repository.card.MiddleCategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    @Autowired
    private MiddleCategoryRepository middleCategoryRepository;

    @Autowired
    private MemoryCardRepository memoryCardRepository;

    // 카드 대분류 저장.
    @Transactional
    public MainCategory saveMainCategory(MainCategory mainCategory) {
        return mainCategoryRepository.save(mainCategory);
    }

    // 카드 대분류 삭제
    @Transactional
    public void deleteMainCategory(Integer id) {
        mainCategoryRepository.deleteById(id);
    }

    // 대분류 이름으로 검색
    @Transactional(readOnly = true)
    public List<MainCategory> findMainCategoryByname(String name) {
        return mainCategoryRepository.findByName(name);
    }

    // 중분류 저장
    @Transactional
    public MiddleCategory saveMiddleCategory(MiddleCategory middleCategory) {
        return middleCategoryRepository.save(middleCategory);
    }

    // 중분류 삭제
    @Transactional
    public void deleteMiddleCategory(Integer id) {
        middleCategoryRepository.deleteById(id);
    }

    // 대분류 코드로 중분류 검색하기
    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByMainCategoryId(Integer ref) {
        return middleCategoryRepository.findByMainCategory(ref);
    }

    // 중분류명으로 검색하기
    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByName(String name) {
        return middleCategoryRepository.findByName(name);
    }

    // 카드 문제 중분류 코드로 검색하기
    @Transactional(readOnly = true)
    public List<MemoryCard> findMemoryCardByMiddleCategory(Integer ref) {
        return memoryCardRepository.findByMiddleCategory(ref);
    }

    // 카드 문제 저장하기
    @Transactional
    public MemoryCard saveMemoryCard(MemoryCard memoryCard) {
        return memoryCardRepository.save(memoryCard);
    }


    // 카드 질문명으로 검색하기
    @Transactional(readOnly = true)
    public List<MemoryCard> findMemoryCardByQuestion_dsl(String question) {
        return memoryCardRepository.findByQuestion_dsl2(question);
    }

}
