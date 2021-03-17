CREATE TABLE IF NOT EXISTS `socialhub`.`goals`
(
    `goals_id`                INT      NOT NULL AUTO_INCREMENT,
    `total_twitter_followers` INT      NULL DEFAULT NULL,
    `goal_end_number`         INT      NULL DEFAULT NULL,
    `start_date`              DATETIME NULL DEFAULT NULL,
    `goal_start_number`       INT      NULL DEFAULT NULL,
    `user_id`                 INT      NOT NULL,
    PRIMARY KEY (`goals_id`),
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
    INDEX `goals_fk_user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `goals_fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `socialhub`.`user_table` (`user_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
