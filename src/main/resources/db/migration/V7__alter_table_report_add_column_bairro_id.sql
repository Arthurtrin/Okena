ALTER TABLE report
    ADD COLUMN bairro_id BIGINT;

ALTER TABLE report
    ADD CONSTRAINT fk_report_bairro
        FOREIGN KEY (bairro_id)
            REFERENCES bairro(id)
            ON DELETE SET NULL;

ALTER TABLE report
DROP COLUMN bairro;