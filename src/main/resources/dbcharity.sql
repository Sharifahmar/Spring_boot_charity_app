-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.54-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for charity_db
DROP DATABASE IF EXISTS `charity_db`;
CREATE DATABASE IF NOT EXISTS `charity_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `charity_db`;

-- Dumping structure for table charity_db.acceptor
DROP TABLE IF EXISTS `acceptor`;
CREATE TABLE IF NOT EXISTS `acceptor` (
  `ACCEPTOR_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `ADDRESS` text,
  `CITY` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `PHONE` varchar(100) NOT NULL,
  `STATE` varchar(100) DEFAULT NULL,
  `ACCEPTOR_STS` bit(1) NOT NULL,
  `ZIPCODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ACCEPTOR_ID`),
  UNIQUE KEY `UK4cxs1d1kblpqkiq2kdiewduhw` (`PHONE`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.acceptor: 4 rows
DELETE FROM `acceptor`;
/*!40000 ALTER TABLE `acceptor` DISABLE KEYS */;
INSERT INTO `acceptor` (`ACCEPTOR_ID`, `CREATED_DATE`, `UPDATED_DATE`, `ADDRESS`, `CITY`, `COUNTRY`, `EMAIL_ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE`, `STATE`, `ACCEPTOR_STS`, `ZIPCODE`) VALUES
	(1, '2019-02-27 00:11:24', '2020-05-03 01:10:39', '444605', 'Amravati', 'India', 'azar@gmail.com', 'azhar', 'shah', '9876543210', 'Maharashtra', b'1', '4411002'),
	(2, '2019-07-29 20:42:23', '2019-10-26 00:39:31', 'Camp, Amravati, 444602', 'Amravati', 'India', 'ahmar93@gmail.co', 'SharifAhmar', 'Ahmar', '9876543217', 'Maharashtra', b'1', '411048'),
	(3, '2020-09-07 15:43:41', '2020-09-07 15:43:41', 'Camp , Amravati', 'Amravati', 'India', 'nagma@gmail.com', 'Nagma', 'Sharif', '9025365255', 'Maharashtra', b'1', '444602'),
	(4, '2020-09-27 18:35:55', '2020-09-27 18:35:55', 'Badnera', 'Amravati', 'India', 'waqar@gmail.com', 'waqar', 'nazish', '9822933122', 'Maharashtra', b'1', '444701');
/*!40000 ALTER TABLE `acceptor` ENABLE KEYS */;

-- Dumping structure for table charity_db.acceptor_amount
DROP TABLE IF EXISTS `acceptor_amount`;
CREATE TABLE IF NOT EXISTS `acceptor_amount` (
  `ACCEPTOR_AMOUNT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `ACCEPTOR_AMOUNT` varchar(100) NOT NULL,
  `ACCEPTOR_AMOUNT_STS` bit(1) NOT NULL,
  `ACCEPTOR_ID` bigint(20) DEFAULT NULL,
  `DONATION_TYPE_ID` bigint(20) DEFAULT NULL,
  `TOKEN_NUMBER` varchar(100) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ACCEPTOR_AMOUNT_ID`),
  KEY `FKsnnuelrgkovg4uof9qfkd4t45` (`ACCEPTOR_ID`),
  KEY `FKr3hydhro16e3dlyi2mrf4njdi` (`DONATION_TYPE_ID`),
  KEY `FK709e3fe8vdybe0lnl7bgqycon` (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.acceptor_amount: 5 rows
DELETE FROM `acceptor_amount`;
/*!40000 ALTER TABLE `acceptor_amount` DISABLE KEYS */;
INSERT INTO `acceptor_amount` (`ACCEPTOR_AMOUNT_ID`, `CREATED_DATE`, `UPDATED_DATE`, `ACCEPTOR_AMOUNT`, `ACCEPTOR_AMOUNT_STS`, `ACCEPTOR_ID`, `DONATION_TYPE_ID`, `TOKEN_NUMBER`, `USER_ID`) VALUES
	(1, '2020-05-03 03:29:23', '2020-09-09 01:50:02', '5000', b'1', 1, 2, '56789', 3),
	(2, '2020-09-09 01:16:26', '2020-09-09 01:16:26', '5000', b'1', 3, 2, '12345', 3),
	(3, '2020-09-09 01:35:07', '2020-09-09 01:35:07', '500', b'1', 3, 2, '12345', 3),
	(4, '2020-09-27 20:05:23', '2020-09-27 20:05:23', '1000', b'1', 1, 2, 'O12', 15),
	(5, '2020-09-27 20:08:23', '2020-09-27 20:08:23', '1000', b'1', 1, 8, 'O12', 15);
/*!40000 ALTER TABLE `acceptor_amount` ENABLE KEYS */;

-- Dumping structure for table charity_db.acceptor_token_details
DROP TABLE IF EXISTS `acceptor_token_details`;
CREATE TABLE IF NOT EXISTS `acceptor_token_details` (
  `ACCEPTOR_TOKEN_DETAILS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `ACCEPTOR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ACCEPTOR_TOKEN_DETAILS_ID`),
  KEY `FK7olafrump22ibei00isfyqf89` (`ACCEPTOR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.acceptor_token_details: 0 rows
DELETE FROM `acceptor_token_details`;
/*!40000 ALTER TABLE `acceptor_token_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `acceptor_token_details` ENABLE KEYS */;

-- Dumping structure for table charity_db.cities
DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities` (
  `CITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_CODE` varchar(100) NOT NULL,
  `CITY_NAME` varchar(100) NOT NULL,
  `CITY_STS` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`CITY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.cities: 0 rows
DELETE FROM `cities`;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;

-- Dumping structure for table charity_db.donars
DROP TABLE IF EXISTS `donars`;
CREATE TABLE IF NOT EXISTS `donars` (
  `DONARS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `CITY` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  `FULL_NAME` varchar(256) DEFAULT NULL,
  `PHONE` varchar(100) NOT NULL,
  `STATE` varchar(100) DEFAULT NULL,
  `DONAR_STS` bit(1) NOT NULL,
  `ZIPCODE` varchar(100) DEFAULT NULL,
  `PROFILE_PICTURE` text,
  `PROFILE_PICTURE_URL` text,
  PRIMARY KEY (`DONARS_ID`),
  UNIQUE KEY `UKnqbtley12h0wka100jbu221oq` (`PHONE`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.donars: 10 rows
DELETE FROM `donars`;
/*!40000 ALTER TABLE `donars` DISABLE KEYS */;
INSERT INTO `donars` (`DONARS_ID`, `CREATED_DATE`, `UPDATED_DATE`, `ADDRESS`, `CITY`, `COUNTRY`, `FULL_NAME`, `PHONE`, `STATE`, `DONAR_STS`, `ZIPCODE`, `PROFILE_PICTURE`, `PROFILE_PICTURE_URL`) VALUES
	(1, '2019-02-22 19:25:11', '2020-10-09 22:31:37', 'camp , Jail Raod, AMravati 444604', 'Amravati', 'India', 'Muzammmil Amt', '9876543210', 'Maharashtra', b'1', '444602', NULL, NULL),
	(2, '2019-07-06 22:36:18', '2020-10-12 01:27:56', 'Mohammadi Wadi, NIBM Road , Kondhwa , Pune', 'Amravati', 'India', 'nimish', '9028356525', 'Maharashtra', b'0', '411048', NULL, NULL),
	(3, '2019-07-19 00:41:30', '2020-10-05 02:31:08', ' Kharadi, Pune', 'Amravati', 'India', 'Muzammmil', '9876543212', 'Maharashtra', b'0', '411036', NULL, NULL),
	(4, '2019-07-27 16:32:45', '2019-10-26 00:49:19', 'Camp ,Amaravati 444602', 'Amravati', 'India', 'Nagma', '8087100602', 'Maharashtra', b'1', '444602', NULL, NULL),
	(5, '2019-11-03 00:26:20', '2020-04-10 20:54:09', 'Amravati', 'Amravati', 'India', 'demo', '8668816121', 'Maharashtra', b'1', '411048', NULL, NULL),
	(6, '2020-09-27 18:17:04', '2020-09-27 18:18:07', 'Badnera 447402', 'Amravati', 'India', 'waqar', '9822933122', 'Maharashtra', b'1', '444701', NULL, NULL),
	(7, '2020-09-27 18:55:09', '2020-09-27 18:55:09', 'BAdnera', 'Amravati', 'India', 'saquib', '7020041371', 'Maharashtra', b'1', '444702', NULL, NULL),
	(8, '2020-10-05 02:32:44', '2020-10-11 02:22:02', 'Nanded', 'Amravati', 'India', 'Asif ', '9764866456', 'Maharashtra', b'1', '444602', 'file:/E:/Desktop/Spring_boot_charity_app/images/Donor/8/mypic.JPG', 'http://localhost:8081/images/Donor/8/mypic.JPG'),
	(9, '2020-10-09 23:38:53', '2020-10-11 02:20:45', 'Pune', 'Amravati', 'India', 'Aazam Pathan', '9028356528', 'Maharashtra', b'1', '444603', 'file:/E:/Desktop/Spring_boot_charity_app/images/Donor/9/mypicedited.JPG', 'http://localhost:8081/images/Donor/9/mypicedited.JPG'),
	(10, '2020-10-10 01:22:15', '2020-10-10 01:22:15', 'NGP', 'Amravati', 'India', 'Atib Sharif', '9876542310', 'Maharashtra', b'1', '444016', NULL, NULL);
/*!40000 ALTER TABLE `donars` ENABLE KEYS */;

-- Dumping structure for table charity_db.donar_slip_details
DROP TABLE IF EXISTS `donar_slip_details`;
CREATE TABLE IF NOT EXISTS `donar_slip_details` (
  `DONAR_SLIP_DETAILS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DONAR_SLIP_DETAILS_ID`),
  KEY `FK3oypdcyclyap972g9ks35smst` (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.donar_slip_details: 1 rows
DELETE FROM `donar_slip_details`;
/*!40000 ALTER TABLE `donar_slip_details` DISABLE KEYS */;
INSERT INTO `donar_slip_details` (`DONAR_SLIP_DETAILS_ID`, `CREATED_DATE`, `UPDATED_DATE`, `USER_ID`) VALUES
	(2, '2019-02-26 23:06:07', '2019-02-26 23:06:07', 1);
/*!40000 ALTER TABLE `donar_slip_details` ENABLE KEYS */;

-- Dumping structure for table charity_db.donation_amount
DROP TABLE IF EXISTS `donation_amount`;
CREATE TABLE IF NOT EXISTS `donation_amount` (
  `DONATION_AMOUNT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `DONATION_AMOUNT` varchar(100) NOT NULL,
  `DONATION_AMOUNT_STS` bit(1) NOT NULL,
  `DONATION_TYPE_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `DONAR_ID` bigint(20) DEFAULT NULL,
  `RECEIPT_NUMBER` varchar(100) NOT NULL,
  PRIMARY KEY (`DONATION_AMOUNT_ID`),
  KEY `FKem8v52bdtx2su5pyws3u7g4k3` (`DONAR_ID`),
  KEY `FKt3rfsoy40ax7syfn1fog3wslk` (`DONATION_TYPE_ID`),
  KEY `FK4457y87oer796dg7xlyrigxnx` (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.donation_amount: 12 rows
DELETE FROM `donation_amount`;
/*!40000 ALTER TABLE `donation_amount` DISABLE KEYS */;
INSERT INTO `donation_amount` (`DONATION_AMOUNT_ID`, `CREATED_DATE`, `UPDATED_DATE`, `DONATION_AMOUNT`, `DONATION_AMOUNT_STS`, `DONATION_TYPE_ID`, `USER_ID`, `DONAR_ID`, `RECEIPT_NUMBER`) VALUES
	(1, '2019-11-04 01:47:59', '2020-04-10 00:50:03', '500', b'1', 2, 3, 5, '00479'),
	(2, '2019-11-06 01:51:40', '2020-04-11 18:30:10', '500', b'1', 2, 3, 5, '984790'),
	(3, '2019-11-23 02:08:20', '2020-09-08 01:15:24', '5668', b'0', 2, 3, 5, '75499'),
	(4, '2019-11-03 15:37:19', '2019-11-03 15:37:19', '500', b'1', 2, 3, 3, '68479'),
	(5, '2019-11-09 23:33:03', '2019-11-09 23:33:03', '1000', b'1', 2, 3, 2, '78567'),
	(6, '2019-11-09 23:54:09', '2020-05-03 01:09:38', '1000', b'0', 2, 3, 2, '78479'),
	(7, '2019-12-09 22:42:03', '2020-04-10 00:50:56', '1000', b'0', 2, 3, 5, 'AH42941'),
	(8, '2020-04-05 14:53:42', '2020-04-05 14:53:42', '5500', b'1', 2, 3, 5, '12345'),
	(13, '2020-09-09 01:08:30', '2020-09-09 01:08:30', '5000', b'1', 2, 3, 5, '12345'),
	(14, '2020-09-27 18:24:29', '2020-09-27 18:27:08', '1500', b'1', 3, 14, 5, '56789'),
	(15, '2020-09-27 18:56:59', '2020-09-27 18:56:59', '1000', b'1', 2, 15, 7, '12345'),
	(16, '2020-09-27 19:20:56', '2020-09-27 19:20:56', '1000', b'1', 2, 15, 7, '12345');
/*!40000 ALTER TABLE `donation_amount` ENABLE KEYS */;

-- Dumping structure for table charity_db.donation_type
DROP TABLE IF EXISTS `donation_type`;
CREATE TABLE IF NOT EXISTS `donation_type` (
  `DONATION_TYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `DONATION_TYPE` varchar(100) NOT NULL,
  `DONATION_TYPE_STS` bit(1) NOT NULL,
  `DONATION_TYPE_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DONATION_TYPE_ID`),
  UNIQUE KEY `UKr2rws1kujaw32toewj52ak7he` (`DONATION_TYPE`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.donation_type: 4 rows
DELETE FROM `donation_type`;
/*!40000 ALTER TABLE `donation_type` DISABLE KEYS */;
INSERT INTO `donation_type` (`DONATION_TYPE_ID`, `CREATED_DATE`, `UPDATED_DATE`, `DONATION_TYPE`, `DONATION_TYPE_STS`, `DONATION_TYPE_NAME`) VALUES
	(2, '2019-02-22 19:48:54', '2019-10-26 00:59:54', 'JAKAAT', b'1', 'jakaat'),
	(3, '2019-02-22 19:52:27', '2019-10-26 01:00:45', 'RATION', b'1', 'ration'),
	(6, '2019-07-23 23:23:50', '2019-07-23 23:23:50', 'ALL', b'1', 'all'),
	(8, '2020-09-27 20:08:00', '2020-09-27 20:08:00', 'SADAQ', b'1', 'sadaq');
/*!40000 ALTER TABLE `donation_type` ENABLE KEYS */;

-- Dumping structure for table charity_db.refresh_tokens
DROP TABLE IF EXISTS `refresh_tokens`;
CREATE TABLE IF NOT EXISTS `refresh_tokens` (
  `token` varchar(255) NOT NULL,
  `expirationDateTime` datetime DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`token`),
  KEY `FKhspjwa36lvj54jpx0kuyx4b33` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.refresh_tokens: 251 rows
DELETE FROM `refresh_tokens`;
/*!40000 ALTER TABLE `refresh_tokens` DISABLE KEYS */;
INSERT INTO `refresh_tokens` (`token`, `expirationDateTime`, `user_id`) VALUES
	('90f9403c-b04d-41e5-87cc-8d6c428172b5', '2020-04-29 15:37:28', 2),
	('804151e6-a1a3-4fd1-ba7d-3b1a4e4974f1', '2020-06-20 19:22:37', 3),
	('002c5eb7-d822-439c-b2d7-4b29f41df44a', '2020-06-20 20:27:50', 3),
	('2f75771a-9e48-4ea6-944e-872c0989d0b6', '2020-06-20 21:08:02', 3),
	('9678f042-9e6c-46fe-8bc7-885edaf11265', '2020-06-20 21:36:26', 3),
	('c64e7fb4-b3dc-40df-ac8d-00d2ab34210c', '2020-06-20 21:44:12', 3),
	('a221abdf-3ca4-4b71-94a1-a020a4152a3e', '2020-06-20 21:50:23', 3),
	('c677cf9f-1c9f-4415-b09b-de225c06194e', '2020-06-20 22:03:15', 3),
	('f45c997f-a39c-490d-8cc8-10aca6f6b401', '2020-06-20 22:14:57', 3),
	('a3ae3aa3-5e1a-446e-affc-f5d857ccebc7', '2020-06-21 22:56:19', 3),
	('0c4234d3-0a90-4be8-a9be-f4e960f88572', '2020-06-24 01:25:17', 8),
	('5a0540fd-3a03-4796-946a-04a041fd6fbe', '2020-06-25 21:51:51', 1),
	('34062711-8cde-466a-befa-bd5cc62fbc0f', '2020-06-25 22:01:31', 1),
	('57404c06-e44f-47a1-9216-504389717a9e', '2020-06-26 23:12:13', 1),
	('2d356cd4-654a-49aa-8caa-09dff2a9e030', '2020-06-26 23:14:30', 1),
	('8141f0c9-bf37-4dcd-bdfd-a6b6d0f0a9e3', '2020-06-26 23:18:02', 1),
	('89878d93-ad52-40b5-aa90-b2d375eca2b6', '2020-06-26 23:24:15', 1),
	('04915db6-b10f-4d62-a451-9e42d8cedb31', '2020-06-28 21:44:32', 1),
	('c7f73529-b001-49a6-9d5e-e5c102ae585a', '2020-06-28 22:12:28', 1),
	('2683eab1-68cb-4272-87bf-0b2a2c9281d8', '2020-06-28 22:17:55', 1),
	('843f2852-5470-4109-8b9b-1110c68d0395', '2020-06-28 22:19:12', 2),
	('ddd4bae1-59c9-4104-bff1-d4c4d10c2c8a', '2020-06-28 22:22:12', 2),
	('ca5392f9-63ac-4994-bebe-aacd032cead8', '2020-06-28 22:38:36', 2),
	('ab2a5aa7-aa8d-45cc-aeaf-d5d8a0f7b2e9', '2020-06-28 22:42:15', 2),
	('394bc553-9007-42f1-bb08-c377066180be', '2020-06-28 22:57:51', 2),
	('b2c5f7c9-2245-47a6-a021-d212f5e74e80', '2020-06-29 22:29:07', 2),
	('7d0df869-6bd8-42d5-b749-5d4c5f66062e', '2020-06-29 22:54:39', 2),
	('f780c4f6-d7ff-4553-b962-3c641298166f', '2020-06-29 23:15:24', 1),
	('3525c67e-ca2a-416d-aca3-1008345f7647', '2020-06-29 23:21:53', 2),
	('8f4a0fb2-c50f-4478-a545-fd02f894aa22', '2020-06-29 23:30:33', 2),
	('70aae335-753d-4f3e-bb2b-3b1b310f348d', '2020-06-30 16:32:56', 2),
	('59920d1b-ab44-43aa-aec4-d5949b53317e', '2020-06-30 17:28:57', 2),
	('2075a996-f224-41e1-8d32-cc2081ebfd55', '2020-06-30 17:32:27', 2),
	('c877ad77-c782-4948-babf-521131c38422', '2020-06-30 17:57:46', 2),
	('4c4a08e4-68dd-4794-a03c-06c64e76000f', '2020-06-30 18:19:31', 2),
	('faf1e252-62f4-4a3c-bb4c-5c4681fc711d', '2020-06-30 18:48:38', 2),
	('ffe502af-b8a3-4016-966f-7cf30323393e', '2020-06-30 19:03:04', 2),
	('437f0e9b-8a0a-47c7-9253-d569461e470e', '2020-06-30 19:12:29', 2),
	('3ae25c62-39d4-4b20-9555-e989fb132e1f', '2020-06-30 19:39:59', 2),
	('e5a52797-fe76-4a71-819f-73e41e262907', '2020-06-30 22:35:02', 2),
	('b081d090-ec07-44d0-845e-43d1c2bc307d', '2020-07-05 23:34:36', 1),
	('7b43e74f-9ac7-42b2-853c-bf60ab55d815', '2020-07-06 20:25:48', 2),
	('97d97439-7266-4577-be67-d1ab50b85b16', '2020-07-06 20:48:00', 2),
	('b55dbaf1-d1a1-41a8-b5f0-8f1aa74b0bef', '2020-07-06 20:53:15', 1),
	('2196b6c7-575f-4e3e-b95b-f786f16a315a', '2020-07-06 20:55:53', 1),
	('9c75a097-caeb-4e1a-aac2-99fddb5406c3', '2020-07-06 22:59:04', 1),
	('b1581853-1efe-48e0-b9b9-e01d716c461b', '2020-07-06 23:39:17', 1),
	('a4d722a8-c1b6-424e-a7dc-4b84e45f2b04', '2020-07-06 23:40:50', 1),
	('36e28148-349f-4569-8e26-4c351ab71519', '2020-07-06 23:46:10', 1),
	('39ec4473-ac62-4905-9ea0-d271bdf0601f', '2020-07-08 02:26:29', 1),
	('d9253119-6a72-4df3-a532-d4f683186a1a', '2020-07-08 19:25:32', 2),
	('1f84a45a-20d7-4df1-95f7-1681577ff9b1', '2020-07-08 19:35:15', 2),
	('d3a01663-fb8a-4184-a73b-a94c93962133', '2020-07-08 19:43:02', 2),
	('962ff051-a284-4faf-84f5-559488362faf', '2020-07-08 19:56:01', 1),
	('9e6888d7-1511-48d5-93da-1c348b605175', '2020-07-11 22:30:02', 1),
	('a5f06960-2279-44b5-9c3a-4f781c9b993f', '2020-07-11 22:31:52', 1),
	('724321f6-2bf6-4085-92c1-def55308efda', '2020-07-11 23:16:28', 1),
	('f533b943-98af-42e0-83bb-ff1136023393', '2020-07-11 23:56:29', 1),
	('d97ab096-f521-4fb8-8e6e-3699ef15e95e', '2020-07-12 22:10:31', 1),
	('7f864f54-fd68-4f9f-b165-9f9ec6a0766e', '2020-07-12 23:51:28', 1),
	('6fa95687-9ea6-450e-8438-600ccbf62ad8', '2020-07-13 00:02:52', 1),
	('39f0c0bb-33e6-43bc-b167-30ffc110f283', '2020-07-13 00:33:31', 1),
	('05113312-826e-4cbf-80fd-16c656ec4754', '2020-07-13 00:35:29', 1),
	('3b955c20-dddd-41d9-862b-94ebf9ed64b8', '2020-07-13 18:24:01', 1),
	('0d81b1bb-3934-4ec1-9baa-b1d77bc2f8a6', '2020-07-13 18:43:58', 1),
	('044dc73d-8227-4f00-9f2e-0f6a355c4f28', '2020-07-15 00:36:40', 1),
	('80d0948a-26e3-424e-baf4-c3d025b16402', '2020-07-15 00:36:40', 1),
	('d730786b-1ea7-4df6-98a8-164f4f30ee10', '2020-07-15 15:56:53', 2),
	('5772a99c-2b71-4842-bc66-e8df9335b0dd', '2020-07-15 15:56:53', 2),
	('0e49cbb4-358f-4be2-aa16-d44fc9b6057e', '2020-07-15 18:44:49', 1),
	('e5d72990-d352-4ebb-8c4d-4d007c81c9ba', '2020-07-17 22:12:55', 1),
	('5962582f-bb63-47d3-9289-99a8c08ed9be', '2020-07-18 00:08:48', 1),
	('2beb8baa-c100-49be-a587-8f47f488f312', '2020-07-18 00:10:24', 1),
	('d9d75815-5ed4-41d2-9b16-eae1a7d09b44', '2020-07-18 21:52:59', 1),
	('7f34ff8f-e966-402b-b278-096798550937', '2020-07-18 21:56:37', 1),
	('29469dde-3946-4285-a776-519f7bf1f7cd', '2020-07-18 21:59:09', 1),
	('665a6777-02dc-410d-85ca-6b9f047380e7', '2020-07-19 22:19:18', 1),
	('5880726c-664d-421e-89da-62c5d35351aa', '2020-07-19 22:31:07', 1),
	('2f9bc27a-5e9a-4b13-afe6-79ae0e367afc', '2020-07-19 22:32:16', 1),
	('25f1dd6d-1735-4c45-a838-519ff77e2221', '2020-07-20 18:31:06', 1),
	('ae14ad0b-e201-408b-bf93-518b5c55063b', '2020-07-20 18:33:43', 1),
	('53e357ed-b1a6-4d75-9d46-faa99a2a122a', '2020-07-20 18:36:16', 1),
	('0529c53e-7a44-4d6a-9516-e8bd14605bce', '2020-07-20 18:36:31', 1),
	('bd6ff7a5-1273-40f3-b069-44185f17f565', '2020-07-20 18:40:27', 1),
	('b84fc8ee-faf6-4465-9965-54f475e6d9ca', '2020-07-20 18:41:34', 1),
	('cbc8c3af-af42-4243-8000-2708d0a037d8', '2020-07-20 18:45:06', 1),
	('8a2b3f82-4748-44ff-970e-deb654481fc5', '2020-07-20 18:48:09', 1),
	('b9cc464b-68cc-4141-8760-e70ecb204d23', '2020-07-20 18:49:54', 1),
	('9fa029d1-8df9-4ccf-914e-e54a5b2fad51', '2020-07-20 18:50:52', 1),
	('38992d6a-359c-4381-a4fc-bc78152811ef', '2020-07-20 18:52:05', 1),
	('ab8c1567-dd89-4078-aae4-e212582521b6', '2020-07-20 18:54:37', 1),
	('0bb1f597-71f2-49ec-845a-1d1733caa780', '2020-07-20 19:01:05', 1),
	('2f7c7b32-f1c1-44de-b8c5-2688a62d191c', '2020-07-20 19:02:07', 1),
	('b1025959-c5b9-443d-8127-95830107e292', '2020-07-20 19:13:41', 1),
	('ea328d76-e427-4b36-92af-3f6f8782fffc', '2020-07-20 19:47:27', 1),
	('58807ce4-79ea-4019-9112-833f05843022', '2020-07-20 20:11:48', 1),
	('9144fd07-80bf-47f2-a78a-6703a305c66b', '2020-07-20 20:56:16', 1),
	('0899c2e5-0dcc-4410-a627-ec351f3c2036', '2020-07-20 20:59:43', 1),
	('fcb3f5ed-9875-4902-92c8-eafcf4fc112e', '2020-07-21 00:25:50', 1),
	('8c0f0416-0fd1-4c76-8472-0f6bc5a6bb15', '2020-07-21 01:12:22', 1),
	('5114f691-6ee5-4d2a-a583-b4bc1dc8c482', '2020-07-21 02:35:01', 1),
	('87fc8ea0-d768-4263-8e01-0ee1f4636054', '2020-07-21 02:37:39', 1),
	('96838e4f-2206-4775-b24d-af8a80ae288d', '2020-07-21 02:40:01', 1),
	('4f17b190-6795-424c-8b09-403327d88bd0', '2020-07-21 14:34:27', 1),
	('7e027015-8879-4f07-b7eb-c34fd7fea6f3', '2020-07-21 14:34:59', 1),
	('350c956f-7b44-4529-aa90-ec4fea683b23', '2020-07-21 15:55:16', 1),
	('f1979518-7931-4c39-872a-c065a9b5b086', '2020-07-21 15:57:46', 1),
	('0fa941e3-442f-4410-9943-509cd2671450', '2020-07-21 16:06:40', 1),
	('bc866fe0-20eb-4de7-8c44-bb9d63fcbfbd', '2020-07-21 16:39:22', 1),
	('46a7b618-134a-4da5-b4aa-843a8e1d6ea3', '2020-07-21 16:43:42', 1),
	('8f97b7b9-3c3b-4e70-a51e-075516c14007', '2020-07-21 16:45:27', 1),
	('0ee8013d-626e-4b97-b3a5-40edc8f55770', '2020-07-21 16:48:54', 1),
	('58919e90-1e1d-407f-8d38-59f4b81d9627', '2020-07-21 17:26:21', 1),
	('ba8fbdf8-3f8e-42ae-8f8b-6310b1003b81', '2020-07-22 22:28:43', 1),
	('26e8e6db-b997-428a-9a5f-ab8ba5c0f3d1', '2020-07-22 22:39:11', 1),
	('c1836756-a60b-4cd6-9c10-29a5e8e5f24a', '2020-07-22 22:41:20', 1),
	('dd83c204-972d-4dac-b44f-3921e55d48a4', '2020-07-23 18:53:47', 1),
	('2b6ab542-4be3-4cd1-b82e-1bf8243e2873', '2020-07-23 19:07:04', 1),
	('ef37f54d-a5ff-4960-ba15-20539e5832fe', '2020-07-23 19:07:52', 1),
	('2ed06fb2-e2b7-49dc-a84f-5c4ac399952c', '2020-07-23 19:20:36', 1),
	('e1c0ebdf-7a78-41ef-8fde-8299d4cd3f27', '2020-07-24 20:48:43', 1),
	('1b6789f2-f90b-4029-a5bf-0c0972d053aa', '2020-07-26 21:58:11', 1),
	('831415f5-031c-49b4-9052-5745002b39bc', '2020-08-18 18:25:14', 2),
	('980ff9ec-2c58-47a2-8e2b-1bd08571155f', '2020-08-18 18:28:23', 2),
	('461493ec-2264-4d80-90f4-3b181a749268', '2020-08-19 14:25:37', 3),
	('31129a19-a5e9-4615-85d0-a2209cd1dfcf', '2020-08-20 19:14:50', 2),
	('5b635989-4cec-4a87-b717-6cb4bf7f3fe7', '2020-08-20 19:49:26', 3),
	('d5d7f972-2258-4d2e-9e10-8ace163ff849', '2020-08-20 20:54:58', 3),
	('8448979e-5e74-4d9c-abac-21527b746300', '2020-10-17 23:30:33', 3),
	('08b37392-33a0-41b4-8f6a-b525faced0c4', '2020-10-19 22:10:22', 3),
	('2d4fe410-a852-4f65-9642-c10e02a041c5', '2020-10-19 23:45:29', 3),
	('9f915741-0949-4d14-a9e7-064eef9dfde0', '2020-10-21 00:43:53', 3),
	('748784be-efb2-4d92-9842-3aa599242c94', '2020-10-21 00:46:01', 3),
	('fd9882c7-1294-446f-a904-10314fc8c6b9', '2020-10-21 00:53:35', 3),
	('99717f9e-ac1e-4c05-9a99-6f144743c63c', '2020-10-21 01:05:50', 3),
	('c2b7a8bc-972d-45a5-a826-77abe7d4906d', '2020-10-21 01:42:37', 3),
	('657d45f6-de9c-4144-b2d8-9f37e0b4f25b', '2020-10-21 15:58:13', 3),
	('8f96cc7c-7225-4fc0-8af9-228a6caa4982', '2020-10-21 16:02:31', 3),
	('32c54914-1f60-4b6b-a919-05c12693a0d3', '2020-10-23 19:50:12', 3),
	('0897124a-38af-46e3-89bc-2bba1ebb432e', '2020-10-23 19:50:40', 3),
	('6fd3723f-7001-41af-8297-186ad6634ac7', '2020-10-24 20:53:04', 3),
	('8e464144-9633-407a-9c1a-59e41464d618', '2020-10-25 19:42:28', 3),
	('cd23acd8-f304-4f11-8ae8-dba521150d55', '2020-10-25 21:14:59', 3),
	('a255ab76-0f1f-4e24-b87c-7a79b7126d7a', '2020-10-27 22:17:34', 3),
	('07e17d87-ce57-4488-ac0d-c3620e24b8c6', '2020-10-27 22:18:09', 3),
	('dce97b53-8751-4674-a459-df354c39496e', '2020-10-28 13:55:48', 3),
	('86162ecc-f3a2-4653-9f67-f439f4b900c0', '2020-10-28 14:56:04', 3),
	('cb86639d-e8b9-48a0-ae0d-881d0c9e77f8', '2020-10-28 15:27:35', 3),
	('68faeec2-6756-493e-8748-bc481e89d577', '2020-10-29 22:18:27', 3),
	('30ea3b18-23ac-4b52-b245-1587034a1f8b', '2020-10-30 19:32:05', 3),
	('ca141251-aedd-4cde-af03-043fc4befb03', '2020-10-30 20:52:23', 3),
	('e69a581c-7f85-4634-a399-81154eea1e0f', '2020-10-30 21:10:32', 3),
	('6ad3cf3f-43df-4b3f-8710-419bdfdb958b', '2020-10-31 23:10:11', 3),
	('2e41d898-c738-42cb-9c30-b58f86d32957', '2020-11-01 00:51:11', 3),
	('504d419e-5c00-432a-a279-add7648d03b9', '2020-11-02 20:17:14', 3),
	('a48a9524-2612-4136-ae00-b11c1c37f5e6', '2020-11-02 23:27:35', 3),
	('0e4b8cdd-6622-4fdc-8797-31a5c15ca3bf', '2020-11-03 00:32:03', 3),
	('04586d6b-c990-4639-892c-486b4f3c3936', '2020-11-03 02:03:30', 3),
	('1973b615-4f5f-4d33-a3dc-e49f93327a45', '2020-11-03 13:18:07', 3),
	('dbf5a848-69c6-4cc1-8b3d-3cddf33b135c', '2020-11-03 15:27:14', 3),
	('d7d68d19-8213-435e-bec5-3efbe0481172', '2020-11-03 23:23:07', 3),
	('df13616d-2fb3-4a8c-aa5e-ba48d3f5d3f3', '2020-11-18 00:06:48', 3),
	('69e56405-e4d0-46c5-8b64-802ad3214f7d', '2020-11-20 21:24:33', 3),
	('30debdfe-3634-47c0-ab78-c01b7b99a1d4', '2020-11-22 22:31:15', 3),
	('fff38812-5250-4010-a507-c79b42270814', '2020-11-22 23:17:26', 3),
	('120fb160-927a-4efe-aca7-c23629e31d73', '2020-11-23 00:21:03', 3),
	('0d5c4c71-c5cd-4ebb-b2a1-0df33d107ef7', '2020-12-03 22:20:03', 3),
	('687f68a9-68f5-48ac-bbde-2ac9310514a8', '2020-12-04 19:58:52', 3),
	('d8b7c42b-102b-482c-8b3f-64a296ad34a6', '2020-12-04 20:28:44', 3),
	('0d7dc724-ab65-4726-b22a-3a705ddb6a39', '2020-12-04 20:53:04', 3),
	('8cba5e56-7a39-4ef7-bb23-272aa038f70c', '2020-12-04 20:54:12', 3),
	('e20c6819-18ff-444c-9de9-4bd5c8bb8940', '2021-03-20 18:08:17', 3),
	('3b69adb8-048d-49ee-9265-1a64c65209e4', '2021-03-30 14:21:48', 3),
	('0597f1c8-570f-4081-8490-a42ca5ea9c3c', '2021-03-30 14:52:08', 3),
	('240d3979-b41b-41b0-8d67-ec00be358fa0', '2021-03-31 14:34:45', 3),
	('178dfc93-f9e9-496f-80df-526633a7ea15', '2021-04-02 01:17:57', 3),
	('90fb5558-736a-419b-9d49-d1cf749a509b', '2021-04-03 15:11:19', 3),
	('2c85249e-861c-419f-9835-6fe08b0ae2fe', '2021-04-05 00:34:01', 3),
	('f8d7b920-c664-48b0-af7e-edbf1074cd7d', '2021-04-05 17:33:56', 3),
	('412589f2-cda3-4cfa-9b58-a14bb1472cab', '2021-04-05 18:14:40', 3),
	('53deb839-bbfc-4e48-9c32-8133b32dbbc4', '2021-04-06 17:55:36', 3),
	('97ee583a-cdf7-4625-be39-8eeb89a27cb3', '2021-04-07 15:14:27', 3),
	('26ffda14-17ac-4585-a2d1-ae57808b68e3', '2021-04-28 01:02:32', 3),
	('d05000be-640d-4105-b772-34081c250af0', '2021-04-28 01:05:25', 3),
	('1588a66b-b36e-4d63-8d29-da3626d83ae8', '2021-05-01 01:30:21', 3),
	('42164371-7ce0-4721-b848-f0ed00c4ac13', '2021-05-01 01:46:57', 3),
	('6114fb1f-4b91-44a5-9d51-efea28650a59', '2021-09-02 15:16:07', 3),
	('ed01e27e-3ead-41a0-9e2c-da314cbd4c0c', '2021-09-02 23:34:06', 3),
	('416a6069-6d84-4674-909d-38f21d20710c', '2021-09-03 01:15:12', 3),
	('99d93327-2264-44d6-a353-d4f461d1e4c6', '2021-09-04 00:00:13', 3),
	('5c8bc8e0-332a-4010-a38d-dbbffd96548b', '2021-09-10 02:19:11', 3),
	('310a5923-2993-4881-bcaa-517d2bc9e480', '2021-09-12 00:34:03', 3),
	('40515b02-be66-4825-94f5-c1fd7089d918', '2021-09-12 01:03:25', 3),
	('32ca7246-81fe-45aa-bc93-c3debbd73c99', '2021-09-12 23:47:50', 3),
	('b33e6278-2027-4e0a-b46f-5b00b7dd5772', '2021-09-12 23:48:20', 3),
	('097fed3f-9458-4469-be91-d6f6306d602b', '2021-09-12 23:48:39', 3),
	('36e29e29-14ae-4ce9-ac6a-ea824cfbebcf', '2021-09-12 23:48:44', 3),
	('bbb4d5d8-f17d-49b8-83ff-a1258d7cb167', '2021-09-12 23:48:52', 3),
	('868977e4-71c8-450c-8fbb-dc6a5b6fa862', '2021-09-12 23:50:54', 3),
	('3fa512b7-4668-4285-b909-732ad614b484', '2021-09-12 23:50:59', 3),
	('78953134-6cd9-4a73-a353-2c900dece953', '2021-09-12 23:53:46', 3),
	('a32429b5-5e70-4668-bfb0-ed0a696240b7', '2021-09-12 23:54:02', 3),
	('2b5038de-4a45-4505-a6c3-45fe64fc40d1', '2021-09-13 00:27:52', 3),
	('ef61c868-decd-4f2a-bbe6-e8e336d02887', '2021-09-13 01:21:18', 3),
	('37be5a57-f47f-4ef1-8607-d671eb994895', '2021-09-13 23:07:46', 3),
	('29685faa-e76e-463e-b92e-474bee9db8e4', '2021-09-13 23:15:22', 3),
	('2dbc5367-cb39-44cf-96b8-6808fba1dd20', '2021-09-14 00:28:53', 3),
	('793fc93c-fc04-4540-b2f8-6a308ae59512', '2021-09-14 02:57:04', 3),
	('b7f798f9-30e9-4d97-8282-0f1046fe7ff1', '2021-09-14 21:15:37', 3),
	('ead7ed0b-3ecf-4523-b817-17fe14644402', '2021-09-14 23:08:02', 3),
	('265849fc-acdb-4a38-9309-f352956772f8', '2021-09-14 23:12:25', 3),
	('c378db0e-9891-47a4-a80b-a9871cfa0d18', '2021-09-14 23:20:04', 3),
	('c9321a48-6fc5-439e-b287-1cf8eaf85ec3', '2021-09-14 23:34:54', 3),
	('7c9e3838-b959-4386-bbdf-09486d023df2', '2021-09-14 23:36:03', 3),
	('84650813-0b7c-44a0-8218-1519129419f5', '2021-09-14 23:37:18', 3),
	('731e65dd-8ad1-4829-b67d-86e1f70a86cb', '2021-09-14 23:54:52', 3),
	('3477adb0-f795-498d-b579-cee5155363ed', '2021-09-15 01:31:52', 3),
	('957fb828-e2d4-4019-9bd2-31e473116f00', '2021-09-15 04:06:28', 3),
	('e584eb2e-970a-4e89-ba63-243fdf432278', '2021-09-15 23:17:09', 3),
	('2df86ae6-8b62-49b0-9773-746a4e59ccad', '2021-09-15 23:40:42', 3),
	('eb4837c8-b41c-45d9-afa8-02caf5865b58', '2021-09-15 23:44:20', 3),
	('3f12d4d9-a30f-4d08-b8c3-66af5066cf79', '2021-09-19 00:33:21', 3),
	('d9a29d16-a19c-4100-87cb-269b87183427', '2021-09-21 02:52:54', 3),
	('05f62c0c-a95b-491d-b80f-fdecedd889c4', '2021-09-21 03:39:52', 3),
	('a38a4069-3777-4d36-a9c3-d0c78b97943d', '2021-09-21 23:13:16', 3),
	('32446304-0884-4b7e-aef0-0c8c2c5e1cb4', '2021-09-22 00:54:51', 12),
	('bb8a9650-ec38-4f5b-a7f4-973a4c2d9a43', '2021-09-22 01:41:51', 3),
	('0f67d02e-a7d5-4a73-bc76-cc8a54811ba7', '2021-09-22 01:42:46', 13),
	('175e1914-9052-4eae-a3e3-73f18bb9e691', '2021-09-22 18:10:34', 14),
	('f56d8ef4-5e60-40b0-aa8b-37b53d6db84d', '2021-09-22 18:14:05', 14),
	('f0044d8b-24ac-4cb8-afc9-848a2147446b', '2021-09-22 18:52:20', 15),
	('56898d1a-db8e-48e2-8cf6-88df2f22af45', '2021-09-22 20:21:31', 3),
	('2052b894-c614-4616-9457-0cf10fe2a86a', '2021-09-26 23:57:48', 3),
	('443bac2f-7b79-4498-917a-07607b44b41c', '2021-09-29 02:10:14', 3),
	('2fe99ff6-6905-4943-8e1b-1b7386df5d19', '2021-09-29 23:30:26', 3),
	('898868a5-a62c-462a-8cdd-b71ab103c649', '2021-09-30 02:01:24', 3),
	('b0792055-1ff6-431e-a218-98fa6789b11a', '2021-09-30 02:02:35', 3),
	('b7a214e2-de31-4fa7-bee0-c631d95e13aa', '2021-09-30 02:08:48', 3),
	('c0cab032-771b-4362-9cd0-c8eb0f9a0c5a', '2021-09-30 02:12:19', 3),
	('17e99d56-be25-4fca-9e5f-77316448960c', '2021-09-30 02:43:43', 3),
	('56fff9df-7f26-4d06-98c1-5c0f29550c54', '2021-10-01 08:24:05', 3),
	('d17f61fd-5e96-4061-8e00-186d20d5ab52', '2021-10-02 01:55:33', 3),
	('8738e40f-209f-4c80-91a7-a3cb283b1f8b', '2021-10-02 02:58:24', 3),
	('2d18da05-6392-4d67-bf74-943fbce61ee9', '2021-10-04 02:13:52', 3),
	('70a0b896-e270-4508-9a2b-33048e8b812b', '2021-10-04 22:30:19', 3),
	('2d19ba97-aec9-4062-9c88-87eb5dc02c88', '2021-10-06 00:30:35', 3),
	('93dabe8d-4a0e-450a-9f38-230b9b6164d7', '2021-10-06 01:37:16', 3),
	('704610df-a359-430a-83ce-6ebd5f7ebcec', '2021-10-06 01:55:45', 3),
	('a9adeb48-deb3-407c-b3cf-6d788da88f33', '2021-10-06 02:30:32', 3),
	('c790f77b-625e-4f3f-9de1-ed0c09d93e8b', '2021-10-06 22:17:38', 3),
	('5b9ac08d-a456-412c-80b0-f362226265ef', '2021-10-06 22:53:43', 3),
	('0ea1128b-0a76-45aa-ba73-7ec2758e4e7e', '2021-10-07 00:47:40', 3),
	('dd8b9aab-4a2e-4920-98f6-e540777d3be1', '2021-10-07 00:52:30', 3),
	('b6313acc-4952-4e22-a7cd-cd865439bf65', '2021-10-07 00:53:37', 14),
	('6e63ceef-3a79-4149-a625-26e4581071fe', '2021-10-07 01:00:18', 3);
/*!40000 ALTER TABLE `refresh_tokens` ENABLE KEYS */;

-- Dumping structure for table charity_db.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_DESC` text,
  `ROLE_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `UK_qfo9r93pug5nrwxcqhps55jvn` (`ROLE_NAME`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.roles: 2 rows
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`ROLE_ID`, `ROLE_DESC`, `ROLE_NAME`) VALUES
	(1, NULL, 'ROLE_ADMIN'),
	(2, NULL, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table charity_db.shipping
DROP TABLE IF EXISTS `shipping`;
CREATE TABLE IF NOT EXISTS `shipping` (
  `SHIPPING_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SHIPPING_AMT` varchar(100) DEFAULT NULL,
  `SHIPPING_NAME` varchar(100) DEFAULT NULL,
  `SHIPPING_STS` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`SHIPPING_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.shipping: 0 rows
DELETE FROM `shipping`;
/*!40000 ALTER TABLE `shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping` ENABLE KEYS */;

-- Dumping structure for table charity_db.students
DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `STUDENTS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `AADHAAR_NUMBER` varchar(100) DEFAULT NULL,
  `ADDRESS` text,
  `CITY` varchar(100) DEFAULT NULL,
  `CLASS_NAME` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  `FATHER_NAME` varchar(100) DEFAULT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `GRADE` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `MOTHER_NAME` varchar(100) DEFAULT NULL,
  `PHONE` varchar(100) NOT NULL,
  `SCHOOL_NAME` text,
  `STATE` varchar(100) DEFAULT NULL,
  `STUDENT_STS` bit(1) NOT NULL,
  `STUDENTS_SUB_ID` int(11) DEFAULT NULL,
  `ZIPCODE` varchar(100) DEFAULT NULL,
  `STUDENTS_ID_NUMBER` int(11) DEFAULT NULL,
  PRIMARY KEY (`STUDENTS_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.students: 3 rows
DELETE FROM `students`;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`STUDENTS_ID`, `CREATED_DATE`, `UPDATED_DATE`, `AADHAAR_NUMBER`, `ADDRESS`, `CITY`, `CLASS_NAME`, `COUNTRY`, `FATHER_NAME`, `FIRST_NAME`, `GRADE`, `LAST_NAME`, `MOTHER_NAME`, `PHONE`, `SCHOOL_NAME`, `STATE`, `STUDENT_STS`, `STUDENTS_SUB_ID`, `ZIPCODE`, `STUDENTS_ID_NUMBER`) VALUES
	(4, '2019-08-26 20:39:14', '2019-10-26 01:01:55', '98765432', 'Camp', 'Amravati', 'Fourth', 'India', 'akhtar', 'amar', 'A', 'sharif', 'biquis', '9876543210', 'Paradise', 'Maharashtra', b'1', 789, '411048', 987),
	(5, '2019-08-26 20:46:11', '2019-10-26 00:19:30', '7894561230', 'camp', 'Amravati', '4', 'India', 'akhtar', 'nagma', 'A', 'sharif', 'nagma', '9876543210', 'Allana', 'Maharashtra', b'1', 987, '411048', 789),
	(6, '2019-10-25 22:16:52', '2020-09-07 15:44:44', '9876543210', 'camp,Amravati, 444604', 'Amravati', '5th', 'India', 'begum', 'ahmar', 'A', 'sharif', 'bilquis', '9876543210', 'St Thomas English', 'Maharashtra', b'1', 123, '444602', 123);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Dumping structure for table charity_db.student_stationary
DROP TABLE IF EXISTS `student_stationary`;
CREATE TABLE IF NOT EXISTS `student_stationary` (
  `STUDENT_STATIONARY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `STUDENT_STATIONARY_STS` bit(1) NOT NULL,
  `STUDENT_STATIONARY_TYPE` varchar(100) NOT NULL,
  `STUDENTS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`STUDENT_STATIONARY_ID`),
  UNIQUE KEY `UKqoovw0rs9l8don0sgf4ege3ct` (`STUDENT_STATIONARY_TYPE`),
  KEY `FK9m2ruwl37ocfphwqycb0hd78y` (`STUDENTS_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.student_stationary: 1 rows
DELETE FROM `student_stationary`;
/*!40000 ALTER TABLE `student_stationary` DISABLE KEYS */;
INSERT INTO `student_stationary` (`STUDENT_STATIONARY_ID`, `CREATED_DATE`, `UPDATED_DATE`, `STUDENT_STATIONARY_STS`, `STUDENT_STATIONARY_TYPE`, `STUDENTS_ID`) VALUES
	(1, '2019-03-03 00:34:03', '2019-03-03 00:34:05', b'1', 'BOOKS', 1);
/*!40000 ALTER TABLE `student_stationary` ENABLE KEYS */;

-- Dumping structure for table charity_db.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `CITY` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  `EMAIL_ID` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `PHONE` varchar(100) NOT NULL,
  `PROFILE_PICTURE` text,
  `PROFILE_PICTURE_URL` text,
  `STATE` varchar(100) DEFAULT NULL,
  `USER_STS` bit(1) NOT NULL,
  `ZIPCODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `UKq7m1l7d7rjcxryb6bs64nmord` (`EMAIL_ID`),
  UNIQUE KEY `UKig284flnsskg3l7df8ty1d9o9` (`PHONE`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.users: 7 rows
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`USER_ID`, `CREATED_DATE`, `UPDATED_DATE`, `ADDRESS`, `CITY`, `COUNTRY`, `EMAIL_ID`, `FIRST_NAME`, `LAST_NAME`, `PASSWORD`, `PHONE`, `PROFILE_PICTURE`, `PROFILE_PICTURE_URL`, `STATE`, `USER_STS`, `ZIPCODE`) VALUES
	(1, '2019-02-21 21:54:36', '2019-07-27 16:16:34', 'Camp Amravati 444602', 'Amravati', 'India', 'ahmar@gmail.com', 'ahmar', 'sharif', '$2a$10$qfS/haB8j6lSovbAaUKPJO9FdAZHfK7fZFm7DPVIxDIAFJ3Sw2gpe', '457876543', NULL, NULL, 'Maharashtra', b'1', '444602'),
	(2, '2019-02-21 21:56:51', '2019-07-06 00:20:29', 'amravati', 'Amravati', 'India', 'ahmarsharif@gmail.com', 'ahmar', 'SHAREEF', '$2a$10$qfS/haB8j6lSovbAaUKPJO9FdAZHfK7fZFm7DPVIxDIAFJ3Sw2gpe', '987654321', NULL, NULL, 'Maharashtra', b'1', '444602'),
	(3, '2019-06-26 19:17:11', '2020-10-12 01:06:24', 'Pune', 'Amravati', 'India', 'ahmarssharif@gmail.com', 'ahmar', 'Sharif', '$2a$10$qfS/haB8j6lSovbAaUKPJO9FdAZHfK7fZFm7DPVIxDIAFJ3Sw2gpe', '9028356525', 'file:/E:/Desktop/Spring_boot_charity_app/images/User-Profile/3/mypic.JPG', 'http://localhost:8081/images/User-Profile/3/mypic.JPG', 'Maharashtra', b'1', '411048'),
	(7, '2019-06-29 19:12:57', '2019-06-29 19:12:57', NULL, NULL, NULL, 'praful@gmail.com', 'praful', 'tidke', '$2a$10$il50qZiqOwKtmC3VdBrp..jjP4OdZkvosVTbbsv1GOnm.dT2ionN6', '9876543210', NULL, NULL, NULL, b'1', NULL),
	(10, '2019-07-26 20:11:32', '2019-07-26 20:11:32', NULL, NULL, NULL, 'nagma@gmail.com', 'Nagma', 'Sharif', '$2a$10$H5swoO/g0DkxHKWYL0o.XecpmagrU8OY4iHTwxkfl4eYYOctAUYQW', '0902835652', NULL, NULL, NULL, b'1', NULL),
	(15, '2020-09-27 18:52:07', '2020-09-27 18:54:14', 'badnera', 'Amravati', 'India', 'abdulsakeem@gmail.com', 'abdul', 'sakeem', '$2a$10$ZI9Q7wG3Ie9AGhGRQVoH..WMBlQCkQzgbvgSjXEL.hpX6wy2ax.s2', '9595006008', 'E:\\Desktop\\Spring_boot_charity_app\\images\\15\\mypic.JPG', NULL, 'Maharashtra', b'1', '444702'),
	(14, '2020-09-27 18:10:09', '2020-09-27 18:12:21', 'Badnera , Amravati 444701', 'Amravati', 'India', 'waqar@gmail.com', 'waqar', 'nazish', '$2a$10$lFmZFW8a9L5.fsMfyPoTfur1KPqz3BgVBBHPig4n2QGutu.RDgsHe', '9822933122', 'E:\\Desktop\\Spring_boot_charity_app\\images\\14\\mypic.JPG', NULL, 'Maharashtra', b'1', '444701');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table charity_db.user_images
DROP TABLE IF EXISTS `user_images`;
CREATE TABLE IF NOT EXISTS `user_images` (
  `FILE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(255) DEFAULT NULL,
  `FILE_PATH` varchar(255) DEFAULT NULL,
  `FILE_SIZE` bigint(20) DEFAULT NULL,
  `FILE_TYPE` varchar(255) DEFAULT NULL,
  `IMG_STS` bit(1) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`FILE_ID`),
  KEY `FKmqsnsolvhjjsa63et6bj7c745` (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.user_images: 0 rows
DELETE FROM `user_images`;
/*!40000 ALTER TABLE `user_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_images` ENABLE KEYS */;

-- Dumping structure for table charity_db.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK61x3nvxbu49xad90tp9f8kmo1` (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table charity_db.user_roles: 15 rows
DELETE FROM `user_roles`;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`USER_ID`, `ROLE_ID`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2),
	(10, 2),
	(11, 2),
	(12, 2),
	(13, 2),
	(14, 2),
	(15, 2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
