CREATE TABLE funcionario (
     id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
     nome VARCHAR(30) NOT NULL,
     sobrenome VARCHAR(50) NOT NULL,
     email VARCHAR(30) NOT NULL,
     pis VARCHAR(11) NOT NULL,
     data_cadastro date NOT NULL
);

INSERT INTO funcionario (nome, sobrenome, email, pis, data_cadastro) values ('William', 'Silva', 'william@gmail.com', '27731439785', '2020-05-15');
INSERT INTO funcionario (nome, sobrenome, email, pis, data_cadastro) values ('Fernanda', 'dos Santos', 'fernanda@gmail.com', '45225051575', '2021-04-18');
INSERT INTO funcionario (nome, sobrenome, email, pis, data_cadastro) values ('Juliane', 'Sousa', 'juliana@homail.com', '97946455719', '2021-01-25');
INSERT INTO funcionario (nome, sobrenome, email, pis, data_cadastro) values ('Marcelo', 'Ribeiro', 'marcelo@gmail.com', '19858125081', '2020-03-08');
INSERT INTO funcionario (nome, sobrenome, email, pis, data_cadastro) values ('Marcos', 'de souza', 'marcos@homail.com', '13511101149', '2021-02-27');
