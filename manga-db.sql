CREATE TABLE
  `author` (
    `id` bigint (20) NOT NULL,
    `name` varchar(255) NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `author` (`id`, `name`)
VALUES
  (1, 'Tomoaki Amagi'),
  (2, 'Oda Eiichiro'),
  (3, 'Akutami Gege'),
  (4, 'Toriyama Akira'),
  (5, 'Kishimoto Masashi'),
  (6, 'Yoshida Akimi'),
  (7, 'Fujiko F. Fujio'),
  (8, 'Fujimoto Tatsuki'),
  (9, 'Kui Ryoko'),
  (10, 'Urasawa Naoki'),
  (11, 'Tezuka Osamu'),
  (12, 'Tanabe Yellow'),
  (13, 'Akai Neko Nyo Dan'),
  (14, 'Wakui Ken'),
  (15, 'Inoue Takehiko'),
  (17, 'Author');

CREATE TABLE
  `chapter` (
    `id` bigint (20) NOT NULL,
    `name` varchar(255) NOT NULL,
    `chapter_index` int (11) NOT NULL,
    `comic_id` bigint (20) NOT NULL,
    `updated_time` datetime NOT NULL DEFAULT current_timestamp()
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `chapter` (
    `id`,
    `name`,
    `chapter_index`,
    `comic_id`,
    `updated_time`
  )
VALUES
  (2, '', 0, 2, '2024-10-21 11:35:13'),
  (3, '', 0, 3, '2024-10-21 11:35:13'),
  (4, '', 0, 4, '2024-10-21 11:35:13'),
  (5, '', 0, 5, '2024-10-21 11:35:13'),
  (6, '', 0, 6, '2024-10-21 11:35:13'),
  (7, '', 0, 7, '2024-10-21 11:35:13'),
  (8, '', 0, 8, '2024-10-21 11:35:13'),
  (9, '', 0, 9, '2024-10-21 11:35:13'),
  (10, '', 0, 10, '2024-10-21 11:35:13'),
  (11, '', 0, 11, '2024-10-21 11:35:13'),
  (12, '', 0, 12, '2024-10-21 11:35:13'),
  (13, '', 0, 13, '2024-10-21 11:35:13'),
  (14, '', 0, 14, '2024-10-21 11:35:13'),
  (15, '', 0, 15, '2024-10-21 11:35:13'),
  (16, '', 1, 13, '2024-10-21 11:35:13'),
  (19, 'Chapter title', 0, 17, '2024-10-23 10:14:24');

CREATE TABLE
  `comic` (
    `id` bigint (20) NOT NULL,
    `title` varchar(255) NOT NULL,
    `description` varchar(1000) NOT NULL,
    `view` bigint (20) NOT NULL,
    `status` enum ('PENDING', 'PUBLISH', 'UNPUBLISH', 'REJECTED') NOT NULL,
    `user_id` bigint (20) NOT NULL,
    `author_id` bigint (20) NOT NULL,
    `updated_time` datetime NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `comic` (
    `id`,
    `title`,
    `description`,
    `view`,
    `status`,
    `user_id`,
    `author_id`,
    `updated_time`
  )
VALUES
  (
    2,
    'Doraemon',
    '"Doraemon" is the masterpiece of Fujiko F. Fujio',
    514,
    'PUBLISH',
    1,
    7,
    '2024-10-23 10:10:30'
  ),
  (
    3,
    'One piece',
    'Gol D. Roger, a man referred to as the "Pirate King," is set to be executed by the World Government. But just before his demise, he confirms the existence of a great treasure, One Piece, located somewhere within the vast ocean known as the Grand Line',
    634,
    'PUBLISH',
    1,
    2,
    '2024-10-21 12:08:04'
  ),
  (
    4,
    'Jujutsu Kaisen',
    'Okkotsu Yuuta is a nervous high school student suffering from a serious problem—his childhood love Rika has turned into a curse and won''t leave him alone',
    511,
    'PUBLISH',
    1,
    3,
    '2024-10-21 12:08:04'
  ),
  (
    5,
    'Dragon Ball',
    'Dragon Ball follows the adventures of Goku from his childhood through adulthood as he trains in martial arts and explores the world in search of the seven mystical orbs known as the Dragon Balls',
    534,
    'PUBLISH',
    1,
    4,
    '2024-10-21 12:08:04'
  ),
  (
    6,
    'Naruto',
    'Before Naruto''s birth, a great demon fox had attacked the Hidden Leaf Village. The 4th Hokage from the leaf village sealed the demon inside the newly born Naruto',
    944,
    'PUBLISH',
    1,
    5,
    '2024-10-23 10:10:44'
  ),
  (
    7,
    'Kisho Tenyo',
    'Sayoko is a newly transferred student: gifted with rare beauty and mysterious and magnetic charm, she captures every student''s attention.',
    736,
    'PUBLISH',
    1,
    6,
    '2024-10-21 12:08:04'
  ),
  (
    8,
    'Look Back',
    'Fourth-grader Ayumu Fujino regularly draws 4Koma manga for her school newspaper and is lauded as having the best artwork in her class',
    498,
    'PUBLISH',
    1,
    8,
    '2024-10-21 12:08:04'
  ),
  (
    9,
    'Dungeon Meshi',
    'After his sister is devoured by a dragon and losing all their supplies in a failed dungeon raid',
    584,
    'PUBLISH',
    1,
    9,
    '2024-10-23 07:42:49'
  ),
  (
    10,
    'Monster',
    'Monster weaves the riveting story of brilliant Dr. Kenzo Tenma',
    282,
    'PUBLISH',
    1,
    10,
    '2024-10-22 10:13:23'
  ),
  (
    11,
    'Black Jack',
    'Black Jack is an "unregistered" doctor with a clouded',
    472,
    'PUBLISH',
    1,
    11,
    '2024-10-13 10:20:44'
  ),
  (
    12,
    'Birdmen',
    'Eishi Karasuma is a loner with a monotone life with his only friend is Mikisada Komoda. While skipping class they met Tsubame',
    354,
    'PUBLISH',
    1,
    12,
    '2024-10-22 10:13:31'
  ),
  (
    13,
    'Fullmetal Alchemist ',
    'Roy and Hughes share an intimate moment in bed and when they nod off to sleep',
    646,
    'PUBLISH',
    1,
    13,
    '2024-10-23 10:14:25'
  ),
  (
    14,
    'Tokyo卍Revengers',
    'Takemichi is a 26-year-old unemployed virgin who learns that the girl he dated in middle school',
    300,
    'PUBLISH',
    2,
    14,
    '2024-10-23 07:35:48'
  ),
  (
    15,
    'Slam Dunk',
    'Winning isn''t everything in the game of basketball',
    493,
    'PUBLISH',
    1,
    15,
    '2024-10-23 07:33:18'
  ),
  (
    17,
    'Hikaru no Go',
    'A regular school boy, Hikaru Shindo stumbles upon an old go board while looking through his grandpa''s old storage room for something worth money
',
    1,
    'PUBLISH',
    2,
    17,
    '2024-10-23 10:16:05'
  );

CREATE TABLE
  `comic_genre` (
    `comic_id` bigint (20) NOT NULL,
    `genre_id` bigint (20) NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `comic_genre` (`comic_id`, `genre_id`)
VALUES
  (2, 1),
  (3, 1),
  (4, 1),
  (7, 1),
  (9, 1),
  (17, 1),
  (4, 2),
  (7, 2),
  (9, 2),
  (15, 2),
  (2, 3),
  (3, 3),
  (5, 3),
  (6, 3),
  (9, 3),
  (11, 3),
  (12, 3),
  (14, 3),
  (15, 3),
  (17, 3),
  (11, 4),
  (12, 4),
  (15, 4),
  (6, 5),
  (9, 5),
  (3, 6),
  (4, 6),
  (5, 6),
  (6, 6),
  (9, 6),
  (12, 6),
  (13, 6),
  (14, 6),
  (7, 8),
  (8, 8),
  (10, 8),
  (6, 9),
  (7, 9),
  (10, 9),
  (11, 9);

CREATE TABLE
  `comment` (
    `id` bigint (20) NOT NULL,
    `comment` mediumtext NOT NULL,
    `user_id` bigint (20) NOT NULL,
    `chapter_id` bigint (20) NOT NULL,
    `created_time` datetime NOT NULL DEFAULT current_timestamp()
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE
  `content` (
    `id` bigint (20) NOT NULL,
    `content_index` int (11) NOT NULL,
    `chapter_id` bigint (20) NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `content` (`id`, `content_index`, `chapter_id`)
VALUES
  (4, 0, 2),
  (5, 1, 2),
  (6, 2, 2),
  (7, 0, 3),
  (8, 1, 3),
  (9, 2, 3),
  (10, 3, 3),
  (11, 4, 3),
  (12, 0, 4),
  (13, 1, 4),
  (14, 2, 4),
  (15, 3, 4),
  (16, 4, 4),
  (17, 5, 4),
  (18, 6, 4),
  (19, 7, 4),
  (20, 8, 4),
  (21, 9, 4),
  (22, 10, 4),
  (23, 0, 5),
  (24, 1, 5),
  (25, 2, 5),
  (26, 3, 5),
  (27, 4, 5),
  (28, 5, 5),
  (29, 6, 5),
  (30, 7, 5),
  (31, 8, 5),
  (32, 9, 5),
  (33, 0, 6),
  (34, 1, 6),
  (35, 2, 6),
  (36, 3, 6),
  (37, 4, 6),
  (38, 5, 6),
  (39, 6, 6),
  (40, 7, 6),
  (41, 8, 6),
  (42, 9, 6),
  (43, 10, 6),
  (44, 11, 6),
  (45, 0, 7),
  (46, 1, 7),
  (47, 2, 7),
  (48, 3, 7),
  (49, 4, 7),
  (50, 0, 8),
  (51, 1, 8),
  (52, 2, 8),
  (53, 3, 8),
  (54, 0, 9),
  (55, 1, 9),
  (56, 2, 9),
  (57, 3, 9),
  (58, 4, 9),
  (59, 0, 10),
  (60, 1, 10),
  (61, 2, 10),
  (62, 3, 10),
  (63, 4, 10),
  (64, 5, 10),
  (65, 0, 11),
  (66, 1, 11),
  (67, 2, 11),
  (68, 3, 11),
  (69, 0, 12),
  (70, 1, 12),
  (71, 2, 12),
  (72, 3, 12),
  (73, 0, 13),
  (74, 1, 13),
  (75, 2, 13),
  (77, 0, 14),
  (78, 1, 14),
  (79, 2, 14),
  (80, 3, 14),
  (81, 4, 14),
  (82, 5, 14),
  (83, 0, 15),
  (84, 1, 15),
  (85, 2, 15),
  (91, 0, 16),
  (97, 1, 16),
  (98, 2, 16),
  (106, 0, 19),
  (107, 1, 19),
  (108, 2, 19),
  (109, 3, 19),
  (110, 4, 19),
  (111, 5, 19),
  (112, 6, 19),
  (113, 7, 19),
  (114, 8, 19),
  (115, 9, 19),
  (116, 10, 19);

CREATE TABLE
  `genre` (
    `id` bigint (20) NOT NULL,
    `name` varchar(255) NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `genre` (`id`, `name`)
VALUES
  (1, 'Action'),
  (2, 'Adventure'),
  (3, 'Comedy'),
  (4, 'Crime'),
  (5, 'Sports'),
  (6, 'Thriller'),
  (7, 'Medical'),
  (8, 'Superhero'),
  (9, 'Historical'),
  (10, 'Theory');

CREATE TABLE
  `review` (
    `user_id` bigint (20) NOT NULL,
    `comic_id` bigint (20) NOT NULL,
    `type` enum ('LIKE', 'DISLIKE') NOT NULL,
    `created_time` datetime NOT NULL DEFAULT current_timestamp()
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE
  `user` (
    `id` bigint (20) NOT NULL,
    `name` varchar(24) NOT NULL,
    `email` varchar(320) NOT NULL,
    `pass` varchar(128) NOT NULL,
    `role` enum ('ADMIN', 'USER') NOT NULL,
    `is_deleted` tinyint (1) NOT NULL
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
  `user` (
    `id`,
    `name`,
    `email`,
    `pass`,
    `role`,
    `is_deleted`
  )
VALUES
  (1, 'admin', 'admin@gmail.com', '123', 'ADMIN', 0),
  (2, 'user', 'user@gmail.com', '123', 'USER', 0);

ALTER TABLE `author` ADD PRIMARY KEY (`id`);

ALTER TABLE `chapter` ADD PRIMARY KEY (`id`),
ADD KEY `comicId` (`comic_id`);

ALTER TABLE `comic` ADD PRIMARY KEY (`id`),
ADD KEY `userId` (`user_id`),
ADD KEY `authorId` (`author_id`);

ALTER TABLE `comic_genre` ADD PRIMARY KEY (`comic_id`, `genre_id`),
ADD KEY `genre_id` (`genre_id`);

ALTER TABLE `comment` ADD PRIMARY KEY (`id`),
ADD KEY `user_id` (`user_id`),
ADD KEY `chapter_id` (`chapter_id`);

ALTER TABLE `content` ADD PRIMARY KEY (`id`),
ADD KEY `chapterId` (`chapter_id`);

ALTER TABLE `genre` ADD PRIMARY KEY (`id`);

ALTER TABLE `review` ADD PRIMARY KEY (`user_id`, `comic_id`),
ADD KEY `comicId` (`comic_id`);

ALTER TABLE `user` ADD PRIMARY KEY (`id`),
ADD UNIQUE KEY `email` (`email`);

ALTER TABLE `author` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 15;

ALTER TABLE `chapter` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 16;

ALTER TABLE `comic` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 16;

ALTER TABLE `comment` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `content` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 86;

ALTER TABLE `genre` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 10;

ALTER TABLE `user` MODIFY `id` bigint (20) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 3;

ALTER TABLE `chapter` ADD CONSTRAINT `chapter_ibfk_1` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `comic` ADD CONSTRAINT `comic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `comic_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE `comic_genre` ADD CONSTRAINT `comic_genre_ibfk_1` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `comic_genre_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `comment` ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `content` ADD CONSTRAINT `content_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `review` ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

COMMIT;