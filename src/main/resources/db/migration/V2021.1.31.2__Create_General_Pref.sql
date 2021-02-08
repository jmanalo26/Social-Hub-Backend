
CREATE TABLE IF NOT EXISTS `socialhub`.`general_preferences`
(
    `general_preferences_id` INT        NOT NULL AUTO_INCREMENT,
    `twitter_feed`           TINYINT(1) NULL DEFAULT NULL,
    `instagram_feed`         TINYINT(1) NULL DEFAULT NULL,
    `facebook_feed`          TINYINT(1) NULL DEFAULT NULL,
    PRIMARY KEY (`general_preferences_id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
