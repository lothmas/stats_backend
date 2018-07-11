-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: stats
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `casted_votes`
--

DROP TABLE IF EXISTS `casted_votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casted_votes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `member_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `voter_identity` int(1) NOT NULL COMMENT '(1) UNANIMOUS  (2) IDENTIFY',
  `like` int(1) DEFAULT NULL COMMENT '1(thumps_up) 2(thumps_down)',
  `nomination` varchar(5000) CHARACTER SET utf8 NOT NULL,
  `nomination_type` int(2) DEFAULT NULL,
  `creation_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casted_votes`
--

LOCK TABLES `casted_votes` WRITE;
/*!40000 ALTER TABLE `casted_votes` DISABLE KEYS */;
/*!40000 ALTER TABLE `casted_votes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `code` varchar(3) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `currency` varchar(3) NOT NULL DEFAULT '',
  `currency_name` varchar(255) NOT NULL DEFAULT '',
  `iso_2_code` varchar(2) DEFAULT NULL,
  `continent` varchar(15) NOT NULL DEFAULT '',
  `old_country_code` varchar(3) DEFAULT NULL,
  `country_partner_id` int(11) NOT NULL DEFAULT '0',
  `dialing_code` varchar(45) DEFAULT '',
  `utc_offset` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8 COMMENT='utf8_general_ci';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'ZAF','South Africa','ZAR','South African Rand','ZA','Africa',NULL,4,'27',0),(2,'AUS','Australia','AUD','Australian Dollar','AU','Australia',NULL,4,'61',0),(3,'NZL','New Zealand','NZD','New Zealand Dollar','NZ','Australia',NULL,5,'64',0),(4,'POL','Poland','PLN','Polish Zloty','PL','Europe',NULL,4,'48',0),(5,'CAN','Canada','CAD','Canadian Dollar','CA','North America',NULL,12,'1',0),(6,'USA','United States','USD','US Dollars','US','North America',NULL,4,'1',0),(7,'CHN','China','CNY','','CN','Asia',NULL,4,'86',0),(8,'IND','India','INR','Indian Rupee','IN','Asia',NULL,4,'91',0),(9,'AUT','Austria','EUR','Euro','AT','Europe',NULL,4,'43',0),(10,'BEL','Belgium','EUR','Euro','BE','Europe',NULL,4,'32',0),(11,'HRV','Croatia','EUR','Euro','HR','Europe',NULL,4,'385',0),(12,'CYP','Cyprus','EUR','Euro','CY','Europe',NULL,4,'357',0),(13,'CZE','Czech Republic','CZK','Czech Krona','CZ','Europe',NULL,4,'420',0),(14,'EGY','Egypt','','','EG','Africa',NULL,4,'20',0),(15,'FRA','France','EUR','Euro','FR','Europe',NULL,4,'33',0),(16,'DEU','Germany','EUR','Euro','DE','Europe',NULL,4,'49',0),(17,'GRC','Greece','EUR','Euro','GR','Europe',NULL,4,'30',0),(18,'NLD','Netherlands','EUR','Euro','NL','Europe',NULL,4,'31',0),(19,'HUN','Hungary','HUF','Hungarian Forint','HU','Europe',NULL,4,'36',0),(20,'IRL','Ireland','EUR','Euro','IE','Europe',NULL,4,'353',0),(21,'ITA','Italy','EUR','Euro','IT','Europe',NULL,4,'39',0),(22,'JPN','Japan','JPY','Japanese Yen','JP','Asia',NULL,4,'81',0),(23,'NAM','Namibia','NAD','Namibian Dollar','NA','Africa',NULL,4,'264',0),(24,'NOR','Norway','NOK','Norwegian Krona','NO','Europe',NULL,4,'47',0),(25,'PRT','Portugal','EUR','Euro','PT','Europe',NULL,4,'351',0),(26,'ESP','Spain','EUR','Euro','ES','Europe','SPA',4,'34',0),(27,'SWE','Sweden','SEK','Swedish Krona','SE','Europe',NULL,4,'46',0),(28,'THA','Thailand','THB','Thai Baht','TH','Asia',NULL,4,'66',0),(29,'ARE','United Arab Emirates','AED','UAE Dirham','AE','Middle East',NULL,4,'971',0),(30,'GBR','United Kingdom','GBP','United Kingdom Pound','GB','Europe',NULL,4,'44',0),(31,'RUS','Russian Federation','RUB','Russian Ruble','RU','Europe',NULL,4,'7',0),(32,'CHE','Switzerland','CHF','Swiss franc','CH','Europe',NULL,4,'41',0),(33,'TUR','Turkey','','','TR','Middle East',NULL,4,'90',0),(34,'MUS','Mauritius','MUR','Mauritius rupee','MU','Africa',NULL,4,'230',0),(35,'SGP','Singapore','SGD','Singapore dollar','SG','Asia',NULL,4,'65',0),(36,'TWN','Taiwan','TWD','Taiwan New Dollars','TW','Asia',NULL,4,'886',0),(37,'MOZ','Mozambique','','','MZ','Africa',NULL,4,'258',0),(38,'HKG','Hong Kong','CNY','China Yuan Renminbi','HK','Asia','',4,'852',0),(40,'DNK','Denmark','DKK','Danish Krona','DK','Europe',NULL,4,'45',0),(41,'MYS','Malaysia','MYR','Malaysia Ringits','MY','Asia','MYA',4,'60',0),(42,'SVK','Slovakia','EUR','Euro','SK','Europe',NULL,4,'421',0),(44,'MDA','Moldova','EUR','Euro','MD','Europe','MDL',4,'373',0),(45,'FIN','Finland','EUR','Euro','FI','Europe',NULL,4,'358',0),(47,'UGA','Uganda','','','UG','Africa',NULL,4,'256',0),(50,'ECB','East Caribbean','XCD','East Caribbean Dollars',NULL,'North America',NULL,4,'758',0),(57,'MAR','Morocco','MAD','Morocco Dirhams','MA','Africa',NULL,4,'212',0),(62,'LKA','Sri Lanka','LKR','Sri Lanka Rupees','LK','Asia',NULL,4,'94',0),(64,'TTO','Trinidad and Tobago','TTD','Trinidad and Tobago Dollars','TT','North America',NULL,4,'1868',0),(65,'ZMB','Zambia','ZMW','Zambia Kwacha','ZM','Africa',NULL,4,'260',0),(67,'BWA','Botswana','BWP','Botswana Pulas','BW','Africa',NULL,4,'267',0),(69,'PHL','Philippines','PHP','Philippine Peso','PH','Asia',NULL,6,'63',0),(71,'LUX','Luxembourg','EUR','Euro','LU','Europe',NULL,4,'352',0),(72,'MEX','Mexico','MXN','Mexico Pesos','MX','North America',NULL,4,'52',0),(73,'UKR','Ukraine','USD','US Dollars','UA','Europe',NULL,4,'380',0),(74,'KOR','South Korea','KRW','South Korea Won','KR','Asia',NULL,4,'82',0),(75,'IDN','Indonesia','IDR','Indonesia Rupiahs','ID','Asia',NULL,4,'62',0),(76,'PAK','Pakistan','PKR','Pakistan Rupees','PK','Asia',NULL,4,'92',0),(77,'KWT','Kuwait','KWD','Kuwait Dinars','KW','Middle East',NULL,4,'965',0),(78,'BHR','Bahrain','BHD','Bahrain Dinars','BH','Middle East',NULL,4,'973',0),(79,'OMN','Oman','OMR','Oman Rials','OM','Middle East',NULL,4,'968',0),(80,'KEN','Kenya','KES','Kenya Shillings','KE','Africa',NULL,7,'254',10800),(81,'NGA','Nigeria','NGN','Nigeria Naira','NG','Africa',NULL,8,'234',0),(82,'BGR','Bulgaria','BGN','Bulgaria Leva','BG','Europe',NULL,4,'359',0),(83,'EST','Estonia','EUR','Euro','EE','Europe',NULL,4,'372',0),(84,'LTU','Lithuania','LTL','Lithuania Litas','LT','Europe',NULL,4,'370',0),(85,'ROU','Romania','RON','Romania New Lei','RO','Europe',NULL,4,'40',0),(88,'ARG','Argentina','ARS','Argentina Pesos','AR','South America',NULL,4,'54',0),(89,'PRY','Paraguay','PYG','Paraguay Guarani','PY','South America',NULL,4,'595',0),(90,'VEN','Venezuela','VEB','Venezuela Bolivares','VE','South America',NULL,4,'58',0),(95,'DOM','Dominican Republic','DOP','Dominican Republic Pesos','DO','North America',NULL,4,'1809, 1829, 1849',0),(96,'BRA','Brazil','BRL','Brazil Reais','BR','South America',NULL,4,'55',0),(98,'SAU','Saudi Arabia','SAR','Saudi Arabian Riyal','SA','Middle East',NULL,4,'966',0),(99,'AGO','Angola','AOA','Angola Kwanza','AO','Africa',NULL,4,'244',0),(100,'BDI','Burundi','BIF','Burundi Francs','BI','Africa',NULL,4,'257',0),(101,'BGD','Bangladesh','BDT','Bangladesh Taka','BD','Asia',NULL,4,'880',0),(102,'BHS','Bahamas','BSD','Bahamas Dollars','BS','North America',NULL,4,'1242',0),(103,'BIH','Bosnia','BAM','Bosnia and Herzegovina Convertible Marka','BA','Europe',NULL,4,'387',0),(104,'BLR','Belarus','BYR','Belarus Rubles','BY','Europe',NULL,4,'375',0),(105,'BLZ','Belize','BZD','Belize Dollars','BZ','North America',NULL,4,'501',0),(106,'BMU','Bermuda','BMD','Bermuda Dollars','BM','North America',NULL,4,'1441',0),(107,'BOL','Bolivia','BOB','Bolivia Bolivianos','BO','South America',NULL,4,'591',0),(108,'BRB','Barbados','BBD','Barbados Dollars','BB','North America',NULL,4,'1246',0),(109,'CHL','Chile','CLP','Chile Pesos','CL','South America',NULL,4,'56',0),(110,'COG','Congo','CDF','Congo/Kinshasa Francs','CG','Africa',NULL,4,'242',0),(111,'CRI','Costa Rica','CRC','Costa Rica Colones','CR','North America',NULL,4,'506',0),(112,'CUB','Cuba','CUP','Cuba Pesos','CU','North America',NULL,4,'53',0),(113,'CYM','Cayman Islands','KYD','Cayman Islands Dollars','KY','North America',NULL,4,'1345',0),(114,'ETH','Ethiopia','ETB','Ethopia Birr','ET','Africa',NULL,4,'251',0),(115,'FJI','Fiji','FJD','Fiji Dollars','FJ','Australia',NULL,4,'679',0),(116,'GHA','Ghana','GHS','Ghana Cedis','GH','Africa',NULL,4,'233',0),(117,'GMB','Gambia','GMD','Gambia Dalasia','GM','Africa',NULL,4,'220',0),(118,'GTM','Guatemala','GTQ','Guatemala Quetzales','GT','North America',NULL,4,'502',0),(119,'GUY','Guyana','GYD','Guyana Dollars','GY','South America',NULL,4,'592',0),(120,'HND','Honduras','HNL','Honduras Lempiras','HN','North America',NULL,4,'504',0),(121,'HTI','Haiti','HTG','Haiti Gourdes','HT','North America',NULL,4,'509',0),(122,'ISL','Iceland','ISK','Iceland Krona','IS','Europe',NULL,4,'354',0),(123,'ISR','Israel','ILS','Israel New Shekels','IL','Middle East',NULL,10,'972',0),(124,'JAM','Jamaica','JMD','Jamaica Dollars','JM','North America',NULL,4,'1876',0),(125,'JOR','Jordan','JOD','Jordan Dinars','JO','Middle East',NULL,4,'962',0),(126,'KHM','Cambodia','KHR','Cambodia Riels','KH','Asia',NULL,4,'855',0),(127,'LBN','Lebanon','LBP','Lebanon Pounds','LB','Middle East',NULL,4,'961',0),(129,'LSO','Lesotho','LSL','Lesotho Maloti','LS','Africa',NULL,4,'266',0),(130,'LVA','Latvia','LVL','Latvia Lati','LV','Europe',NULL,4,'371',0),(131,'MDG','Madagascar','MGA','Madagascar Ariary','MG','Africa',NULL,4,'261',0),(132,'MDV','Maldives','MVR','Maldives Rufiyaa','MV','Asia',NULL,4,'960',0),(133,'MRT','Mauritania','MRO','Mauritania Ouguiyas','MR','Africa',NULL,4,'222',0),(134,'MWI','Malawi','MWK','Malawi Kwachas','MW','Africa',NULL,4,'265',0),(135,'NPL','Nepal','NPR','Nepal Rupees','NP','Asia',NULL,4,'977',0),(136,'PAN','Panama','PAB','Panama Balboas','PA','North America',NULL,4,'507',0),(137,'PER','Peru','PEN','Peru Nuevos Soles','PE','South America',NULL,4,'51',0),(138,'QAT','Qatar','QAR','Qatar Riyals','QA','Middle East',NULL,4,'974',0),(139,'RWA','Rwanda','RWF','Rwanda Francs','RW','Africa',NULL,4,'250',0),(140,'SLE','Sierra Leone','SLL','Siera Leone Leones','SL','Africa',NULL,4,'232',0),(141,'SRB','Serbia','RSD','Serbia Dinars','RS','Europe',NULL,4,'381',0),(142,'SWZ','Swaziland','SZL','Swaziland Emalangeni','SZ','Africa',NULL,4,'268',0),(143,'SYC','Seychelles','SCR','Seychelles Rupees','SC','Africa',NULL,4,'248',0),(144,'TON','Tonga','TOP','Tonga Pa`anga','TO','Australia',NULL,4,'676',0),(145,'TUN','Tunisia','TND','Tunisia Dinars','TN','Africa',NULL,4,'216',0),(146,'TZA','Tanzania','TZS','Tanzania Shillings','TZ','Africa',NULL,4,'255',0),(147,'URY','Uruguay','UYU','Uruguay Pesos','UY','South America',NULL,4,'598',0),(148,'VNM','Vietnam','VND','Vietnam Dong','VN','Asia',NULL,4,'84',0),(149,'WSM','Samoa','WST','Samao Tala','WS','Australia',NULL,4,'685',0),(150,'ZWE','Zimbabwe','NAD','United States Dollars','ZW','Africa','ZIM',9,'263',0),(151,'AFG','Afghanistan','','','AF','Middle East',NULL,4,'93',0),(152,'ALB','Albania','','','AL','Europe',NULL,4,'355',0),(153,'DZA','Algeria','','','DZ','Africa',NULL,4,'213',0),(154,'ASM','American Samoa','','','AS','Australia',NULL,4,'1684',0),(155,'AND','Andorra','','','AD','Europe',NULL,4,'376',0),(156,'AIA','Anguilla','','','AI','North America',NULL,4,'1264',0),(157,'ATG','Antigua and Barbuda','','','AG','North America',NULL,4,'1268',0),(158,'ARM','Armenia','','','AM','Asia',NULL,4,'374',0),(159,'ABW','Aruba','','','AW','North America',NULL,4,'297',0),(160,'AZE','Azerbaijan','','','AZ','Asia',NULL,4,'994',0),(161,'BEN','Benin','','','BJ','Africa',NULL,4,'229',0),(162,'BTN','Bhutan','','','BT','Asia',NULL,4,'975',0),(163,'BRN','Brunei','','','BN','Asia',NULL,4,'673',0),(164,'BFA','Burkina Faso','','','BF','Africa',NULL,4,'226',0),(165,'CMR','Cameroon','','','CM','Africa',NULL,4,'237',0),(166,'CPV','Cape Verde','','','CV','Africa',NULL,4,'238',0),(167,'CAF','Central African Republic','','','CF','Africa',NULL,4,'236',0),(168,'TCD','Chad','','','TD','Africa',NULL,4,'235',0),(169,'COL','Colombia','COP','Columbian Peso','CO','South America',NULL,4,'57',0),(170,'COM','Comoros','','','KM','Africa',NULL,4,'269',0),(171,'COD','DRC','','','CD','Africa',NULL,4,'243',0),(172,'COK','Cook Islands','','','CK','Australia',NULL,4,'682',0),(173,'CIV','Cote D\'Ivoire','','','CI','Africa',NULL,4,'225',0),(174,'DJI','Djibouti','','','DJ','Africa',NULL,4,'253',0),(175,'DMA','Dominica','','','DM','South America',NULL,4,'1767',0),(176,'TMP','East Timor','','','','Asia',NULL,4,'670',0),(177,'ECU','Ecuador','','','EC','South America',NULL,4,'593',0),(178,'SLV','El Salvador','','','SV','North America',NULL,4,'503',0),(179,'GNQ','Equatorial Guinea','','','GQ','Africa',NULL,4,'240',0),(180,'ERI','Eritrea','','','ER','Africa',NULL,4,'291',0),(181,'FRO','Faroe Islands','','','FO','Europe',NULL,4,'298',0),(182,'GAB','Gabon','','','GA','Africa',NULL,4,'241',0),(183,'GEO','Georgia','','','GE','Europe',NULL,4,'995',0),(184,'GIB','Gibraltar','','','GI','Europe',NULL,4,'350',0),(185,'GRL','Greenland','','','GL','North America',NULL,4,'299',0),(186,'GRD','Grenada','','','GD','North America',NULL,4,'1473',0),(187,'GLP','Guadeloupe','','','GP','North America',NULL,4,'590',0),(188,'GUM','Guam','','','GU','Australia',NULL,4,'1671',0),(189,'GIN','Guinea','GNF','Guinea Franc','GN','Africa',NULL,4,'224',0),(190,'GNB','Guinea-Bissau','','','GW','Africa',NULL,4,'245',0),(191,'IRN','Iran','','','IR','Middle East',NULL,4,'98',0),(192,'IRQ','Iraq','','','IQ','Middle East',NULL,4,'964',0),(193,'KAZ','Kazakhstan','','','KZ','Asia',NULL,4,'76, 77',0),(194,'KIR','Kiribati','','','KI','Australia',NULL,4,'686',0),(195,'PRK','Peoples Republic of Korea','','','KP','Asia',NULL,4,'850',0),(197,'KGZ','Kyrgyzstan','','','KG','Asia',NULL,4,'996',0),(198,'LAO','Laos','','','LA','Asia',NULL,4,'856',0),(199,'LBR','Liberia','','','LR','Africa',NULL,4,'231',0),(200,'LBY','Libya','','','LY','Africa',NULL,4,'218',0),(201,'LIE','Liechtenstein','','','LI','Europe',NULL,4,'423',0),(202,'MAC','Macau','','','MO','Asia',NULL,4,'853',0),(203,'MKD','Macedonia','','','MK','Europe',NULL,4,'389',0),(204,'MLI','Mali','','','ML','Africa',NULL,4,'223',0),(205,'MLT','Malta','','','MT','Europe',NULL,4,'356',0),(206,'MTQ','Martinique','','','MQ','North America',NULL,4,'596',0),(207,'MYT','Mayotte','','','YT','Africa',NULL,4,'262',0),(208,'MCO','Monaco','','','MC','Europe',NULL,4,'377',0),(209,'MNG','Mongolia','','','MN','Asia',NULL,4,'976',0),(210,'MSR','Montserrat','','','MS','North America',NULL,4,'1664',0),(211,'MMR','Myanmar','','','NM','Asia',NULL,4,'95',0),(212,'NRU','Nauru','','','NR','Australia',NULL,4,'674',0),(213,'NIC','Nicaragua','','','NI','North America',NULL,4,'505',0),(214,'NER','Niger','','','NE','Africa',NULL,4,'227',0),(215,'PLW','Palau','','','PW','Australia',NULL,4,'680',0),(216,'PNG','Papua New Guinea','','','PG','Australia',NULL,4,'675',0),(217,'PRI','Puerto Rico','','','PR','North America',NULL,4,'1787, 1939',0),(218,'REU','Reunion','','','RE','Africa',NULL,4,'262',0),(219,'KNA','Saint Kitts and Nevis','','','KN','North America',NULL,4,'1869',0),(220,'LCA','Saint Lucia','','','LC','North America',NULL,4,'1758',0),(221,'SMR','San Marino','','','SM','Europe',NULL,4,'378',0),(222,'SEN','Senegal','','','SN','Africa',NULL,4,'221',0),(223,'SVN','Slovenia','','','SI','Europe',NULL,4,'386',0),(224,'SOM','Somalia','','','SO','Africa',NULL,4,'252',0),(225,'SDN','Sudan','','','SD','Africa',NULL,4,'249',0),(226,'SUR','Suriname','','','SR','South America',NULL,4,'597',0),(227,'SYR','Syria','','','SY','Middle East',NULL,4,'963',0),(228,'TJK','Tajikistan','','','TJ','Asia',NULL,4,'992',0),(229,'TGO','Togo','','','TG','Africa',NULL,4,'228',0),(230,'TKM','Turkmenistan','','','TM','Asia',NULL,4,'993',0),(231,'UZB','Uzbekistan','','','UZ','Asia',NULL,4,'998',0),(232,'YEM','Yemen','','','YE','Middle East',NULL,4,'967',0),(233,'YUG','Yugoslavia','','','','Europe',NULL,4,'381',0),(234,'GGY','Guernsey','','','GG','Europe',NULL,4,'44',0),(236,'ABK','Abkhazia','RUB','Russian ruble','AB','Europe',NULL,4,'7840, 7940, 995',0),(237,'IOM','Isle of Man','','','IM','Europe',NULL,4,'44',0),(238,'JEY','Jersey','','','JE','Europe',NULL,4,'44',0),(239,'NCL','New Caledonia','','','NC','Europe',NULL,0,'687',0),(240,'VGB','British Virgin Islands','','','VG','North America',NULL,0,'284',0),(241,'SWX','Branch - Bern/Switzerland','','','CH','Europe',NULL,0,'',0),(242,'SWY','Branch - Geneva/Switzerland','','','CH','Europe',NULL,0,'',0),(243,'E4F','E4F Wallet','','','4F','E4F Wallet','',0,'',NULL);
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expected_stats`
--

DROP TABLE IF EXISTS `expected_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expected_stats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) NOT NULL,
  `vote_type` int(1) DEFAULT NULL COMMENT '1(like_dislike) 2(rating) 3(ranking)',
  `views` int(1) DEFAULT NULL,
  `comments` int(1) DEFAULT NULL,
  `location_restrictions` varchar(5000) CHARACTER SET utf8 DEFAULT NULL COMMENT '4 cardinal location separated by a comma n,w,s,e',
  `gender` int(1) DEFAULT NULL,
  `race` int(1) DEFAULT NULL,
  `age_range` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT 'age range',
  `occupation` int(1) DEFAULT NULL,
  `occupation_industry` int(1) DEFAULT NULL,
  `location_stats` int(1) DEFAULT NULL,
  `age_stats` int(1) DEFAULT NULL,
  `occupation_industry_restriction` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT 'the only proffessions you require',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expected_stats`
--

LOCK TABLES `expected_stats` WRITE;
/*!40000 ALTER TABLE `expected_stats` DISABLE KEYS */;
/*!40000 ALTER TABLE `expected_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `following`
--

DROP TABLE IF EXISTS `following`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `following` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `followed_member_id` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `following`
--

LOCK TABLES `following` WRITE;
/*!40000 ALTER TABLE `following` DISABLE KEYS */;
/*!40000 ALTER TABLE `following` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `industrial_classification`
--

DROP TABLE IF EXISTS `industrial_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `industrial_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industrial_classification`
--

LOCK TABLES `industrial_classification` WRITE;
/*!40000 ALTER TABLE `industrial_classification` DISABLE KEYS */;
INSERT INTO `industrial_classification` VALUES (1,'Holiday and Accommodation Services Including Catering',NULL),(2,'Financial and Insurance',NULL),(3,'Legal, Accounting, Tax and Business Management Activities',NULL),(4,'Educational Services',NULL),(5,'Real Estate and Rent',NULL),(6,'Sporting and Other Recreational Activities',NULL),(7,'Government and Municipal Services',NULL),(8,'Construction and Building',NULL),(9,'Community, Social and Personal Services',NULL),(10,'Film, Radio, TV, News and Other Entertainment Activities',NULL),(11,'Computer, Data and Business Services',NULL),(12,'Transport, Storage and Telecoms',NULL),(13,'Architectural and Engineering',NULL),(14,'Advertising',NULL),(15,'Research and Development',NULL),(16,'Health and Vetenary Services',NULL),(17,'Wholesale and Retail Trade Including Motor Vehicles',NULL),(18,'Manufacturing and Printing',NULL),(19,'Electricity, Gas and Water',NULL),(20,'Agriculture, Hunting, Forestry & Fishing',NULL),(21,'Mining & Quarrying',NULL);
/*!40000 ALTER TABLE `industrial_classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `usert_type` int(1) DEFAULT NULL COMMENT 'individual (1)    Corporate (2)',
  `email_address` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mobile_number` varchar(45) COLLATE utf8_bin NOT NULL,
  `enabled` int(1) NOT NULL,
  `date_established` date DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `race` int(1) DEFAULT NULL COMMENT '    1) American Indian or Alaska Native.\n    2) Asian.\n    3) Black or African American.\n    4) Native Hawaiian or Other Pacific Islander.\n    5) White.\n    6) MIxed	',
  `first_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `surname` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `marital_status` int(1) DEFAULT NULL COMMENT 'MARITAL STATUS 0 (SINGLE)  1(MARRIED) 3(DIVORCED)',
  `gender` int(1) DEFAULT NULL COMMENT 'gender 1 (MALE) 2(FEMALE)',
  `identification` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `identification_type` int(1) DEFAULT NULL,
  `profile_pic_path` varchar(5000) COLLATE utf8_bin DEFAULT NULL,
  `preferred_categories` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `member_id_UNIQUE` (`member_id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'MMM111','louis','',1,'lothmas@live.com','+2780915010',1,'1988-07-09',NULL,NULL,3,'louis','maparura',1,1,'63-19558 W 42',1,'http://www.car-brand-names.com/wp-content/uploads/2015/04/BMW-logo.png',NULL),(2,'MMM112','fifa.com','',1,'lothmas@live.com','+2780915010',1,'1988-07-09',NULL,NULL,3,'louis','maparura',1,1,'63-19558 W 42',1,'https://acnntv.com/wp-content/uploads/2017/12/world-cup-trophy_18l6eo08udnjp10sb13z6qxiok-696x392.jpg',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `votes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `title` varchar(45) COLLATE utf8_bin NOT NULL,
  `post_path` varchar(5000) CHARACTER SET utf8 DEFAULT NULL,
  `post_type` int(1) NOT NULL COMMENT '0 (description only) 1(Picture) 2(Video)',
  `enabled` int(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `vote_type` int(1) DEFAULT NULL COMMENT '0 (open) 1 (closed)',
  `creation_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes` DISABLE KEYS */;
INSERT INTO `votes` VALUES (1,'MMM111','Pic Your Choice','2017 Best USV Of the Year','https://s3.ap-southeast-1.amazonaws.com/images.deccanchronicle.com/dc-Cover-mij5p9tr598drd4b5ljgunh066-20170527123550.Medi.jpeg',1,1,NULL,NULL,1,'2018-06-11 07:59:00'),(2,'MMM112','Who Will Win Fifa World Cup 2018, Have your say.','2018 FIFA World Cup Russia™','https://steemitimages.com/0x0/https://cdn.steemitimages.com/DQmXo1tQGY8aPmjHJKecaNKgay7WEWR4kfniqinjy4gh1jP/fifa-world-cup-2018-russia.jpg',1,1,NULL,NULL,1,'2018-06-11 07:59:00');
/*!40000 ALTER TABLE `votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-11 16:56:54
