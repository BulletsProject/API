# likes table

# --- !Ups

CREATE TABLE `likes` (
  `pkid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shortid` bigint(20) unsigned NOT NULL,
  `device_id` varchar(40) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE KEY `pkid_UNIQUE` (`pkid`),
  KEY `FK_LIKE_SHORTS` (`shortid`),
  CONSTRAINT `FK_LIKE_SHORTS` FOREIGN KEY (`shortid`) REFERENCES `shorts` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

DROP TABLE `likes`
