-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `cittadinoregistrato`
--

DROP TABLE IF EXISTS `cittadinoregistrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cittadinoregistrato` (
  `idCittadino` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `dataNascita` date NOT NULL,
  `luogoNascita` varchar(60) NOT NULL,
  `luogoResidenza` varchar(60) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`idCittadino`),
  UNIQUE KEY `cf_UNIQUE` (`cf`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cittadinoregistrato`
--

LOCK TABLES `cittadinoregistrato` WRITE;
/*!40000 ALTER TABLE `cittadinoregistrato` DISABLE KEYS */;
INSERT INTO `cittadinoregistrato` VALUES (1,'Andrea','Palmieri','HYAXMG61S31A510A','1936-03-11','San Giovanni Rotondo','Barletta','3829339105','rledger0@exblog.jp','kfarnall0','sM@9?*}<'),(2,'Chiara','Pagano','WZCPVX92Z99A267P','1934-07-27','Pietrasanta','Fidenza','3244803840','jind1@loc.gov','mdeverson1','qR_\"W3L0'),(3,'Elisa','Ferri','YVEMRJ69S88L573I','2010-11-01','Catanzaro','Catania','3019910958','ccoon2@ihg.com','aosullivan2','xC}P#$n+s3'),(4,'Stefano','Grasso','LFIPMW33N28O603F','1992-08-01','Pomezia','Bologna','3566258695','bbohlmann3@ustream.tv','csiege3','aR97LT7'),(5,'Roberto','Sartori','MMBZAF42U38Z407I','2004-02-07','San Giovanni Rotondo','Catanzaro','3297469588','kgreathead4@foxnews.com','ccustard4','aF#e1?2RrCl5{0'),(6,'Lorenzo','Marino','PIWQMU27A54Q273C','1928-09-02','Lecce','Como','3283247339','aliebermann5@army.mil','dumbert5','fA?1(`>iFk!Plo'),(7,'Ludovica','Messina','CLLPKF93S51Z560T','1905-03-05','Cagliari','Lecce','3533554380','cbarnhart6@histats.com','malyoshin6','fY&qksKJ!snE=u'),(8,'Veronica','Milani','PQSRNU94K88I686A','1963-05-22','Sulmona','Salerno','3399705661','aleathwood7@opensource.org','slening7','tU(a}!wTBNCQ'),(9,'Giulia','Lombardi','JUQVKO25F54W890V','1971-06-06','Mazara del Vallo','Firenze','3281166023','sosullivan8@domainmarket.com','dgoldney8','eX\'\"la,\"S1QrVIM'),(10,'Riccardo','Fabbri','BABRUZ47X29L010D','2004-10-08','Forlì','Città di Castello','3302233369','lescott9@wikispaces.com','mmartinuzzi9','lA@.V5}Y'),(11,'Lorenzo','D\'Angelo','AFIEQV03W08F877K','1994-04-17','Livorno','Cerveteri','3411088503','djohantgesa@apache.org','ngrafoma','bG>i3v<>L\'e|'),(12,'Valentina','Ferretti','XWELFK69D17T500Z','2019-08-31','Monza','Lecce','3932404912','ekillichb@cnn.com','ccadaganb','zH?1ly6Ye\''),(13,'Federica','Silvestri','SGODSA06G28A593U','1914-08-18','Ravenna','Foggia','3352305760','apaulleyc@answers.com','pcranmorec','sD}|qgSXs542F_u'),(14,'Laura','Mancini','UBOUWX81H65Y802G','1945-02-28','Sant\'Antimo','Catanzaro','3046628184','malcidod@nbcnews.com','mmendenhalld','qE=34AxO6@}\"%JQf'),(15,'Alessandro','Ricciardi','PTHFVX04G88X151D','2006-09-20','Sassari','Taranto','3079959572','tpasfielde@springer.com','tshucksmithe','sY%4#gU.zENXH\'k'),(16,'Ginevra','Sartori','MLLQOX33O50N932H','1922-06-14','Lecce','Ferrara','3174531143','tferrof@aboutads.info','lcollinettef','yT={T%cBqX@IPHs'),(17,'Martina','Ferretti','ZWCNNH51V40Q805M','2014-11-16','Venezia','Genova','3566460593','gfealyg@pinterest.com','lfaersg','uJ`i7OYy>=zd}*/'),(18,'Luca','Mancuso','KXHTKK90F97X990T','1981-05-03','Padova','Trento','3465291254','wjardinh@who.int','mbrafertonh','mM}U5!/%xTGia|'),(19,'Giuseppe','De Santis','XCDBQS00N91X172R','1924-05-27','Bologna','Giarre','3167682020','sthursbyi@google.cn','gjobbi','bV!S_r21dWDuq*'),(20,'Marco','Bernardi','WISPNR64J95D448U','1936-09-15','Lucca','Reggio Emilia','3203266703','ahachettej@dagondesign.com','lsprigingsj','bG`{TOhO~zp~pCd'),(21,'Michele','Valentini','DTLQVY32Y69B681H','1929-09-19','Ladispoli','Messina','3925364846','wphippenk@mashable.com','nwalisiakk','oD?G%~h{=ETCV5`'),(22,'Alessio','Caruso','PSOWCI86A40U967T','1904-05-30','Città della Pieve','Brescia','3673630725','adearl@jimdo.com','hbastianl','lB\"*4{ZGiM``,~M|'),(23,'Alessandro','Lombardi','KNASXS96W58J133Q','2005-08-06','Sulmona','Sassari','3274891623','dbrandelm@pcworld.com','smepstedm','oH$|yzQ4'),(24,'Sara','Fabbri','CYZQUL58D52D804G','1902-04-23','Cittadella','Terni','3232741815','etomasellin@google.it','rcurtainn','sS)!NgcK_|CLS._'),(25,'Sofia','Sorrentino','EMQIZA82C94H791Q','1947-07-02','Cosenza','Ferrara','3699240796','eperronio@ehow.com','fgirscho','yO<~#ZLeSX'),(26,'Federico','Ferrari','WTFLAU09B73G019V','1938-03-19','Padova','Forlì','3489723239','bjacoxp@constantcontact.com','erubinfajnp','hF\'uDj(%vJ|kWh$'),(27,'Antonio','Giuliani','RFSKIS73P31V772E','1939-07-10','Fidenza','Sulmona','3712945487','blodemannq@slashdot.org','rdaftorq','pI\"ww0@*'),(28,'Sara','Giuliano','QRZZCQ99D03T623C','1954-08-02','Cerveteri','Cuneo','3494557877','rgrowdenr@oakley.com','asultanar','oS!kko8Ai4)'),(29,'Paola','Salvatore','HBHOJS32S56E241Q','1985-03-09','Monza','Pietrasanta','3652165349','sthomens@nps.gov','ksantarellis','bS(UVG~y>'),(30,'Alessandro','Orlando','RUIGAY89Z08O017Q','1965-06-28','Lecce','Città della Pieve','3180363661','wcruddast@sina.com.cn','cklaggest','nF%d2x&se,}2`Q,'),(31,'Davide','Negri','AWRBXR18S85C382L','1972-10-14','Catania','Trento','3118668284','bbarberyu@berkeley.edu','iparru','yX~%U*SesV'),(32,'Sara','Ruggiero','NLXGCK41M24L900M','1903-06-13','Firenze','Pisa','3506588645','kmencov@over-blog.com','vbougheyv','bT/,s$NFVJsyFG'),(33,'Noemi','Messina','FUVGZK75F90K393Y','2005-03-16','Como','Como','3877491669','sorfordw@columbia.edu','ctunnaw','cQa2@o.*b8kXfc'),(34,'Noemi','Lombardi','WSCZSO81Y17V624Y','1910-09-20','Messina','Latina','3698202760','eledgewayx@about.me','mshirlandx','oI`s~yd9PDq('),(35,'Roberto','Negri','AHSVSX24E90P882J','1959-05-14','Ravenna','Genova','3968665155','cturlandy@soup.io','hclayworthy','aX$wdHTR<<K'),(36,'Beatrice','Damico','GCBMIQ45T99T496C','1933-04-18','Sassari','Pescara','3744751886','gtugwellz@bandcamp.com','bkohnekez','qP{|t+!nl?3~'),(37,'Michele','Marino','IPYXWU57K58Q686R','1991-11-18','Città Sant\'Angelo','Udine','3109312613','vtruran10@sfgate.com','gkonzelmann10','dG%o6?WI'),(38,'Veronica','Giannini','JQHADL38R23I499J','1997-09-29','Ravenna','Città di Castello','3378120882','egarbott11@altervista.org','zgosnell11','aY\'8eAQe'),(39,'Ylenia','Ferrari','MHHFPK92N65L694S','1946-11-28','Reggio Emilia','Taranto','3583665510','agrimmer12@discovery.com','aadolfson12','hI!0uRx3R`9rEg'),(40,'Paola','Longo','TMWKYO02P87Z120L','1947-11-05','Giugliano in Campania','Caserta','3666648590','pshillinglaw13@printfriendly.com','gcroson13','qE.Ew_Xf~'),(41,'Daniele','Lombardo','LGLBQO42B51Z168C','1975-06-09','Velletri','Genova','3146832905','gbavidge14@adobe.com','adorro14','uF%AS<ar%2'),(42,'Noemi','Caputo','LMMNHF67O76I882H','1974-12-31','Latina','Torino','3751613232','jgindghill15@reverbnation.com','amoneypenny15','lW\"oFi4yK&a.'),(43,'Federico','De Angelis','UOYUKS26K77X125H','1903-06-10','Cassino','Bolzano','3625072418','mmouse16@psu.edu','ocollelton16','aJ=1\'HLSDME_'),(44,'Luca','Vitali','YPAGGV72U94C339X','2008-01-29','Latina','Siracusa','3665426602','achainey17@walmart.com','oskehens17','dY`@6!3\"DpF{'),(45,'Alessia','Giuliani','MULBMI42S98R182C','1948-05-13','Grosseto','Barletta','3916320066','sdecourcy18@w3.org','kmines18','jZ`znmq*='),(46,'Sara','Franco','EMGYAK75M72T655I','1909-09-25','Sant\'Anastasia','Latina','3122529160','tbartolozzi19@vimeo.com','ttrent19','wW.KC1Q3gI'),(47,'Veronica','Sanna','TDIXBV05A54N871A','1933-10-21','Vicenza','Grosseto','3844668141','acroom1a@newyorker.com','crene1a','cT&8+7R5Ah$DOs'),(48,'Sara','Ruggiero','WWLLZZ39Y45G974B','1976-02-24','Siracusa','Andria','3857763219','ezeplin1b@pagesperso-orange.fr','bstormouth1b','tY?1ctN{x'),(49,'Martina','Messina','AXSZYX06L33S410M','1919-02-28','Pomezia','Palmi','3854975076','smattioli1c@icq.com','pschops1c','aU|>w~Y!iwuV,a'),(50,'Luca','Vitale','MHLRAQ06B68M298Y','2018-04-01','Bari','Castellammare di Stabia','3213970740','shain1d@nba.com','mmaliphant1d','wR}V3OuO'),(52,'Domenico','Coppola','DCPCMSW23HKW123','2023-06-09','Afghanistan','Pomigliano','3466558956','mistermuscolo@gmail.com','domecoppola','Domenico78@'),(101,'Alfonso','Micheletti','AFMCHR12FMMMMMM1','2023-07-12','Napoli','Napoli','3264569852','sdjjdwuwhd@dd9fj.com','alfomiche','AlfoMiche1#'),(105,'Michele','Ceccarelli','CMCCCR12HSWKMMM1','2023-07-11','Napoli','Napoli','3264512165','sgsgdhs@sjjdc.com','Mikececca','Mikececca7#'),(107,'Maurizio','Micheli','MSNDHW2MWMJWAJAA','2023-08-01','Napoli','Napoli','3268963145','maurimiche@gmail.com','mauroMiche','Mauromiche10$'),(108,'Giovanni','Alfonsini','HGASNMSSSM2NAANN','2023-08-26','Napoli','Napoli','3162563265','jognalfo@gmail.com','Johnalfo','JohnAlfo10@'),(109,'Gaudenzio','Panicucci','PNCGNZ38A23B963C','2023-08-18','Caserta','Caserta','0362986504','GaudenzioPanicucci@rhyta.com ','Turnintionce','     aezoh2eZ'),(110,'Giuseppe','Esposito','SPSGPP80A01F839B','2015-07-01','Napoli','Napoli','3488397653','Giusy.espo@hotmail.com','Giuseppe80','fLkxa7w&'),(111,'Giacomo','Comi','SHDNCMDOSKS5AMOA','2023-09-09','Napoli','Napoli','3286729641','jack@gmail.com','jackComi','Giacomo10$'),(112,'Giacomo','Micheli','AMSSK2HSMCKOKLAM','2023-09-09','Napoli','Napoli','3289612365','giaxco@gmail.com','JackMick','Giacomo10$');
/*!40000 ALTER TABLE `cittadinoregistrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codiceqr`
--

DROP TABLE IF EXISTS `codiceqr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codiceqr` (
  `codice` varchar(20) NOT NULL,
  `stanza` varchar(2) NOT NULL,
  `piano` int NOT NULL,
  PRIMARY KEY (`codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codiceqr`
--

LOCK TABLES `codiceqr` WRITE;
/*!40000 ALTER TABLE `codiceqr` DISABLE KEYS */;
INSERT INTO `codiceqr` VALUES ('8lDlK8FhZRBYdf5UJ2iw','um',3),('8LhBAEiB1Na2dZIfG07N','h2',2),('9GC848kGCURayj3hEreh','kl',4),('9LUijDaq9GHjb9YJx5ox','Xy',1),('9ndBHx9ctqClhQJLP0x5','bG',1),('9W3RgCU1XgW8m4Losx9m','IP',1),('E7XyYJAPX5idlDaBuFR1','NJ',2),('FYOSCsbTuCWf5poLX8au','cS',1),('GVx6mDf6Pf8JkONkyZTK','9W',1),('hJgilmXlEJEFTqcDl5s8','QU',5),('JteWZC6EjUF12ZU3wBC5','KU',5),('mChmME1GzfGrhQnsC9gq','hG',3),('th5wcHicjw94Pr8H4wmc','Tj',1);
/*!40000 ALTER TABLE `codiceqr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `idMedico` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `specializzazione` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`idMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'Sara','Ferretti','Neurologia','kmcglade0@msn.com','bP6~60|1vk%,n'),(2,'Daniele','Esposito','Reumatologia','jkerby1@gov.uk','vN0*b5<31aEz'),(3,'Paola','Milani','Gastroenterologia','fliddy2@jalbum.net','aF3(vs1YBMD'),(4,'Chiara','Russo','Oncologia','smatthai3@msn.com','aG7%CARa_'),(5,'Silvia','Giuliano','Gastroenterologia','lfitzer4@mlb.com','wK4\\bft_'),(6,'Giulia','Gatti','Dermatologia','abyrd5@lycos.com','qM8\\O#N_u<*x('),(7,'Veronica','Milani','Otorinolaringoiatria','wsnasel6@smh.com.au','iB5{L.yoI9KA'),(8,'Federico','Grassi','Gerontologia','scurrall7@yolasite.com','hS6?zy4OnN/'),(9,'Daniele','Longo','Reumatologia','ehayhow8@ask.com','aH8(K*1p56>s5'),(10,'Eleonora','Giuliani','Cardiologia','wfyall9@hexun.com','cR8\\1U9Y'),(11,'Federica','Moretti','Reumatologia','hgracewooda@hexun.com','tN3XZzwK'),(12,'Simone','Monti','Psichiatria','bbaignardb@domainmarket.com','eJ5(9je.(J'),(13,'Laura','Gatti','Dermatologia','loreaganc@tinypic.com','iE9(stquW(<'),(14,'Stefano','Milani','Otorinolaringoiatria','ofitzpaynd@dagondesign.com','iI5|IDpEf4gSlDp'),(15,'Federico','Lombardo','Endocrinologia','vlomaze@instagram.com','xB5|iv`m$%kR'),(16,'Marco','Rizzo','Neurologia','ecolliverf@wikia.com','hY8,>q}o|KNv=&'),(17,'Laura','Salvatore','Psichiatria','amceloryg@forbes.com','fX4(jMq41N'),(18,'Davide','Vitali','Pediatria','gtathamh@msu.edu','eY5/I*nBi<Ji'),(19,'Giulia','Ricci','Ginecologia','pventami@eventbrite.com','hF8@8a*}{&\\\\c~'),(20,'Gabriele','Fabbri','Urologia','ekelloughj@nbcnews.com','mV0}p,Oa4\\P%0UmP'),(21,'Sara','Colombo','Urologia','moculligank@google.de','nI7(V*8E6$6Sp'),(22,'Davide','Sanna','Endocrinologia','awittletonl@paypal.com','rS9`Rc3S9mz'),(23,'Giovanni','Parisi','Urologia','yhallattm@weibo.com','xU6&H%UFmv~UV<\"'),(24,'Serena','Monti','Gastroenterologia','bmccathien@ovh.net','iU4?x+J('),(25,'Giovanni','Lombardi','Pediatria','rwilloxo@vimeo.com','mC4~s3UNv4nRL/9'),(26,'Simone','Santini','Dermatologia','amaleckp@altervista.org','uM9+EE3Z'),(27,'Andrea','Bernardi','Urologia','llehucquetq@samsung.com','sU4+EI329>}$n>'),(28,'Fabio','Lombardo','Otorinolaringoiatria','bhaytonr@squarespace.com','aE8+e?BXTY,/L'),(29,'Marco','De Luca','Cardiologia','aseilmanns@cisco.com','zA1<T8Vv*WquN'),(30,'Stefano','Villa','Gerontologia','bprandit@ustream.tv','tE9&=h!Z'),(31,'Cristina','Giannini','Pediatria','dklainu@adobe.com','vJ7*=bD+kB7Ig'),(32,'Vittoria','Marchetti','Pediatria','cjessoppv@e-recht24.de','sS0`F$/@%YC_*7b'),(33,'Noemi','Gatti','Psichiatria','avenneurw@angelfire.com','hO3+!w|W'),(34,'Luca','Ruggiero','Oncologia','jrotterx@smugmug.com','aL2\"(d,G=TQ%'),(35,'Stefano','Benedetti','Reumatologia','spilchy@slate.com','nI4#\\e0m'),(36,'Simone','Riva','Urologia','doffilerz@issuu.com','mM8&Tk5kmUYod'),(37,'Sofia','Silvestro','Otorinolaringoiatria','awyatt10@nsw.gov.au','cO8%3N2T'),(38,'Veronica','Vitali','Psichiatria','tfairbanks11@wisc.edu','pI8\\~gJ*)I'),(39,'Silvia','Colombo','Cardiologia','tpickle12@angelfire.com','mK9>H4|>DG'),(40,'Serena','Martino','Pediatria','gduffet13@zdnet.com','gN8{SNgJJG\"z{or'),(41,'Giulia','Bianchi','Ginecologia','dwilce14@bloglines.com','aD1!D)N}~h{\"'),(42,'Stefano','Poli','Reumatologia','kjohnsson15@unc.edu','cR5*VL`mQ9wx*'),(43,'Veronica','Franco','Endocrinologia','dperrelli16@de.vu','eY7=T\"SiF'),(44,'Elisa','Palmieri','Oncologia','jmoraleda17@shareasale.com','nU7{M>2$)e3+'),(45,'Chiara','Martino','Neurologia','jretchless18@bloglovin.com','cV9#>ncQbR7+_2F'),(46,'Laura','Piras','Otorinolaringoiatria','swoolam19@prnewswire.com','vD8#EiJ_$'),(47,'Serena','Leone','Cardiologia','scarnilian1a@google.fr','fV5*$uoq.cEZwhG'),(48,'Marco','Vitale','Ginecologia','gmeekins1b@blinklist.com','xJ2>`it_~BAG&uo'),(49,'Laura','Salvatore','Neurologia','cbittleson1c@nasa.gov','zB4`l*XU'),(50,'Federica','Lombardi','Urologia','lennor1d@yellowbook.com','mM2=M$+!Ge3('),(64,'Mario','Tortora','Gastroenterologia','mvillaron1e@wunderground.com','oP1*ZUM!~BFO3le_'),(65,'Alfonso','Ghirardini','Ortologia','dmcareavey1f@hp.com','fG4`u?&&CFA5|='),(66,'Romualdo','Di Guida','Neurologia','romu@gmail.com','Romualdo10$'),(67,'Mario','Tortora','Gastroenterologia','giusy.espo@asl.com','fLkxa7w&'),(68,'Alfonso','Roberti','Cardiologia','alfo@gmail.com','Alfonso10$');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `idPrenotazione` int NOT NULL,
  `giorno` date NOT NULL,
  `CittadinoRegistrato_idCittadino` int NOT NULL,
  `Codice_CodiceQR` varchar(20) NOT NULL,
  `Visita_IdVisita` int NOT NULL,
  PRIMARY KEY (`idPrenotazione`,`CittadinoRegistrato_idCittadino`,`Codice_CodiceQR`),
  KEY `FK_ciitadino_IdCittadino_idx` (`CittadinoRegistrato_idCittadino`),
  KEY `FK_codice_codiceQR_idx` (`Codice_CodiceQR`),
  KEY `FK_visita_idVisita_idx` (`Visita_IdVisita`),
  CONSTRAINT `FK_cittadino_IdCittadino` FOREIGN KEY (`CittadinoRegistrato_idCittadino`) REFERENCES `cittadinoregistrato` (`idCittadino`) ON DELETE RESTRICT,
  CONSTRAINT `FK_codice_codiceQR` FOREIGN KEY (`Codice_CodiceQR`) REFERENCES `codiceqr` (`codice`) ON DELETE RESTRICT,
  CONSTRAINT `FK_visita_idVisita` FOREIGN KEY (`Visita_IdVisita`) REFERENCES `visita` (`idVisita`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (6,'2023-06-14',2,'8lDlK8FhZRBYdf5UJ2iw',5),(12,'2023-06-05',52,'th5wcHicjw94Pr8H4wmc',2),(13,'2023-06-15',52,'mChmME1GzfGrhQnsC9gq',26),(14,'2023-09-09',112,'JteWZC6EjUF12ZU3wBC5',55),(15,'2023-09-15',52,'9W3RgCU1XgW8m4Losx9m',46),(16,'2023-09-12',52,'FYOSCsbTuCWf5poLX8au',42),(17,'2023-09-20',52,'9GC848kGCURayj3hEreh',31),(18,'2023-09-23',52,'GVx6mDf6Pf8JkONkyZTK',14),(19,'2023-09-21',52,'E7XyYJAPX5idlDaBuFR1',45),(20,'2023-09-25',52,'8LhBAEiB1Na2dZIfG07N',8),(21,'2023-09-19',52,'9ndBHx9ctqClhQJLP0x5',35);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita` (
  `idVisita` int NOT NULL,
  `giorno` int NOT NULL,
  `orario` time NOT NULL,
  `descrizione` varchar(50) NOT NULL,
  `Medico_IdMedico` int NOT NULL,
  PRIMARY KEY (`idVisita`),
  KEY `FK_medico_idMedico_idx` (`Medico_IdMedico`),
  CONSTRAINT `FK_medico_idMedico` FOREIGN KEY (`Medico_IdMedico`) REFERENCES `medico` (`idMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
INSERT INTO `visita` VALUES (1,4,'17:00:00','Visita neurologica',1),(2,5,'13:00:00','Visita gastroenterologica',3),(3,6,'19:00:00','Visita gastroenterologica',5),(4,5,'20:00:00','Visita gastroenterologica',8),(5,4,'20:00:00','Visita urologica',20),(6,1,'20:00:00','Visita oculistica',4),(7,7,'20:00:00','Visita ginecologica',19),(8,2,'20:00:00','Visita cardiologica',10),(9,2,'09:00:00','Visita gastroenterologica',24),(10,5,'08:00:00','Esame del sangue',2),(11,4,'10:00:00','Visita otorinolaringoiatrica',7),(12,2,'20:00:00','Visita cardiologica',29),(13,6,'09:00:00','Visita oculistica',34),(14,7,'13:00:00','Visita cardiologica',39),(15,7,'20:00:00','Visita dermatologica',6),(16,1,'10:00:00','Visita urologica',21),(17,1,'08:00:00','Visita cardiologica',47),(18,4,'16:00:00','Visita ginecologica',41),(19,6,'08:00:00','Visita otorinolaringoiatrica',14),(20,7,'20:00:00','Visita dermatologica',13),(21,4,'09:00:00','Visita otorinolaringoiatrica',28),(22,1,'18:00:00','Visita neurologica',16),(23,5,'08:00:00','Visita ortopedica',12),(24,1,'08:00:00','Visita dermatologica',26),(25,7,'08:00:00','Visita dermatologica',26),(26,5,'18:00:00','Visita gastroenterologica',3),(27,1,'10:00:00','Visita neurologica',45),(28,1,'09:00:00','Visita ginecologica',48),(29,5,'09:00:00','Visita neurologica',49),(30,5,'09:00:00','Visita neurologica',1),(31,4,'20:00:00','Visita oculistica',44),(32,2,'20:00:00','Visita urologica',23),(33,6,'08:00:00','Esame del sangue',9),(34,3,'09:00:00','Visita ortopedica',17),(35,3,'14:00:00','Visita gastroenterologica',5),(36,1,'13:00:00','Visita gastroenterologica',8),(37,6,'20:00:00','Visita neurologica',16),(38,5,'09:00:00','Visita ginecologica',19),(39,7,'10:00:00','Visita ginecologica',41),(40,3,'17:00:00','Visita oculistica',4),(41,7,'09:00:00','Visita ortopedica',33),(42,3,'20:00:00','Visita ortopedica',38),(43,2,'10:00:00','Visita urologica',27),(44,4,'18:00:00','Visita cardiologica',10),(45,5,'11:00:00','Visita neurologica',45),(46,6,'09:00:00','Visita urologica',36),(47,4,'20:00:00','Visita ginecologica',48),(48,4,'11:00:00','Esame del sangue',11),(49,6,'20:00:00','Visita otorinolaringoiatrica',37),(50,1,'20:00:00','Visita otorinolaringoiatrica',46),(51,7,'19:00:00','Visita ortologica',65),(52,3,'15:00:00','Visita ortologica',65),(53,5,'16:00:00','Visita neurologica',66),(54,6,'15:00:00','Visita neurologica',66),(55,7,'09:00:00','Visita cardiologica',68),(56,3,'08:00:00','Visita cardiologica',68);
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-08 19:26:19
