/*
MySQL Backup
Database: vedioprocessing
Backup Time: 2022-03-03 15:40:01
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `vedioprocessing`.`files`;
DROP TABLE IF EXISTS `vedioprocessing`.`users`;
CREATE TABLE `files` (
  `file_name` varchar(32) NOT NULL,
  `file_url` varchar(255) NOT NULL,
  `file_to_user` int(11) NOT NULL COMMENT '上传文件的用户',
  KEY `file_user` (`file_to_user`),
  CONSTRAINT `file_user` FOREIGN KEY (`file_to_user`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL,
  `user_pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `vedioprocessing`.`files` WRITE;
DELETE FROM `vedioprocessing`.`files`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `vedioprocessing`.`users` WRITE;
DELETE FROM `vedioprocessing`.`users`;
INSERT INTO `vedioprocessing`.`users` (`user_id`,`user_name`,`user_pwd`) VALUES (1, 'admin', '123456');
UNLOCK TABLES;
COMMIT;
