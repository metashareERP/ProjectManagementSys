DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (`ID` Varchar(255) NOT NULL,`DELETED` decimal(1, 0) NULL DEFAULT NULL,`Name` Varchar(255)  NULL DEFAULT NULL, 
`project_id` varchar(255),`project_name` varchar(255),`parenttask_id` varchar(255),`parenttask_name` varchar(255), PRIMARY KEY (`ID`) );

