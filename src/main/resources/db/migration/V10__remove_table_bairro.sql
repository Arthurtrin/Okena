ALTER TABLE usuarios
DROP FOREIGN KEY fk_usuarios_bairro;

ALTER TABLE usuarios
DROP COLUMN bairro_id;

ALTER TABLE report
DROP FOREIGN KEY fk_report_bairro;

ALTER TABLE report
DROP COLUMN bairro_id;

DROP TABLE bairro;