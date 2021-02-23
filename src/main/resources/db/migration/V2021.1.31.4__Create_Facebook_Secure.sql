CREATE TABLE `facebook_secure`
(
    `facebook_ID`          int unsigned NOT NULL,
    `facebook_name`        varchar(45)  NOT NULL,
    `facebook_accessToken` varchar(45)  NOT NULL,
    `facebook_email`       varchar(45)  NOT NULL,
    `facebook_birthday`    varchar(45)  NOT NULL,
    PRIMARY KEY (`facebook_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
