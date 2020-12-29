-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2020 at 03:23 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `superzone`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc1` ()  select * from count$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc2` ()  NO SQL
select productname from grocery where price=65$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `items` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `user` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`items`, `price`, `user`, `pass`) VALUES
('cocacola', 50, 'raj', '123'),
('Biscuit', 20, 'raj', '123'),
('Face Cream', 90, 'navi', '90'),
('Face Cream', 90, 'navi', '90'),
('Bitroot', 45, 'navi', '90'),
('Lux soap', 10, 'navi', '90'),
('Biscuit', 20, 'navyaa', '79'),
('Fogg Perfume', 300, 'ramya', '123'),
('cocacola', 50, 'ramya', '123'),
('Brinjol', 40, 'ramya', '123'),
('Lux soap', 10, 'harshi', '123'),
('Nevia BodyLotion', 150, 'rasmi', '23'),
('Tomato', 30, 'rasmi', '23'),
('Turmeric powder', 50, 'rasmi', '23'),
('Nevia BodyLotion', 150, 'har', '12'),
('namkeen', 20, 'har', '12'),
('Tomato', 30, 'har', '12'),
('Nevia BodyLotion', 150, 'rani', '12'),
('Lays', 10, 'rani', '12'),
('Patato', 50, 'rani', '12');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(5) NOT NULL,
  `category_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Fashion'),
(2, 'Food/Drink'),
(3, 'Vegetable'),
(4, 'Grocery');

-- --------------------------------------------------------

--
-- Table structure for table `count`
--

CREATE TABLE `count` (
  `c` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `count`
--

INSERT INTO `count` (`c`) VALUES
(41);

-- --------------------------------------------------------

--
-- Table structure for table `fashion`
--

CREATE TABLE `fashion` (
  `Productname` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fashion`
--

INSERT INTO `fashion` (`Productname`, `price`) VALUES
('Himalaya FaceWash', 250),
('Nevia BodyLotion', 150),
('Fogg Perfume', 300),
('Lux soap', 10),
('Face Cream', 90);

-- --------------------------------------------------------

--
-- Table structure for table `fooddrink`
--

CREATE TABLE `fooddrink` (
  `Productname` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fooddrink`
--

INSERT INTO `fooddrink` (`Productname`, `price`) VALUES
('Lays', 10),
('Biscuit', 20),
('cocacola', 50),
('pepsi', 60),
('namkeen', 20);

-- --------------------------------------------------------

--
-- Table structure for table `grocery`
--

CREATE TABLE `grocery` (
  `Productname` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grocery`
--

INSERT INTO `grocery` (`Productname`, `price`) VALUES
('Wheatflour', 65),
('Sugar', 100),
('Basamatirice', 80),
('Turmeric powder', 50),
('Dal', 70);

-- --------------------------------------------------------

--
-- Table structure for table `signupvalues`
--

CREATE TABLE `signupvalues` (
  `Username` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Phoneno` bigint(12) NOT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signupvalues`
--

INSERT INTO `signupvalues` (`Username`, `Password`, `Gender`, `Email`, `Phoneno`, `Address`) VALUES
('1221', '1231', 'female', '12321', 1213, 'efcdesf'),
('navaratna', '123', 'female', 'navratna@gamil.com', 123456789, 'abc'),
('abcc', '345', 'female', '123@gmail.com', 98765, 'kjsbaulbx'),
('reetik', '79', 'female', 'reetik@gmail.com', 73556706, 'basti'),
('navya', '123', 'female', 'navya@gamil.com', 1234567, 'sfdzsaf'),
('navyaa', '30', 'female', '90', 3333333, 'sirsi'),
('rekha', '123', 'female', 'rekha@gmail.com', 12345678, 'basitiiiii'),
('Raj', '123', 'female', 'raj@gmail.com', 945002178, 'Behind Scout Press '),
('navyaa', '30', 'female', '90', 3333333, 'sirsi'),
('pari', '123', 'female', 'pari@gamil.com', 123456, 'djxcishjk'),
('r', '1', 'male', 'ree@ggm', 22, 'hhh'),
('sdoi', 'sad', 'sad', 'asd', 2, 'sadd'),
('rrr', '34', 'female', 'rrr@gamil.com', 234, 'djf'),
('cute cute papa', 'aa', 'female', 'wdkqidylq', 735567645, 'Sirsi'),
('cute cute papa', 'aa', 'female', 'wdkqidylq', 735567645, 'Sirsi'),
('sunu', '23', 'female', 'jemdghjer', 6587685, 'defjmkehj'),
('kashvi', '123', 'female', 'hxgcks', 5765, 'sdkjchlsy'),
('ramya', '12', 'female', 'ramya@gmail.com', 2345678, 'bengalore'),
('ramyaaa', '', 'female', '90', 13255, 'elfjsl'),
('harshi', '123', 'female', 'sldjaku', 456, 'chitradurga'),
('aish', '123', 'female', 'skhj', 123, 'sxkjl'),
('hh', '1', 'female', 'gg', 789777, 'jkhj'),
('priyanka', '38', 'female', 'priyanka@gmail.com', 123456, 'mysore'),
('veena', '34', 'female', 'veena@gmail.com', 1223, 'ugyi'),
('seema', '78', 'female', 'seema@gmail.com', 735567064, 'kdlsjfksd'),
('rama', '123', 'female', 'rama@gmail.com', 735560645, 'swd'),
('hjsdf', '12', 'female', 'weq', 735567064, 'khu'),
('shwetha', '123', 'female', 'kwjhqkw', 948313239, 'fdd'),
('aru', '123', 'female', 'fh,sj', 9483132396, 'frsgs'),
('eee', '963', 'female', 'rr', 1234567896, 'yty'),
('ash', '12', 'female', 'ash@gmail.com', 9786451235, 'QSLKJ'),
('KK', '123', 'female', 'k@gmail.com', 9784454512, ',N'),
('roy', '12', 'female', 'roy@gmail.com', 9483132396, 'scac'),
('ram', '12', 'female', 'ram@gmail.com', 9483132396, 'sad'),
('rasmii', '12', 'female', 'rasmi@gmail.com', 9483132396, 'edjd'),
('har', '12', 'female', 'har@gmail.com', 9876543211, 'hgfd'),
('harsh', '123', 'female', 'harsh@gmail.com', 9876543211, 'htfsd'),
('rani', '12', 'female', 'rani@gmail.com', 9483132396, 'aggh');

--
-- Triggers `signupvalues`
--
DELIMITER $$
CREATE TRIGGER `trig1` AFTER INSERT ON `signupvalues` FOR EACH ROW update count SET c=c+1
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `vegetable`
--

CREATE TABLE `vegetable` (
  `Productname` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vegetable`
--

INSERT INTO `vegetable` (`Productname`, `price`) VALUES
('Patato', 50),
('Brinjol', 40),
('Tomato', 30),
('Bitroot', 45),
('cucumber', 35);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
