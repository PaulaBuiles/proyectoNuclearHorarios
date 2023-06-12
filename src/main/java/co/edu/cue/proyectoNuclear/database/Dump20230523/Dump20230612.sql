-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cue
-- ------------------------------------------------------
-- Server version	8.0.32

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
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKohu3gc1466hi04g9vspiisw4p` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day_of_week` smallint NOT NULL,
  `end` time NOT NULL,
  `start` time NOT NULL,
  `teacher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5liwoeq6cm7ngrmx8o9t8eyj4` (`teacher_id`),
  CONSTRAINT `FK5liwoeq6cm7ngrmx8o9t8eyj4` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,0,'09:30:00','07:00:00',7069415283),(2,0,'13:00:00','10:30:00',4172853069),(3,0,'20:00:00','16:00:00',7019586432),(5,1,'19:00:00','15:00:00',5294310867),(6,1,'22:00:00','17:00:00',4826091573),(7,2,'12:00:00','07:00:00',8439170625),(8,2,'18:00:00','16:00:00',7019586432),(9,3,'09:00:00','07:00:00',7069415283),(10,3,'12:00:00','07:00:00',8439170625),(11,4,'12:00:00','07:00:00',8439170625),(12,4,'14:00:00','10:30:00',7019586432),(13,4,'19:00:00','14:00:00',5294310867),(14,5,'12:00:00','07:00:00',3962580417),(15,5,'12:00:00','09:00:00',7069415283),(16,2,'11:00:00','09:00:00',123456789);
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `location` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `observation` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,30,'PRINCIPAL','104A','N/A','on'),(2,30,'PRINCIPAL','302','N/A','on'),(3,30,'PRINCIPAL','304','N/A','on'),(4,30,'PRINCIPAL','S1','N/A','on'),(5,30,'PRINCIPAL','S2','Persiana dañada','on'),(6,30,'PRINCIPAL','Lab','N/A','on'),(7,30,'NOGAL','S1','N/A','on'),(8,23,'CAMPINA','305','ninguna','on'),(9,30,'NOGAL','105','ninguna','on'),(10,30,'VIRTUAL','VIRTUAL','Google meet','on');
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom_property`
--

DROP TABLE IF EXISTS `classroom_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom_property` (
  `classroom_id` bigint NOT NULL,
  `property` varchar(255) DEFAULT NULL,
  KEY `FKowraoxg9x6hxt5k48rwvwx2po` (`classroom_id`),
  CONSTRAINT `FKowraoxg9x6hxt5k48rwvwx2po` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom_property`
--

LOCK TABLES `classroom_property` WRITE;
/*!40000 ALTER TABLE `classroom_property` DISABLE KEYS */;
INSERT INTO `classroom_property` VALUES (8,'PROJECTOR'),(8,'CAMERA'),(9,'PROJECTOR'),(9,'CAMERA'),(9,'TELEVISION'),(9,'AIR_CONDITIONER'),(9,'VENTILATOR');
/*!40000 ALTER TABLE `classroom_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id_student` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  KEY `FKm1expnaas0onmafqpktmjixnx` (`subject_id`),
  KEY `FKsqpe0x9lliygi14ahcpdgylgp` (`id_student`),
  CONSTRAINT `FKm1expnaas0onmafqpktmjixnx` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKsqpe0x9lliygi14ahcpdgylgp` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (7849325710,1),(7849325710,2),(7849325710,3),(7849325710,4),(7849325710,5),(7849325710,6),(9137452086,1),(9137452086,2),(9137452086,3),(9137452086,4),(9137452086,5),(9137452086,6),(9137452086,7),(6927304581,1),(6927304581,2),(6927304581,3),(6927304581,4),(6927304581,5),(6927304581,6),(6927304581,7),(8351907624,1),(8351907624,2),(8351907624,3),(8351907624,4),(8351907624,5),(8351907624,6),(8351907624,7),(8351907624,8);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day_of_week` smallint NOT NULL,
  `durability` time NOT NULL,
  `end` time NOT NULL,
  `start` time NOT NULL,
  `subject_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK69oakeanwehikps300emu9sy4` (`subject_id`),
  CONSTRAINT `FK69oakeanwehikps300emu9sy4` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,0,'03:00:00','13:00:00','10:00:00',2),(2,1,'03:00:00','21:00:00','18:00:00',7),(3,3,'02:00:00','09:00:00','07:00:00',1),(4,3,'03:00:00','12:00:00','09:00:00',4),(5,1,'02:00:00','18:00:00','16:00:00',5),(6,2,'03:00:00','10:00:00','07:00:00',4),(7,2,'02:00:00','18:00:00','16:00:00',3),(8,0,'02:00:00','20:00:00','18:00:00',3),(9,0,'02:00:00','09:00:00','07:00:00',1),(10,4,'03:00:00','10:00:00','07:00:00',4),(11,4,'02:00:00','13:00:00','11:00:00',3),(12,4,'02:00:00','19:00:00','17:00:00',5),(13,5,'04:00:00','12:00:00','08:00:00',6),(45,1,'02:00:00','09:00:00','07:00:00',23),(47,1,'02:00:00','16:00:00','14:00:00',8);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `career` varchar(255) NOT NULL,
  `semester` smallint NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKqytew32213tbnj8u0er377k3q` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('Ingeniería de software',3,12345678),('Ingenieria de Software',2,87965321),('Ingeniería de software',3,6927304581),('Ingeniería de software',3,7849325710),('Ingeniería de software',3,8351907624),('Ingeniería de software',3,9137452086);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `credit` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `classroom_id` bigint DEFAULT NULL,
  `id_teacher` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiop75g8ukdkam407gg6xvdqkw` (`classroom_id`),
  KEY `FK2clbnn49j3bpu266tefvtkda9` (`id_teacher`),
  CONSTRAINT `FK2clbnn49j3bpu266tefvtkda9` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKiop75g8ukdkam407gg6xvdqkw` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,3,'Programación II',4,7069415283),(2,2,'Análisis numerico',1,4172853069),(3,2,'Metodología de Desarrollo I',2,7019586432),(4,3,'Ingeniería de Software I',6,8439170625),(5,2,'Formulación de Proyectos de Ingeniería de Software',3,5294310867),(6,2,'Bases de Datos I',5,3962580417),(7,2,'Ingles III',1,4826091573),(8,2,'TICS',7,123456789),(23,0,'Reservado',1,123456789);
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
  PRIMARY KEY (`id`),
  CONSTRAINT `FKlicv62vmu1ydw117bbxqhkof1` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (0),(123456789),(3962580417),(4172853069),(4826091573),(5294310867),(7019586432),(7069415283),(8439170625);
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
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'none','none','none','none',_binary '\0'),(12345678,'carolina1230@gmail.com','Carolina Arango Suarez','123456','Estudiante',_binary ''),(87965321,'felipe98764@gmail.com','Felipe andres','123456','Estudiante',_binary ''),(123456789,'jbustamante18@cue.edu.co','	Juan Sebastian Bustamante Montoya','789123456','Profesor',_binary ''),(3962580417,'mcardenas16@cue.edu.co','Maycol Cardenas Acevedo','1234567890','Profesor',_binary ''),(4172853069,'mmesa4@cue.edu.co','Monica Jhoana Mesa Mazo','789123456','Profesor',_binary ''),(4826091573,'lfelipeb806@cue.edu.co','Luis Felipe Botero Lopez','789123456','Profesor',_binary ''),(5294310867,'cgranada173@cue.edu.co','Cesar Augusto Granada Muñoz','789123456','Profesor',_binary ''),(5678901234,'carolina201@gmail.com','carolina suarez','password789','Administrativo',_binary ''),(6927304581,'dquejada10281@cue.edu.co','Derly Elena Quejada Pera','123456789','Estudiante',_binary ''),(7019586432,'arodriguez18@cue.edu.co','Andres Mauricio Rodriguez Suarez','789123456','Profesor',_binary ''),(7069415283,'mtobon86@cue.edu.co','Monica Lorena Tobon Clavijo','789123456','Profesor',_binary ''),(7849325710,'ccorrea1068@cue.edu.co','Cristhian Camilo Correa Ceballos','123456789','Estudiante',_binary ''),(8351907624,'sberrio1021@cue.edu.co','Samuel Berrio Rojas','123456789','Estudiante',_binary ''),(8439170625,'lzamora734@cue.edu.co','Lida Zamora Marin','789123456','Profesor',_binary ''),(9137452086,'pbuiles1026@cue.edu.co','Paula Andrea Builes Loaiza','123456789','Estudiante',_binary '');
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

-- Dump completed on 2023-06-12  0:07:04
