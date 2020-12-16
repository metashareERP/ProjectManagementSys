DROP TABLE IF EXISTS `a`;
CREATE TABLE `a` (`ID` Varchar(255) NOT NULL,`DELETED` decimal(1, 0) NULL DEFAULT NULL,`Name` Varchar(255)  NULL DEFAULT NULL, 
`project_id` varchar(255),`enterprise_name` varchar(255),`project_name` varchar(255),`enterprise_id` varchar(255), PRIMARY KEY (`ID`) );

