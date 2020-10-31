INSERT INTO usuario
(idusuario, nome, email, password)
VALUES(1, 'Otavio Soares', 'tavinq@hotmail.com', '$2a$10$Jdfs4LkarGUsxV5fGESfX.KLzBi0yW2Z5akx3YShEZ7VomXK/DnZS')
ON DUPLICATE KEY UPDATE nome = "Otavio Soares";
