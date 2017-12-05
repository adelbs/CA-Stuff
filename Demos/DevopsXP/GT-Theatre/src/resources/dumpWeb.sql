-- MySQL dump 10.13  Distrib 5.6.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketsgalaxy_web
-- ------------------------------------------------------
-- Server version	5.6.27-log

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

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ticketsgalaxy_web_dev` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ticketsgalaxy_web_dev`;

--
-- Table structure for table `fi_cd_cliente_clie`
--

DROP TABLE IF EXISTS `fi_cd_cliente_clie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_cd_cliente_clie` (
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  `CLIE_DS_EMAIL` varchar(50) DEFAULT NULL,
  `CLIE_DS_LOGIN` varchar(10) DEFAULT NULL,
  `CLIE_DS_NOME` varchar(50) DEFAULT NULL,
  `CLIE_DS_NUMCARTAO` varchar(50) DEFAULT NULL,
  `CLIE_DS_PWD` varchar(100) DEFAULT NULL,
  `CLIE_DS_TELEFONE` varchar(50) DEFAULT NULL,
  `CLIE_TP_CARTAO` int(11) DEFAULT NULL,
  `CLIE_TP_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIE_CD_CLIENTE`),
  UNIQUE KEY `UK_dv8tcmbeax3sp2w8ke7754hvb` (`CLIE_DS_LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_cd_cliente_clie`
--

LOCK TABLES `fi_cd_cliente_clie` WRITE;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_compra_comp`
--

DROP TABLE IF EXISTS `fi_ng_compra_comp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_compra_comp` (
  `ID_COMP_CD_COMPRA` int(11) NOT NULL,
  `COMP_DH_COMPRA` varchar(255) DEFAULT NULL,
  `COMP_DH_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_DS_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_NR_VALOR` double DEFAULT NULL,
  `ID_TICK_CD_TICKET` int(11) DEFAULT NULL,
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMP_CD_COMPRA`),
  KEY `FK_92gigm0yx6ynbulh81xh78nm6` (`ID_CLIE_CD_CLIENTE`),
  CONSTRAINT `FK_92gigm0yx6ynbulh81xh78nm6` FOREIGN KEY (`ID_CLIE_CD_CLIENTE`) REFERENCES `fi_cd_cliente_clie` (`ID_CLIE_CD_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_compra_comp`
--

LOCK TABLES `fi_ng_compra_comp` WRITE;
/*!40000 ALTER TABLE `fi_ng_compra_comp` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_compra_comp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_numeradora_nume`
--

DROP TABLE IF EXISTS `fi_ng_numeradora_nume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_numeradora_nume` (
  `NUME_DS_ENTITY` varchar(50) NOT NULL,
  `NUME_NR_APPBUFFER` int(11) NOT NULL,
  `NUME_NR_NEXTVAL` int(11) NOT NULL,
  PRIMARY KEY (`NUME_DS_ENTITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_numeradora_nume`
--

LOCK TABLES `fi_ng_numeradora_nume` WRITE;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 18:20:17












CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ticketsgalaxy_web_qa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ticketsgalaxy_web_qa`;

--
-- Table structure for table `fi_cd_cliente_clie`
--

DROP TABLE IF EXISTS `fi_cd_cliente_clie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_cd_cliente_clie` (
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  `CLIE_DS_EMAIL` varchar(50) DEFAULT NULL,
  `CLIE_DS_LOGIN` varchar(10) DEFAULT NULL,
  `CLIE_DS_NOME` varchar(50) DEFAULT NULL,
  `CLIE_DS_NUMCARTAO` varchar(50) DEFAULT NULL,
  `CLIE_DS_PWD` varchar(100) DEFAULT NULL,
  `CLIE_DS_TELEFONE` varchar(50) DEFAULT NULL,
  `CLIE_TP_CARTAO` int(11) DEFAULT NULL,
  `CLIE_TP_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIE_CD_CLIENTE`),
  UNIQUE KEY `UK_dv8tcmbeax3sp2w8ke7754hvb` (`CLIE_DS_LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_cd_cliente_clie`
--

LOCK TABLES `fi_cd_cliente_clie` WRITE;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_compra_comp`
--

DROP TABLE IF EXISTS `fi_ng_compra_comp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_compra_comp` (
  `ID_COMP_CD_COMPRA` int(11) NOT NULL,
  `COMP_DH_COMPRA` varchar(255) DEFAULT NULL,
  `COMP_DH_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_DS_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_NR_VALOR` double DEFAULT NULL,
  `ID_TICK_CD_TICKET` int(11) DEFAULT NULL,
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMP_CD_COMPRA`),
  KEY `FK_92gigm0yx6ynbulh81xh78nm6` (`ID_CLIE_CD_CLIENTE`),
  CONSTRAINT `FK_92gigm0yx6ynbulh81xh78nm6` FOREIGN KEY (`ID_CLIE_CD_CLIENTE`) REFERENCES `fi_cd_cliente_clie` (`ID_CLIE_CD_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_compra_comp`
--

LOCK TABLES `fi_ng_compra_comp` WRITE;
/*!40000 ALTER TABLE `fi_ng_compra_comp` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_compra_comp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_numeradora_nume`
--

DROP TABLE IF EXISTS `fi_ng_numeradora_nume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_numeradora_nume` (
  `NUME_DS_ENTITY` varchar(50) NOT NULL,
  `NUME_NR_APPBUFFER` int(11) NOT NULL,
  `NUME_NR_NEXTVAL` int(11) NOT NULL,
  PRIMARY KEY (`NUME_DS_ENTITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_numeradora_nume`
--

LOCK TABLES `fi_ng_numeradora_nume` WRITE;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 18:20:17













CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ticketsgalaxy_web_prod` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ticketsgalaxy_web_prod`;

--
-- Table structure for table `fi_cd_cliente_clie`
--

DROP TABLE IF EXISTS `fi_cd_cliente_clie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_cd_cliente_clie` (
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  `CLIE_DS_EMAIL` varchar(50) DEFAULT NULL,
  `CLIE_DS_LOGIN` varchar(10) DEFAULT NULL,
  `CLIE_DS_NOME` varchar(50) DEFAULT NULL,
  `CLIE_DS_NUMCARTAO` varchar(50) DEFAULT NULL,
  `CLIE_DS_PWD` varchar(100) DEFAULT NULL,
  `CLIE_DS_TELEFONE` varchar(50) DEFAULT NULL,
  `CLIE_TP_CARTAO` int(11) DEFAULT NULL,
  `CLIE_TP_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIE_CD_CLIENTE`),
  UNIQUE KEY `UK_dv8tcmbeax3sp2w8ke7754hvb` (`CLIE_DS_LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_cd_cliente_clie`
--

LOCK TABLES `fi_cd_cliente_clie` WRITE;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_cd_cliente_clie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_compra_comp`
--

DROP TABLE IF EXISTS `fi_ng_compra_comp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_compra_comp` (
  `ID_COMP_CD_COMPRA` int(11) NOT NULL,
  `COMP_DH_COMPRA` varchar(255) DEFAULT NULL,
  `COMP_DH_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_DS_EVENTO` varchar(255) DEFAULT NULL,
  `COMP_NR_VALOR` double DEFAULT NULL,
  `ID_TICK_CD_TICKET` int(11) DEFAULT NULL,
  `ID_CLIE_CD_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMP_CD_COMPRA`),
  KEY `FK_92gigm0yx6ynbulh81xh78nm6` (`ID_CLIE_CD_CLIENTE`),
  CONSTRAINT `FK_92gigm0yx6ynbulh81xh78nm6` FOREIGN KEY (`ID_CLIE_CD_CLIENTE`) REFERENCES `fi_cd_cliente_clie` (`ID_CLIE_CD_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_compra_comp`
--

LOCK TABLES `fi_ng_compra_comp` WRITE;
/*!40000 ALTER TABLE `fi_ng_compra_comp` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_compra_comp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fi_ng_numeradora_nume`
--

DROP TABLE IF EXISTS `fi_ng_numeradora_nume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fi_ng_numeradora_nume` (
  `NUME_DS_ENTITY` varchar(50) NOT NULL,
  `NUME_NR_APPBUFFER` int(11) NOT NULL,
  `NUME_NR_NEXTVAL` int(11) NOT NULL,
  PRIMARY KEY (`NUME_DS_ENTITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fi_ng_numeradora_nume`
--

LOCK TABLES `fi_ng_numeradora_nume` WRITE;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` DISABLE KEYS */;
/*!40000 ALTER TABLE `fi_ng_numeradora_nume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 18:20:17
