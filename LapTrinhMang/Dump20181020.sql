-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: messenger
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Table structure for table `friendlist`
--

DROP TABLE IF EXISTS `friendlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendlist` (
  `UserId` int(11) NOT NULL,
  `UserFriendId` int(11) NOT NULL,
  PRIMARY KEY (`UserId`,`UserFriendId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendlist`
--

LOCK TABLES `friendlist` WRITE;
/*!40000 ALTER TABLE `friendlist` DISABLE KEYS */;
INSERT INTO `friendlist` VALUES (1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(2,1),(2,3),(2,4),(2,8);
/*!40000 ALTER TABLE `friendlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupchat`
--

DROP TABLE IF EXISTS `groupchat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupchat` (
  `GroupId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL COMMENT 'User created',
  `GroupName` varchar(45) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`GroupId`,`UserId`),
  KEY `UserId_idx` (`UserId`),
  CONSTRAINT `UserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UsersId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupchat`
--

LOCK TABLES `groupchat` WRITE;
/*!40000 ALTER TABLE `groupchat` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupchat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupdetail`
--

DROP TABLE IF EXISTS `groupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupdetail` (
  `GroupId` int(11) NOT NULL,
  `ToUserId` int(11) NOT NULL,
  PRIMARY KEY (`GroupId`,`ToUserId`),
  KEY `TouserId_idx` (`ToUserId`),
  CONSTRAINT `GroupId` FOREIGN KEY (`GroupId`) REFERENCES `groupchat` (`GroupId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TouserId` FOREIGN KEY (`ToUserId`) REFERENCES `users` (`UsersId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupdetail`
--

LOCK TABLES `groupdetail` WRITE;
/*!40000 ALTER TABLE `groupdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `messagesId` int(11) NOT NULL AUTO_INCREMENT,
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) NOT NULL,
  `content` text,
  `createdDate` datetime NOT NULL,
  `groupId` int(11) DEFAULT '-1',
  PRIMARY KEY (`messagesId`,`fromUserId`,`toUserId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,1,2,'dfgf','2018-12-09 00:00:00',-1),(2,2,1,'bunij123','2018-12-09 00:01:00',-1),(3,1,2,'fsddddddddddddddddddddddddddddffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggfsddddddddddddddddddddddddddddffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggfsddddddddddddddddddddddddddddffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggfsddddddddddddddddddddddddddddffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggfsddddddddddddddddddddddddddddffffffffffffffffffffffffffffffffffffffffggggggggggggggggggg','2018-12-09 00:02:00',-1),(4,3,1,'dgsgsdgdfgs','2018-06-09 00:02:00',-1),(5,1,4,'sdfgrtghyhty','2018-03-09 00:02:01',-1),(6,1,4,'asdfs','2018-10-13 00:02:01',-1),(7,1,4,'manh test gui mess 1','2018-10-13 18:20:55',-1),(8,1,6,'xin chao','2018-10-13 18:30:09',-1),(9,1,8,'manh test mess\n','2018-10-13 18:46:35',-1),(10,8,1,'1','2018-10-13 18:59:31',-1),(11,1,8,'what your name?\n','2018-10-13 19:43:07',-1),(12,1,8,'dfv','2018-10-13 19:43:39',-1),(13,1,8,'fvdfvff','2018-10-13 19:43:43',-1),(14,1,8,'3','2018-10-13 19:43:47',-1),(15,1,8,'4','2018-10-13 19:43:53',-1),(16,1,8,'df','2018-10-13 19:43:58',-1),(17,1,8,'dfvdfv','2018-10-13 19:44:02',-1),(18,1,8,'dfbrtrt','2018-10-13 19:44:05',-1),(19,1,8,'rtrtt','2018-10-13 19:44:08',-1),(20,1,8,'rtttt','2018-10-13 19:44:12',-1),(21,1,8,'jujuyjy','2018-10-13 19:44:15',-1),(22,1,8,'new1','2018-10-13 19:44:24',-1),(23,1,3,'afsdf','2018-10-13 21:26:30',-1),(24,1,2,'dsgdsds','2018-10-17 07:42:00',-1),(25,1,2,'1','2018-10-17 07:42:12',-1),(26,2,1,'chim','2018-10-17 07:42:25',-1);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offlinemessage`
--

DROP TABLE IF EXISTS `offlinemessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offlinemessage` (
  `FromUserId` int(11) NOT NULL,
  `ToUserId` varchar(45) NOT NULL,
  `Message` text,
  `CreatedDate` datetime NOT NULL,
  PRIMARY KEY (`FromUserId`,`ToUserId`,`CreatedDate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offlinemessage`
--

LOCK TABLES `offlinemessage` WRITE;
/*!40000 ALTER TABLE `offlinemessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `offlinemessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UsersId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `PassWord` varchar(45) NOT NULL,
  `State` int(1) DEFAULT '0' COMMENT '0- offline\n1-online',
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Address` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`UsersId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin',0,'manh','pham','a','a'),(2,'user1','pass',0,'user1','last1','a','a'),(3,'user2','pass',0,'user2','last1','a','a'),(4,'user3','pass',0,'user3','last1','a','a'),(5,'user4','pass',0,'user4','last1','a','a'),(6,'user5','pass',0,'user5','last1','a','a'),(7,'user6','pass',0,'user6','last1','a','a'),(8,'user7','pass',0,'user7','last1','a','a'),(9,'user8','pass',0,'user8','last1','a','a'),(10,'user9','pass',0,'user9','last1','a','a');
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

-- Dump completed on 2018-10-20 18:59:05
