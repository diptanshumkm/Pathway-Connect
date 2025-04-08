-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.4.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for springboot_db
CREATE DATABASE IF NOT EXISTS `springboot_db` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `springboot_db`;

-- Dumping structure for table springboot_db.availability_slot
CREATE TABLE IF NOT EXISTS `availability_slot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `mentor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnpmvprk95337lqoyft0xxpf30` (`mentor_id`),
  CONSTRAINT `FKnpmvprk95337lqoyft0xxpf30` FOREIGN KEY (`mentor_id`) REFERENCES `mentor_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.availability_slot: ~0 rows (approximately)

-- Dumping structure for table springboot_db.mentor_table
CREATE TABLE IF NOT EXISTS `mentor_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `professional_detail_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4btlm19w07ule9gkie88v29d1` (`professional_detail_id`),
  UNIQUE KEY `UK46kx2t0yraqqw6oqfgskpeoml` (`user_id`),
  CONSTRAINT `FKbghar9u0iva92rdfnvx7mhfyp` FOREIGN KEY (`professional_detail_id`) REFERENCES `professional_table` (`id`),
  CONSTRAINT `FKxbtut0p7mau5vibpjbtrrlk9` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.mentor_table: ~1 rows (approximately)
INSERT INTO `mentor_table` (`id`, `professional_detail_id`, `user_id`) VALUES
	(1, 1, 5);

-- Dumping structure for table springboot_db.past_companies
CREATE TABLE IF NOT EXISTS `past_companies` (
  `professional_id` bigint(20) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  KEY `FKgr3v6y9q5xan89vv1d38cb63e` (`professional_id`),
  CONSTRAINT `FKgr3v6y9q5xan89vv1d38cb63e` FOREIGN KEY (`professional_id`) REFERENCES `professional_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.past_companies: ~3 rows (approximately)
INSERT INTO `past_companies` (`professional_id`, `company_name`) VALUES
	(1, 'Infosys'),
	(1, 'Wipro'),
	(1, 'TCS');

-- Dumping structure for table springboot_db.professional_table
CREATE TABLE IF NOT EXISTS `professional_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_company` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `year_of_experience` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.professional_table: ~1 rows (approximately)
INSERT INTO `professional_table` (`id`, `current_company`, `education`, `year_of_experience`) VALUES
	(1, 'TechCorp Pvt. Ltd.', 'M.Tech in Computer Science', 5);

-- Dumping structure for table springboot_db.rating_review_table
CREATE TABLE IF NOT EXISTS `rating_review_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rating` int(11) NOT NULL,
  `review` varchar(255) DEFAULT NULL,
  `mentor_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5dvm802x3g71dw7ky22gcqs9t` (`mentor_id`),
  KEY `FKk3fkjs32iil89w1w50gv818em` (`user_id`),
  CONSTRAINT `FK5dvm802x3g71dw7ky22gcqs9t` FOREIGN KEY (`mentor_id`) REFERENCES `mentor_table` (`id`),
  CONSTRAINT `FKk3fkjs32iil89w1w50gv818em` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.rating_review_table: ~0 rows (approximately)

-- Dumping structure for table springboot_db.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.students: ~4 rows (approximately)
INSERT INTO `students` (`id`, `age`, `email`, `name`) VALUES
	(1, 22, 'shivam@eg.com', 'shivam'),
	(2, 25, 'Diptanshu@eg.com', 'Diptanshu'),
	(3, 5, 'ram@eg.com', 'ram'),
	(4, 50, 'dhaam@eg123.com', 'naam');

-- Dumping structure for table springboot_db.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.user: ~0 rows (approximately)
INSERT INTO `user` (`id`, `email`, `name`) VALUES
	(1, 'shivam@eg.com', 'shivam');

-- Dumping structure for table springboot_db.user_table
CREATE TABLE IF NOT EXISTS `user_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `role` enum('MENTEE','MENTOR') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table springboot_db.user_table: ~5 rows (approximately)
INSERT INTO `user_table` (`id`, `email`, `name`, `phone`, `profile_picture`, `role`) VALUES
	(1, 'rohan.sharma@example.com', 'Rohan Sharma', '9876543210', 'https://example.com/images/rohan.jpg', 'MENTOR'),
	(2, 'rohan.sharma@example.com', 'Rohan Sharma', '9876543210', 'https://example.com/images/rohan.jpg', 'MENTEE'),
	(3, 'diptanshu.mishra@example.com', 'Diptanshu Mishra', '9876543210', 'https://example.com/images/diptanshu.jpg', 'MENTEE'),
	(4, 'diptanshu.mishra@example.com', 'Divang Sharma', '9876543210', 'https://example.com/images/diptanshu.jpg', 'MENTEE'),
	(5, 'ravi.kumar@example.com', 'Ravi Kumar', '9876543210', 'https://example.com/profile/ravi.jpg', 'MENTOR');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
