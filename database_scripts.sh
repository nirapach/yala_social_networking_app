CREATE DATABASE se_p566;

USE se_p566;

CREATE TABLE Groups (
	Group_ID VARCHAR(32) NOT NULL PRIMARY KEY,
	Group_Name VARCHAR(128) NOT NULL,
	Group_Privacy VARCHAR(1) NOT NULL DEFAULT 'O',
	Time TIMESTAMP NOT NULL DEFAULT NOW(),
	Group_Profile_PIC LONGBLOB,
	Group_Creator VARCHAR(10) NOT NULL);
	
CREATE TABLE account_information (
	User_Name VARCHAR(10) NOT NULL PRIMARY KEY,
	E_mail_ID VARCHAR(64) NOT NULL, 
	Full_Name VARCHAR(128) NOT NULL, 
	Date_of_Birth DATE, 
	Profile_Pic VARCHAR(128),
	Assoicated_Group_ID VARCHAR(32),
	Privacy_Setting VARCHAR(16));
   
CREATE TABLE user_details (
	User_Name VARCHAR(10) NOT NULL,
	E_Mail_ID VARCHAR(64),
	Full_Name VARCHAR(128),
	Password VARCHAR(16), 
	PRIMARY KEY (User_Name));
  
CREATE TABLE Users_Groups (
	User_Name VARCHAR(10) NOT NULL,
	Group_ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (User_Name, Group_ID),
	FOREIGN KEY(User_Name) REFERENCES account_information(User_Name),
	FOREIGN KEY(Group_ID) REFERENCES Groups(Group_ID));

CREATE TABLE friendship (
	friend1 VARCHAR(10) NOT NULL,
	friend2 VARCHAR(10) NOT NULL,
	PRIMARY KEY(friend1, friend2),
	UNIQUE KEY friend2(friend2, friend1));

CREATE TABLE temporaryfriends (
	User_Name_Sender VARCHAR(10) NOT NULL,
	User_Name_Receiver VARCHAR(10) NOT NULL,
	PRIMARY KEY(User_Name_Sender, User_Name_Receiver),
	UNIQUE KEY User_Name_Receiver(User_Name_Receiver, User_Name_Sender));
	
CREATE TABLE `groupnewsfeed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(128) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `status` varchar(4028) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);
CREATE TABLE `newsfeed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `status` varchar(4028) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);
