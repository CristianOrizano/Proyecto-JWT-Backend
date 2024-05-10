CREATE DATABASE  IF NOT EXISTS `entrenajwt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `entrenajwt`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: entrenajwt
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_emision` datetime DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `total` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_id_idx` (`id_cliente`),
  KEY `fk_usuario_id_idx` (`id_usuario`),
  CONSTRAINT `fk_cliente_id` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`codigo`),
  CONSTRAINT `fk_usuario_id` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES (95,'2024-04-20 15:59:11',2,1,4100.00),(96,'2024-04-20 16:28:56',4,1,9567.00),(97,'2024-04-20 17:07:53',5,1,19799.60),(98,'2024-04-20 17:10:49',15,1,5100.00),(99,'2024-04-20 18:18:32',15,1,6250.00),(100,'2024-04-22 18:45:22',2,1,10097.00),(101,'2024-04-22 20:07:20',16,26,4799.00),(102,'2024-04-22 20:10:32',15,26,3999.00),(103,'2024-04-23 17:41:09',4,1,11008.00);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria` (
  `ide_cat` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `state` bit(1) NOT NULL,
  PRIMARY KEY (`ide_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
INSERT INTO `tb_categoria` VALUES (3,'Refrigeracion','Esta categoría incluye teléfonos inteligentes tableta',_binary ''),(6,'Multimedia','Esta categoría incluye teléfonos inteligentes tabletas',_binary ''),(26,'Celulares y Smartphones','productos todo celulares de alta gama',_binary ''),(27,'Laptops','Productos para la oficina',_binary ''),(28,'Tablets','Productos para estudiar',_binary ''),(29,'Consolas','Productos de entretenimiento',_binary ''),(30,'Teclados','Productos para pc',_binary '');
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ciudad`
--

DROP TABLE IF EXISTS `tb_ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ciudad` (
  `cod_ciu` int NOT NULL AUTO_INCREMENT,
  `nom_ciu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_ciu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ciudad`
--

LOCK TABLES `tb_ciudad` WRITE;
/*!40000 ALTER TABLE `tb_ciudad` DISABLE KEYS */;
INSERT INTO `tb_ciudad` VALUES (1,'wisonsin'),(2,'California'),(3,'Denver');
/*!40000 ALTER TABLE `tb_ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `ndocumento` int DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (2,'Rous','lima','Emma',987456121,78945612,_binary ''),(3,'orizano','lima','cristian',987456121,78945612,_binary ''),(4,'rodrigo','lima','olivia',987456121,78945612,_binary ''),(5,'taylor','Av larco ','fgh',987456121,78945612,_binary '\0'),(15,'swift','times sq','taylor',987456121,78945612,_binary '\0'),(16,'laruso rus','lima','alex',987456121,78945678,_binary '');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_demo`
--

DROP TABLE IF EXISTS `tb_demo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_demo` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_demo`
--

LOCK TABLES `tb_demo` WRITE;
/*!40000 ALTER TABLE `tb_demo` DISABLE KEYS */;
INSERT INTO `tb_demo` VALUES (31,'Salas Ro','10015.PNG','Taylor'),(36,'Dorw','10003.PNG','Amelia'),(37,'Dorw','2007.jpg','Amelia'),(38,'Salazar','d3.jpg','Nini'),(39,'Dorw','10006.PNG','Amelia'),(40,'Salazar','2001.jpg','Amelia'),(42,'Salazar','100.PNG','Simvastatin');
/*!40000 ALTER TABLE `tb_demo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_boleta`
--

DROP TABLE IF EXISTS `tb_detalle_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detalle_boleta` (
  `id_boleta` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_boleta`,`id_producto`),
  KEY `fk_id_producto_idx` (`id_producto`),
  CONSTRAINT `fk_id_boleta` FOREIGN KEY (`id_boleta`) REFERENCES `tb_boleta` (`id`),
  CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `tb_producto` (`codigo_ele`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_boleta`
--

LOCK TABLES `tb_detalle_boleta` WRITE;
/*!40000 ALTER TABLE `tb_detalle_boleta` DISABLE KEYS */;
INSERT INTO `tb_detalle_boleta` VALUES (95,1047,2),(96,1038,2),(96,1042,1),(96,1044,2),(97,1011,8),(97,1037,2),(97,1046,2),(98,1047,2),(98,1048,1),(99,1045,2),(99,1047,1),(100,1044,3),(100,1047,2),(101,1044,1),(101,1049,1),(101,1050,1),(102,1023,1),(102,1044,1),(103,1038,2),(103,1044,2),(103,1047,2);
/*!40000 ALTER TABLE `tb_detalle_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `cod_adm` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `sueldo` double NOT NULL,
  `fechanaci` date DEFAULT NULL,
  `codciudad` int DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  PRIMARY KEY (`cod_adm`),
  KEY `FKiy88kw0t3newip1ir33gnnfw4` (`codciudad`),
  CONSTRAINT `FKiy88kw0t3newip1ir33gnnfw4` FOREIGN KEY (`codciudad`) REFERENCES `tb_ciudad` (`cod_ciu`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (30,'cristiano oriza','orizano','los pinos',987456123,6000.66,'2001-09-09',3,_binary ''),(31,'emma lisa','Roza alvarez','california',987456123,6000.5,'2010-08-01',1,_binary '\0'),(93,'cristian','orizano','los pinos',987456123,6000.66,'2002-07-13',1,_binary ''),(94,'Roman The tribal','rings','av lima',984454652,5000.5,'2003-08-24',1,_binary ''),(95,'cristan','dsfdsf','sdfdsf',987455555,5000.55,'2001-09-02',2,_binary ''),(96,'olivia','Rodrigo','time square',987451224,5000,'2002-08-28',3,_binary ''),(105,'Agony ','kingy','los parques prince',978987988,7899.05,'2024-03-03',2,_binary ''),(106,'criasd','gfhgfhfg','hfghgf',789456566,1000.55,'2024-04-14',1,_binary ''),(107,'cristian','orizano','yuyt',987456123,1000,'2024-04-02',2,_binary '');
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `codestad` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codestad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto` (
  `codigo_ele` int NOT NULL AUTO_INCREMENT,
  `ide_cat` int DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `stock` int NOT NULL,
  `precio` double NOT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `id_estado` int DEFAULT NULL,
  `nimagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo_ele`),
  KEY `FKp8j22yseqsc32oc7091w4djrl` (`id_estado`),
  KEY `FKjaf1cbuyagmyfxnys0m8rvrj9` (`ide_cat`),
  CONSTRAINT `FKjaf1cbuyagmyfxnys0m8rvrj9` FOREIGN KEY (`ide_cat`) REFERENCES `tb_categoria` (`ide_cat`),
  CONSTRAINT `FKp8j22yseqsc32oc7091w4djrl` FOREIGN KEY (`id_estado`) REFERENCES `tb_estado` (`codestad`)
) ENGINE=InnoDB AUTO_INCREMENT=1051 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` VALUES (1011,3,'CONGELADORA COLDEX 247 LTS CH08 ',20,1000,'Coldex',1,'2refri.jpg'),(1023,3,'ASPIRADORA 2000W 25L ELECTRICA',20,2000,'Forte ',2,'10001.PNG'),(1024,6,'ASPIRADORA ELECTROLUX SON10 1400W',20,2000,'forte',1,'2007.jpg'),(1036,26,'IPHONE 13 6.1 - AZUL MEDIANOCHE',50,2660,'Apple',1,'2065287752910_2.jpg'),(1037,26,'SMARTPHONE SAMSUNG GALAXY S24 ULTRA 512G',50,3999,'Samsung',1,'2065329700244_2.jpg'),(1038,26,'APPLE IPHONE 12 AZUL 64 GB REACONDICIONADO',50,1455,'Apple',1,'full_image-1.jpg'),(1039,26,'APPLE IPHONE 14 6.1 128G+12MP MEDIANOCHE',50,1966,'Apple',1,'2065300885090_2.jpg'),(1040,27,'LAPTOP LENOVO IDEAPAD 1 AMD RYZEN 7 5700U 16GB 1TB SSD',50,1860,'Lenovo',1,'2004326027909_2.jpg'),(1041,27,'LAPTOP ASUS TUF GAMING F15 FX507ZC4',50,2060,'Asus',1,'2004317213762_2.jpg'),(1042,27,'LAPTOP ACER INTEL CORE I3 8GB GB RAM',50,2659,'Acer',1,'2004330098650.jpg'),(1043,28,'TABLET SAMSUNG TAB S6 LITE 2024 10.4\" 128GB',50,1600,'Sansung',1,'2004334581943.jpg'),(1044,28,'APPLE IPAD AIR (5TA GENERACIÓN) WI-FI 64GB MORADO',50,1999,'Apple',1,'2004319125704.jpg'),(1045,29,'CONSOLA SONY PLAY STATION 5 HW STANDARD SPIDERMAN 2',50,2100,'Sony',1,'2031324246483.jpg'),(1046,29,'PLAY STATION 4 (PS4) 1TB GOW RAGNAROK',50,1900,'Sony',1,'2031304917457.jpg'),(1047,29,'CONSOLA NINTENDO SWITCH MODELO OLED',50,2050,'Sony',1,'prod-usemirakl.jpg'),(1048,30,'COMBO DE TECLADO Y MOUSE CHONCHOW PARA JUEGOS MECÁNICOS',50,1000,'Asus',1,'mediprousmir.jpg'),(1049,6,'TELEVISOR LG NANOCELL 4K 55\" SMART TV CON THINQ ',50,1600,'LG ',1,'201831124336.jpg'),(1050,6,'AUDIFONOSINDY EVO XT SKULLCANDY',50,1200,'Evo',1,'206525477083.jpg');
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `nimagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Perez','juanPerez@hotmail.com','juan','$2a$10$0gBxewHfhSu9R4YF/B8/M.yGIibs9CiBeTgA3nOikdeKNq18OoOFC','JuanPerez',_binary '','d2.jpg'),(2,'salzar','salaz@gmail.com','lucas','$2a$10$0gBxewHfhSu9R4YF/B8/M.yGIibs9CiBeTgA3nOikdeKNq18OoOFC','LucasSalaz',_binary '',''),(11,'hola','dfg@gmail','Asaf','$2a$10$0bIDU17ute5Q1f2wAGTkJuCRdUgfSlVewNV/ga6cF8ydklEWfxIy6','Taylor',_binary '',''),(17,'rodrigo','liv@gmail.com','olivia','$2a$10$BpFRs69S6bUHco150A6pM.H6NQY69LD6BxFllvUcGiNEMI3edfhzK','olivia20',_binary '\0',''),(25,'lopez','lopez@gmail','pedro','$2a$10$P9T81VmHdD2HSD1xUb9LWuD4dUQDSzs6IpQ6dEDA1XTSeSoMXeHBG','pedro20',_binary '',''),(26,'Salazar','nini@gmail','nini ','$2a$10$zmLDrDeP.RD.YTqTkuNvtuyoaZVf5.8MHWXuK5O7okf4McovNUlmK','NiniSalazar',_binary '','d4.jpg'),(27,'orizano','asf@gmail','asafs','$2a$10$g6W3vU4TtTooAIc3i/UHBOGExnv9DoqgHSrP5vkqUZdFNPXTVPnhK','asaf20',_binary '',NULL),(28,'allison swift','taylor@gmail.com','taylor','$2a$10$zmf30j.1lDzdqOOC9dCLWOpyOuZ6o5hALaUxToM9QpMSHmVtYk1cS','TaylorSw13',_binary '',''),(29,'prueba','prueba@gmail','prueba','$2a$10$PPQ/8mVxymQNnqmR7c8Y9ekl9P5MqPewz6NpFS8pwHosxtZJv356.','prueba.pass@gmail.com',_binary '\0',''),(35,'allison','assaf@jazani.com','taylor','$2a$10$2615depAm.3PpYjfQ7/fE.LBeGkXLACKkMl8fmBZXtDLOIqcZ2nrq','jazani',_binary '\0',''),(36,'cindy','lindy@gmail.com','cindy','$2a$10$v6SOEHIAIye6K6zbQTF5d.7/KwYizW0ky7XAaCx7ZpOrTB6KTW5EK','lindy',_binary '',NULL),(37,'pedro','pedro@gmail.com','pedro','$2a$10$H4M1c2DrQJWOnorOQvP7QuW.Cvfutu3uGmBjZhgAivfGmJGIu.D/K','pedro123',_binary '',''),(38,'orizano','cristian@gmail.com','criss','$2a$10$dQF37T0aSzRsvNxSu6fpyO37U3Qo/kPeWclhK2XKd8TNYLUSYN3qm','cristian',_binary '','');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario_role`
--

DROP TABLE IF EXISTS `tb_usuario_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario_role` (
  `id_usuario` int NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `FKb18y127q590uwui814trri1jh` (`id_rol`),
  CONSTRAINT `FKb18y127q590uwui814trri1jh` FOREIGN KEY (`id_rol`) REFERENCES `tb_rol` (`id_rol`),
  CONSTRAINT `FKq88807wwkx7h5neicih51cq70` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario_role`
--

LOCK TABLES `tb_usuario_role` WRITE;
/*!40000 ALTER TABLE `tb_usuario_role` DISABLE KEYS */;
INSERT INTO `tb_usuario_role` VALUES (2,1),(11,1),(17,1),(25,1),(26,1),(27,1),(28,1),(29,1),(35,1),(36,1),(37,1),(38,1),(1,2);
/*!40000 ALTER TABLE `tb_usuario_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'entrenajwt'
--

--
-- Dumping routines for database 'entrenajwt'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09 21:20:06
