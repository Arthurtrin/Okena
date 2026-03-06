create table usuarios(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    nomeDeUsuario varchar(50) not null unique,
    email varchar(100) not null unique,
    bairro varchar(100) not null,
    cpf varchar(14) not null unique,
    senha varchar(10) not null unique,

    primary key(id)
)

