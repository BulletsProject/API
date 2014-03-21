# categories_view
 
# --- !Ups

CREATE VIEW `categories_view` AS
    select 
        `categories`.`pkid` AS `pkid`, `categories`.`name` AS `name`
    from
        `categories`;

# --- !Downs

DROP TABLE `categories_view`
        