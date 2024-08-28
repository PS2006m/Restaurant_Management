
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Database: `java_project`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_from_staff` (IN `id` INT)   BEGIN
Delete from staff where staff_id=id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `menu_quantity` int(11) NOT NULL,
  `menu_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `order_tableno` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `order_quantity` int(11) NOT NULL,
  `order_totalprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `staff_name` varchar(50) NOT NULL,
  `staff_email` varchar(50) NOT NULL,
  `staff_salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_tableno` int(11) NOT NULL,
  `user_fname` varchar(50) NOT NULL,
  `user_lname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_tableno`, `user_fname`, `user_lname`) VALUES
(35, 'ad', 'da');

-- --------------------------------------------------------

--
-- Table structure for table `view_menu`
--

CREATE TABLE `view_menu` (
  `view_menu_id` int(11) NOT NULL,
  `view_menu_name` varchar(50) NOT NULL,
  `view_menu_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `view_menu`
--

INSERT INTO `view_menu` (`view_menu_id`, `view_menu_name`, `view_menu_price`) VALUES
(1, 'Burger', 1002.2),
(2, 'Pasta', 3),
(3, 'Vadapav', 52.2),
(4, 'Pizza', 12.2),
(5, 'Dosa', 5),
(6, 'Salad', 6),
(7, 'Noodles', 7),
(8, 'Dabeli', 8),
(9, 'Sprite', 9),
(10, 'Sandwich', 10),
(11, 'Coca-Cola', 11),
(12, 'Pepsi', 12),
(13, 'Buttermilk', 13),
(14, 'Roll', 14),
(15, 'Momos', 15),
(16, 'Fried Rice', 16),
(17, 'Biryani', 17),
(18, 'Chole-Puri', 18),
(19, 'Bhel', 19),
(20, 'Sevpuri', 20),
(21, 'Plain Rice', 21),
(23, 'SevPuri', 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `view_menu`
--
ALTER TABLE `view_menu`
  ADD PRIMARY KEY (`view_menu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `view_menu`
--
ALTER TABLE `view_menu`
  MODIFY `view_menu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;


