---- OOP 2022
--
--DROP DATABASE IF EXISTS `user_database`;
--CREATE DATABASE `user_database`;
--USE `user_database`;
--DROP TABLE IF EXISTS `user`;
--CREATE TABLE `user` (
--  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
--  `FIRST_NAME` varchar(50) NOT NULL,
--  `LAST_NAME` varchar(50) NOT NULL,
--  `USERNAME` varchar(20) NOT NULL,
--  `PASSWORD` varchar(20) NOT NULL,
--  PRIMARY KEY  (`USER_ID`)
--  );
--
--INSERT INTO user VALUES (null, "John", "Smith", "smithj", "password"),
--  			(null, "Mary", "Byrne", "byrnem", "password"),
--  			(null, "Frankie", "Cocozza", "cocozzaf", "password"),
--            (null, "Patrick", "Jones", "jonesp", "password"),
--            (null, "John", "Smyth", "smythj", "password");


-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2023 at 07:30 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29



-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id`, `first_name`, `last_name`, `position`, `nationality`, `salary`, `age`) VALUES
(1, 'Lionel', 'Messi', 'Forward', 'Argentina', '10000000.00', 34),
(2, 'Cristiano', 'Ronaldo', 'Forward', 'Portugal', '8000000.00', 37),
(3, 'Neymar', 'Jr', 'Forward', 'Brazil', '7000000.00', 30),
(4, 'Kevin', 'De Bruyne', 'Midfielder', 'Belgium', '6000000.00', 30),
(5, 'Kylian', 'Mbappe', 'Forward', 'France', '5000000.00', 23),
(6, 'Mohamed', 'Salah', 'Forward', 'Egypt', '4500000.00', 29),
(7, 'Virgil', 'van Dijk', 'Defender', 'Netherlands', '4000000.00', 30),
(8, 'Sadio', 'Mane', 'Forward', 'Senegal', '3500000.00', 29),
(9, 'Harry', 'Kane', 'Forward', 'England', '3000000.00', 28),
(10, 'Robert', 'Lewandowski', 'Forward', 'Poland', '2500000.00', 33);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);
COMMIT;

