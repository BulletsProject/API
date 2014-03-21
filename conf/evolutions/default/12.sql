# Initial data
 
# --- !Ups

INSERT INTO `ogfields` (`name`) VALUES ('og:image');
INSERT INTO `categories` (`name`) VALUES ('Science');
INSERT INTO `categories` (`name`) VALUES ('Technology');
INSERT INTO `categories` (`name`) VALUES ('Business');
INSERT INTO `categories` (`name`) VALUES ('Global Issues');
INSERT INTO `categories` (`name`) VALUES ('Art and Culture');
INSERT INTO `categories` (`name`) VALUES ('History');
INSERT INTO `categories` (`name`) VALUES ('Nature');

# --- !Downs

DELETE FROM `ogfields` WHERE name = 'og:image';
DELETE FROM `categories` WHERE name = 'Science';
DELETE FROM `categories` WHERE name = 'Technology';
DELETE FROM `categories` WHERE name = 'Business';
DELETE FROM `categories` WHERE name = 'Global Issues';
DELETE FROM `categories` WHERE name = 'Art and Culture';
DELETE FROM `categories` WHERE name = 'History';
DELETE FROM `categories` WHERE name = 'Nature';
