-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyvkvlnccht
-- ------------------------------------------------------
-- Server version	5.7.25-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `maAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `tenTKQL` varchar(100) NOT NULL,
  PRIMARY KEY (`maAdmin`),
  KEY `fk_Admin_tenTKQL` (`tenTKQL`),
  CONSTRAINT `fk_Admin_tenTKQL` FOREIGN KEY (`tenTKQL`) REFERENCES `quanly` (`tenTKQL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_role` (
  `ROLE_ID` varchar(20) NOT NULL,
  `ROLE_NAME` varchar(30) NOT NULL,
  `DEL_FLAG` varchar(1) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `CREATE_PROGRAM` varchar(50) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `UPDATE_USER` varchar(50) NOT NULL,
  `UPDATE_PROGRAM` varchar(50) NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `APP_ROLE_UK` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
/*!40000 ALTER TABLE `app_role` DISABLE KEYS */;
INSERT INTO `app_role` VALUES ('1','ROLE_ADMIN','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('2','ROLE_CBQL','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('3','ROLE_LANH_DAO','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('4','ROLE_CBCS','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12');
/*!40000 ALTER TABLE `app_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `USER_ID` varchar(20) NOT NULL,
  `USER_NAME` varchar(36) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  `Locale` varchar(13) NOT NULL,
  `DEL_FLAG` varchar(1) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `CREATE_PROGRAM` varchar(50) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `UPDATE_USER` varchar(50) NOT NULL,
  `UPDATE_PROGRAM` varchar(50) NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `APP_USER_UK` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES ('1','admin','Admin','$2a$10$G/DbF7nH/dnwS0s2EaavtOtbaucB231SvlhEqc2TwjNoPZYmMXBCa',_binary '','vn','0','HoaNV','ADMIN','2019-01-01 12:12:12','HoaNV','ADMIN','2019-01-01 12:12:12',NULL),('2','cbql','CBQL','$2a$10$G/DbF7nH/dnwS0s2EaavtOtbaucB231SvlhEqc2TwjNoPZYmMXBCa',_binary '','vn','0','HoaNV','ADMIN','2019-01-01 12:12:12','HoaNV','ADMIN','2019-01-01 12:12:12',NULL),('3','lanhdao','Lãnh Đạo','$2a$10$G/DbF7nH/dnwS0s2EaavtOtbaucB231SvlhEqc2TwjNoPZYmMXBCa',_binary '','vn','0','HoaNV','ADMIN','2019-01-01 12:12:12','HoaNV','ADMIN','2019-01-01 12:12:12',NULL),('4','cbcs','CBCS','$2a$10$G/DbF7nH/dnwS0s2EaavtOtbaucB231SvlhEqc2TwjNoPZYmMXBCa',_binary '','vn','0','HoaNV','ADMIN','2019-01-01 12:12:12','HoaNV','ADMIN','2019-01-01 12:12:12',NULL);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user_detail`
--

DROP TABLE IF EXISTS `app_user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user_detail` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar_path` varchar(255) DEFAULT NULL,
  `cmn_create_date` datetime DEFAULT NULL,
  `cmn_create_program` varchar(255) DEFAULT NULL,
  `cmn_create_user` varchar(255) DEFAULT NULL,
  `cmn_update_date` datetime DEFAULT NULL,
  `cmn_update_program` varchar(255) DEFAULT NULL,
  `cmn_update_user` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `in_date` varchar(255) DEFAULT NULL,
  `leader_id` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `mail_fsoft` varchar(255) DEFAULT NULL,
  `out_date` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `phone_number_urgent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user_detail`
--

LOCK TABLES `app_user_detail` WRITE;
/*!40000 ALTER TABLE `app_user_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bienban`
--

DROP TABLE IF EXISTS `bienban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bienban` (
  `soBienBan` int(11) NOT NULL AUTO_INCREMENT,
  `maDuyet` int(11) NOT NULL,
  `ngayMuon` date NOT NULL,
  `maCBQL` int(11) NOT NULL,
  PRIMARY KEY (`soBienBan`),
  KEY `fk_BienBan_maDuyet` (`maDuyet`),
  KEY `fk_BienBan_maCBQL` (`maCBQL`),
  CONSTRAINT `fk_BienBan_maCBQL` FOREIGN KEY (`maCBQL`) REFERENCES `cbql` (`maCBQL`),
  CONSTRAINT `fk_BienBan_maDuyet` FOREIGN KEY (`maDuyet`) REFERENCES `duyetmuon` (`maDuyet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bienban`
--

LOCK TABLES `bienban` WRITE;
/*!40000 ALTER TABLE `bienban` DISABLE KEYS */;
/*!40000 ALTER TABLE `bienban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbcs`
--

DROP TABLE IF EXISTS `cbcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbcs` (
  `maCBCS` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuCAND` varchar(10) NOT NULL,
  `hoTen` varchar(50) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `donVi` varchar(50) DEFAULT NULL,
  `capBac` varchar(50) DEFAULT NULL,
  `chucVu` varchar(50) DEFAULT NULL,
  `soDienThoai` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`maCBCS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbcs`
--

LOCK TABLES `cbcs` WRITE;
/*!40000 ALTER TABLE `cbcs` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbcs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbcs_member`
--

DROP TABLE IF EXISTS `cbcs_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbcs_member` (
  `tenTK` varchar(100) NOT NULL,
  `matKhau` varchar(255) NOT NULL,
  `maCBCS` int(11) NOT NULL,
  PRIMARY KEY (`tenTK`),
  KEY `fk_CBCSMember_maCBCS` (`maCBCS`),
  CONSTRAINT `fk_CBCSMember_maCBCS` FOREIGN KEY (`maCBCS`) REFERENCES `cbcs` (`maCBCS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbcs_member`
--

LOCK TABLES `cbcs_member` WRITE;
/*!40000 ALTER TABLE `cbcs_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbcs_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbcs_not_mem`
--

DROP TABLE IF EXISTS `cbcs_not_mem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbcs_not_mem` (
  `maCBCS_Not_Mem` int(11) NOT NULL AUTO_INCREMENT,
  `maCBCS` int(11) NOT NULL,
  `soHieuCAND` varchar(10) NOT NULL,
  PRIMARY KEY (`maCBCS_Not_Mem`),
  KEY `fk_CBCSNotMem_maCBCS` (`maCBCS`),
  CONSTRAINT `fk_CBCSNotMem_maCBCS` FOREIGN KEY (`maCBCS`) REFERENCES `cbcs` (`maCBCS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbcs_not_mem`
--

LOCK TABLES `cbcs_not_mem` WRITE;
/*!40000 ALTER TABLE `cbcs_not_mem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbcs_not_mem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbql`
--

DROP TABLE IF EXISTS `cbql`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbql` (
  `maCBQL` int(11) NOT NULL AUTO_INCREMENT,
  `tenTKQL` varchar(100) NOT NULL,
  PRIMARY KEY (`maCBQL`),
  KEY `fk_CBQL_maCBQL` (`tenTKQL`),
  CONSTRAINT `fk_CBQL_maCBQL` FOREIGN KEY (`tenTKQL`) REFERENCES `quanly` (`tenTKQL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbql`
--

LOCK TABLES `cbql` WRITE;
/*!40000 ALTER TABLE `cbql` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbql` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccht`
--

DROP TABLE IF EXISTS `ccht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ccht` (
  `maCCHT` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuVK_VLN_CCHT` int(11) NOT NULL,
  PRIMARY KEY (`maCCHT`),
  KEY `fk_CCHT_soHieuVKVLNCCHT` (`soHieuVK_VLN_CCHT`),
  CONSTRAINT `fk_CCHT_soHieuVKVLNCCHT` FOREIGN KEY (`soHieuVK_VLN_CCHT`) REFERENCES `vk_vln_ccht` (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccht`
--

LOCK TABLES `ccht` WRITE;
/*!40000 ALTER TABLE `ccht` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhsachmuon`
--

DROP TABLE IF EXISTS `danhsachmuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhsachmuon` (
  `maMuon` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuVK_VLN_CCHT` int(11) NOT NULL,
  `maCBCS` int(11) NOT NULL,
  PRIMARY KEY (`maMuon`),
  KEY `fk_DanhSachMuon_soHieuVKVLNCCHT` (`soHieuVK_VLN_CCHT`),
  KEY `fk_DanhSachMuon_maCBCS` (`maCBCS`),
  CONSTRAINT `fk_DanhSachMuon_maCBCS` FOREIGN KEY (`maCBCS`) REFERENCES `cbcs` (`maCBCS`),
  CONSTRAINT `fk_DanhSachMuon_soHieuVKVLNCCHT` FOREIGN KEY (`soHieuVK_VLN_CCHT`) REFERENCES `vk_vln_ccht` (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhsachmuon`
--

LOCK TABLES `danhsachmuon` WRITE;
/*!40000 ALTER TABLE `danhsachmuon` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhsachmuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duyetmuon`
--

DROP TABLE IF EXISTS `duyetmuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `duyetmuon` (
  `maDuyet` int(11) NOT NULL AUTO_INCREMENT,
  `maLanhDao` int(11) NOT NULL,
  `maMuon` int(11) NOT NULL,
  PRIMARY KEY (`maDuyet`),
  KEY `fk_DuyetMuon_maLanhDao` (`maLanhDao`),
  KEY `fk_DuyetMuon_maMuon` (`maMuon`),
  CONSTRAINT `fk_DuyetMuon_maLanhDao` FOREIGN KEY (`maLanhDao`) REFERENCES `lanhdao` (`maLanhDao`),
  CONSTRAINT `fk_DuyetMuon_maMuon` FOREIGN KEY (`maMuon`) REFERENCES `danhsachmuon` (`maMuon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duyetmuon`
--

LOCK TABLES `duyetmuon` WRITE;
/*!40000 ALTER TABLE `duyetmuon` DISABLE KEYS */;
/*!40000 ALTER TABLE `duyetmuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpsd`
--

DROP TABLE IF EXISTS `gpsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gpsd` (
  `soGPSD` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuVK_VLN_CCHT` int(11) NOT NULL,
  `chungLoaiGPSD` varchar(20) DEFAULT NULL,
  `ngayCap` date DEFAULT NULL,
  `ngayHetHan` date DEFAULT NULL,
  `nguoiKy` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`soGPSD`),
  KEY `fk_GPSD_soHieuVKVLNCCHT` (`soHieuVK_VLN_CCHT`),
  CONSTRAINT `fk_GPSD_soHieuVKVLNCCHT` FOREIGN KEY (`soHieuVK_VLN_CCHT`) REFERENCES `vk_vln_ccht` (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpsd`
--

LOCK TABLES `gpsd` WRITE;
/*!40000 ALTER TABLE `gpsd` DISABLE KEYS */;
/*!40000 ALTER TABLE `gpsd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imgvk`
--

DROP TABLE IF EXISTS `imgvk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imgvk` (
  `nhanHieuVK_VLN_CCHT` varchar(20) NOT NULL,
  `imgPath` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`nhanHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imgvk`
--

LOCK TABLES `imgvk` WRITE;
/*!40000 ALTER TABLE `imgvk` DISABLE KEYS */;
/*!40000 ALTER TABLE `imgvk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lanhdao`
--

DROP TABLE IF EXISTS `lanhdao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lanhdao` (
  `maLanhDao` int(11) NOT NULL AUTO_INCREMENT,
  `tenTKQL` varchar(100) NOT NULL,
  PRIMARY KEY (`maLanhDao`),
  KEY `fk_LanhDao_maLanhDao` (`tenTKQL`),
  CONSTRAINT `fk_LanhDao_maLanhDao` FOREIGN KEY (`tenTKQL`) REFERENCES `quanly` (`tenTKQL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lanhdao`
--

LOCK TABLES `lanhdao` WRITE;
/*!40000 ALTER TABLE `lanhdao` DISABLE KEYS */;
/*!40000 ALTER TABLE `lanhdao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_screen`
--

DROP TABLE IF EXISTS `mst_screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_screen` (
  `id` varchar(255) NOT NULL,
  `awesome_class` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_program` varchar(255) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `locale` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_display` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_program` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_screen`
--

LOCK TABLES `mst_screen` WRITE;
/*!40000 ALTER TABLE `mst_screen` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieutra`
--

DROP TABLE IF EXISTS `phieutra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phieutra` (
  `maTra` int(11) NOT NULL AUTO_INCREMENT,
  `soBienBan` int(11) NOT NULL,
  `ngayTra` date NOT NULL,
  PRIMARY KEY (`maTra`),
  KEY `fk_PhieuTra_soBienBan` (`soBienBan`),
  CONSTRAINT `fk_PhieuTra_soBienBan` FOREIGN KEY (`soBienBan`) REFERENCES `bienban` (`soBienBan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieutra`
--

LOCK TABLES `phieutra` WRITE;
/*!40000 ALTER TABLE `phieutra` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieutra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanly`
--

DROP TABLE IF EXISTS `quanly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quanly` (
  `tenTKQL` varchar(100) NOT NULL,
  `matKhau` varchar(255) DEFAULT NULL,
  `soHieuCAND` varchar(10) NOT NULL,
  `hoTen` varchar(50) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `capBac` varchar(50) DEFAULT NULL,
  `chucVu` varchar(50) DEFAULT NULL,
  `soDienThoai` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tenTKQL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanly`
--

LOCK TABLES `quanly` WRITE;
/*!40000 ALTER TABLE `quanly` DISABLE KEYS */;
/*!40000 ALTER TABLE `quanly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ID` varchar(20) NOT NULL,
  `USER_ID` varchar(20) NOT NULL,
  `ROLE_ID` varchar(20) NOT NULL,
  `DEL_FLAG` varchar(1) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `CREATE_PROGRAM` varchar(50) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `UPDATE_USER` varchar(50) NOT NULL,
  `UPDATE_PROGRAM` varchar(50) NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_ROLE_UK` (`USER_ID`,`ROLE_ID`),
  KEY `USER_ROLE_FK2` (`ROLE_ID`),
  CONSTRAINT `FKg7fr1r7o0fkk41nfhnjdyqn7b` FOREIGN KEY (`USER_ID`) REFERENCES `app_user` (`USER_ID`),
  CONSTRAINT `FKp6m37g6n6c288s096400uw8fw` FOREIGN KEY (`ROLE_ID`) REFERENCES `app_role` (`ROLE_ID`),
  CONSTRAINT `USER_ROLE_FK1` FOREIGN KEY (`USER_ID`) REFERENCES `app_user` (`USER_ID`),
  CONSTRAINT `USER_ROLE_FK2` FOREIGN KEY (`ROLE_ID`) REFERENCES `app_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('1','1','1','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('2','2','2','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('3','3','3','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12'),('4','4','4','0','ADMIN','ADMIN','2019-01-01 12:12:12','ADMIN','ADMIN','2019-01-01 12:12:12');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vk`
--

DROP TABLE IF EXISTS `vk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vk` (
  `maVK` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuVK_VLN_CCHT` int(11) NOT NULL,
  PRIMARY KEY (`maVK`),
  KEY `fk_VK_soHieuVKVLNCCHT` (`soHieuVK_VLN_CCHT`),
  CONSTRAINT `fk_VK_soHieuVKVLNCCHT` FOREIGN KEY (`soHieuVK_VLN_CCHT`) REFERENCES `vk_vln_ccht` (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vk`
--

LOCK TABLES `vk` WRITE;
/*!40000 ALTER TABLE `vk` DISABLE KEYS */;
/*!40000 ALTER TABLE `vk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vk_vln_ccht`
--

DROP TABLE IF EXISTS `vk_vln_ccht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vk_vln_ccht` (
  `soHieuVK_VLN_CCHT` int(11) NOT NULL AUTO_INCREMENT,
  `chungLoai` varchar(20) DEFAULT NULL,
  `nhanHieuVK_VLN_CCHT` varchar(20) DEFAULT NULL,
  `soLuong` int(11) DEFAULT '1',
  `donViTinh` varchar(10) DEFAULT NULL,
  `nuocSanXuat` varchar(20) DEFAULT NULL,
  `tinhTrang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vk_vln_ccht`
--

LOCK TABLES `vk_vln_ccht` WRITE;
/*!40000 ALTER TABLE `vk_vln_ccht` DISABLE KEYS */;
/*!40000 ALTER TABLE `vk_vln_ccht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vln`
--

DROP TABLE IF EXISTS `vln`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vln` (
  `maVLN` int(11) NOT NULL AUTO_INCREMENT,
  `soHieuVK_VLN_CCHT` int(11) NOT NULL,
  PRIMARY KEY (`maVLN`),
  KEY `fk_VLN_soHieuVKVLNCCHT` (`soHieuVK_VLN_CCHT`),
  CONSTRAINT `fk_VLN_soHieuVKVLNCCHT` FOREIGN KEY (`soHieuVK_VLN_CCHT`) REFERENCES `vk_vln_ccht` (`soHieuVK_VLN_CCHT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vln`
--

LOCK TABLES `vln` WRITE;
/*!40000 ALTER TABLE `vln` DISABLE KEYS */;
/*!40000 ALTER TABLE `vln` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18  9:36:11
