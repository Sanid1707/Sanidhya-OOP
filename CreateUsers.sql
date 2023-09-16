-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2023 at 05:28 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `football`
--

-- --------------------------------------------------------

--
-- Table structure for table `clubs`
--

CREATE TABLE `clubs` (
  `club_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `jersey_colour` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clubs`
--

INSERT INTO `clubs` (`club_id`, `name`, `jersey_colour`) VALUES
(1, 'Real Madrid', 'white'),
(2, 'Barcelona', 'red and blue'),
(3, 'Manchester United', 'red'),
(4, 'Bayern Munich', 'red and white'),
(5, 'Juventus', 'black and white');

-- --------------------------------------------------------

--
-- Table structure for table `clubs_players`
--

CREATE TABLE `clubs_players` (
  `club_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clubs_players`
--

INSERT INTO `clubs_players` (`club_id`, `player_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 4),
(3, 1),
(3, 3),
(4, 1),
(4, 4),
(5, 3),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE `players` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `club_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`id`, `first_name`, `last_name`, `position`, `nationality`, `salary`, `age`, `club_id`) VALUES
(1, 'Cristiano', 'Ronaldo', 'Forward', 'Portuguese', 60000000, 36, 1),
(2, 'Lionel', 'Messi', 'Forward', 'Argentinian', 80000000, 33, 2),
(3, 'Bruno', 'Fernandes', 'Midfielder', 'Portuguese', 15000000, 26, 3),
(4, 'Robert', 'Lewandowski', 'Forward', 'Polish', 50000000, 32, 4),
(5, 'Paulo', 'Dybala', 'Forward', 'Argentinian', 30000000, 27, 5),
(6, 'Kevin', 'De Bruyne', 'Midfielder', 'Belgian', 40000000, 29, 3),
(7, 'Sadio', 'Mane', 'Forward', 'Senegalese', 25000000, 29, 5),
(8, 'Sergio', 'Ramos', 'Defender', 'Spanish', 20000000, 35, 1),
(9, 'Virgil', 'van Dijk', 'Defender', 'Dutch', 50000000, 29, 1),
(10, 'Neymar', 'Jr', 'Forward', 'Brazilian', 45000000, 29, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clubs`
--
ALTER TABLE `clubs`
  ADD PRIMARY KEY (`club_id`);

--
-- Indexes for table `clubs_players`
--
ALTER TABLE `clubs_players`
  ADD PRIMARY KEY (`club_id`,`player_id`),
  ADD KEY `player_id` (`player_id`);

--
-- Indexes for table `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`id`),
  ADD KEY `club_id` (`club_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clubs_players`
--
ALTER TABLE `clubs_players`
  ADD CONSTRAINT `clubs_players_ibfk_1` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`),
  ADD CONSTRAINT `clubs_players_ibfk_2` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`);

--
-- Constraints for table `players`
--
ALTER TABLE `players`
  ADD CONSTRAINT `players_ibfk_1` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
