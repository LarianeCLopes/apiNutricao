CREATE TABLE `nutricionista`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `inicio_programa` VARCHAR(15),
    `fim_programa` VARCHAR(15)
);