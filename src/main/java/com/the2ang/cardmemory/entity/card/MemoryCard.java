package com.the2ang.cardmemory.entity.card;

import jakarta.persistence.*;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middle_category_id")
    private MiddleCategory middleCategory;

    @Column(nullable = false, length = 2 )
    @ColumnDefault("'MC'")
    private String questionType;

    @Column(length = 500, nullable = false)
    private String question;

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
    private Short rigntAnswerNum;

    @Column(length = 2)
    @ColumnDefault("0")
    private Short learningCount;

    @Column(length = 2)
    @ColumnDefault("1")
    private Short level;

    @Column(length = 2)
    @ColumnDefault("0")
    private Short completed;

    @Builder
    public MemoryCard(Long id, MiddleCategory middleCategory, String questionType, String question, String num1, String num2, String num3,
                            String num4, String rightAnswer, Short learningCount, Short level, Short completed) {
        this.id = id;
        this.middleCategory = middleCategory;
        this.questionType = questionType;
        this.question = question;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.rightAnswer = rightAnswer;
        this.learningCount = learningCount;
        this.level = level;
        this.completed = completed;
    }


}
