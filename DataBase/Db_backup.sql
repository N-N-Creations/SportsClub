/*
SQLyog Community Edition- MySQL GUI v8.03 
MySQL - 5.0.51a-community-nt : Database - sportsclub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`sportsclub` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sportsclub`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `slno` int(11) default NULL,
  `name` varchar(20) NOT NULL,
  `uname` varchar(15) NOT NULL,
  `pswd` varchar(15) NOT NULL,
  `sq` varchar(30) NOT NULL,
  `answer` varchar(15) NOT NULL,
  `active` int(3) default NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`slno`,`name`,`uname`,`pswd`,`sq`,`answer`,`active`) values (2,'nishad','nishad123','nishad123','What You Want...?','nothing',0),(1,'Muhammed Nisham MP','nisham123','4321','What is Your Problem...?','nothing',0);

/*Table structure for table `event` */

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `event_id` varchar(5) NOT NULL,
  `name` varchar(20) default NULL,
  `category` varchar(10) default NULL,
  `date` varchar(10) default NULL,
  `lastdate` varchar(10) default NULL,
  PRIMARY KEY  (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `event` */

insert  into `event`(`event_id`,`name`,`category`,`date`,`lastdate`) values ('E-1','CricketMatch','Cricket','2020-04-24','2020-04-23'),('E-2','FootBallMatch','FootBall','2020-04-23','2020-04-21'),('E-3','VolleyBallMatch','VolleyBall','2020-05-26','2020-05-27');

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `user` varchar(15) NOT NULL,
  `namme` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `operation` varchar(15) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `history` */

insert  into `history`(`user`,`namme`,`date`,`operation`) values ('nishad123','Muneesh','2020-03-02','Update'),('nisham123','bineesh','2020-03-04','Added'),('nisham123','bahu','2020-05-14','Update'),('nisham123','bahu','2020-05-14','Update'),('nisham123','sreerag','2020-05-14','Added'),('nisham123','aaaaa','2020-05-14','Added'),('nisham123','Muneesh','2020-05-19','Update'),('nisham123','sdfsd','2020-05-19','Added'),('nisham123','sdfsd','2020-05-19','Deleted'),('nishad123','Irshad','2020-05-19','Added');

/*Table structure for table `member_sug` */

DROP TABLE IF EXISTS `member_sug`;

CREATE TABLE `member_sug` (
  `id` varchar(10) default NULL,
  `vname` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `dob` date NOT NULL,
  `bg` varchar(5) NOT NULL,
  `sports` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `member_sug` */

/*Table structure for table `members` */

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
  `slno` int(11) NOT NULL auto_increment,
  `id` varchar(5) NOT NULL,
  `name` varchar(22) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `dob` date NOT NULL,
  `bg` varchar(5) NOT NULL,
  `sports` varchar(50) NOT NULL,
  `active` int(3) default NULL,
  `event_id` varchar(15) default NULL,
  `ev_app` varchar(15) default NULL,
  PRIMARY KEY  (`slno`,`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `members` */

insert  into `members`(`slno`,`id`,`name`,`phone`,`dob`,`bg`,`sports`,`active`,`event_id`,`ev_app`) values (1,'M-1','Mohammed rinshad','9895612423','1999-07-18','A+','FootBall,Cricket,VolleyBall',NULL,NULL,NULL),(2,'M-2','Nidhin Pep','9567495367','2000-11-17','AB+','FootBall,Cricket',NULL,NULL,NULL),(3,'M-3','Nishad','9745016315','1999-08-24','AB+','VolleyBall',NULL,NULL,NULL),(4,'M-4','Anandu','9876543210','2000-02-29','A+','FootBall,Cricket,VolleyBall',NULL,NULL,NULL),(5,'M-5','nejeeb','8137952190','2000-08-16','B+','FootBall,Cricket',NULL,NULL,NULL),(6,'M-6','Shibil','7736223427','2000-04-30','O+','VolleyBall',NULL,NULL,NULL),(7,'M-7','Binesh','9747311146','2001-11-15','A+','FootBall',NULL,NULL,NULL),(8,'M-8','Sreerag','9876543210','1999-05-12','AB+','FootBall,Cricket,VolleyBall',NULL,NULL,NULL),(9,'M-9','aaaaa','9876543210','2018-05-16','AB-','Cricket',NULL,NULL,NULL),(10,'M-10','bahu','9876543210','2008-02-06','O+','FootBall,VolleyBall',0,'E-3','E-2'),(11,'M-11','Muneesh','9654321087','1998-02-06','A+','VolleyBall',NULL,NULL,NULL),(12,'M-12','bahu','9876543210','1999-06-24','B+','FootBall,VolleyBall',NULL,NULL,NULL),(13,'M-13','Sreerag','8012345679','2019-03-13','O+','Cricket',NULL,NULL,NULL),(14,'M-14','nidhin','9876543210','2000-04-03','B+','FootBall,Cricket',NULL,NULL,NULL),(15,'M-15','nisham','7356773248','2001-12-20','A+','FootBall,VolleyBall',NULL,NULL,NULL),(16,'M-16','bineesh','9747311146','2001-11-15','A+','FootBall,Cricket,VolleyBall',NULL,NULL,NULL),(17,'M-17','Irshad','9847947285','2004-01-06','O+','FootBall,Cricket',NULL,NULL,NULL);

/*Table structure for table `visitors` */

DROP TABLE IF EXISTS `visitors`;

CREATE TABLE `visitors` (
  `id` varchar(5) default NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `active` int(3) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `visitors` */

insert  into `visitors`(`id`,`name`,`phone`,`email`,`active`) values ('V-1','Nishad','9745016315','mnvp369@gmail.com',0),('V-2','Nisham','9876543210','nisham@gmail.com',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
