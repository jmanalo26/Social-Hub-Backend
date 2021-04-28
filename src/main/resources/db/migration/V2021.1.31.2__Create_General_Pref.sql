CREATE TABLE IF NOT EXISTS `socialhub`.`general_preferences`
(
    `general_preferences_id` INT         NOT NULL AUTO_INCREMENT,
    `twitter_feed`           TINYINT(1)  NULL DEFAULT NULL,
    `instagram_feed`         TINYINT(1)  NULL DEFAULT NULL,
    `facebook_feed`          TINYINT(1)  NULL DEFAULT NULL,
    `user_id`                INT         NOT NULL,
    `on_login`               VARCHAR(45) NULL,
    PRIMARY KEY (`general_preferences_id`),
    INDEX `fk_user_id_idx` (`user_id` ASC) VISIBLE,
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_id_preferences`
        FOREIGN KEY (`user_id`)
            REFERENCES `socialhub`.`user_table` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
