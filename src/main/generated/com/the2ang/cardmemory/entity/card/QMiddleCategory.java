package com.the2ang.cardmemory.entity.card;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMiddleCategory is a Querydsl query type for MiddleCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMiddleCategory extends EntityPathBase<MiddleCategory> {

    private static final long serialVersionUID = 808342113L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMiddleCategory middleCategory = new QMiddleCategory("middleCategory");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QMainCategory mainCategory;

    public final ListPath<MemoryCard, QMemoryCard> memoryCardList = this.<MemoryCard, QMemoryCard>createList("memoryCardList", MemoryCard.class, QMemoryCard.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMiddleCategory(String variable) {
        this(MiddleCategory.class, forVariable(variable), INITS);
    }

    public QMiddleCategory(Path<? extends MiddleCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMiddleCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMiddleCategory(PathMetadata metadata, PathInits inits) {
        this(MiddleCategory.class, metadata, inits);
    }

    public QMiddleCategory(Class<? extends MiddleCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mainCategory = inits.isInitialized("mainCategory") ? new QMainCategory(forProperty("mainCategory")) : null;
    }

}

