create table player
(
    id int auto_increment,
    name varchar(20) not null,
    constraint player_pk
        primary key (id)
);

create index id_name
    on player (name);
