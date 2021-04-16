CREATE TABLE IF NOT EXISTS `socialhub`.`one_post_posted_to` (
  `one_post_posted_to_is` INT NOT NULL,
  `social_media` VARCHAR(45) NULL DEFAULT NULL,
  `one_post_posted_to_fk_user_id` INT NOT NULL,
  PRIMARY KEY (`one_post_posted_to_is`),
  INDEX `one_post_posted_to_fk_idx` (`one_post_posted_to_fk_user_id` ASC) VISIBLE,
  CONSTRAINT `one_post_posted_to_fk`
    FOREIGN KEY (`one_post_posted_to_fk_user_id`)
    REFERENCES `socialhub`.`user_table` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
