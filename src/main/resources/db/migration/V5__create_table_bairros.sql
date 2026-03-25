create table bairro(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    latitude decimal(9,6),
    longitude decimal(9,6),

    primary key(id)
)

