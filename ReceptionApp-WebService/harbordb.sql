/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.44 : Database - harbordb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`harbordb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `harbordb`;

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `dpt_id` varchar(20) NOT NULL,
  `dpt_name` varchar(50) DEFAULT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `dpt_location` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dpt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `departments` */

insert  into `departments`(`dpt_id`,`dpt_name`,`hid`,`dpt_location`) values ('DPT-5529877204','dpt1','hid1','first'),('DPT-5531860647','dpt4','hid1','test');

/*Table structure for table `doctor_availability` */

DROP TABLE IF EXISTS `doctor_availability`;

CREATE TABLE `doctor_availability` (
  `avail_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `doc_name` varchar(50) DEFAULT NULL,
  `mon` varchar(50) DEFAULT NULL,
  `tue` varchar(50) DEFAULT NULL,
  `wed` varchar(50) DEFAULT NULL,
  `thu` varchar(50) DEFAULT NULL,
  `fri` varchar(50) DEFAULT NULL,
  `sat` varchar(50) DEFAULT NULL,
  `sun` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`avail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doctor_availability` */

insert  into `doctor_availability`(`avail_id`,`hid`,`doc_name`,`mon`,`tue`,`wed`,`thu`,`fri`,`sat`,`sun`) values ('AVA-5452087283','hid1','infosai infosai','M1,M1','M1,M1','Off','M1,M1','M1,M1','M1,M1','Off');

/*Table structure for table `doctor_specialities` */

DROP TABLE IF EXISTS `doctor_specialities`;

CREATE TABLE `doctor_specialities` (
  `doc_spec_id` varchar(20) DEFAULT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `doctor_id` varchar(20) DEFAULT NULL,
  `specialities` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doctor_specialities` */

/*Table structure for table `doctors` */

DROP TABLE IF EXISTS `doctors`;

CREATE TABLE `doctors` (
  `doctor_id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `specialities` varchar(100) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doctors` */

/*Table structure for table `general_settings` */

DROP TABLE IF EXISTS `general_settings`;

CREATE TABLE `general_settings` (
  `settings_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `slot_duration` varchar(20) DEFAULT NULL,
  `max_patient` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`settings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `general_settings` */

insert  into `general_settings`(`settings_id`,`hid`,`slot_duration`,`max_patient`) values ('SET-5353643256','hid1','16','52');

/*Table structure for table `hospital_admin` */

DROP TABLE IF EXISTS `hospital_admin`;

CREATE TABLE `hospital_admin` (
  `admin_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `photo` varchar(50) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospital_admin` */

insert  into `hospital_admin`(`admin_id`,`hid`,`fname`,`lname`,`username`,`password`,`role`,`nick_name`,`gender`,`address`,`contact`,`last_login`,`photo`,`creation_date`) values ('AID-5095760343','hid1','Kunal b','Birbal','admin','d033e22ae348aeb5660fc2140aec35850c4da997','doctor','infosai','male','nagpur','7769865652','2018-08-31 12:58:35','IMG-5549547415.jpg','2018-08-24'),('AID-5544380942','hid1','kunal','birbal','adminwr','d033e22ae348aeb5660fc2140aec35850c4da997','doctor','kunal','male','Yerkheda, kamptee','08055262521','2018-08-29 19:03:29','IMG-5544380931.jpg','2018-08-29'),('AID-5549404568','hid1','kunal','birbal','admin123','d033e22ae348aeb5660fc2140aec35850c4da997','asst_doc,nurse','kunal','male','Yerkheda','08055262521','2018-08-31 12:58:27','IMG-5549404562.jpg','2018-08-29');

/*Table structure for table `hospital_diseases` */

DROP TABLE IF EXISTS `hospital_diseases`;

CREATE TABLE `hospital_diseases` (
  `hdis_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `dis_name` varchar(100) DEFAULT NULL,
  `dis_desc` text,
  `dis_img` varchar(50) DEFAULT NULL,
  `dis_videos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hdis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospital_diseases` */

/*Table structure for table `hospital_dos_donts` */

DROP TABLE IF EXISTS `hospital_dos_donts`;

CREATE TABLE `hospital_dos_donts` (
  `hos_do_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `do_dont_name` varchar(50) DEFAULT NULL,
  `do_dont_desc` text,
  `do_dont_img` varchar(50) DEFAULT NULL,
  `do_dont_videos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hos_do_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospital_dos_donts` */

/*Table structure for table `hospitals` */

DROP TABLE IF EXISTS `hospitals`;

CREATE TABLE `hospitals` (
  `hid` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` int(10) DEFAULT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `reg_number` varchar(30) DEFAULT NULL,
  `logo` varchar(50) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospitals` */

insert  into `hospitals`(`hid`,`name`,`address`,`city`,`state`,`pincode`,`contact`,`reg_number`,`logo`,`creation_date`) values ('hid1','Meditrina','100, Rose Villa, Jasmine Street','Nagpur','Maharashtra',440067,'9876543210','123456789123','logo-5698978280.jpg','2018-08-23');

/*Table structure for table `login_history` */

DROP TABLE IF EXISTS `login_history`;

CREATE TABLE `login_history` (
  `lid` varchar(20) NOT NULL,
  `session_id` varchar(50) DEFAULT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `admin_id` varchar(20) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `logout_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login_history` */

insert  into `login_history`(`lid`,`session_id`,`hid`,`admin_id`,`login_time`,`logout_time`) values ('LID-5531836857','38C9130BCB903682FFCB4326C893116F','hid1','AID-5095760343','2018-08-29 14:07:13','2018-08-29 14:12:54'),('LID-5534333469','25254D1E9AC8859095AA0C20C196185E','hid1','AID-5095760343','2018-08-29 14:48:43','2018-08-29 14:48:54'),('LID-5541136684','1EAB151A491AC47304450429CEF37F33','hid1','AID-5095760343','2018-08-29 16:42:10','2018-08-29 16:42:17'),('LID-5541688473','8ADDE8A541343847729106BBF0D91171','hid1','AID-5095760343','2018-08-29 16:51:25','2018-08-29 16:51:29'),('LID-5542395220','7B8E5CD5ECF70FE0E637004224A8E519','hid1','AID-5095760343','2018-08-29 17:03:10','2018-08-29 17:03:15'),('LID-5544118331','B46F2AC0B9334D31D86ADCD261364E97','hid1','AID-5095760343','2018-08-29 17:31:54','2018-08-29 17:31:58'),('LID-5544203575','B46F2AC0B9334D31D86ADCD261364E97','hid1','AID-5095760343','2018-08-29 17:31:54','2018-08-29 17:33:23'),('LID-5544342176','8C98B1082FCBB13E9154D5C277624002','hid1','AID-5095760343','2018-08-29 17:35:37','2018-08-29 17:35:42'),('LID-5544923600','3E308FCEE95E425E2BA8283627B888EC','hid1','AID-5095760343','2018-08-29 17:45:21','2018-08-29 17:45:24'),('LID-5545124357','FE9DF6DC947E10296B04676D2AF2833F','hid1','AID-5095760343','2018-08-29 17:48:39','2018-08-29 17:49:50'),('LID-5545191803','5BA3E7E838BCE59D0E54B0B521ECEA9D','hid1','AID-5095760343','2018-08-29 17:49:50','2018-08-29 17:49:51'),('LID-5545315130','6AB0AEF79656BE0D0285B0152FBC2F54','hid1','AID-5095760343','2018-08-29 17:51:50','2018-08-29 17:51:55'),('LID-5545619682','63F4323995C1CA6673B0F5DE6D2A8D62','hid1','AID-5095760343','2018-08-29 17:56:56','2018-08-29 17:57:00'),('LID-5547563015','623BD8B0AE0FC44FE4D6309BDC8BE1A1','hid1','AID-5095760343','2018-08-29 18:29:19','2018-08-29 18:29:23'),('LID-5549203111','33B99365FAD912B4FF0BCC22FE6A04D6','hid1','AID-5095760343','2018-08-29 18:56:38','2018-08-29 18:58:17'),('LID-5549316613','D6FBECD059B7C5FFB9F252D8CB602BCE','hid1','AID-5095760343','2018-08-29 18:58:17','2018-08-29 18:58:36'),('LID-5550062934','D6FBECD059B7C5FFB9F252D8CB602BCE','hid1','AID-5095760343','2018-08-29 18:58:17','2018-08-29 19:11:03'),('LID-5628192466','96596AD0A90C357B74B3114F3A207471','hid1','AID-5095760343','2018-08-30 16:50:16','2018-08-30 16:53:13'),('LID-5633449525','B2925F3BAA4C1EDE224BE66302034466','hid1','AID-5095760343','2018-08-30 18:20:47','2018-08-30 18:20:49'),('LID-5698815666','26B7E60C15D226CC1A98172E78CC0757','hid1','AID-5095760343','2018-08-31 12:29:47','2018-08-31 12:30:16'),('LID-5698913064','0D733B119777CF10C664639E2EAD0196','hid1','AID-5095760343','2018-08-31 12:31:49','2018-08-31 12:31:53'),('LID-5700460029','32847973E9A612F65A8B328EB3FC97DF','hid1','AID-5095760343','2018-08-31 12:57:36','2018-08-31 12:58:23'),('LID-5700507941','69F43FE9D4BD59FD5F4084DD7EBD4D03','hid1','AID-5549404568','2018-08-31 12:58:23','2018-08-31 12:58:33'),('LID-5700515666','1EA42573306F394BA31C99A49316568D','hid1','AID-5095760343','2018-08-31 12:58:34','2018-08-31 12:58:35');

/*Table structure for table `patients` */

DROP TABLE IF EXISTS `patients`;

CREATE TABLE `patients` (
  `patient_id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patients` */

/*Table structure for table `queue_management` */

DROP TABLE IF EXISTS `queue_management`;

CREATE TABLE `queue_management` (
  `queue_id` varchar(50) NOT NULL,
  `hid` varchar(50) DEFAULT NULL,
  `dpt_name` varchar(50) DEFAULT NULL,
  `room_name` varchar(50) DEFAULT NULL,
  `doc_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`queue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `queue_management` */

insert  into `queue_management`(`queue_id`,`hid`,`dpt_name`,`room_name`,`doc_name`) values ('QUE-5455869355','hid1','dpt1','GF1','infosai12 infosai');

/*Table structure for table `rate_charts` */

DROP TABLE IF EXISTS `rate_charts`;

CREATE TABLE `rate_charts` (
  `rate_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `tariff_name` varchar(50) DEFAULT NULL,
  `service_name` varchar(50) DEFAULT NULL,
  `service_category` varchar(50) DEFAULT NULL,
  `rates` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `is_mandatory` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rate_charts` */

insert  into `rate_charts`(`rate_id`,`hid`,`tariff_name`,`service_name`,`service_category`,`rates`,`doctor_name`,`department`,`is_mandatory`) values ('RID-5455030849','hid1','Hospital','service name','test','40','infosai infosai','dpt2',1),('RID-5549638488','hid1','OPD','test','test','12155','kunal birbal','dpt4',1);

/*Table structure for table `shifts` */

DROP TABLE IF EXISTS `shifts`;

CREATE TABLE `shifts` (
  `shifts_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `shift_name` varchar(20) DEFAULT NULL,
  `start_time` varchar(20) DEFAULT NULL,
  `end_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`shifts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shifts` */

insert  into `shifts`(`shifts_id`,`hid`,`shift_name`,`start_time`,`end_time`) values ('SHD-5118829459','hid1','M1','02:12','12:12'),('SHD-5119610149','hid1','M1','04:54','00:12'),('SHD-5349182548',NULL,'m4','00:12','12:12');

/*Table structure for table `tariffs` */

DROP TABLE IF EXISTS `tariffs`;

CREATE TABLE `tariffs` (
  `tariff_id` varchar(20) NOT NULL,
  `hid` varchar(20) DEFAULT NULL,
  `tariff_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tariff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tariffs` */

insert  into `tariffs`(`tariff_id`,`hid`,`tariff_name`) values ('TID-5375801411','hid1','Hospital'),('TID-5380757951','hid1','OPD'),('TID-5382462003','hid1','new'),('TID-5549568819','hid1','test');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
