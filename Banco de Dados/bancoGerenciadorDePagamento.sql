CREATE DATABASE  IF NOT EXISTS `gerenciadordepagamento` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gerenciadordepagamento`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gerenciadordepagamento
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `cartaodecredito`
--

DROP TABLE IF EXISTS `cartaodecredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartaodecredito` (
  `idCartaoDeCredito` int(11) NOT NULL AUTO_INCREMENT,
  `NumCartao` int(11) NOT NULL,
  `VencimentoCartao` date NOT NULL,
  `NomeTitular` varchar(45) NOT NULL,
  `CVV` varchar(45) NOT NULL,
  `FormaDePagamento_idFormaDePagamento` int(11) NOT NULL,
  PRIMARY KEY (`idCartaoDeCredito`),
  KEY `fk_CartaoDeCredito_FormaDePagamento1_idx` (`FormaDePagamento_idFormaDePagamento`),
  CONSTRAINT `fk_CartaoDeCredito_FormaDePagamento1` FOREIGN KEY (`FormaDePagamento_idFormaDePagamento`) REFERENCES `formadepagamento` (`idFormaDePagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartaodecredito`
--

LOCK TABLES `cartaodecredito` WRITE;
/*!40000 ALTER TABLE `cartaodecredito` DISABLE KEYS */;
INSERT INTO `cartaodecredito` VALUES (1,234234,'2012-02-02','jo2232se','3333333',1),(2,234234234,'2012-05-05','JOSE','123',2),(3,12345,'2012-12-12','maria','123',3);
/*!40000 ALTER TABLE `cartaodecredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome_cli` varchar(45) NOT NULL,
  `CPF_cli` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formadepagamento`
--

DROP TABLE IF EXISTS `formadepagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formadepagamento` (
  `idFormaDePagamento` int(11) NOT NULL AUTO_INCREMENT,
  `DataHora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Viagem_idViagem` int(11) NOT NULL,
  PRIMARY KEY (`idFormaDePagamento`),
  KEY `fk_FormaDePagamento_Viagem1_idx` (`Viagem_idViagem`),
  CONSTRAINT `fk_FormaDePagamento_Viagem1` FOREIGN KEY (`Viagem_idViagem`) REFERENCES `viagem` (`idViagem`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formadepagamento`
--

LOCK TABLES `formadepagamento` WRITE;
/*!40000 ALTER TABLE `formadepagamento` DISABLE KEYS */;
INSERT INTO `formadepagamento` VALUES (1,'2017-11-04 15:08:12',1),(2,'2017-11-16 18:17:26',4),(3,'2017-11-16 18:54:39',6),(4,'2017-11-18 18:11:19',7),(5,'2017-11-18 18:16:33',8),(6,'2017-11-18 18:18:01',9),(7,'2017-11-19 03:01:30',9),(8,'2017-11-19 03:03:39',9),(9,'2017-11-19 03:03:57',9),(10,'2017-11-19 03:11:39',9),(11,'2017-11-19 04:25:33',10),(12,'2017-11-19 04:35:26',10),(13,'2017-11-19 04:40:05',10),(14,'2017-11-19 04:41:40',10);
/*!40000 ALTER TABLE `formadepagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorista`
--

DROP TABLE IF EXISTS `motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motorista` (
  `idmotorista` int(11) NOT NULL,
  `nome_mot` varchar(45) NOT NULL,
  `CNH` varchar(45) NOT NULL,
  `CPF_mot` varchar(45) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `CEP` varchar(45) DEFAULT NULL,
  `Saldo` double DEFAULT NULL,
  PRIMARY KEY (`idmotorista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorista`
--

LOCK TABLES `motorista` WRITE;
/*!40000 ALTER TABLE `motorista` DISABLE KEYS */;
/*!40000 ALTER TABLE `motorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paypal`
--

DROP TABLE IF EXISTS `paypal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paypal` (
  `idPayPal` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(45) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `NumeroCartao` int(11) NOT NULL,
  `FormaDePagamento_idFormaDePagamento` int(11) NOT NULL,
  PRIMARY KEY (`idPayPal`),
  KEY `fk_PayPal_FormaDePagamento1_idx` (`FormaDePagamento_idFormaDePagamento`),
  CONSTRAINT `fk_PayPal_FormaDePagamento1` FOREIGN KEY (`FormaDePagamento_idFormaDePagamento`) REFERENCES `formadepagamento` (`idFormaDePagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paypal`
--

LOCK TABLES `paypal` WRITE;
/*!40000 ALTER TABLE `paypal` DISABLE KEYS */;
/*!40000 ALTER TABLE `paypal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valepresente`
--

DROP TABLE IF EXISTS `valepresente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valepresente` (
  `idValePresente` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Valor` double NOT NULL,
  `FormaDePagamento_idFormaDePagamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idValePresente`),
  KEY `fk_ValePresente_FormaDePagamento1_idx` (`FormaDePagamento_idFormaDePagamento`),
  CONSTRAINT `fk_ValePresente_FormaDePagamento1` FOREIGN KEY (`FormaDePagamento_idFormaDePagamento`) REFERENCES `formadepagamento` (`idFormaDePagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valepresente`
--

LOCK TABLES `valepresente` WRITE;
/*!40000 ALTER TABLE `valepresente` DISABLE KEYS */;
INSERT INTO `valepresente` VALUES (1,'cd1',50,7),(2,'cd2',30,9),(3,'cd3',20,8),(4,'cd4',50,10),(5,'a1',50,12),(7,'a3',30,14),(14,'d2',32.02,NULL);
/*!40000 ALTER TABLE `valepresente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viagem`
--

DROP TABLE IF EXISTS `viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viagem` (
  `idViagem` int(11) NOT NULL AUTO_INCREMENT,
  `Origem` varchar(45) NOT NULL,
  `Destino` varchar(45) NOT NULL,
  `TotalViagem` double NOT NULL,
  `motorista_idmotorista` int(11) DEFAULT NULL,
  `cliente_idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idViagem`),
  KEY `fk_Viagem_motorista1_idx` (`motorista_idmotorista`),
  KEY `fk_Viagem_cliente1_idx` (`cliente_idcliente`),
  CONSTRAINT `fk_Viagem_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viagem_motorista1` FOREIGN KEY (`motorista_idmotorista`) REFERENCES `motorista` (`idmotorista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viagem`
--

LOCK TABLES `viagem` WRITE;
/*!40000 ALTER TABLE `viagem` DISABLE KEYS */;
INSERT INTO `viagem` VALUES (1,'aki','ali',20,NULL,NULL),(2,'seraqvai','vaisim',800,NULL,NULL),(3,'rrrrrrrrrrrrrrrrrrrrr','tttttttttttttttttttttttttttttttttt',250,NULL,NULL),(4,'EEEEEEEEEEEEEEEEEEEEEEEEEE','RRRRRRRRRRRRRRR',20,NULL,NULL),(5,'tfdtd','dttfd',20.66,NULL,NULL),(6,'agoravai','vaimesmo',25.65,NULL,NULL),(7,'TENTANTIVA1','TESTE DE HISTORICO',50,NULL,NULL),(8,'teste','testando retorno',50.22,NULL,NULL),(9,'agoravai','testejcv2',40.56,NULL,NULL),(10,'sera','test1',20,NULL,NULL);
/*!40000 ALTER TABLE `viagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-19 19:42:22
