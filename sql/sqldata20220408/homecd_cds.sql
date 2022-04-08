-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: homecd
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cds`
--

DROP TABLE IF EXISTS `cds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `catalog_number` varchar(45) NOT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cd_location1_idx` (`location_id`),
  CONSTRAINT `fk_cd_location1` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cds`
--

LOCK TABLES `cds` WRITE;
/*!40000 ALTER TABLE `cds` DISABLE KEYS */;
INSERT INTO `cds` VALUES (1,'RCA','RCD2-2951',1),(2,'Telarc','CD-80078',1),(3,'London','414455-2',1),(4,'Chandos','Chan9048',1),(5,'Telarc','CD-80663',1),(6,'BBC','VolV No8',1),(7,'BBC','Vol19 No8',2),(8,'BBC','Vol19 No7',2),(9,'BBC','Vol 6 No 2',2),(10,'BBC','Vol 9 No 6',2),(11,'BBC','Vol 5 No 7',2),(12,'Telarc','CD-80060',3),(13,'Hungaroton','HCD 12461-2',4),(14,'Archiv','419324-2',4),(15,'Loiseau-Lyre','414338-2',4),(17,'Capriccio','10034',3);
/*!40000 ALTER TABLE `cds` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08  5:50:28
