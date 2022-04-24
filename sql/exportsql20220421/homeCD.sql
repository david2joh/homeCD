-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema homecd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `homecd`;

-- -----------------------------------------------------
-- Schema homecd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `homecd` DEFAULT CHARACTER SET utf8;
USE `homecd`;

-- -----------------------------------------------------
-- Table `homecd`.`locations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`locations`;

CREATE TABLE IF NOT EXISTS `homecd`.`locations`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `location_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 37
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `homecd`.`cds`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`cds`;

CREATE TABLE IF NOT EXISTS `homecd`.`cds`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `label`          VARCHAR(45) NOT NULL,
    `catalog_number` VARCHAR(45) NOT NULL,
    `location_id`    INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_cd_location1_idx` (`location_id` ASC) VISIBLE,
    CONSTRAINT `fk_location_cd1`
        FOREIGN KEY (`location_id`)
            REFERENCES `homecd`.`locations` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 19
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `homecd`.`composers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`composers`;

CREATE TABLE IF NOT EXISTS `homecd`.`composers`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `composer_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 25
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `homecd`.`performances`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`performances`;

CREATE TABLE IF NOT EXISTS `homecd`.`performances`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `cd_id`       INT         NOT NULL,
    `composer_id` INT         NOT NULL,
    `performance` VARCHAR(45) NULL DEFAULT NULL,
    `artist`      VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_performance_cd1_idx` (`cd_id` ASC) VISIBLE,
    INDEX `fk_performance_composer1_idx` (`composer_id` ASC) VISIBLE,
    CONSTRAINT `fk_performance_cd1`
        FOREIGN KEY (`cd_id`)
            REFERENCES `homecd`.`cds` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_performance_composer1`
        FOREIGN KEY (`composer_id`)
            REFERENCES `homecd`.`composers` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 22
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `homecd`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`users`;

CREATE TABLE IF NOT EXISTS `homecd`.`users`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `user_name`  VARCHAR(16)  NOT NULL,
    `password`   VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(30)  NOT NULL,
    `last_name`  VARCHAR(30)  NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 17
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `homecd`.`user_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `homecd`.`user_roles`;

CREATE TABLE IF NOT EXISTS `homecd`.`user_roles`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `user_id`   INT         NOT NULL,
    `user_role` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_user_role_user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `FK_user_role_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `homecd`.`users` (`id`)
            ON DELETE CASCADE
            ON UPDATE RESTRICT
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 14
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
