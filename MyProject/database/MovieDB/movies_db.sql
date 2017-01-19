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

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre` varchar(20) NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'аниме'),(2,'биографический'),(3,'боевик'),(4,'вестерн'),(5,'военный'),(6,'детектив'),(7,'детский'),(8,'документальный'),(9,'драма'),(10,'исторический'),(11,'комедия'),(12,'концерт'),(13,'короткометражный'),(14,'криминал'),(15,'мелодрамма'),(16,'мистика'),(17,'музыка'),(18,'мультфильм'),(19,'мюзикл'),(20,'научный'),(21,'приключения'),(22,'реалити-шоу'),(23,'семейный'),(24,'спорт'),(25,'триллер'),(26,'ужасы'),(27,'фантастика'),(28,'фильм-нуар'),(29,'фэнтези'),(30,'эротика');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `year` year(4) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Властелин колец: Братство кольца',2001,'США'),(2,'Властелин колец: Две крепости',2002,'США'),(3,'Властелин колец: Возвращение короля',2003,'США'),(4,'Хоббит: Нежданное путешествие',2012,'США'),(5,'Хоббит: Пустошь Смауга',2013,'США'),(6,'Хоббит: Битва пяти воинств',2014,'США'),(7,'Пираты Карибского моря: Проклятие Черной жемчужины',2003,'США'),(8,'Пираты Карибского моря: Сундук мертвеца',2006,'США'),(9,'Пираты Карибского моря: На краю Света',2007,'США'),(10,'Пираты Карибского моря: На странных берегах',2011,'США');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_genre`
--

DROP TABLE IF EXISTS `movies_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies_genre` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `movies_genre_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`),
  CONSTRAINT `movies_genre_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_genre`
--

LOCK TABLES `movies_genre` WRITE;
/*!40000 ALTER TABLE `movies_genre` DISABLE KEYS */;
INSERT INTO `movies_genre` VALUES (1,21),(2,21),(3,21),(4,21),(5,21),(6,21),(7,21),(8,21),(9,21),(10,21),(1,29),(2,29),(3,29),(4,29),(5,29),(6,29),(7,29),(8,29),(9,29),(10,29);
/*!40000 ALTER TABLE `movies_genre` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `rank` int(11) NOT NULL,
  `comment` text,
  PRIMARY KEY (`review_id`),
  KEY `user_id` (`user_id`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,1,1,10,'Братство кольца - это отличная экранизация романа Толкиена о борьбе добра и зла.\nФильм снят достаточно близко к литературному варианту. Мне очень понравился фильм, как и вся серия \'Властелин колец\'.'),(2,1,4,10,'Фильмы серии \'Хоббит\' меня поразили качеством и масшабностью съёмок, несмотря на некоторые расхождения \nв событиях фильмы и книги, всё равно фильм отличный и заслуживает высокой оценки.');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `mname` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Дмитрий','Нестерчук','Александрович','ndmitrius@gmail.com','Dima'),(2,'Амаль','Кабулов','Ахметович','kabulov.amal@gmail.com','Amal'),(3,'Эдуард','Дедловский','Михайлович','eddisson@yandex.ru','Eddisson');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-15 22:17:33
