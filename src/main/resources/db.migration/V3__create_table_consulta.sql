CREATE TABLE `consulta` (
                           `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           `agendamento` varchar(255) NOT NULL,
                           `usuario_id` bigint NOT NULL,
                           `nutricionista_id` bigint NOT NULL,
                           FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
                           FOREIGN KEY (`nutricionista_id`) REFERENCES `nutricionista` (`id`)
);