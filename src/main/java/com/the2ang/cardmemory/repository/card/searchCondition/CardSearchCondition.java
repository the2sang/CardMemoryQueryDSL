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


}
