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
  `ma_admin` int(11) NOT NULL,
  `ten_tkql` varchar(100) NOT NULL,
  PRIMARY KEY (`ma_admin`),
  KEY `fk_Admin_tenTKQL` (`ten_tkql`),
  CONSTRAINT `FK2e19hw29o7fiut3cy8btpygy5` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`),
  CONSTRAINT `fk_Admin_tenTKQL` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`)
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
-- Table structure for table `bien_ban`
--

DROP TABLE IF EXISTS `bien_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bien_ban` (
  `so_bien_ban` int(11) NOT NULL AUTO_INCREMENT,
  `ma_duyet` int(11) NOT NULL,
  `ngay_muon` date NOT NULL,
  `ma_cbql` int(11) NOT NULL,
  PRIMARY KEY (`so_bien_ban`),
  KEY `fk_BienBan_maDuyet` (`ma_duyet`),
  KEY `FKdc08r32rrkf3ibn9j9meyvnck` (`ma_cbql`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien_ban`
--

LOCK TABLES `bien_ban` WRITE;
/*!40000 ALTER TABLE `bien_ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `bien_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbcs`
--

DROP TABLE IF EXISTS `cbcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbcs` (
  `ma_cbcs` int(11) NOT NULL AUTO_INCREMENT,
  `so_hieu_cand` varchar(10) NOT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `don_vi` varchar(50) DEFAULT NULL,
  `cap_bac` varchar(50) DEFAULT NULL,
  `chuc_vu` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ma_cbcs`)
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
  `ten_tk` varchar(100) NOT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `ma_cbcs` int(11) NOT NULL,
  PRIMARY KEY (`ten_tk`),
  KEY `fk_CBCSMember_maCBCS` (`ma_cbcs`),
  CONSTRAINT `FK7vpqrn3ga7w68m7apa5ymku40` FOREIGN KEY (`ma_cbcs`) REFERENCES `cbcs` (`ma_cbcs`),
  CONSTRAINT `fk_CBCSMember_maCBCS` FOREIGN KEY (`ma_cbcs`) REFERENCES `cbcs` (`ma_cbcs`)
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
  `ma_cbcs_not_mem` int(11) NOT NULL AUTO_INCREMENT,
  `ma_cbcs` int(11) NOT NULL,
  `so_hieu_cand` varchar(10) NOT NULL,
  PRIMARY KEY (`ma_cbcs_not_mem`),
  KEY `fk_CBCSNotMem_maCBCS` (`ma_cbcs`),
  CONSTRAINT `FKohbh6ud8h7dt0om1ps4lxv8yc` FOREIGN KEY (`ma_cbcs`) REFERENCES `cbcs` (`ma_cbcs`),
  CONSTRAINT `fk_CBCSNotMem_maCBCS` FOREIGN KEY (`ma_cbcs`) REFERENCES `cbcs` (`ma_cbcs`)
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
  `ma_cbql` int(11) NOT NULL AUTO_INCREMENT,
  `ten_tkql` varchar(100) NOT NULL,
  PRIMARY KEY (`ma_cbql`),
  KEY `fk_CBQL_maCBQL` (`ten_tkql`),
  CONSTRAINT `FKhk17lohowjnmu6t28bojle51f` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`),
  CONSTRAINT `fk_CBQL_maCBQL` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`)
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
-- Table structure for table `danh_sach_muon`
--

DROP TABLE IF EXISTS `danh_sach_muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danh_sach_muon` (
  `ma_muon` int(11) NOT NULL AUTO_INCREMENT,
  `so_hieu_vk_vln_ccht` int(11) NOT NULL,
  `ma_cbcs` int(11) NOT NULL,
  PRIMARY KEY (`ma_muon`),
  KEY `fk_DanhSachMuon_soHieuVKVLNCCHT` (`so_hieu_vk_vln_ccht`),
  KEY `FKg2mx89oax337yxwcmnixf66w1` (`ma_cbcs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_sach_muon`
--

LOCK TABLES `danh_sach_muon` WRITE;
/*!40000 ALTER TABLE `danh_sach_muon` DISABLE KEYS */;
/*!40000 ALTER TABLE `danh_sach_muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duyet_muon`
--

DROP TABLE IF EXISTS `duyet_muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `duyet_muon` (
  `ma_duyet` int(11) NOT NULL AUTO_INCREMENT,
  `ma_lanh_dao` int(11) NOT NULL,
  `ma_muon` int(11) NOT NULL,
  PRIMARY KEY (`ma_duyet`),
  KEY `fk_DuyetMuon_maLanhDao` (`ma_lanh_dao`),
  KEY `fk_DuyetMuon_maMuon` (`ma_muon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duyet_muon`
--

LOCK TABLES `duyet_muon` WRITE;
/*!40000 ALTER TABLE `duyet_muon` DISABLE KEYS */;
/*!40000 ALTER TABLE `duyet_muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpsd`
--

DROP TABLE IF EXISTS `gpsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gpsd` (
  `so_gpsd` int(11) NOT NULL AUTO_INCREMENT,
  `so_hieu_vk_vln_ccht` int(11) NOT NULL,
  `chung_loai_gpsd` varchar(20) DEFAULT NULL,
  `ngay_cap` date DEFAULT NULL,
  `ngay_het_han` date DEFAULT NULL,
  `nguoi_ky` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`so_gpsd`),
  KEY `fk_GPSD_soHieuVKVLNCCHT` (`so_hieu_vk_vln_ccht`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpsd`
--

LOCK TABLES `gpsd` WRITE;
/*!40000 ALTER TABLE `gpsd` DISABLE KEYS */;
INSERT INTO `gpsd` VALUES (123,1,'1','1990-01-01','1990-01-01','Hoa');
/*!40000 ALTER TABLE `gpsd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img_vk`
--

DROP TABLE IF EXISTS `img_vk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `img_vk` (
  `nhan_hieu_vk_vln_ccht` varchar(20) NOT NULL,
  `img_path` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`nhan_hieu_vk_vln_ccht`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img_vk`
--

LOCK TABLES `img_vk` WRITE;
/*!40000 ALTER TABLE `img_vk` DISABLE KEYS */;
/*!40000 ALTER TABLE `img_vk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lanh_dao`
--

DROP TABLE IF EXISTS `lanh_dao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lanh_dao` (
  `ma_lanh_dao` int(11) NOT NULL AUTO_INCREMENT,
  `ten_tkql` varchar(100) NOT NULL,
  PRIMARY KEY (`ma_lanh_dao`),
  KEY `fk_LanhDao_maLanhDao` (`ten_tkql`),
  CONSTRAINT `FK68sxl4w4fxj40ieg4e8lysir5` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`),
  CONSTRAINT `fk_LanhDao_maLanhDao` FOREIGN KEY (`ten_tkql`) REFERENCES `quan_ly` (`ten_tkql`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lanh_dao`
--

LOCK TABLES `lanh_dao` WRITE;
/*!40000 ALTER TABLE `lanh_dao` DISABLE KEYS */;
/*!40000 ALTER TABLE `lanh_dao` ENABLE KEYS */;
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
-- Table structure for table `phieu_tra`
--

DROP TABLE IF EXISTS `phieu_tra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phieu_tra` (
  `ma_tra` int(11) NOT NULL AUTO_INCREMENT,
  `so_bien_ban` int(11) NOT NULL,
  `ngay_tra` date NOT NULL,
  PRIMARY KEY (`ma_tra`),
  KEY `fk_PhieuTra_soBienBan` (`so_bien_ban`),
  CONSTRAINT `fk_PhieuTra_soBienBan` FOREIGN KEY (`so_bien_ban`) REFERENCES `bien_ban` (`so_bien_ban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_tra`
--

LOCK TABLES `phieu_tra` WRITE;
/*!40000 ALTER TABLE `phieu_tra` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieu_tra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quan_ly`
--

DROP TABLE IF EXISTS `quan_ly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quan_ly` (
  `ten_tkql` varchar(100) NOT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `so_hieu_cand` varchar(10) NOT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `cap_bac` varchar(50) DEFAULT NULL,
  `chuc_vu` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ten_tkql`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quan_ly`
--

LOCK TABLES `quan_ly` WRITE;
/*!40000 ALTER TABLE `quan_ly` DISABLE KEYS */;
/*!40000 ALTER TABLE `quan_ly` ENABLE KEYS */;
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
-- Table structure for table `vk_vln_ccht`
--

DROP TABLE IF EXISTS `vk_vln_ccht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vk_vln_ccht` (
  `so_hieu_vk_vln_ccht` int(11) NOT NULL AUTO_INCREMENT,
  `chung_loai` varchar(20) DEFAULT NULL,
  `nhan_hieu_vk_vln_ccht` varchar(20) DEFAULT NULL,
  `so_luong` int(11) DEFAULT '1',
  `don_vi_tinh` varchar(10) DEFAULT NULL,
  `nuoc_san_xuat` varchar(20) DEFAULT NULL,
  `tinh_trang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`so_hieu_vk_vln_ccht`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vk_vln_ccht`
--

LOCK TABLES `vk_vln_ccht` WRITE;
/*!40000 ALTER TABLE `vk_vln_ccht` DISABLE KEYS */;
INSERT INTO `vk_vln_ccht` VALUES (1,'1','1',2,'2','Viet Nam','0');
/*!40000 ALTER TABLE `vk_vln_ccht` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-21  8:49:07
