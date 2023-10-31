CREATE TABLE `nutricionista` (
                           `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           `nome` varchar(255) NOT NULL,
                           `inicio_programa` varchar(255) DEFAULT NULL,
                           `fim_programa` varchar(255) DEFAULT NULL
);