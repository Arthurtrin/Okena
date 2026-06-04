ALTER TABLE usuarios
    ADD CONSTRAINT fk_usuarios_bairro
        FOREIGN KEY (bairro_id)
            REFERENCES bairro(id)
            ON DELETE SET NULL;

ALTER TABLE usuarios
DROP COLUMN bairro;