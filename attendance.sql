-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2023 at 07:14 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `ACC_ID` int(11) NOT NULL,
  `ACC_USERNAME` varchar(255) NOT NULL,
  `ACC_PASSWORD` varchar(255) NOT NULL,
  `ACC_ROLE` varchar(50) NOT NULL DEFAULT 'T'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`ACC_ID`, `ACC_USERNAME`, `ACC_PASSWORD`, `ACC_ROLE`) VALUES
(1, '@saz', '267e7f896b662b67e3b397adc1ad4027', 'A'),
(2, '@angeela', '769d8967919b46ffe233dae6daaa19da', 'S'),
(3, '@suron', '80e3d9f3e8cb277e24f07d8d3805b690', 'S'),
(4, '@mithlesh', 'f784928e01384df6cf02ac354608be6e', 'S'),
(5, '@susmit', '65fbb5985028c8461c079cf2bd151ef4', 'S'),
(6, '@subin', '7e9b66494dc711d010b9d82557861c52', 'S'),
(8, '@kedar', '8b3ec9a01f2567143c17426f16b132b9', 'T'),
(9, '@wassabii', '7b63d1cafe15e5edab88a8e81de794b5', 'S'),
(10, 'fle', '9a00a9036b524dfc7cb4a478f0d4ec17', 'S'),
(11, '@rajesh', '65a1223dae83b8092c4edba0823a793c', 'T');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `ATT_ID` int(11) NOT NULL,
  `STU_ID` int(11) NOT NULL,
  `ACC_ID` int(11) NOT NULL,
  `SUB_ID` int(11) NOT NULL,
  `ATT_DATE` datetime NOT NULL DEFAULT current_timestamp(),
  `STATUS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`ATT_ID`, `STU_ID`, `ACC_ID`, `SUB_ID`, `ATT_DATE`, `STATUS`) VALUES
(2, 1, 8, 1, '2023-04-05 00:00:00', 1),
(3, 1, 8, 1, '2023-04-06 00:00:00', 1),
(4, 2, 8, 1, '2023-04-06 00:00:00', 1),
(5, 3, 8, 1, '2023-04-06 00:00:00', 1),
(6, 1, 8, 1, '2023-04-07 00:00:00', 1),
(7, 2, 8, 1, '2023-04-07 00:00:00', 1),
(8, 3, 8, 1, '2023-04-07 00:00:00', 1),
(9, 4, 8, 1, '2023-04-07 00:00:00', 1),
(10, 5, 8, 1, '2023-04-07 00:00:00', 1),
(11, 7, 8, 1, '2023-04-07 00:00:00', 1),
(12, 1, 8, 1, '2023-04-10 00:00:00', 1),
(13, 2, 8, 1, '2023-04-10 00:00:00', 1),
(14, 3, 8, 1, '2023-04-10 00:00:00', 1),
(15, 4, 8, 1, '2023-04-10 00:00:00', 1),
(16, 5, 8, 1, '2023-04-10 00:00:00', 1),
(17, 7, 8, 1, '2023-04-10 00:00:00', 1),
(18, 1, 8, 1, '2023-04-13 00:00:00', 1),
(19, 2, 8, 1, '2023-04-13 00:00:00', 1),
(20, 3, 8, 1, '2023-04-13 00:00:00', 1),
(21, 4, 8, 1, '2023-04-13 00:00:00', 1),
(22, 5, 8, 1, '2023-04-13 00:00:00', 1),
(23, 7, 8, 1, '2023-04-13 00:00:00', 1),
(24, 8, 8, 2, '2023-04-13 00:00:00', 1),
(25, 1, 8, 1, '2023-04-21 00:00:00', 1),
(26, 2, 8, 1, '2023-04-21 00:00:00', 1),
(27, 3, 8, 1, '2023-04-21 00:00:00', 1),
(28, 4, 8, 1, '2023-04-21 00:00:00', 1),
(29, 5, 8, 1, '2023-04-21 00:00:00', 1),
(30, 7, 8, 1, '2023-04-21 00:00:00', 1),
(31, 1, 8, 1, '2023-04-20 00:00:00', 1),
(32, 2, 8, 1, '2023-04-20 00:00:00', 1),
(33, 3, 8, 1, '2023-04-20 00:00:00', 1),
(34, 4, 8, 1, '2023-04-20 00:00:00', 1),
(35, 5, 8, 1, '2023-04-20 00:00:00', 1),
(36, 7, 8, 1, '2023-04-20 00:00:00', 1),
(37, 8, 8, 2, '2023-04-20 00:00:00', 1),
(38, 8, 8, 2, '2023-04-21 00:00:00', 1),
(39, 1, 8, 1, '2023-04-23 00:00:00', 1),
(40, 2, 8, 1, '2023-04-23 00:00:00', 1),
(41, 3, 8, 1, '2023-04-23 00:00:00', 1),
(42, 4, 8, 1, '2023-04-23 00:00:00', 1),
(43, 5, 8, 1, '2023-04-23 00:00:00', 1),
(44, 7, 8, 1, '2023-04-23 00:00:00', 1),
(45, 1, 1, 1, '2023-04-24 00:00:00', 1),
(46, 2, 1, 1, '2023-04-24 00:00:00', 1),
(47, 3, 1, 1, '2023-04-24 00:00:00', 1),
(48, 4, 1, 1, '2023-04-24 00:00:00', 1),
(49, 8, 1, 2, '2023-04-23 00:00:00', 1),
(50, 1, 1, 1, '2023-04-25 00:00:00', 1),
(51, 2, 1, 1, '2023-04-25 00:00:00', 1),
(52, 3, 1, 1, '2023-04-25 00:00:00', 1),
(53, 4, 1, 1, '2023-04-25 00:00:00', 1),
(54, 5, 1, 1, '2023-04-25 00:00:00', 1),
(55, 7, 1, 1, '2023-04-25 00:00:00', 1),
(56, 8, 1, 2, '2023-04-24 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `C_ID` int(11) NOT NULL,
  `COURSE_NAME` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`C_ID`, `COURSE_NAME`) VALUES
(1, 'BICT'),
(2, 'MBA');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `M_ID` int(11) NOT NULL,
  `MESSAGE_TEXT` text NOT NULL,
  `MESSAGE_DATE` datetime NOT NULL DEFAULT current_timestamp(),
  `CATEGORY` varchar(255) DEFAULT NULL,
  `STUD_ID` int(11) NOT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`M_ID`, `MESSAGE_TEXT`, `MESSAGE_DATE`, `CATEGORY`, `STUD_ID`, `status`) VALUES
(2, 'i WILL  be absence dure to stomach ache for two dats', '2023-04-24 14:48:00', 'sick leave', 3, 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE `section` (
  `SECTION_ID` int(11) NOT NULL,
  `SECTION_NAME` varchar(255) NOT NULL,
  `COURSE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`SECTION_ID`, `SECTION_NAME`, `COURSE_ID`) VALUES
(1, 'A', 1),
(2, 'B', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `SEM_ID` int(11) NOT NULL,
  `SEM_NAME` varchar(255) NOT NULL,
  `C_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`SEM_ID`, `SEM_NAME`, `C_ID`) VALUES
(1, 'first', 1),
(2, 'second', 1),
(3, 'third', 1),
(4, 'fourth', 1),
(5, 'fifth', 1),
(6, 'sixth', 1),
(7, 'seventh', 1),
(8, 'eight', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STUD_ID` int(11) NOT NULL,
  `STUD_NAME` varchar(255) NOT NULL,
  `STUD_EMAIL` varchar(255) DEFAULT NULL,
  `STUD_ADD` varchar(255) DEFAULT NULL,
  `STUD_PHONE` varchar(255) NOT NULL,
  `SEM_ID` int(11) DEFAULT NULL,
  `C_ID` int(11) NOT NULL,
  `SEC_ID` int(11) NOT NULL,
  `ACC_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STUD_ID`, `STUD_NAME`, `STUD_EMAIL`, `STUD_ADD`, `STUD_PHONE`, `SEM_ID`, `C_ID`, `SEC_ID`, `ACC_ID`) VALUES
(1, 'Angeela Ghimire', 'angeela@gmail.com', 'Godawari', '9841223322', 5, 1, 2, 2),
(2, 'Surohan Maharjan', 'suron@gmail.com', 'Patan', '9886162222', 5, 1, 2, 3),
(3, 'Mithlesh Kumar Singh', 'mithlesh@gmail.com', 'Kirtipur', '9808776655', 5, 1, 2, 4),
(4, 'Susmit Chaudhary', 'susmit@gmail.com', 'Kathmandu', '9841222222', 5, 1, 2, 5),
(5, 'Subin Sedhai', 'subin@gmail.com', 'Baneswor', '9841222223', 5, 1, 2, 6),
(7, 'Wonjala Joshi', 'wonju@gmail.com', 'Bhaisepati, Lalitpur', '9808122234', 5, 1, 2, 9),
(8, 'Fletcher Glenn', 'fle@gmail.com', 'Bhaisepati', '9808883838', 3, 1, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `SUB_ID` int(11) NOT NULL,
  `SUB_NAME` varchar(255) NOT NULL,
  `SUB_CODE` varchar(255) NOT NULL,
  `TEAC_ID` int(11) DEFAULT NULL,
  `C_ID` int(11) NOT NULL,
  `SEM_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`SUB_ID`, `SUB_NAME`, `SUB_CODE`, `TEAC_ID`, `C_ID`, `SEM_ID`) VALUES
(1, 'Advance Java', 'CCP399', 1, 1, 5),
(2, 'OOP', 'COP100', 2, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `TEAC_ID` int(11) NOT NULL,
  `TEAC_NAME` varchar(255) NOT NULL,
  `TEAC_ADDRESS` varchar(255) DEFAULT NULL,
  `TEAC_EMAIL` varchar(255) DEFAULT NULL,
  `TEAC_PHONE` varchar(255) NOT NULL,
  `ACC_ID` int(11) NOT NULL,
  `MODIFIED_DATE` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`TEAC_ID`, `TEAC_NAME`, `TEAC_ADDRESS`, `TEAC_EMAIL`, `TEAC_PHONE`, `ACC_ID`, `MODIFIED_DATE`) VALUES
(1, 'Kedar Sedai', 'Kapan', 'kedar@gmail.com', '9871626364', 8, '2023-04-10 14:21:48'),
(2, 'Rajesh Singh', 'Kirtipur', 'rajesh@gmail.com', '9874122233', 11, '2023-04-22 20:31:55');

-- --------------------------------------------------------

--
-- Table structure for table `total_attendance`
--

CREATE TABLE `total_attendance` (
  `ATT_DATE` datetime NOT NULL DEFAULT current_timestamp(),
  `SUB_ID` int(11) NOT NULL,
  `COUNT` int(100) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `total_attendance`
--

INSERT INTO `total_attendance` (`ATT_DATE`, `SUB_ID`, `COUNT`) VALUES
('2023-04-24 01:04:27', 1, 7),
('2023-04-24 01:04:56', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_activity`
--

CREATE TABLE `user_activity` (
  `ACT_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STATUS` varchar(255) NOT NULL DEFAULT 'U',
  `ACTIVE_DATE` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_activity`
--

INSERT INTO `user_activity` (`ACT_ID`, `USER_ID`, `STATUS`, `ACTIVE_DATE`) VALUES
(2, 8, 'Active', '2023-04-10 20:16:38'),
(3, 11, 'Inactive', '2023-04-22 20:31:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`ACC_ID`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`ATT_ID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`C_ID`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`M_ID`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`SECTION_ID`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`SEM_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STUD_ID`),
  ADD UNIQUE KEY `STUD_PHONE` (`STUD_PHONE`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`SUB_ID`),
  ADD UNIQUE KEY `SUB_CODE` (`SUB_CODE`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TEAC_ID`),
  ADD UNIQUE KEY `ACC_ID` (`ACC_ID`),
  ADD UNIQUE KEY `TEAC_PHONE` (`TEAC_PHONE`);

--
-- Indexes for table `user_activity`
--
ALTER TABLE `user_activity`
  ADD PRIMARY KEY (`ACT_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `ACC_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `ATT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `C_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `M_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `section`
--
ALTER TABLE `section`
  MODIFY `SECTION_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `SEM_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `STUD_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `SUB_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `TEAC_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_activity`
--
ALTER TABLE `user_activity`
  MODIFY `ACT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
