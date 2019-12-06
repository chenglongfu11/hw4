-- Drop all tables;
--


DROP TABLE IF EXISTS `CURRENCYRATES`;


CREATE TABLE `CURRENCY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(3) NOT NULL UNIQUE,
  `DESCRIPTION` varchar(50) NULL,
  
  PRIMARY KEY (`ID`)
)

CREATE TABLE `RATE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FROMM` varchar(3) NOT NULL,
  `TO` varchar(3) NOT NULL,
  `RATE` float NOT NULL,

  PRIMARY KEY (`ID`),
  FOREIGN KEY (`FROMM`) REFERENCES CURRENCY(`CODE`),
  FOREIGN KEY (`TO`) REFERENCES CURRENCY(`CODE`),
)
