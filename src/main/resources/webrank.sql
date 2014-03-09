CREATE TABLE `date_visited` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_visited` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_visited` (`date_visited`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE `website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE visit (
date_visited_id int,
website_id int,
visit_count int,
PRIMARY KEY (date_visited_id, website_id),
CONSTRAINT fk_date_visited FOREIGN KEY (date_visited_id) REFERENCES date_visited(id),
CONSTRAINT fk_website FOREIGN KEY (websitedate_visiteddate_visited_id) REFERENCES website(id)
)



