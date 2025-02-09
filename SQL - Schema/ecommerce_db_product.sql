-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce_db
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `delivery_amount` decimal(38,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `free_delivery` bit(1) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `new_price` decimal(38,2) DEFAULT NULL,
  `old_price` decimal(38,2) DEFAULT NULL,
  `product_url` varchar(255) DEFAULT NULL,
  `scheduled_start_date` date DEFAULT NULL,
  `vendor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgx1u98olx0264avddv9w8k2kf` (`vendor_id`),
  CONSTRAINT `FKgx1u98olx0264avddv9w8k2kf` FOREIGN KEY (`vendor_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (8,'Electronics',0.00,'A high-end smartphone with an amazing camera and display.','2025-02-17',_binary '','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRd9qBA2K5gXPc35H5OJk5-xMBG_kFtZIsFQ&s.jpg','OnePlus Nord 3',26000.00,30000.00,'oneplus-nord-2-50b1d193-1813-4c76-bcf1-87eeb104fb65','2025-02-10',11),(9,'Fashion',0.00,'Premium running shoes with a sleek design and maximum comfort.','2025-02-25',_binary '','https://example.com/nike-airmax.jpg','Nike Air Max 2025',9999.00,12000.00,'nike-air-max-2025-fbdd92b3-fc9d-4ce7-b0aa-b56c41613529','2025-02-18',12),(10,'Home Appliances',0.00,'A powerful and intelligent vacuum cleaner with laser detection technology.','2025-02-27',_binary '','https://example.com/dyson-v15.jpg','Dyson V15 Cordless Vacuum',49999.00,52000.00,'dyson-v15-cordless-vacuum-795e1165-faf7-41be-89c0-21826d8dc5da','2025-02-20',12),(11,'Beauty & Personal Care',0.00,'A compact hair dryer with 1000W power for quick and gentle drying.','2025-03-01',_binary '','https://example.com/philips-hairdryer.jpg','Philips Hair Dryer HP8100',1299.00,1500.00,'philips-hair-dryer-hp8100-04d1cd88-9ac0-46e1-9596-7577ce494713','2025-02-22',12),(14,'Sports & Outdoors',0.00,'Lightweight graphite racket designed for powerful smashes.','2025-03-07',_binary '','https://example.com/yonex-nanoray.jpg','Yonex Nanoray 18i Badminton Racket',2599.00,2800.00,'yonex-nanoray-18i-badminton-racket-b7945f30-25e7-4104-8fae-2ab6d3c48405','2025-02-28',12),(15,'Books',0.00,'A bestselling book on financial management and wealth-building psychology.','2025-03-08',_binary '','https://example.com/psychology-of-money.jpg','The Psychology of Money',399.00,499.00,'the-psychology-of-money-70d9155d-26b5-416f-a78e-7834567c3b83','2025-03-01',12),(16,'Automotive',100.00,'Premium engine oil ensuring smooth performance and longevity.','2025-03-12',_binary '\0','https://example.com/castrol-edge.jpg','Castrol Edge 5W-40 Fully Synthetic Engine Oil',3199.00,3500.00,'castrol-edge-5w-40-fully-synthetic-engine-oil-36be9b68-c6c6-49d1-883b-38ff75e7e9e6','2025-03-05',12),(17,'Health & Wellness',0.00,'A fitness tracker with heart rate monitoring and GPS tracking.','2025-03-17',_binary '','https://example.com/fitbit-charge6.jpg','Fitbit Charge 6 Smartwatch',12999.00,14000.00,'fitbit-charge-6-smartwatch-3ecea336-d6a2-4eb7-8305-b59fab8b5039','2025-03-10',12),(18,'Toys & Games',0.00,'A highly detailed LEGO set of the iconic Star Wars spacecraft.','2025-03-22',_binary '','https://example.com/lego-millenniumfalcon.jpg','LEGO Star Wars Millennium Falcon',23999.00,25000.00,'lego-star-wars-millennium-falcon-6c953af4-d351-4d38-943e-27c6002d8681','2025-03-15',12);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-09 14:50:55
