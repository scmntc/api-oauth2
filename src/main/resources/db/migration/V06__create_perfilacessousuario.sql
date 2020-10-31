CREATE TABLE IF NOT EXISTS perfilacessousuario (
	id BIGINT(20) auto_increment NOT NULL,
	idusuario BIGINT(20) NOT NULL,
	idperfilacesso BIGINT(20) NOT NULL,
	CONSTRAINT perfilacessousuario_PK PRIMARY KEY (id),
	CONSTRAINT fk_perfilacessousuario_usuario FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
	CONSTRAINT fk_perfilacessousuario_perfilacesso FOREIGN KEY (id) REFERENCES perfilacesso(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
