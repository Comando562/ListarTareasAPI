
CREATE TABLE `tareas_api`.`tarea`
(
    id          BIGINT       not null AUTO_INCREMENT,
    titulo      VARCHAR(255) not null,
    descripcion VARCHAR(255) not null,
    Fecha       DATE         not null,
    completado  TINYINT(1),
    PRIMARY KEY (id)
) ENGINE = InnoDB;