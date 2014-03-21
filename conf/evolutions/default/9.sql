# authors_view
 
# --- !Ups

CREATE VIEW `authors_view` AS
    select 
        `a`.`pkid` AS `pkid`,
        `a`.`facebook_id` AS `facebook_id`,
        `a`.`first_name` AS `first_name`,
        `a`.`last_name` AS `last_name`,
        `a`.`email` AS `email`,
        `a`.`created` AS `created`,
        (select 
                count(`l`.`pkid`)
            from
                (`likes` `l`
                join `shorts` `s`)
            where
                ((`l`.`shortid` = `s`.`pkid`)
                    and (`s`.`authorid` = `a`.`pkid`))) AS `likes_amount`,
        (select 
                count(`s`.`pkid`)
            from
                `shorts` `s`
            where
                (`s`.`authorid` = `a`.`pkid`)) AS `shorts_amount`,
        (select 
                count(`ar`.`pkid`)
            from
                (`articles` `ar`
                join `shorts` `s` ON ((`ar`.`pkid` = `s`.`articleid`)))
            where
                (`s`.`authorid` = `a`.`pkid`)) AS `articles_amount`
    from
        `authors` `a`;
        
# --- !Downs

DROP TABLE `authors_view`
        