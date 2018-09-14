CREATE TABLE `stats`.`nominees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vote_id` VARCHAR(45) NOT NULL,
  `nominee_name` VARCHAR(45) NOT NULL,
  `nominee_image` VARCHAR(45) NULL,
  `nominees_description` VARCHAR(45) NULL,
  `creation_date` DATE NOT NULL,
  PRIMARY KEY (`id`));
