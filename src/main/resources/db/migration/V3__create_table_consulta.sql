CREATE TABLE `consulta` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `agendamento` VARCHAR(30),
    `nutricionista_id` BIGINT NOT NULL,
    `usuario_id` BIGINT NOT NULL,
    FOREIGN KEY (`nutricionista_id`) REFERENCES `nutricionista`(`id`),
    FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`)
);