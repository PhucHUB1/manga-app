CREATE TABLE `author` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `author` (`id`, `name`) VALUES
(1, 'Kim Lân'),
(2, 'Eiichiro Oda'),
(3, 'Nisin Osin'),
(4, 'Toriyama Akira'),
(5, 'Kishimoto Masashi'),
(6, 'Lê Linh'),
(7, 'David Benioff'),
(8, 'J.K. Rowling'),
(9, 'Vũ Trọng Phụng'),
(10, 'Arthur Conan Doyle'),
(11, 'George R. R. Martin'),
(12, 'Sigmund Freud'),
(13, 'Herman Melville'),
(14, 'Robert Jordan');


CREATE TABLE `chapter` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `chapter_index` int(11) NOT NULL,
  `comic_id` bigint(20) NOT NULL,
  `updated_time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `chapter` (`id`, `name`, `chapter_index`, `comic_id`, `updated_time`) VALUES
(2, '', 0, 2, '2022-12-06 21:14:53'),
(3, '', 0, 3, '2022-12-13 09:59:32'),
(4, '', 0, 4, '2022-12-13 10:07:34'),
(5, '', 0, 5, '2022-12-13 10:08:57'),
(6, '', 0, 6, '2022-12-13 10:10:07'),
(7, '', 0, 7, '2022-12-13 10:11:12'),
(8, '', 0, 8, '2022-12-13 10:17:50'),
(9, '', 0, 9, '2022-12-13 10:18:41'),
(10, '', 0, 10, '2022-12-13 10:19:24'),
(11, '', 0, 11, '2022-12-13 10:20:44'),
(12, '', 0, 12, '2022-12-13 10:21:52'),
(13, '', 0, 13, '2022-12-13 10:22:37'),
(14, '', 0, 14, '2022-12-13 10:54:39'),
(15, '', 0, 15, '2022-12-13 10:57:55');

CREATE TABLE `comic` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `view` bigint(20) NOT NULL,
  `status` enum('PENDING','PUBLISH','UNPUBLISH','REJECTED') NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  `updated_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `comic` (`id`, `title`, `description`, `view`, `status`, `user_id`, `author_id`, `updated_time`) VALUES
(2, 'Vợ nhặt', 'abacaeè', 0, 'PUBLISH', 1, 1, '2022-12-13 10:11:45'),
(3, 'One piece', 'Câu truyện về cậu bé muốn trở thành Vua cướp biển?', 0, 'PUBLISH', 1, 2, '2022-12-13 09:59:32'),
(4, 'Bakemonogatari', 'Câu truyện kể về quái dị', 0, 'PUBLISH', 1, 3, '2022-12-13 10:07:34'),
(5, '7 viên ngọc rồng', 'Hành trình tìm 7 viên ngọc rồng ban lại điều ước', 0, 'PUBLISH', 1, 4, '2022-12-13 10:08:57'),
(6, 'Naruto', 'Câu truyện về cậu bé ninja mơ ước thành trưởng làng', 0, 'PUBLISH', 1, 5, '2022-12-13 10:10:07'),
(7, 'Thần đồng đất việt', 'Về một cậu bé trạng Nguyên', 0, 'PUBLISH', 1, 6, '2022-12-13 10:11:12'),
(8, 'Thành phố trộm', 'Về thành phố Berlingrad thời kì thế chiến thứ 2 ', 0, 'PUBLISH', 1, 7, '2022-12-13 10:17:50'),
(9, 'Hary Potter', 'Về những phù thủy xứ Anh?', 0, 'PUBLISH', 1, 8, '2022-12-13 10:18:41'),
(10, 'Số đỏ', 'Về chàng trai may mắn', 0, 'PUBLISH', 1, 9, '2022-12-13 10:19:24'),
(11, 'Sherlock Holmes', 'Câu truyện về thám tử xứ London', 0, 'PUBLISH', 1, 10, '2022-12-13 10:20:44'),
(12, 'A song of Ice and Fire', 'Thế giới giả tưởng', 0, 'PUBLISH', 1, 11, '2022-12-13 10:21:52'),
(13, 'Diễn giải giấc mơ', 'Nghiên cứu khoa học về giấc mơ', 0, 'PUBLISH', 1, 12, '2022-12-13 10:22:37'),
(14, 'Moby Dick', 'Câu truyện chuyển phiêu lưu săn cá voi trắng của chàng thủy thủ Ishmael', 0, 'PENDING', 2, 13, '2022-12-13 10:54:39'),
(15, 'The Eye of the World', 'Hành trình của một kị sĩ', 0, 'PUBLISH', 1, 14, '2022-12-13 10:57:55');

CREATE TABLE `comic_genre` (
  `comic_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `comic_genre` (`comic_id`, `genre_id`) VALUES
(2, 1),
(2, 3),
(3, 1),
(3, 3),
(3, 6),
(4, 1),
(4, 2),
(4, 6),
(5, 3),
(5, 6),
(6, 3),
(6, 5),
(6, 6),
(6, 9),
(7, 1),
(7, 2),
(7, 8),
(7, 9),
(8, 8),
(9, 1),
(9, 2),
(9, 3),
(9, 5),
(9, 6),
(10, 8),
(10, 9),
(11, 3),
(11, 4),
(11, 9),
(12, 3),
(12, 4),
(12, 6),
(13, 6),
(14, 3),
(14, 6),
(15, 2),
(15, 3),
(15, 4);


CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `comment` mediumtext NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `chapter_id` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `content` (
  `id` bigint(20) NOT NULL,
  `content_index` int(11) NOT NULL,
  `chapter_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `content` (`id`, `content_index`, `chapter_id`) VALUES
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
(76, 3, 13),
(77, 0, 14),
(78, 1, 14),
(79, 2, 14),
(80, 3, 14),
(81, 4, 14),
(82, 5, 14),
(83, 0, 15),
(84, 1, 15),
(85, 2, 15);



CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Action'),
(2, 'Adventure'),
(3, 'Comedy'),
(4, 'Crime'),
(5, 'Drama'),
(6, 'Fantasy'),
(7, 'Horror'),
(8, 'Isekai'),
(9, 'Mecha'),
(10,'Mystery'),
(11,'Philosophical'),
(12,'Psychological'),
(13,'Romance'),
(14,'Sci-Fi'),
(15,'Superhero'),
(16,'Sports'),
(17,'Thriller'),
(18,'Tragedy'),
(19,'Slice of Life'),
(20,'Wuxia');



CREATE TABLE `review` (
  `user_id` bigint(20) NOT NULL,
  `comic_id` bigint(20) NOT NULL,
  `type` enum('LIKE','DISLIKE') NOT NULL,
  `created_time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(24) NOT NULL,
  `email` varchar(320) NOT NULL,
  `pass` varchar(128) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  `is_deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `name`, `email`, `pass`, `role`, `is_deleted`) VALUES
(1, 'SystemAdmin', 'sa123@gmail.com', '123456', 'ADMIN', 0),
(2, 'user1', 'user1@gmail.com', '123456', 'USER', 0);


ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `chapter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comicId` (`comic_id`);

ALTER TABLE `comic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`user_id`),
  ADD KEY `authorId` (`author_id`);


ALTER TABLE `comic_genre`
  ADD PRIMARY KEY (`comic_id`,`genre_id`),
  ADD KEY `genre_id` (`genre_id`);


ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `chapter_id` (`chapter_id`);

ALTER TABLE `content`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chapterId` (`chapter_id`);


ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `review`
  ADD PRIMARY KEY (`user_id`,`comic_id`),
  ADD KEY `comicId` (`comic_id`);


ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);


ALTER TABLE `author`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

ALTER TABLE `chapter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;


ALTER TABLE `comic`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;


ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE `content`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;


ALTER TABLE `genre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;


ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


ALTER TABLE `chapter`
  ADD CONSTRAINT `chapter_ibfk_1` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `comic`
  ADD CONSTRAINT `comic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `comic_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;


ALTER TABLE `comic_genre`
  ADD CONSTRAINT `comic_genre_ibfk_1` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comic_genre_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `content`
  ADD CONSTRAINT `content_ibfk_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;


