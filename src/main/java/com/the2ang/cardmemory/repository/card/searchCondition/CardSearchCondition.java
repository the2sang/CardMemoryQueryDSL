package com.the2ang.cardmemory.repository.card.searchCondition;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CardSearchCondition {
    private String question;
    private String cardId;
    private String completed;
    private String questionType;
    private String middleCategoryId;
    private String level;
    private String learningCount;
    private Integer page;
    private Integer size;

//    @Builder
//    public CardSearchCondition(String question, String questionType, String cardId, String completed, String middleCategoryId,
//                               String level, String learningCount, Integer page, Integer size) {
//        this.question = question;
//        this.questionType = questionType;
//        this.cardId = cardId;
//        this.completed = completed;
//        this.middleCategoryId = middleCategoryId;
//        this.level = level;
//        this.learningCount = learningCount;
//        this.page = page;
//        this.size = size;
//    }



}
