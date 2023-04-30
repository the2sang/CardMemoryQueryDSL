package com.the2ang.cardmemory.entity.card;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemoryCard is a Querydsl query type for MemoryCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemoryCard extends EntityPathBase<MemoryCard> {

    private static final long serialVersionUID = 670992223L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemoryCard memoryCard = new QMemoryCard("memoryCard");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Short> completed = createNumber("completed", Short.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Short> learningCount = createNumber("learningCount", Short.class);

    public final NumberPath<Short> level = createNumber("level", Short.class);

    public final QMiddleCategory middleCategory;

    public final StringPath num1 = createString("num1");

    public final StringPath num2 = createString("num2");

    public final StringPath num3 = createString("num3");

    public final StringPath num4 = createString("num4");

    public final StringPath question = createString("question");

    public final StringPath questionType = createString("questionType");

    public final StringPath rightAnswer = createString("rightAnswer");

    public final NumberPath<Short> rigntAnswerNum = createNumber("rigntAnswerNum", Short.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemoryCard(String variable) {
        this(MemoryCard.class, forVariable(variable), INITS);
    }

    public QMemoryCard(Path<? extends MemoryCard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemoryCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemoryCard(PathMetadata metadata, PathInits inits) {
        this(MemoryCard.class, metadata, inits);
    }

    public QMemoryCard(Class<? extends MemoryCard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.middleCategory = inits.isInitialized("middleCategory") ? new QMiddleCategory(forProperty("middleCategory"), inits.get("middleCategory")) : null;
    }

}

