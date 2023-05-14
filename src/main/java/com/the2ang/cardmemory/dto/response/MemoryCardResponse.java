package com.the2ang.cardmemory.dto.response;

import com.the2ang.cardmemory.dto.MiddleCategoryDto;
import com.the2ang.cardmemory.entity.card.MemoryCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoryCardResponse {

    private Integer id;
    private String questionType;
    private String question;
    private String explanation;
    private String num1;
    private String num2;
    private String num3;
    private String num4;
    private String rightAnswer;
    private Integer rightAnswerNum;
    private Integer learningCount;
    private Integer level;
    private Integer completed;
    private Integer middleCategoryId;
    private Integer page;
    private Integer size;

    public MemoryCardResponse(MemoryCard memoryCard) {
        this.id = memoryCard.getId();
        this.questionType = memoryCard.getQuestionType();
        this.question = memoryCard.getQuestion();
        this.explanation = memoryCard.getExplanation();
        this.num1 = memoryCard.getNum1();
        this.num2 = memoryCard.getNum2();
        this.num3 = memoryCard.getNum3();
        this.num4 = memoryCard.getNum4();
        this.rightAnswer = memoryCard.getRightAnswer();
        this.rightAnswerNum = memoryCard.getRightAnswerNum();
        this.learningCount = memoryCard.getLearningCount();
        this.level = memoryCard.getLevel();
        this.completed = memoryCard.getCompleted();
        this.middleCategoryId = memoryCard.getMiddleCategory().getId();
    }

}
