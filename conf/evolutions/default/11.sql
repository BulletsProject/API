# shorts_view
 
# --- !Ups

CREATE VIEW `shorts_view` AS
    select 
        `s`.`pkid` AS `pkid`,
        `s`.`authorid` AS `authorid`,
        `s`.`articleid` AS `articleid`,
        `s`.`title` AS `title`,
        `s`.`bullet1` AS `bullet1`,
        `s`.`bullet2` AS `bullet2`,
        `s`.`bullet3` AS `bullet3`,
        `s`.`bullet4` AS `bullet4`,
        `s`.`bullet5` AS `bullet5`,
        `s`.`created` AS `created`,
        `s`.`categoryid` AS `categoryid`,
        (select 
                `a`.`facebook_id`
            from
                `authors` `a`
            where
                (`a`.`pkid` = `s`.`authorid`)) AS `author_facebookid`,
        (select 
                count(`likes`.`pkid`)
            from
                `likes`
            where
                (`likes`.`shortid` = `s`.`pkid`)) AS `likes_amount`
    from
        `shorts` `s`;
        
# --- !Downs

DROP VIEW `shorts_view`
