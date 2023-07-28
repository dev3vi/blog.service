CREATE TABLE `my-blog`.`users` (
                                   `username` VARCHAR(45) NOT NULL,
                                   `password` VARCHAR(255) NOT NULL,
                                   `role_id` VARCHAR(255) NOT NULL,
                                   `full_name` VARCHAR(100) NOT NULL,
                                   `email` VARCHAR(45) NULL,
                                   `token` VARCHAR(45) NULL,
                                   `is_activated` VARCHAR(45) NULL,
                                   `created_at` VARCHAR(45) NULL,
                                   `update_at` VARCHAR(45) NULL,
                                   PRIMARY KEY (`username`)
                                )ENGINE = INNODB
								 DEFAULT CHARSET = utf8mb4;