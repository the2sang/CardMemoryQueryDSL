package com.the2ang.cardmemory.entity.card;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRefreshToken is a Querydsl query type for RefreshToken
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRefreshToken extends EntityPathBase<RefreshToken> {

    private static final long serialVersionUID = 307484684L;

    public static final QRefreshToken refreshToken1 = new QRefreshToken("refreshToken1");

    public final StringPath accessToken = createString("accessToken");

    public final StringPath accessTokenExpireDate = createString("accessTokenExpireDate");

    public final NumberPath<Long> accessTokenExpireTime = createNumber("accessTokenExpireTime", Long.class);

    public final StringPath email = createString("email");

    public final StringPath grantType = createString("grantType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath refreshToken = createString("refreshToken");

    public QRefreshToken(String variable) {
        super(RefreshToken.class, forVariable(variable));
    }

    public QRefreshToken(Path<? extends RefreshToken> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRefreshToken(PathMetadata metadata) {
        super(RefreshToken.class, metadata);
    }

}

