-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ibm_teste
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `idade` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_conta` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `UKiytklfb99234i8muhue46mla8` (`id_conta`),
  CONSTRAINT `FKojbsgmdtukgrosyjtmfl1gdxi` FOREIGN KEY (`id_conta`) REFERENCES `conta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (6,'teste1',35,'wesley1@teste.com.br',2),(7,'teste2',27,'wesley2@teste.com.br',3),(9,'wesley melo',23,'wesley7@hotmail.com',5),(10,'wesley melo',32,'wesleyhsm@hotmail.com',6),(32,'wesley melo teste',34,'wesley67@hotmail.com',31),(33,'wesley jefferson',65,'wesley1000@hotmail.com',32);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_transacoes`
--

DROP TABLE IF EXISTS `cliente_transacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_transacoes` (
  `cliente_id` int NOT NULL,
  `transacoes_id` int NOT NULL,
  UNIQUE KEY `UK57h37l5abivbfwidf5hecexcc` (`transacoes_id`),
  KEY `FK1vfpus1q3y6gbpeiiwl2auufj` (`cliente_id`),
  CONSTRAINT `FK101li46w0hnnxpxpjeecv7pbk` FOREIGN KEY (`transacoes_id`) REFERENCES `transacao` (`id`),
  CONSTRAINT `FK1vfpus1q3y6gbpeiiwl2auufj` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_transacoes`
--

LOCK TABLES `cliente_transacoes` WRITE;
/*!40000 ALTER TABLE `cliente_transacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_transacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `saldo` decimal(38,2) DEFAULT NULL,
  `data_atualizacao` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_UNIQUE` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (2,123,0.00,'2024-06-05 00:00:00.000000'),(3,233,301.62,'2024-06-05 19:50:23.108000'),(5,33333,178.00,'2024-06-06 16:31:04.659000'),(6,88888,0.00,'2024-06-06 16:31:38.045000'),(31,66666,0.00,'2024-06-06 17:06:22.331000'),(32,99999,1079.00,'2024-06-07 15:55:33.954000');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacao`
--

DROP TABLE IF EXISTS `transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` enum('CREDITO','DEBITO') DEFAULT NULL,
  `valor` decimal(38,2) DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `data` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacao`
--

LOCK TABLES `transacao` WRITE;
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` VALUES (5,'CREDITO',50.27,7,'2024-06-05 21:22:38.210000'),(6,'CREDITO',50.27,7,'2024-06-05 21:22:42.846000'),(7,'DEBITO',250.27,7,'2024-06-05 21:23:32.706000'),(8,'DEBITO',150.81,7,'2024-06-05 21:24:05.596000'),(9,'CREDITO',150.81,7,'2024-06-05 22:11:18.284000'),(10,'CREDITO',150.81,7,'2024-06-05 22:31:44.772000'),(11,'CREDITO',222.00,9,'2024-06-07 13:23:04.242000'),(12,'DEBITO',44.00,9,'2024-06-07 13:29:31.009000'),(13,'CREDITO',500.00,33,'2024-06-07 15:55:57.109000'),(14,'CREDITO',800.00,33,'2024-06-07 15:56:13.239000'),(15,'DEBITO',221.00,33,'2024-06-07 15:56:34.420000');
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-07 16:03:26
