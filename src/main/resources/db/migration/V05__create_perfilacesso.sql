CREATE TABLE IF NOT EXISTS perfilacesso (
	id BIGINT(20) auto_increment NOT NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT perfilacesso_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
