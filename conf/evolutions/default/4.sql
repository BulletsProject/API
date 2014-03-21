# Articles
 
# --- !Ups

CREATE TABLE `articles` (
  `pkid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(2000) NOT NULL,
  `url_hash` varchar(45) NOT NULL,
  `created` datetime NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE KEY `pkid_UNIQUE` (`pkid`),
  UNIQUE KEY `url_hash_UNIQUE` (`url_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

DROP TABLE `articles`
