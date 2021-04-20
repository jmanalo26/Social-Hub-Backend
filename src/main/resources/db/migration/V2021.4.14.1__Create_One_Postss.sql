CREATE TABLE IF NOT EXISTS `socialhub`.`one_posts` (
  `one_posts_id` INT NOT NULL AUTO_INCREMENT,
  `text_content` VARCHAR(600) NULL DEFAULT NULL,
  `image` BLOB NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  `social_media` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`one_posts_id`),
  INDEX `fk_user_id_one_posts_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id_one_posts`
    FOREIGN KEY (`user_id`)
    REFERENCES `socialhub`.`user_table` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
