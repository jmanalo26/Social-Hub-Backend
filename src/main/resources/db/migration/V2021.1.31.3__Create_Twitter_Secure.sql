CREATE TABLE IF NOT EXISTS `socialhub`.`twitter_secure`
(
    `twitter_secure_id`   INT         NOT NULL AUTO_INCREMENT,
    `api_key`             VARCHAR(90) NOT NULL,
    `api_secret_key`      VARCHAR(90) NOT NULL,
    `access_token`        VARCHAR(90) NOT NULL,
    `access_token_secret` VARCHAR(90) NOT NULL,
    `twitter_handle`      VARCHAR(45) NOT NULL,
    `user_id`             INT         NOT NULL,
    PRIMARY KEY (`twitter_secure_id`),
    UNIQUE INDEX `api_key_UNIQUE` (`api_key` ASC) VISIBLE,
    UNIQUE INDEX `api_secret_key_UNIQUE` (`api_secret_key` ASC) VISIBLE,
    UNIQUE INDEX `access_token_UNIQUE` (`access_token` ASC) VISIBLE,
    UNIQUE INDEX `access_token_secret_UNIQUE` (`access_token_secret` ASC) VISIBLE,
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_id_secure`
        FOREIGN KEY (`user_id`)
            REFERENCES `socialhub`.`user_table` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
