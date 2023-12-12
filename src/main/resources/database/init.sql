CREATE TABLE `my-blog`.`users`
(
    `username`     VARCHAR(45)  NOT NULL,
    `password`     VARCHAR(255) NOT NULL,
    `role_id`      VARCHAR(255) NOT NULL,
    `full_name`    VARCHAR(100) NOT NULL,
    `email`        VARCHAR(45) NULL,
    `token`        VARCHAR(45) NULL,
    `is_activated` VARCHAR(45) NULL,
    `created_at`   VARCHAR(45) NULL,
    `update_at`    VARCHAR(45) NULL,
    PRIMARY KEY (`username`)
)ENGINE = INNODB
DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`
(
    `id`        int          NOT NULL,
    `role_code` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `thaolv-blog`.roles (id, role_code)
VALUES (1, 'DEV'),
       (2, 'ADMIN'),
       (3, 'USER');

CREATE TABLE `thaolv-blog`.log_info
(
    id      INT auto_increment NOT NULL,
    `time`  varchar(100) NOT NULL,
    ip      varchar(100) NOT NULL,
    info_device varchar(100) NOT NULL,
    CONSTRAINT log_info_PK PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
