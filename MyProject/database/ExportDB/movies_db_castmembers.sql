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
-- Table structure for table `castmembers`
--

DROP TABLE IF EXISTS `castmembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `castmembers` (
  `cm_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `mname` varchar(30) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`cm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `castmembers`
--

LOCK TABLES `castmembers` WRITE;
/*!40000 ALTER TABLE `castmembers` DISABLE KEYS */;
INSERT INTO `castmembers` VALUES (1,'Питер','Джексон',NULL,'1961-10-31'),(2,'Элайджа','Вуд',NULL,'1981-01-28'),(3,'Иэн','МакКеллен',NULL,'1939-05-25'),(4,'Вигго','Мортенсен',NULL,'1958-10-20'),(5,'Шон','Бин',NULL,'1959-04-17'),(6,'Орландо','Блум',NULL,'1977-01-13'),(7,'Джон','Рис-Девис',NULL,'1944-05-05'),(8,'Иэн','Холм',NULL,'1931-09-12'),(9,'Шон','Эстин',NULL,'1971-02-25'),(10,'Билли','Бойд',NULL,'1968-08-28'),(11,'Доминик','Монахэн',NULL,'1976-12-08'),(12,'Хьюго','Уивинг',NULL,'1960-04-04'),(13,'Кейт','Бланшетт',NULL,'1969-05-14'),(14,'Лив','Тайлер',NULL,'1977-07-01'),(15,'Кристофер','Ли',NULL,'1922-05-27'),(16,'Миранда','Отто',NULL,'1967-12-16'),(17,'Энди','Серкис',NULL,'1964-04-20'),(18,'Бернард','Хилл',NULL,'1944-12-17'),(19,'Брэд','Дуриф',NULL,'1950-03-18'),(20,'Карл','Урбан',NULL,'1972-06-07'),(21,'Дэвид','Уэнэм',NULL,'1965-09-21'),(22,'Мартин','Фриман',NULL,'1971-09-08'),(23,'Ричард','Армитидж',NULL,'1971-08-22'),(24,'Джеймс','Несбитт',NULL,'1965-01-15'),(25,'Кен','Скотт',NULL,'1954-10-19'),(26,'Грэм','МакТавиш',NULL,'1961-01-04'),(27,'Уильям','Кирчер',NULL,'1958-05-23'),(28,'Стивен','Хантер',NULL,'1946-03-25'),(29,'Дин','О\'Горман',NULL,'1976-12-01'),(30,'Эйдан','Тернер',NULL,'1983-06-19'),(31,'Джон','Каллен',NULL,'1928-10-18'),(32,'Питер','Хэмблтон',NULL,'1960-01-01'),(33,'Джед','Брофи',NULL,'1963-01-09'),(34,'Адам','Браун',NULL,'1980-05-29'),(35,'Сильвестр','Маккой',NULL,'1943-08-20'),(36,'Ли','Пейс',NULL,'1979-03-25'),(37,'Эванджелин','Лилли',NULL,'1979-08-03'),(38,'Микаэль','Персбрант',NULL,'1963-09-25'),(39,'Люк','Эванс',NULL,'1979-04-15'),(40,'Бенедикт','Камбербэтч',NULL,'1976-07-19'),(41,'Ману','Беннетт',NULL,'1969-10-10'),(42,'Билли','Конноли',NULL,'1942-11-24'),(43,'Гор','Вербински',NULL,'1964-03-16'),(44,'Джонни','Депп',NULL,'1963-06-09'),(45,'Джефри','Раш',NULL,'1951-07-06'),(46,'Кира','Найтли',NULL,'1985-03-26'),(47,'Джек','Девенпорт',NULL,'1973-03-01'),(48,'Кевин','МакНэлли',NULL,'1956-04-27'),(49,'Джонатан','Прайс',NULL,'1947-06-01'),(50,'Ли','Аренберг',NULL,'1962-07-18'),(51,'Макензи','Крук',NULL,'1971-09-29'),(52,'Дэвид','Бейли',NULL,'1937-12-04'),(53,'Билл','Найи',NULL,'1949-12-12'),(54,'Стеллан','Скарегард',NULL,'1951-06-13'),(55,'Том','Холландер',NULL,'1967-08-25'),(56,'Наоми','Харрис',NULL,'1976-09-06'),(57,'Чоу','Юнь-Фат',NULL,'1955-09-18'),(58,'Роб','Маршалл',NULL,'1960-10-17'),(59,'Пенелопа','Крус',NULL,'1974-04-28'),(60,'Иэн','МакШейн',NULL,'1942-09-29'),(61,'Стивен','Грэм',NULL,'1973-08-03'),(62,'Сэм','Клафлин',NULL,'1986-06-27'),(63,'Астрид','Берже-Фрисби',NULL,'1986-05-26'),(64,'Джемма','Уорд',NULL,'1987-11-03'),(65,'Кит','Ричардс',NULL,'1943-12-18');
/*!40000 ALTER TABLE `castmembers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15 22:24:49
