CREATE TABLE `nutricionista`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `inicio_programa` DATE,
    `fim_programa` DATE
);
