CREATE TABLE IF NOT EXISTS `socialhub`.`twitter_data`
(
    `twitter_data_id` INT         NOT NULL AUTO_INCREMENT,
    `follower_count`  INT         NULL DEFAULT NULL,
    `twitter_handle`  VARCHAR(45) NULL DEFAULT NULL,
    `user_id`         INT         NOT NULL,
    PRIMARY KEY (`twitter_data_id`, `user_id`),
    INDEX `fk_twitter_data_user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_twitter_data_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `socialhub`.`user_table` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
