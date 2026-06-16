CREATE DATABASE  IF NOT EXISTS `member_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `member_shop`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: member_shop
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT '1000.00',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'teacher','1234','teacher@example.com','ADMIN',999204.00,'2026-02-02 01:22:35'),(2,'bob','pass123','bob@example.com','SILVER',4892.00,'2026-02-02 01:22:35'),(3,'charlie','pass123','charlie@example.com','BRONZE',850.00,'2026-02-02 01:22:35'),(4,'david','pass123','david@example.com','GOLD',16888.00,'2026-02-02 01:22:35'),(5,'eve','pass123','eve@example.com','BRONZE',50.00,'2026-02-02 01:22:35'),(6,'frank','pass123','frank@example.com','SILVER',2500.00,'2026-02-02 01:22:35'),(7,'grace','pass123','grace@example.com','GOLD',19000.00,'2026-02-02 01:22:35'),(8,'hank','pass123','hank@example.com','BRONZE',1000.00,'2026-02-02 01:22:35'),(9,'ivy','pass123','ivy@example.com','SILVER',3200.00,'2026-02-02 01:22:35'),(10,'jack','pass123','jack@example.com','BRONZE',0.00,'2026-02-02 01:22:35'),(12,'test','1234',NULL,'BRONZE',1000.00,'2026-02-04 07:04:34');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price_at_time` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,12,10,1,2200.00),(2,13,6,1,800.00),(3,14,14,1,250.00),(4,15,14,1,250.00),(5,16,18,1,290.00),(6,17,7,1,600.00),(7,18,15,1,12000.00),(8,19,8,1,990.00),(9,19,11,1,2800.00),(10,19,15,1,12000.00),(11,20,22,10,50.00),(12,20,13,1,4200.00),(13,21,5,1,120.00),(14,21,12,1,7500.00),(15,22,4,1,450.00),(16,22,15,1,12000.00),(17,23,16,1,5500.00),(18,23,5,1,120.00),(19,23,8,1,990.00),(20,24,3,1,1500.00),(21,25,19,1,80.00),(22,26,18,1,290.00),(23,27,11,1,2800.00),(24,28,4,1,450.00),(25,28,12,1,7500.00),(26,29,5,1,120.00),(27,30,9,1,350.00),(28,31,4,1,450.00),(29,31,6,1,800.00);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (12,1,2200.00,'2026-02-03 13:30:36','2026-02-03 13:30:36'),(13,1,800.00,'2026-02-03 13:30:39','2026-02-03 13:30:39'),(14,1,250.00,'2026-02-03 13:30:41','2026-02-03 13:30:41'),(15,1,250.00,'2026-02-03 13:32:24','2026-02-03 13:32:24'),(16,1,290.00,'2026-02-03 13:32:28','2026-02-03 13:32:28'),(17,1,600.00,'2026-02-03 13:44:09','2026-02-03 13:44:09'),(18,1,12000.00,'2026-02-03 13:44:14','2026-02-03 13:44:14'),(19,1,15790.00,'2026-02-03 13:49:12','2026-02-03 13:49:12'),(20,1,470.00,'2026-02-04 02:10:31','2026-02-04 02:10:31'),(21,1,762.00,'2026-02-04 02:11:28','2026-02-04 02:11:28'),(22,1,1245.00,'2026-02-04 02:47:03','2026-02-04 02:47:03'),(23,1,661.00,'2026-02-04 02:50:00','2026-02-04 02:50:00'),(24,4,1200.00,'2026-02-04 03:08:20','2026-02-04 03:08:20'),(25,1,8.00,'2026-02-04 03:09:09','2026-02-04 03:09:09'),(26,1,29.00,'2026-02-04 03:09:49','2026-02-04 03:09:49'),(27,4,2240.00,'2026-02-04 06:22:39','2026-02-04 06:22:39'),(28,1,795.00,'2026-02-04 06:45:09','2026-02-04 06:45:09'),(29,2,108.00,'2026-02-04 07:14:13','2026-02-04 07:14:13'),(30,3,350.00,'2026-02-04 07:14:39','2026-02-04 07:14:39'),(31,7,1000.00,'2026-02-04 07:15:10','2026-02-04 07:15:10');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'iPhone 17','Electronics',35000.00,10,'Latest smartphone'),(2,'機械式鍵盤','Electronics',3200.00,49,'RGB Backlit'),(3,'電競滑鼠','Electronics',1500.00,99,'High DPI'),(4,'咖啡豆','Food',450.00,196,'Arabica 1kg'),(5,'綠茶','Food',120.00,275,'Japanese Style'),(6,'瑜珈墊','Sports',800.00,37,'Non-slip'),(7,'啞鈴 5kg','Sports',600.00,25,'Iron cast'),(8,'檯燈','Home',990.00,13,'Eye protection'),(9,'水壺','Home',350.00,498,'Stainless steel'),(10,'後背包','Fashion',2200.00,29,'Waterproof'),(11,'跑鞋','Sports',2800.00,9,'Lightweight'),(12,'27吋螢幕','Electronics',7500.00,5,'4K Resolution'),(13,'無線耳機','Electronics',4200.00,44,'Noise cancelling'),(14,'奶茶包','Food',250.00,146,'Instant mix'),(15,'電動升降桌','Home',12000.00,1,'Electric height adjust'),(16,'辦公椅','Home',5500.00,9,'Ergonomic'),(17,'蛋白粉','Sports',1800.00,60,'Whey protein'),(18,'USB-C Cable','Electronics',290.00,998,'Fast charging'),(19,'筆記型電腦','Stationery',8000.00,1999,'A5 Ruled'),(20,'鋼筆','Stationery',1500.00,20,'Luxury edition'),(22,'香菜乖乖','Food',50.00,989,'搶手貨');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_order_details`
--

DROP TABLE IF EXISTS `view_order_details`;
/*!50001 DROP VIEW IF EXISTS `view_order_details`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_order_details` AS SELECT 
 1 AS `order_id`,
 1 AS `product_name`,
 1 AS `price_at_time`,
 1 AS `quantity`,
 1 AS `subtotal`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_order_details`
--

/*!50001 DROP VIEW IF EXISTS `view_order_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_order_details` AS select `i`.`order_id` AS `order_id`,`p`.`name` AS `product_name`,`i`.`price_at_time` AS `price_at_time`,`i`.`quantity` AS `quantity`,(`i`.`price_at_time` * `i`.`quantity`) AS `subtotal` from (`order_items` `i` join `products` `p` on((`i`.`product_id` = `p`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-04 16:03:31
