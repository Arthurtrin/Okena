create table report (
    id bigint not null auto_increment,
    texto varchar(1200) not null,
    bairro varchar(100) not null,
    categoria varchar(100) not null,
    data timestamp not null,
    usuario_id bigint,

    primary key(id),
    foreign key(usuario_id)
        references usuarios(id)
        on delete set null
);