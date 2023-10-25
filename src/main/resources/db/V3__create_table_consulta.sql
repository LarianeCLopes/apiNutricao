CREATE TABLE `consulta` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `data_consulta` DATE,
    `observacao` TEXT,
    `nutricionista_id` BIGINT NOT NULL,
    `usuario_id` BIGINT NOT NULL,
    FOREIGN KEY (`nutricionista_id`) REFERENCES `nutricionista`(`id`),
    FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`)
);