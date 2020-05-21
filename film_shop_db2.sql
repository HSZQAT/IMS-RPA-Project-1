-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: film_shop
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CID` smallint NOT NULL,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `email` varchar(320) NOT NULL,
  `address` varchar(150) NOT NULL,
  `city` varchar(32) NOT NULL,
  `postcode` char(8) NOT NULL,
  `age` tinyint NOT NULL,
  `loyalty` tinyint(1) NOT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Arnold','Schwartz','gettothechopper@skynet.com','15 Twins Lane','California','CA4 8FL',72,1),(2,'Ricolas','Cage','ricolasc1@bunnybox.com','32 Wicker Street','Las Vegas','LV6 2IX',56,0),(3,'Katie','Winslot','queenoftheworld@titanic.co.uk','2 Rose Avenue','London','LN9 8PD',44,0),(4,'Adam','Rickman','hans.gruber@nakatomi.com','83 Snapes Road','Nottingham','NT4 4JA',19,1),(5,'Jeff','Silverblum','prof.fly@jpark.com','11 Jazz Park','Isla Nublar','IN4 2RE',67,0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OID` smallint NOT NULL,
  `CID` smallint NOT NULL,
  `Total` decimal(4,2) NOT NULL,
  PRIMARY KEY (`OID`),
  KEY `CID` (`CID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `customer` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,12.99),(2,2,5.99),(3,4,8.99),(4,1,5.39),(5,5,5.99);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_products` (
  `OID` smallint NOT NULL,
  `PID` smallint NOT NULL,
  KEY `OID` (`OID`),
  KEY `PID` (`PID`),
  CONSTRAINT `orders_products_ibfk_1` FOREIGN KEY (`OID`) REFERENCES `orders` (`OID`),
  CONSTRAINT `orders_products_ibfk_2` FOREIGN KEY (`PID`) REFERENCES `products` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `PID` smallint NOT NULL,
  `name` varchar(150) NOT NULL,
  `director` varchar(150) NOT NULL,
  `genre` varchar(32) NOT NULL,
  `release_date` date DEFAULT NULL,
  `language` varchar(32) NOT NULL DEFAULT 'English',
  `age_rating` tinyint NOT NULL,
  `price` decimal(4,2) NOT NULL,
  `loyalty_price` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Get Out','Jordan Peele','Horror','2017-03-17','English',15,8.99,8.09),(2,'Midsommar','Ari Aster','Horror','2019-07-05','English',18,10.99,9.89),(3,'Parasite','Bong Joon-Ho','Thriller','2020-02-07','Korean',15,12.99,11.69),(4,'Titanic','James Cameron','Romance','1998-01-23','English',12,5.99,5.39),(5,'Con Air','Jerry Bruckheimer','Action','1997-06-06','English',15,5.99,5.39),(6,'Ladybird','Greta Gerwig','Comedy/Drama','2018-02-16','English',15,9.99,8.99),(7,'The Room','Tommy Wiseau','Romantic Drama','2003-06-27','English',15,99.99,89.99);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 23:13:35
