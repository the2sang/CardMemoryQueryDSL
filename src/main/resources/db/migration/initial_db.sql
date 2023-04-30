create table public.flyway_schema_history
(
    installed_rank integer                 not null
        constraint flyway_schema_history_pk
            primary key,
    version        varchar(50),
    description    varchar(200)            not null,
    type           varchar(20)             not null,
    script         varchar(1000)           not null,
    checksum       integer,
    installed_by   varchar(100)            not null,
    installed_on   timestamp default now() not null,
    execution_time integer                 not null,
    success        boolean                 not null
);

alter table public.flyway_schema_history
    owner to carduser;

create index flyway_schema_history_s_idx
    on public.flyway_schema_history (success);

create table public.main_category
(
    id         bigint       not null
        primary key,
    created_at timestamp(6),
    updated_at timestamp(6),
    name       varchar(100) not null
);

alter table public.main_category
    owner to carduser;

create table public.middle_category
(
    id                      bigint       not null
        primary key,
    created_at              timestamp(6),
    updated_at              timestamp(6),
    name                    varchar(100) not null,
    main_category_entity_id bigint
        constraint fk9hypb3q5nj5s5isbiulhcq8f9
            references public.main_category
);

alter table public.middle_category
    owner to carduser;

create table public.memory_card
(
    id                        bigint                                     not null
        primary key,
    created_at                timestamp(6),
    updated_at                timestamp(6),
    completed                 smallint   default 0,
    learning_count            smallint   default 0,
    level                     smallint   default 1,
    num1                      varchar(300),
    num2                      varchar(300),
    num3                      varchar(300),
    num4                      varchar(300),
    question                  varchar(500)                               not null,
    question_type             varchar(2) default 'MC'::character varying not null,
    right_answer              varchar(300),
    rignt_answer_num          smallint,
    middle_category_entity_id bigint
        constraint fk4lshp3l7lnnsjknxl42m7iyhu
            references public.middle_category
);

alter table public.memory_card
    owner to carduser;



create sequence public.main_category_seq
    increment by 50;

alter sequence public.main_category_seq owner to carduser;

create sequence public.memory_card_seq
    increment by 50;

alter sequence public.memory_card_seq owner to carduser;

create sequence public.middle_category_seq
    increment by 50;

alter sequence public.middle_category_seq owner to carduser;
