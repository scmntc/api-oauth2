CREATE TABLE pessoa (
	codigo_pessoa BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO PESSOA (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
VALUES ('Lucas Correia', 'Avenida Brasil Argentina', 1000, 'Perto do Posto', 'Centro', '85.520-000', 'Vitorino', 'PR', true)