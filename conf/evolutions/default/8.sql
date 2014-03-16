# articles_view

# --- !Ups

CREATE VIEW `articles_view` AS select `a`.`pkid` AS `pkid`,`a`.`url` AS `url`,`a`.`url_hash` AS `url_hash`,`a`.`created` AS `created`,(time_to_sec(timediff(now(),`a`.`created`)) / 3600) AS `time_difference`,(select count(`l`.`pkid`) from (`likes` `l` join `shorts` `s` on((`l`.`shortid` = `s`.`pkid`))) where (`s`.`articleid` = `a`.`pkid`)) AS `likes_amount`,((select (count(`l`.`pkid`) * 2) from (`likes` `l` join `shorts` `s` on((`l`.`shortid` = `s`.`pkid`))) where (`s`.`articleid` = `a`.`pkid`)) - ((time_to_sec(timediff(now(),`a`.`created`)) / 3600) * 2.5)) AS `factor` from `articles` `a`;

# --- !Downs

DROP VIEW `articles_view`
