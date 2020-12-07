# Generator: MySQL-Front 6.1  (Build 1.26)

DROP DATABASE IF EXISTS `bookstore`;
CREATE DATABASE `bookstore` charset utf8;
USE `bookstore`;

#
# Structure for table "kp_book"
#

DROP TABLE IF EXISTS `kp_book`;
CREATE TABLE `kp_book` (
  `bid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(11) unsigned NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `rank` decimal(2,1) NOT NULL DEFAULT '5.0',
  `ranker` int(11) unsigned NOT NULL DEFAULT '0',
  `img` varchar(255) DEFAULT NULL,
  `isbn` varchar(32) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `dates` date DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

#
# Data for table "kp_book"
#

INSERT INTO `kp_book` VALUES (1,1,'Bridge Build','It\'s about bridge building skills',5.0,1,NULL,'123456789',19.99,'2020-11-23'),(2,1,'Book Engineer N02','This is the 2nd book',4.6,3,NULL,'123456789',15.00,'2020-11-24'),(3,1,'Book Engineer N03','This is the 3rd book',5.0,1,NULL,'123456789',12.50,'2020-11-24'),(4,1,'Book Engineer N04','This is the 4th book',5.0,1,NULL,'123456789',12.50,'2020-11-25'),(5,1,'Book Engineer N05','This is the 5th book',5.0,1,NULL,'123456789',10.99,'2020-11-25'),(6,1,'Book Engineer N06','This is the 6th book',5.0,1,NULL,'123456789',32.90,'2020-11-25'),(7,1,'Book Engineer N07','This is the 7th book',5.0,1,NULL,'123456789',9.99,'2020-11-25'),(8,1,'Book Engineer N08','This is the 8th book',5.0,1,NULL,'123456789',56.30,'2020-11-25'),(9,1,'Book Engineer N09','This is the 9th book',5.0,1,NULL,'123456789',29.99,'2020-11-25'),(10,2,'Book Science N01','This is the science book 1',5.0,1,NULL,'123456789',15.00,'2020-11-24'),(11,2,'Book Science N02','This is the science book 2',5.0,1,NULL,'123456789',12.00,'2020-11-27'),(12,2,'Book Science N03','This is the science book 3',5.0,1,NULL,'123456789',13.00,'2020-11-24'),(13,2,'Book Science N04','This is the science book 4',5.0,1,NULL,'123456789',11.00,'2020-11-24'),(14,2,'Book Science N05','This is the science book 5',5.0,1,NULL,'123456789',15.00,'2020-11-25'),(15,2,'Book Science N06','This is the science book 6',5.0,1,NULL,'123456789',16.00,'2020-11-24'),(16,2,'Book Science N07','This is the science book 7',5.0,1,NULL,'123456789',17.00,'2020-11-27'),(17,2,'Book Science N08','This is the science book 8',5.0,1,NULL,'123456789',18.00,'2020-11-28'),(18,2,'Book Science N09','This is the science book 9',5.0,1,NULL,'123456789',19.00,'2020-11-29'),(19,2,'Book Science N10','This is the science book 10',5.0,1,NULL,'123456789',25.50,'2020-11-26'),(20,3,'Book Fiction N01','This is the fiction book 1',5.0,1,NULL,'123456789',15.00,'2020-11-24'),(21,3,'Book Fiction N02','This is the fiction book 2',5.0,1,NULL,'123456',22.00,'2020-11-27'),(22,3,'Book Fiction N03','This is the fiction book 3',5.0,1,NULL,'123456789',5.00,'2020-11-24'),(23,3,'Book Fiction N04','This is the fiction book 4',5.0,1,NULL,'123456789',14.00,'2020-11-24'),(24,3,'Book Fiction N05','This is the fiction book 5',5.0,1,NULL,'123456',15.00,'2020-11-25'),(25,3,'Book Fiction N06','This is the fiction book 6',5.0,1,NULL,'123456789',16.00,'2020-11-24'),(26,3,'Book Fiction N07','This is the fiction book 7',5.0,1,NULL,'123456789',17.00,'2020-11-27'),(27,3,'Book Fiction N08','This is the fiction book 8',5.0,1,NULL,'123456789',18.00,'2020-11-28'),(28,3,'Book Fiction N09','This is the fiction book 9',5.0,1,NULL,'123456789',19.00,'2020-11-29'),(29,3,'Book Fiction N10','This is the fiction book 10',5.0,1,NULL,'123456789',25.50,'2020-11-26'),(30,3,'Book Fiction N11','This is the fiction book 11',5.0,1,NULL,'56789012',18.99,'2020-11-26'),(31,4,'Book Astronomy N01','This is the astronomy book 1',5.0,1,NULL,'123456789',14.99,'2020-11-24'),(32,4,'Book Astronomy N02','This is the astronomy book 2',5.0,1,NULL,'123456',12.00,'2020-11-27'),(33,4,'Book Astronomy N03','This is the astronomy book 3',5.0,1,NULL,'123456789',13.00,'2020-11-24'),(34,4,'Book Astronomy N04','This is the astronomy book 4',5.0,1,NULL,'123456789',14.00,'2020-11-24'),(35,4,'Book Astronomy N05','This is the astronomy book 5',5.0,1,NULL,'123456',15.00,'2020-11-25'),(36,4,'Book Astronomy N06','This is the astronomy book 6',5.0,1,NULL,'123456789',16.00,'2020-11-24'),(37,4,'Book Astronomy N07','This is the astronomy book 7',4.7,2,NULL,'123456789',17.00,'2020-11-27'),(38,4,'Book Astronomy N08','This is the astronomy book 8',5.0,1,NULL,'123456789',18.00,'2020-11-28'),(39,4,'Book Astronomy N09','This is the astronomy book 9',5.0,1,NULL,'123456789',19.00,'2020-11-29'),(40,5,'Book Music N01','This is the music book 1',5.0,1,NULL,'123456789',14.99,'2020-11-24'),(41,5,'Book Music N02','This is the music book 2',5.0,1,NULL,'123456',12.00,'2020-11-27'),(42,5,'Book Music N03','This is the music book 3',5.0,1,NULL,'123456789',13.00,'2020-11-24'),(43,5,'Book Music N04','This is the music book 4',5.0,1,NULL,'123456789',14.00,'2020-11-24'),(44,5,'Book Music N05','This is the music book 5',5.0,1,NULL,'123456',15.00,'2020-11-25'),(45,5,'Book Music N06','This is the music book 6',5.0,1,NULL,'123456789',16.00,'2020-11-24'),(46,5,'Book Music N07','This is the music book 7',5.0,1,NULL,'123456789',17.00,'2020-11-27'),(47,5,'Book Music N08','This is the music book 8',5.0,1,NULL,'123456789',18.00,'2020-11-28'),(48,5,'Book Music N09','This is the music book 9',5.0,1,NULL,'123456789',19.00,'2020-11-29'),(49,6,'Book Literature N01','This is the literature book 1',5.0,1,NULL,'123456789',14.99,'2020-11-24'),(50,6,'Book Literature N02','This is the literature book 2',5.0,1,NULL,'123456',12.00,'2020-11-27'),(51,6,'Book Literature N03','This is the literature book 3',5.0,1,NULL,'123456789',13.00,'2020-11-24'),(52,6,'Book Literature N04','This is the literature book 4',5.0,1,NULL,'123456789',14.00,'2020-11-24'),(53,6,'Book Literature N05','This is the literature book 5',5.0,1,NULL,'123456',15.00,'2020-11-25'),(54,6,'Book Literature N06','This is the literature book 6',5.0,1,NULL,'123456789',16.00,'2020-11-24'),(55,6,'Book Literature N07','This is the literature book 7',5.0,1,NULL,'123456789',17.00,'2020-11-27'),(56,6,'Book Literature N08','This is the literature book 8',5.0,1,NULL,'123456789',18.00,'2020-11-28'),(57,6,'Book Literature N09','This is the literature book 9',5.0,1,NULL,'123456789',19.00,'2020-11-29'),(58,6,'Book Literature N10','This is the literature book 10',5.0,1,NULL,'123456789',25.50,'2020-11-26'),(59,6,'Book Literature N11','This is the literature book 11',5.0,1,NULL,'56789012',18.99,'2020-11-26'),(60,6,'Book Literature N12','This is the literature book 12',5.0,1,NULL,'77889963',9.99,'2020-11-25');

#
# Structure for table "kp_category"
#

DROP TABLE IF EXISTS `kp_category`;
CREATE TABLE `kp_category` (
  `cid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "kp_category"
#

INSERT INTO `kp_category` VALUES (1,'Engineering'),(2,'Science'),(3,'Fiction'),(4,'Astronomy'),(5,'Music'),(6,'Literature');

#
# Structure for table "kp_order"
#

DROP TABLE IF EXISTS `kp_order`;
CREATE TABLE `kp_order` (
  `oid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) unsigned NOT NULL,
  `dates` datetime DEFAULT NULL,
  `paid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "kp_order"
#

INSERT INTO `kp_order` VALUES (1,1,'2020-11-30 00:00:00',1),(2,1,'2020-12-01 00:00:00',1),(3,0,'2020-12-03 00:00:00',0),(4,4,'2020-12-03 00:00:00',1);

#
# Structure for table "kp_order_item"
#

DROP TABLE IF EXISTS `kp_order_item`;
CREATE TABLE `kp_order_item` (
  `iid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `oid` int(11) unsigned NOT NULL,
  `bid` int(11) unsigned NOT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `num` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`iid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "kp_order_item"
#

INSERT INTO `kp_order_item` VALUES (1,1,4,12.50,1),(2,1,46,17.00,1),(3,2,33,13.00,2),(4,2,14,15.00,1),(5,2,3,12.50,1),(6,4,8,56.30,1),(7,4,14,15.00,1),(8,4,25,16.00,1);

#
# Structure for table "kp_review"
#

DROP TABLE IF EXISTS `kp_review`;
CREATE TABLE `kp_review` (
  `rid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(11) unsigned NOT NULL,
  `uid` int(11) unsigned NOT NULL,
  `dates` datetime DEFAULT NULL,
  `content` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`rid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "kp_review"
#

INSERT INTO `kp_review` VALUES (1,3,3,'2020-12-02 00:00:00','6666666666666');

#
# Structure for table "kp_user"
#

DROP TABLE IF EXISTS `kp_user`;
CREATE TABLE `kp_user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(16) DEFAULT NULL,
  `email` varchar(128) NOT NULL DEFAULT '',
  `nick` varchar(16) NOT NULL DEFAULT '',
  `pass` varchar(64) NOT NULL DEFAULT '',
  `dates` datetime DEFAULT NULL,
  `name` varchar(32) NOT NULL DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  `addr` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `nick` (`nick`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "kp_user"
#

INSERT INTO `kp_user` VALUES (1,'administrator','admin@test.com','admin','123456','2020-11-30 00:00:00','Bill Clinton','+1-203-615-3366','Newyork central street 25'),(2,'partner','nydaily@newyork.com','nydaily','123456','2020-12-01 00:00:00','Nick Willson','+1-123-456-9978','Central Park Street 303, Newyork'),(3,'user','test1@test.com','test1','123456','2020-12-01 00:00:00','Tom Hanks','+1-06460-3455','99 CHERRY ST #7, MILFORD, CT'),(4,'user','test2@test.com','test2','123456','2020-12-03 00:00:00','Kim JongUn','+96-333-6678','Pyongyang, People\'s Republic of Korea');
