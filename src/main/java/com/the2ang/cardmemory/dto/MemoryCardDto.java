package com.the2ang.cardmemory.dto;

import com.the2ang.cardmemory.entity.card.MemoryCard;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class MemoryCardDto {

    private final Integer id;
    private final MiddleCategoryDto middleCategoryDto;
    private final String questionType;
    private final String question;
    private final String explanation;
    private final String num1;
    private final String num2;
    private final String num3;
    private final String num4;
    private final String rightAnswer;
    private final Integer rightAnswerNum;
    private final Integer learningCount;
    private final Integer level;
    private final Integer completed;

    @Builder
    public MemoryCardDto(Integer id, MiddleCategoryDto middleCategoryDto, String questionType, String question,
                         String explanation, String num1, String num2, String num3,
                         String num4, String rightAnswer, Integer rightAnswerNum, Integer learningCount, Integer level, Integer completed) {
        this.id = id;
        this.middleCategoryDto = middleCategoryDto;
        this.questionType = questionType;
        this.question = question;
        this.explanation = explanation;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.rightAnswer = rightAnswer;
        this.rightAnswerNum = rightAnswerNum;
        this.learningCount = learningCount;
        this.level = level;
        this.completed = completed;
    }

    public MemoryCard toEntity() {
        return MemoryCard.builder()
                .id(id)
                .middleCategory(middleCategoryDto.toEntity())
                .questionType(questionType)
                .question(question)
                .explanation(explanation)
                .num1(num1)
                .num2(num2)
                .num3(num3)
                .num4(num4)
                .rightAnswer(rightAnswer)
                .rightAnswerNum(rightAnswerNum)
                .learningCount(learningCount)
                .level(level)
                .completed(completed)
                .build();
    }
}
