package com.the2ang.cardmemory.entity.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class MemoryCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middle_category_id")
    @JsonIgnore
    private MiddleCategory middleCategory;

    @Column(columnDefinition = "varchar(2) default 'MC'")
    private String questionType;

    @Column(length = 500, nullable = false)
    private String question;

    // 질문 설명 추가
    @Column(length = 500)
    private String explanation;

    @Column(length = 300)
    private String num1;

    @Column(length = 300)
    private String num2;

    @Column(length = 300)
    private String num3;

    @Column(length = 300)
    private String num4;

    @Column(length = 300)
    private String rightAnswer;

    @Column(length = 2)
    private Integer rightAnswerNum;

    @Column(length = 2)
    @ColumnDefault("0")
    private Integer learningCount;

    @Column(length = 2)
    @ColumnDefault("1")
    private Integer level;

    @Column(length = 2)
    @ColumnDefault("0")
    private Integer completed;

    @Builder
    public MemoryCard(Integer id, MiddleCategory middleCategory, String questionType, String question, String explanation, String num1, String num2, String num3,
                            String num4, String rightAnswer, Integer rightAnswerNum, Integer learningCount, Integer level, Integer completed) {
        this.id = id;
        this.middleCategory = middleCategory;
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


}
