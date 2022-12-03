-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2022 at 09:58 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `foodid` int(11) NOT NULL,
  `food_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  `rating` varchar(30) DEFAULT NULL,
  `price` varchar(15) DEFAULT NULL,
  `image` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`foodid`, `food_name`, `category`, `rating`, `price`, `image`, `status`) VALUES
(1, 'biriyani', 'fast_food', '4.0', '4.00€', 'image_url', 'recent');

-- --------------------------------------------------------

--
-- Table structure for table `food_order`
--

CREATE TABLE `food_order` (
  `orderid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `foodid` int(11) NOT NULL,
  `tableid` int(11) NOT NULL,
  `date` varchar(40) DEFAULT NULL,
  `time` varchar(40) DEFAULT NULL,
  `day` varchar(30) DEFAULT NULL,
  `month` varchar(20) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `quanty` varchar(30) NOT NULL,
  `total_price` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_order`
--

INSERT INTO `food_order` (`orderid`, `userid`, `foodid`, `tableid`, `date`, `time`, `day`, `month`, `year`, `status`, `quanty`, `total_price`) VALUES
(1, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'In progress', '2', '150');

-- --------------------------------------------------------

--
-- Table structure for table `table_detail`
--

CREATE TABLE `table_detail` (
  `tableid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `date` varchar(50) DEFAULT NULL,
  `time` varchar(40) DEFAULT NULL,
  `members` varchar(30) NOT NULL,
  `seat_location` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_detail`
--

INSERT INTO `table_detail` (`tableid`, `userid`, `date`, `time`, `members`, `seat_location`) VALUES
(1, 1, '12-05-2022', '9:00pm', '5', 'Sider');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `place` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `first_name`, `last_name`, `phone_no`, `email`, `place`, `password`, `role`) VALUES
(1, 'jineshkp', 'Jinesh', 'KP', '8137082713', 'jineshkp@gmail.com', NULL, '$2a$10$aOsfRHpNHXexJ8yqCRD21uFwvhACgdbQGAcM5QpvUa4QRnU0FrVC.', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`foodid`),
  ADD UNIQUE KEY `food_name` (`food_name`);

--
-- Indexes for table `food_order`
--
ALTER TABLE `food_order`
  ADD PRIMARY KEY (`orderid`),
  ADD KEY `FK_UsersUser_Id` (`userid`),
  ADD KEY `FK_FoodFoodId` (`foodid`),
  ADD KEY `FK_TableDetailTableId` (`tableid`);

--
-- Indexes for table `table_detail`
--
ALTER TABLE `table_detail`
  ADD PRIMARY KEY (`tableid`),
  ADD KEY `FK_UserUserId` (`userid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `foodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `food_order`
--
ALTER TABLE `food_order`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `table_detail`
--
ALTER TABLE `table_detail`
  MODIFY `tableid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `food_order`
--
ALTER TABLE `food_order`
  ADD CONSTRAINT `FK_FoodFoodId` FOREIGN KEY (`foodid`) REFERENCES `food` (`foodid`),
  ADD CONSTRAINT `FK_TableDetailTableId` FOREIGN KEY (`tableid`) REFERENCES `table_detail` (`tableid`),
  ADD CONSTRAINT `FK_UsersUser_Id` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);

--
-- Constraints for table `table_detail`
--
ALTER TABLE `table_detail`
  ADD CONSTRAINT `FK_UserUserId` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;