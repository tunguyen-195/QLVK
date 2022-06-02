-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyvkvlnccht
-- ------------------------------------------------------
-- Server version	5.7.38-log

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
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
-- Table structure for table `bien_ban`
--

DROP TABLE IF EXISTS `bien_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bien_ban` (
  `so_bien_ban` int(11) NOT NULL AUTO_INCREMENT,
  `ma_duyet` int(11) NOT NULL,
  `ngay_muon` date NOT NULL,
  `ma_cbql` int(11) NOT NULL,
  `da_xuat_bien_ban` int(11) DEFAULT NULL,
  PRIMARY KEY (`so_bien_ban`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien_ban`
--

LOCK TABLES `bien_ban` WRITE;
/*!40000 ALTER TABLE `bien_ban` DISABLE KEYS */;
INSERT INTO `bien_ban` VALUES (1,1,'2022-06-01',1,0),(2,1,'2022-06-01',1,0);
/*!40000 ALTER TABLE `bien_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbcs`
--

DROP TABLE IF EXISTS `cbcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cbcs` (
  `user_id` varchar(20) NOT NULL,
  `so_hieu_cand` varchar(10) NOT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `don_vi` varchar(50) DEFAULT NULL,
  `cap_bac` varchar(50) DEFAULT NULL,
  `chuc_vu` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(10) DEFAULT NULL,
  `ma_cbcs` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbcs`
--

LOCK TABLES `cbcs` WRITE;
/*!40000 ALTER TABLE `cbcs` DISABLE KEYS */;
INSERT INTO `cbcs` VALUES ('cbql','1','hien','2000-07-12','C1','Trung tá','thủ quỷ','11223344','1'),('user1','2','Ha','2000-06-01','C2','Thiếu úy','chơi','22334455','2'),('user2','3','Ha1','2000-06-01','C3','Thiếu úy','chơi','22334455','3'),('user3','4','ha2','2000-06-01','c4','Thiếu úy','chơi','22334455','4'),('user4','5','ha3','2000-06-01','c5','Thiếu úy','chơi','22334455','5'),('user5','6','ha4','2000-06-01','c6','Thiếu úy','chơi','22334455','6');
/*!40000 ALTER TABLE `cbcs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_muon`
--

DROP TABLE IF EXISTS `chi_tiet_muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_muon` (
  `ma_chi_tiet` int(11) NOT NULL AUTO_INCREMENT,
  `ma_muon` int(11) NOT NULL,
  `ma_duyet` int(11) NOT NULL,
  `so_hieu_vk_vln_ccht` int(11) NOT NULL,
  PRIMARY KEY (`ma_chi_tiet`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_muon`
--

LOCK TABLES `chi_tiet_muon` WRITE;
/*!40000 ALTER TABLE `chi_tiet_muon` DISABLE KEYS */;
INSERT INTO `chi_tiet_muon` VALUES (1,1,1,2),(2,1,1,3),(3,1,1,9),(4,1,1,9),(5,1,1,9),(6,1,1,9);
/*!40000 ALTER TABLE `chi_tiet_muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danh_sach_muon`
--

DROP TABLE IF EXISTS `danh_sach_muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_sach_muon` (
  `ma_muon` int(11) NOT NULL AUTO_INCREMENT,
  `nhan_hieu_vk_vln_ccht` varchar(20) NOT NULL,
  `ma_cbcs` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `trang_thai_muon` int(11) DEFAULT NULL,
  `ly_do` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ma_muon`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_sach_muon`
--

LOCK TABLES `danh_sach_muon` WRITE;
/*!40000 ALTER TABLE `danh_sach_muon` DISABLE KEYS */;
INSERT INTO `danh_sach_muon` VALUES (3,'004',4,6,4,NULL),(9,'001',1,1,3,NULL),(10,'001',1,0,4,NULL),(11,'001',1,0,4,'thich thi muon'),(12,'001',1,1,0,''),(13,'001',1,1,0,''),(14,'004',1,1,0,''),(15,'006',1,1,0,''),(16,'006',1,1,0,''),(17,'006',1,1,0,'');
/*!40000 ALTER TABLE `danh_sach_muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duyet_muon`
--

DROP TABLE IF EXISTS `duyet_muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duyet_muon` (
  `ma_duyet` int(11) NOT NULL AUTO_INCREMENT,
  `ma_lanh_dao` int(11) NOT NULL,
  `ma_muon` int(11) NOT NULL,
  `so_hieu_vk_vln_ccht` int(11) DEFAULT NULL,
  PRIMARY KEY (`ma_duyet`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duyet_muon`
--

LOCK TABLES `duyet_muon` WRITE;
/*!40000 ALTER TABLE `duyet_muon` DISABLE KEYS */;
INSERT INTO `duyet_muon` VALUES (1,1,1,NULL),(2,2,2,NULL),(3,3,3,NULL);
/*!40000 ALTER TABLE `duyet_muon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpsd`
--

DROP TABLE IF EXISTS `gpsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpsd` (
  `so_gpsd` int(11) NOT NULL AUTO_INCREMENT,
  `so_hieu_vk_vln_ccht` int(11) NOT NULL,
  `chung_loai_gpsd` varchar(20) DEFAULT NULL,
  `ngay_cap` date DEFAULT NULL,
  `ngay_het_han` date DEFAULT NULL,
  `nguoi_ky` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`so_gpsd`),
  KEY `fk_GPSD_soHieuVKVLNCCHT` (`so_hieu_vk_vln_ccht`)
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
-- Table structure for table `img_vk`
--

DROP TABLE IF EXISTS `img_vk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `img_vk` VALUES ('001','ak1.png'),('002','ak2.png'),('003','m16.png');
/*!40000 ALTER TABLE `img_vk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
-- Table structure for table `phan_loai`
--

DROP TABLE IF EXISTS `phan_loai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phan_loai` (
  `ma_phan_loai_1` varchar(20) NOT NULL,
  `gia_tri_phan_loai_1` varchar(20) NOT NULL,
  `ten_hien_thi_1` varchar(20) DEFAULT NULL,
  `ma_phan_loai_2` varchar(20) DEFAULT NULL,
  `gia_tri_phan_loai_2` varchar(20) DEFAULT NULL,
  `ten_hien_thi_2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ma_phan_loai_1`,`gia_tri_phan_loai_1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phan_loai`
--

LOCK TABLES `phan_loai` WRITE;
/*!40000 ALTER TABLE `phan_loai` DISABLE KEYS */;
/*!40000 ALTER TABLE `phan_loai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_tra`
--

DROP TABLE IF EXISTS `phieu_tra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_tra` (
  `ma_tra` int(11) NOT NULL AUTO_INCREMENT,
  `so_bien_ban` int(11) NOT NULL,
  `ngay_tra` date NOT NULL,
  PRIMARY KEY (`ma_tra`)
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
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vk_vln_ccht` (
  `so_hieu_vk_vln_ccht` int(11) NOT NULL,
  `chung_loai` varchar(20) NOT NULL,
  `nhan_hieu_vk_vln_ccht` varchar(20) NOT NULL,
  `don_vi_tinh` varchar(10) DEFAULT NULL,
  `nuoc_san_xuat` varchar(20) DEFAULT NULL,
  `tinh_trang` varchar(45) NOT NULL,
  PRIMARY KEY (`so_hieu_vk_vln_ccht`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vk_vln_ccht`
--

LOCK TABLES `vk_vln_ccht` WRITE;
/*!40000 ALTER TABLE `vk_vln_ccht` DISABLE KEYS */;
INSERT INTO `vk_vln_ccht` VALUES (5,'3','004','2','Viet Nam','0'),(6,'3','006','2','Viet Nam','0'),(7,'3','006','2','Viet Nam','0'),(8,'3','006','2','Viet Nam','0'),(9,'1','001','khẩu','Việt Nam','0'),(34,'1','001','khẩu','Việt Nam','0');
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

-- Dump completed on 2022-06-02 20:17:59
