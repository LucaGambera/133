-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`T_Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`T_Users` (
  `PK_Users` INT NOT NULL AUTO_INCREMENT,
  `Password` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PK_Users`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`T_Avis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`T_Avis` (
  `PK_Avis` INT NOT NULL AUTO_INCREMENT,
  `Avis` LONGTEXT NOT NULL,
  `IdFilm` INT NOT NULL,
  `FK_UsersUsers` INT NOT NULL,
  PRIMARY KEY (`PK_Avis`),
  INDEX `fk_T_Avis_T_Users_idx` (`FK_UsersUsers` ASC) VISIBLE,
  CONSTRAINT `fk_T_Avis_T_Users`
    FOREIGN KEY (`FK_UsersUsers`)
    REFERENCES `mydb`.`T_Users` (`PK_Users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
