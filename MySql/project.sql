DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (`ID` Varchar(255) NOT NULL,`DELETED` decimal(1, 0) NULL DEFAULT NULL,`Name` Varchar(255)  NULL DEFAULT NULL, 
`enterprise_id` varchar(255),`enterprise_name` varchar(255), PRIMARY KEY (`ID`) );

