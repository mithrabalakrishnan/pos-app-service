-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2022 at 10:08 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
  `image` varchar(255) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`foodid`, `food_name`, `category`, `rating`, `price`, `image`, `status`) VALUES
(1, 'biriyani', 'fast_food', '4.0', '4.00€', 'image_url', 'recent'),
(2, 'bottle', 'Water', '0.0', '20', 'http://10.0.0.122:8013/download-file/Screenshot_2022-11-21-15-02-12-960_com.kenyanut.rma.jpg', 'popular'),
(4, 'xbnxns', 'water', '0.0', '30', 'http://10.0.0.122:8013/download-file/1665125002704.jpg', 'popular'),
(5, 'Menu', 'AM', '0.0', '10', 'http://10.0.0.122:8013/download-file/1669708782344.jpg', 'popular'),
(6, 'bss', 'bandh', '0.0', '50', 'http://10.0.0.122:8013/download-file/IMG_20221109_202601.jpg', 'popular'),
(7, 'normal pizza', 'Pizza', '0.0', '30', 'http://192.168.1.9:8013/download-file/images.jpeg', 'popular'),
(8, 'Spicy pizza', 'Pizza', '0.0', '40', 'http://192.168.1.9:8013/download-file/download.jpeg', 'popular'),
(9, 'mexican burger', 'Burger', '0.0', '25', 'http://192.168.1.9:8013/download-file/images%20(1).jpeg', 'popular'),
(10, 'Monster burger', 'Burger', '0.0', '40', 'http://192.168.1.9:8013/download-file/images%20(2).jpeg', 'popular');

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
(1, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'In-Progress', '2', '150'),
(2, 1, 4, 17, '2022-12-07', '10:00 AM', '7', 'DECEMBER', '2022', 'Completed', '1', '30'),
(3, 1, 5, 17, '2022-12-07', '10:00 AM', '7', 'DECEMBER', '2022', 'To Do', '1', '10'),
(4, 1, 2, 24, '2022-12-06', '6:00 PM', '6', 'DECEMBER', '2022', 'To Do', '1', '20'),
(5, 1, 4, 24, '2022-12-06', '6:00 PM', '6', 'DECEMBER', '2022', 'To Do', '1', '30'),
(6, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'To Do', '2', '150'),
(7, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'To Do', '2', '150'),
(8, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'To Do', '2', '150'),
(9, 1, 4, 25, '2022-12-09', '12:00 PM', '9', 'DECEMBER', '2022', 'To Do', '1', '30'),
(10, 1, 5, 25, '2022-12-09', '12:00 PM', '9', 'DECEMBER', '2022', 'To Do', '1', '10'),
(11, 1, 1, 1, '2022-11-09', '9 pm', '9', 'NOVEMBER', '2022', 'To Do', '2', '150'),
(12, 1, 2, 26, '2022-12-10', '11:00 AM', '10', 'DECEMBER', '2022', 'To Do', '2', '40'),
(13, 1, 4, 26, '2022-12-10', '11:00 AM', '10', 'DECEMBER', '2022', 'To Do', '2', '60'),
(14, 1, 2, 27, '2022-12-11', '11:00 AM', '11', 'DECEMBER', '2022', 'To Do', '1', '20'),
(15, 1, 4, 27, '2022-12-11', '11:00 AM', '11', 'DECEMBER', '2022', 'To Do', '1', '30'),
(16, 1, 2, 28, '2022-12-09', '4:00 PM', '9', 'DECEMBER', '2022', 'To Do', '2', '40'),
(17, 1, 4, 28, '2022-12-09', '4:00 PM', '9', 'DECEMBER', '2022', 'To Do', '2', '60');

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
(1, 1, '12-05-2022', '9:00pm', '5', 'Sider'),
(2, 1, '2022-12-05', '11:00 AM', '3', 'Window side'),
(3, 1, '2022-12-07', '11:00 AM', '4', 'Window side'),
(4, 1, '2022-12-04', '10:00 AM', '5', 'Classic booth'),
(5, 1, '2022-12-06', '12:00 PM', '5', 'Classic booth'),
(6, 1, '2022-12-07', '12:00 PM', '4', 'High top table'),
(7, 1, '2022-12-06', '3:00 PM', '5', 'High top table'),
(8, 1, '2022-12-08', '9:00 PM', '7', 'Classic booth'),
(9, 1, '2022-12-08', '12:00 PM', '6', 'Classic booth'),
(10, 1, '2022-12-06', '10:00 AM', '6', 'High top table'),
(11, 1, '2022-12-06', '11:00 AM', '6', 'Classic booth'),
(12, 1, '2022-12-07', '2:00 PM', '5', 'Classic booth'),
(13, 1, '2022-12-08', '11:00 AM', '5', 'High top table'),
(14, 1, '2022-12-08', '1:00 PM', '4', 'Classic booth'),
(15, 1, '2022-12-08', '8:00 PM', '7', 'Classic booth'),
(16, 1, '12-05-2022', '10:00pm', '5', 'Sider'),
(17, 1, '2022-12-07', '10:00 AM', '5', 'High top table'),
(18, 1, '2022-12-08', '7:00 PM', '5', 'High top table'),
(19, 1, '2022-12-08', '6:00 PM', '5', 'High top table'),
(20, 1, '2022-12-07', '1:00 PM', '4', 'High top table'),
(21, 1, '2022-12-07', '3:00 PM', '3', 'Window side'),
(22, 1, '2022-12-05', '3:00 PM', '2', 'Window side'),
(23, 1, '2022-12-06', '2:00 PM', '4', 'Window side'),
(24, 1, '2022-12-06', '6:00 PM', '3', 'Window side'),
(25, 1, '2022-12-09', '12:00 PM', '3', 'High top table'),
(26, 1, '2022-12-10', '11:00 AM', '6', 'Classic booth'),
(27, 1, '2022-12-11', '11:00 AM', '5', 'Classic booth'),
(28, 1, '2022-12-09', '4:00 PM', '4', 'Window side');

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
(1, 'jineshkp', 'Jinesh', 'KP', '8137082713', 'jineshkp@gmail.com', NULL, '$2a$10$aOsfRHpNHXexJ8yqCRD21uFwvhACgdbQGAcM5QpvUa4QRnU0FrVC.', 'User'),
(2, 'admin', 'admin', 'cc', '85544444', 'admin@gmail.com', NULL, '$2a$10$y2J4F9le6U5F8dpOQzcyduU2O2sWIyHQbi17U1ez1APOkI8zt2e3i', 'User'),
(3, 'kitchen', 'kitchen', 'kitchen', '999999999999', 'kitchen@gmail.com', NULL, '$2a$10$R28VTy.FO7.oxUsWhmeUFOJ64YC/d/xbA0Xx/RfAUSIo.cf8cuT5q', 'User'),
(4, 'asdfg', 'asd', 'asd', '8137082713', 'asdfgh@gmail.com', NULL, '$2a$10$5P1CAQxSIclgMUeGTFyEweKmzDK8juIzfPeeeJm59MgQNKH/JkdmO', 'Kitchen'),
(5, 'asdjn', 'asd', 'asd', '123456', 'asdmin@gmail.com', NULL, '$2a$10$45K1zW4kTLelqQksceGhMuIEqk.Xo5yoQjWTuCrfl.WCxbAaygeYC', 'Kitchen');

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `voucher_id` int(11) NOT NULL,
  `voucher_code` varchar(30) NOT NULL,
  `voucher_discount` varchar(30) NOT NULL,
  `voucher_title` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voucher`
--

INSERT INTO `voucher` (`voucher_id`, `voucher_code`, `voucher_discount`, `voucher_title`, `date`) VALUES
(1, 'PIZZA50', '50', 'Pizza offer', '10-12-2022'),
(2, 'NEW50', '70', 'Welcome offer', '13-12-2022');

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
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`voucher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `foodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `food_order`
--
ALTER TABLE `food_order`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `table_detail`
--
ALTER TABLE `table_detail`
  MODIFY `tableid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `voucher`
--
ALTER TABLE `voucher`
  MODIFY `voucher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

CREATE TABLE `visit` (
  `visitid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `month` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `visit`
  ADD PRIMARY KEY (`visitid`),
  ADD KEY `FK_UseUser_Id` (`userid`);

ALTER TABLE `visit`
  MODIFY `visitid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
