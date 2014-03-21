# Article ogfields
 
# --- !Ups

CREATE TABLE `article_ogfields` (
  `pkid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parentid` bigint(20) unsigned DEFAULT NULL,
  `articleid` bigint(20) unsigned DEFAULT NULL,
  `ogfieldid` bigint(20) unsigned DEFAULT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE KEY `pkid_UNIQUE` (`pkid`),
  KEY `FK_ARTICLE_OGFIELD_OGFIELDS_idx` (`parentid`),
  KEY `FK_ARTICLE_OGFIELD_ARTICLES_idx` (`articleid`),
  KEY `FK_ARTICLE_OGFIELD_OGFIELDS_idx1` (`ogfieldid`),
  CONSTRAINT `FK_ARTICLE_OGFIELD_ARTICLES` FOREIGN KEY (`articleid`) REFERENCES `articles` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ARTICLE_OGFIELD_OGFIELDS` FOREIGN KEY (`parentid`) REFERENCES `article_ogfields` (`pkid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# --- !Downs

DROP TABLE `article_ogfields`