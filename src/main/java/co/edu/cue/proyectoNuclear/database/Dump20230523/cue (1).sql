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
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKcu5qmvx3cer9y9ydr9c2cf6ps` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrative`
--

LOCK TABLES `administrative` WRITE;
/*!40000 ALTER TABLE `administrative` DISABLE KEYS */;
INSERT INTO `administrative` VALUES ('Director',5678901234);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,'Monday','10:00:00','08:00:00'),(2,'Tuesday','12:00:00','10:00:00'),(3,'Wednesday','16:00:00','14:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characteristic`
--

LOCK TABLES `characteristic` WRITE;
/*!40000 ALTER TABLE `characteristic` DISABLE KEYS */;
INSERT INTO `characteristic` VALUES (1,'Working properly',1,1),(2,'Needs markers',2,2),(3,'Needs update',3,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'30','Building A','101',1),(2,'35','Building A','102',2),(3,'40','Building B','103',3);
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
  `name` varchar(255) NOT NULL,
  `id_student` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsqpe0x9lliygi14ahcpdgylgp` (`id_student`),
  CONSTRAINT `FKsqpe0x9lliygi14ahcpdgylgp` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Mathematics',1234567890),(2,'Physics',1234567890),(3,'Mathematics',9876543210);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
INSERT INTO `element` VALUES (1,'Projector'),(2,'Whiteboard'),(3,'Computer');
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
  CONSTRAINT `FKbbe1cpx8gndhwcrdp6ry6ppfe` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_user`),
  CONSTRAINT `FKfef7bhlxqn3m1l66316i9eoeq` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_student`
--

LOCK TABLES `history_student` WRITE;
/*!40000 ALTER TABLE `history_student` DISABLE KEYS */;
INSERT INTO `history_student` VALUES (1,1234567890,1),(2,1234567890,2);
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
  CONSTRAINT `FK6wmfbeu5yfwqlepdtquhmyhni` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_user`),
  CONSTRAINT `FKhjut3pisckdys3d6hsqu2yc5j` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_teacher`
--

LOCK TABLES `history_teacher` WRITE;
/*!40000 ALTER TABLE `history_teacher` DISABLE KEYS */;
INSERT INTO `history_teacher` VALUES (2,1,987654321);
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
  `name` varchar(255) NOT NULL,
  `id_availability` int DEFAULT NULL,
  `id_classroom` int DEFAULT NULL,
  `id_course` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr27owouendy9k99dvcrapigl1` (`id_availability`),
  KEY `FKf99924n5rgkyfmh3p6u4lye51` (`id_classroom`),
  KEY `FKrmvag562fnoc08wxh64bv58e5` (`id_course`),
  CONSTRAINT `FKf99924n5rgkyfmh3p6u4lye51` FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id`),
  CONSTRAINT `FKr27owouendy9k99dvcrapigl1` FOREIGN KEY (`id_availability`) REFERENCES `availability` (`id`),
  CONSTRAINT `FKrmvag562fnoc08wxh64bv58e5` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'02:00:00','Mathematics Class',1,1,1),(2,'02:00:00','Physics Class',2,2,2),(3,'02:00:00','Mathematics Class',3,1,1);
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
  `semester` int NOT NULL,
  `id_user` bigint NOT NULL,
  `id_course` int DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FK8vv1wsmmptm1gsc230wg2r1ie` (`id_course`),
  CONSTRAINT `FK8vv1wsmmptm1gsc230wg2r1ie` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`),
  CONSTRAINT `FKb4lfwbonj876jqkfv3syhp06o` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('Computer Science',3,1234567890,1),('Computer Science',3,9876543210,2);
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
  `id_availability` int DEFAULT NULL,
  `id_teacher` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9edxi9w0db4kjud1pu9bbnjt4` (`id_availability`),
  KEY `FK2clbnn49j3bpu266tefvtkda9` (`id_teacher`),
  CONSTRAINT `FK2clbnn49j3bpu266tefvtkda9` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_user`),
  CONSTRAINT `FK9edxi9w0db4kjud1pu9bbnjt4` FOREIGN KEY (`id_availability`) REFERENCES `availability` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,4,'Mathematics',1,987654321),(2,3,'Physics',2,987654321);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id_user` bigint NOT NULL,
  `id_availability` int DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FKjlkrve9jak75upbcmdhyfpnhq` (`id_availability`),
  CONSTRAINT `FK1j8r4d0olybhmcj1r9bn3shuu` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjlkrve9jak75upbcmdhyfpnhq` FOREIGN KEY (`id_availability`) REFERENCES `availability` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (987654321,3);
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
INSERT INTO `user` VALUES (987654321,'jane@example.com','Jane Smith','password456','Profesor'),(1234567890,'john@example.com','John Doe','password123','Estudiante'),(5432109876,'sarah@example.com','Sarah Davis','passworddef','Profesor'),(5678901234,'alice@example.com','Alice Johnson','password789','Administrativo'),(9876543210,'bob@example.com','Bob Anderson','passwordabc','Estudiante');
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

-- Dump completed on 2023-05-24 21:59:11
