-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: movies_db
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies_members`
--

DROP TABLE IF EXISTS `movies_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies_members` (
  `movie_id` int(11) NOT NULL,
  `cm_id` int(11) NOT NULL,
  `member_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`movie_id`,`cm_id`),
  KEY `cm_id` (`cm_id`),
  CONSTRAINT `movies_members_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`),
  CONSTRAINT `movies_members_ibfk_2` FOREIGN KEY (`cm_id`) REFERENCES `castmembers` (`cm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_members`
--

LOCK TABLES `movies_members` WRITE;
/*!40000 ALTER TABLE `movies_members` DISABLE KEYS */;
INSERT INTO `movies_members` VALUES (1,1,'режиссер'),(1,2,'актер'),(1,3,'актер'),(1,4,'актер'),(1,5,'актер'),(1,6,'актер'),(1,7,'актер'),(1,8,'актер'),(1,9,'актер'),(1,10,'актер'),(1,11,'актер'),(1,12,'актер'),(1,13,'актер'),(1,14,'актер'),(1,15,'актер'),(2,1,'режиссер'),(2,2,'актер'),(2,3,'актер'),(2,4,'актер'),(2,6,'актер'),(2,7,'актер'),(2,9,'актер'),(2,10,'актер'),(2,11,'актер'),(2,12,'актер'),(2,13,'актер'),(2,14,'актер'),(2,15,'актер'),(2,16,'актер'),(2,17,'актер'),(2,18,'актер'),(2,19,'актер'),(2,20,'актер'),(2,21,'актер'),(3,1,'режиссер'),(3,2,'актер'),(3,3,'актер'),(3,4,'актер'),(3,6,'актер'),(3,8,'актер'),(3,9,'актер'),(3,10,'актер'),(3,11,'актер'),(3,12,'актер'),(3,13,'актер'),(3,14,'актер'),(3,15,'актер'),(3,16,'актер'),(3,17,'актер'),(3,18,'актер'),(3,20,'актер'),(3,21,'актер'),(4,1,'режиссер'),(4,3,'актер'),(4,8,'актер'),(4,12,'актер'),(4,13,'актер'),(4,15,'актер'),(4,17,'актер'),(4,22,'актер'),(4,23,'актер'),(4,24,'актер'),(4,25,'актер'),(4,26,'актер'),(4,27,'актер'),(4,28,'актер'),(4,29,'актер'),(4,30,'актер'),(4,31,'актер'),(4,32,'актер'),(4,33,'актер'),(4,34,'актер'),(4,35,'актер'),(4,36,'актер'),(4,41,'актер'),(5,1,'режиссер'),(5,3,'актер'),(5,6,'актер'),(5,13,'актер'),(5,22,'актер'),(5,23,'актер'),(5,24,'актер'),(5,25,'актер'),(5,26,'актер'),(5,27,'актер'),(5,28,'актер'),(5,29,'актер'),(5,30,'актер'),(5,31,'актер'),(5,32,'актер'),(5,33,'актер'),(5,34,'актер'),(5,35,'актер'),(5,36,'актер'),(5,37,'актер'),(5,38,'актер'),(5,39,'актер'),(5,40,'актер'),(5,41,'актер'),(6,1,'режиссер'),(6,3,'актер'),(6,6,'актер'),(6,8,'актер'),(6,12,'актер'),(6,13,'актер'),(6,15,'актер'),(6,22,'актер'),(6,23,'актер'),(6,24,'актер'),(6,25,'актер'),(6,26,'актер'),(6,27,'актер'),(6,28,'актер'),(6,29,'актер'),(6,30,'актер'),(6,31,'актер'),(6,32,'актер'),(6,33,'актер'),(6,34,'актер'),(6,35,'актер'),(6,36,'актер'),(6,37,'актер'),(6,38,'актер'),(6,39,'актер'),(6,40,'актер'),(6,41,'актер'),(6,42,'актер'),(7,6,'актер'),(7,43,'режиссер'),(7,44,'актер'),(7,45,'актер'),(7,46,'актер'),(7,47,'актер'),(7,48,'актер'),(7,49,'актер'),(7,50,'актер'),(7,51,'актер'),(7,52,'актер'),(8,6,'актер'),(8,43,'режиссер'),(8,44,'актер'),(8,46,'актер'),(8,47,'актер'),(8,48,'актер'),(8,50,'актер'),(8,51,'актер'),(8,53,'актер'),(8,54,'актер'),(8,55,'актер'),(9,6,'актер'),(9,43,'режиссер'),(9,44,'актер'),(9,45,'актер'),(9,46,'актер'),(9,47,'актер'),(9,53,'актер'),(9,54,'актер'),(9,55,'актер'),(9,56,'актер'),(9,57,'актер'),(10,44,'актер'),(10,45,'актер'),(10,48,'актер'),(10,58,'режиссер'),(10,59,'актер'),(10,60,'актер'),(10,61,'актер'),(10,62,'актер'),(10,63,'актер'),(10,64,'актер'),(10,65,'актер');
/*!40000 ALTER TABLE `movies_members` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15 22:24:48