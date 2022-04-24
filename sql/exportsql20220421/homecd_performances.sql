-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: homecd
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Dumping data for table `performances`
--

LOCK TABLES `performances` WRITE;
/*!40000 ALTER TABLE `performances`
    DISABLE KEYS */;
INSERT INTO `performances`
VALUES (1, 1, 11, 'Othello', 'Placido Domingo'),
       (2, 2, 4, 'Appalacian Spring', 'Atlanta Symphony'),
       (3, 3, 8, 'The Bells OP 35', 'Ashkenazy'),
       (4, 4, 5, 'The Golden Spinning Wheel', 'Czech Philharmonic'),
       (5, 5, 2, ' Piano Concertos 1 and 2', 'Serkin and BSO'),
       (6, 6, 3, 'Symphony 4', 'BBC'),
       (7, 7, 1, 'Organ Works Fugue in C minor', 'David Goode'),
       (8, 8, 6, 'Symphony No 8', 'BBC Scottish Symphony'),
       (9, 9, 7, 'Wind Seranade K361', 'Orchestra of the Age of Enlightenment'),
       (10, 10, 7, 'Trio in E Flat K498', 'La Jolla Chamber Music'),
       (11, 11, 9, 'Death and the Maiden', 'Endellion String Quartet'),
       (12, 12, 2, 'Symphony No 5', 'Ozawa and the BSO'),
       (13, 17, 1, 'Cembalowerke', 'Armin Thalheim'),
       (14, 13, 1, 'BMV 996 BMV 997', 'Sarkozy lute-harpsicord'),
       (15, 14, 1, 'St John Passion', 'Monteverdi Choir Gardiner'),
       (16, 15, 2, 'Symphony 1 Symphony 2', 'Academy  of Ancient Music'),
       (18, 10, 10, 'Souvenir de Florance', 'La Jolla Chamber Music');
/*!40000 ALTER TABLE `performances`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-04-21 13:41:38
