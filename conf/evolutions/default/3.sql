# Ogfields
 
# --- !Ups

CREATE TABLE `ogfields` (
  `pkid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parentid` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE KEY `pkid_UNIQUE` (`pkid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `FK_OGFIELD_OGFIELDS_idx` (`parentid`),
  CONSTRAINT `FK_OGFIELD_OGFIELDS` FOREIGN KEY (`parentid`) REFERENCES `ogfields` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

DROP TABLE `ogfields`
