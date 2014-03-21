# Shorts
 
# --- !Ups

CREATE TABLE `shorts` (
  `pkid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `authorid` bigint(20) unsigned NOT NULL,
  `articleid` bigint(20) unsigned NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `bullet1` varchar(140) NOT NULL,
  `bullet2` varchar(140) DEFAULT NULL,
  `bullet3` varchar(140) DEFAULT NULL,
  `bullet4` varchar(140) DEFAULT NULL,
  `bullet5` varchar(140) DEFAULT NULL,
  `created` datetime NOT NULL,
  `categoryid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE KEY `pkid_UNIQUE` (`pkid`),
  KEY `IDX_TITLE` (`title`),
  KEY `FK_SHORT_AUTHORS_idx` (`authorid`),
  KEY `FK_SHORT_ARTICLES_idx` (`articleid`),
  KEY `FK_SHORT_CATEGORIES_idx` (`categoryid`),
  CONSTRAINT `FK_SHORT_ARTICLES` FOREIGN KEY (`articleid`) REFERENCES `articles` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SHORT_AUTHORS` FOREIGN KEY (`authorid`) REFERENCES `authors` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SHORT_CATEGORIES` FOREIGN KEY (`categoryid`) REFERENCES `categories` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

DROP TABLE `shorts`
