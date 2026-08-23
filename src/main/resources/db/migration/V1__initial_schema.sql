CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          nome_de_usuario VARCHAR(255) NOT NULL UNIQUE,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          cpf VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
);

CREATE TABLE report (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        usuario_id BIGINT,
                        anonimo BOOLEAN NOT NULL,
                        texto VARCHAR(255),
                        latitude DOUBLE,
                        longitude DOUBLE,
                        estado VARCHAR(255),
                        cidade VARCHAR(255),
                        bairro VARCHAR(255),
                        logradouro VARCHAR(255),
                        categoria VARCHAR(255),
                        data DATETIME,

                        CONSTRAINT fk_report_usuario
                            FOREIGN KEY (usuario_id)
                                REFERENCES usuarios(id)
);

