create table book
(
    id                 int          not null
        primary key,
    author             varchar(255) not null,
    created_by         varchar(255) null,
    created_date       datetime(6)  null,
    last_modified_by   varchar(255) null,
    last_modified_date datetime(6)  null,
    price              double       not null,
    quantity           int          not null,
    title              varchar(255) not null,
    version            int          not null
);

create table hibernate_sequence
(
    next_val bigint null
);

create table transaction
(
    id               bigint auto_increment
        primary key,
    comment          longtext       null,
    discount         decimal(19, 2) null,
    price            decimal(19, 2) not null,
    transaction_date datetime(6)    not null,
    book_id          int            not null,
    constraint fk_transaction_book_id
        foreign key (book_id) references book (id)
);

