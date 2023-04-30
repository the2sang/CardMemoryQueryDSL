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

    @Transactional
    public MainCategory saveMainCategory(MainCategory mainCategory) {
        return mainCategoryRepository.save(mainCategory);
    }

    @Transactional
    public void deleteMainCategory(Integer id) {
        mainCategoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MainCategory> findMainCategoryByname(String name) {
        return mainCategoryRepository.findByName(name);
    }

    @Transactional
    public MiddleCategory saveMiddleCategory(MiddleCategory middleCategory) {
        return middleCategoryRepository.save(middleCategory);
    }

    @Transactional
    public void deleteMiddleCategory(Integer id) {
        middleCategoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByMain(Integer ref) {
        return middleCategoryRepository.findByMainCategory(ref);
    }

    @Transactional(readOnly = true)
    public List<MiddleCategory> findMiddleCategoryByname(String name) {
        return middleCategoryRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<MemoryCard> findMemoryCardByMiddleCategory(Integer ref) {
        return memoryCardRepository.findByMiddleCategory(ref);
    }

    @Transactional
    public MemoryCard saveMemoryCard(MemoryCard memoryCard) {
        return memoryCardRepository.save(memoryCard);
    }


}
