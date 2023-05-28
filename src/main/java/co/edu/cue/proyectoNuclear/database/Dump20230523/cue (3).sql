-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cue
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `administrative`
--

DROP TABLE IF EXISTS `administrative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrative` (
  `charge` varchar(255) NOT NULL,
  `id_user` bigint NOT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `FK4e5lkj25bjtrgdvdkgpbvewqa` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrative`
--

LOCK TABLES `administrative` WRITE;
/*!40000 ALTER TABLE `administrative` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day_of_week` varchar(255) NOT NULL,
  `end` time NOT NULL,
  `start` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,'Lunes','10:00:00','07:00:00'),(2,'Martes','12:00:00','10:00:00'),(3,'Miercoles','16:00:00','14:00:00'),(4,'Lunes','13:30:00','11:00:00'),(5,'Martes','21:00:00','16:00:00'),(6,'Martes','21:00:00','18:00:00'),(7,'Miercoles','12:00:00','07:00:00'),(8,'Miercoles','18:00:00','14:00:00'),(9,'Jueves','09:00:00','07:00:00'),(10,'Jueves','12:00:00','07:00:00'),(11,'Martes','17:00:00','14:00:00'),(12,'Viernes','13:00:00','07:00:00'),(13,'Viernes','20:00:00','17:00:00'),(14,'Sabado','12:00:00','08:00:00'),(15,'Lunes','20:00:00','12:00:00');
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characteristic`
--

DROP TABLE IF EXISTS `characteristic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characteristic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `observation` varchar(255) NOT NULL,
  `id_classroom` int DEFAULT NULL,
  `id_element` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKixhheo2iyas0g3yi9a6um3ven` (`id_classroom`),
  KEY `FKn22ftissnqpv5q58d7fmjx88n` (`id_element`),
  CONSTRAINT `FKixhheo2iyas0g3yi9a6um3ven` FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id`),
  CONSTRAINT `FKn22ftissnqpv5q58d7fmjx88n` FOREIGN KEY (`id_element`) REFERENCES `element` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characteristic`
--

LOCK TABLES `characteristic` WRITE;
/*!40000 ALTER TABLE `characteristic` DISABLE KEYS */;
INSERT INTO `characteristic` VALUES (1,'No hay',1,1),(2,'No hay',1,2),(3,'No hay',1,3),(4,'No hay',1,4),(5,'No hay',2,1),(6,'No hay',2,2),(7,'No hay',2,3),(8,'No hay',2,5);
/*!40000 ALTER TABLE `characteristic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacity` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  `id_availability` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79r6vssxi8jhwg1gjdfisayiy` (`id_availability`),
  CONSTRAINT `FK79r6vssxi8jhwg1gjdfisayiy` FOREIGN KEY (`id_availability`) REFERENCES `availability` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'30','Principal','s1',1),(2,'35','Principal','105A',2),(3,'30','Principal','s2',7),(4,'35','Principal','104B',8),(5,'40','Nogal','s1',10),(6,'20','Principal','302',8),(7,'20','Principal','302',12),(8,'20','Principal','Lab',12),(9,'30','Principal','s1',13),(10,'40','Nogal','s1',11),(11,'30','Principal','s2',14),(12,'no aplica','virtual','no aplica',15);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL,
  `id_student` bigint DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsqpe0x9lliygi14ahcpdgylgp` (`id_student`),
  KEY `FKf8p8s0sw4hgvkg0envppmfxps` (`id_subject`),
  CONSTRAINT `FKf8p8s0sw4hgvkg0envppmfxps` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKsqpe0x9lliygi14ahcpdgylgp` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,2,1),(8,2,2),(9,2,3),(10,2,4),(11,2,5),(12,2,6),(13,2,7),(14,3,1),(15,3,2),(16,3,3),(17,3,4),(18,3,5),(19,3,6),(20,3,7),(21,3,8),(22,4,1),(23,4,2),(24,4,3),(25,4,4),(26,4,5),(27,4,6),(28,4,7);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element`
--

DROP TABLE IF EXISTS `element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `element` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
INSERT INTO `element` VALUES (1,'Proyector'),(2,'Camara'),(3,'Televisor'),(4,'Aire acondicionado'),(5,'Ventilador');
/*!40000 ALTER TABLE `element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_student`
--

DROP TABLE IF EXISTS `history_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_student` bigint DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbbe1cpx8gndhwcrdp6ry6ppfe` (`id_student`),
  KEY `FKfef7bhlxqn3m1l66316i9eoeq` (`id_subject`),
  CONSTRAINT `FKbbe1cpx8gndhwcrdp6ry6ppfe` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`),
  CONSTRAINT `FKfef7bhlxqn3m1l66316i9eoeq` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_student`
--

LOCK TABLES `history_student` WRITE;
/*!40000 ALTER TABLE `history_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `history_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_teacher`
--

DROP TABLE IF EXISTS `history_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_subject` int DEFAULT NULL,
  `id_teacher` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjut3pisckdys3d6hsqu2yc5j` (`id_subject`),
  KEY `FK6wmfbeu5yfwqlepdtquhmyhni` (`id_teacher`),
  CONSTRAINT `FK6wmfbeu5yfwqlepdtquhmyhni` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKhjut3pisckdys3d6hsqu2yc5j` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_teacher`
--

LOCK TABLES `history_teacher` WRITE;
/*!40000 ALTER TABLE `history_teacher` DISABLE KEYS */;
INSERT INTO `history_teacher` VALUES (1,1,1),(2,3,5),(3,4,7),(4,5,10),(6,6,13),(7,7,14),(8,2,3);
/*!40000 ALTER TABLE `history_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `durability` time NOT NULL,
  `id_classroom` int DEFAULT NULL,
  `id_subject` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf99924n5rgkyfmh3p6u4lye51` (`id_classroom`),
  KEY `FKq9t4e99c25mfugmj4orrtjyea` (`id_subject`),
  CONSTRAINT `FKf99924n5rgkyfmh3p6u4lye51` FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id`),
  CONSTRAINT `FKq9t4e99c25mfugmj4orrtjyea` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'02:00:00',1,2),(2,'02:00:00',10,2),(3,'03:00:00',2,1),(4,'02:00:00',5,5),(5,'02:00:00',9,5),(6,'02:00:00',4,7),(7,'02:00:00',10,8),(8,'03:00:00',3,4),(9,'03:00:00',5,4),(10,'03:00:00',8,4),(11,'02:00:00',12,3),(12,'02:00:00',6,3),(13,'02:00:00',7,3),(14,'05:00:00',11,6);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` bigint NOT NULL,
  `career` varchar(255) NOT NULL,
  `semester` smallint NOT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb4lfwbonj876jqkfv3syhp06o` (`id_user`),
  CONSTRAINT `FKb4lfwbonj876jqkfv3syhp06o` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'IngenierÃƒÂ­a de software',3,7849325710),(2,'IngenierÃƒÂ­a de software',3,9137452086),(3,'IngenierÃƒÂ­a de software',3,8351907624),(4,'IngenierÃƒÂ­a de software',3,6927304581),(5,'IngenierÃƒÂ­a industrial',3,6927304581);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `credit` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `id_teacher` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2clbnn49j3bpu266tefvtkda9` (`id_teacher`),
  CONSTRAINT `FK2clbnn49j3bpu266tefvtkda9` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,2,'Analisis numerico',1),(2,3,'Programacion II',3),(3,3,'Metodolofia de desarrollo I',5),(4,3,'Ingenieria de software I',7),(5,3,'Formulacion de proyectos de ingenieria de software',10),(6,3,'Bases de datos I',13),(7,2,'Ingles',14),(8,2,'Tics',0);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` bigint NOT NULL,
  `id_availability` int DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjlkrve9jak75upbcmdhyfpnhq` (`id_availability`),
  KEY `FK1j8r4d0olybhmcj1r9bn3shuu` (`id_user`),
  CONSTRAINT `FK1j8r4d0olybhmcj1r9bn3shuu` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjlkrve9jak75upbcmdhyfpnhq` FOREIGN KEY (`id_availability`) REFERENCES `availability` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (0,1,0),(1,4,4172853069),(2,3,4172853069),(3,1,7069415283),(4,3,7069415283),(5,3,7019586432),(6,12,7019586432),(7,7,8439170625),(8,10,8439170625),(9,12,8439170625),(10,5,5294310867),(11,13,5294310867),(13,14,3962580417),(14,6,4826091573);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'none','none','none','none'),(3962580417,'mcardenas16@cue.edu.co','Maycol Cardenas Acevedo','789123456','Profesor'),(4172853069,'mmesa4@cue.edu.co','Monica Jhoana Mesa Mazo','789123456','Profesor'),(4826091573,'lfelipeb806@cue.edu.co','Luis Felipe Botero Lopez','789123456','Profesor'),(5294310867,'cgranada173@cue.edu.co','Cesar Augusto Granada MuÃ±oz','789123456','Profesor'),(5678901234,'alice@example.com','Alice Johnson','password789','Administrativo'),(6927304581,'dquejada1028@cue.edu.co','Derly Elena Quejada Perea','123456789','Estudiante'),(7019586432,'arodriguez18@cue.edu.co','Andres Mauricio Rodriguez Suarez','789123456','Profesor'),(7069415283,'mtobon86@cue.edu.co','Monica Lorena Tobon Clavijo','789123456','Profesor'),(7849325710,'ccorrea1068@cue.edu.co','Cristhian Camilo Correa Ceballos','123456789','Estudiante'),(8351907624,'sberrio1021@cue.edu.co','Samuel Berrio Rojas','123456789','Estudiante'),(8439170625,'lzamora734@cue.edu.co','Lida Zamora Marin','789123456','Profesor'),(9137452086,'pbuiles1026@cue.edu.co','Paula Andrea Builes Loaiza','123456789','Estudiante');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28 17:40:44
