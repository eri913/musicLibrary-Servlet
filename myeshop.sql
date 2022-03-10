-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 26 Ιουν 2020 στις 19:40:00
-- Έκδοση διακομιστή: 10.4.11-MariaDB
-- Έκδοση PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `myeshop`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `products`
--

CREATE TABLE `products` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `info` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `img` varchar(750) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `products`
--

INSERT INTO `products` (`id`, `name`, `info`, `price`, `img`) VALUES
(1, 'Maxi dress', 'Maxi dress printed with flowers. Short sleeves. Closing with zipper on the side.', 100, 'https://www.helmi.gr/content/images/thumbs/0039686_-maxi-_700.jpeg'),
(2, 'Short dress', 'Short printed dress. Fine straps. Neckline with curls.', 70, 'https://www.helmi.gr/content/images/thumbs/0032312_-.jpeg'),
(3, 'Floral dress', 'Short dress with floral print design. Short sleeve. Closing on the side.', 49.7, 'https://www.helmi.gr/content/images/thumbs/0039420_-.jpeg'),
(4, 'Brocade dress', 'Sleeveless midi dress. Sures on the skirt. Open back with a smile. Closing back with zipper.', 48.2, 'https://www.helmi.gr/content/images/thumbs/0039239_-.jpeg'),
(5, 'Polka dot dress', 'Medi polka dot dress. Short sleeve. Closing back with zipper. Tie in the middle with a belt.', 55.2, 'https://www.helmi.gr/content/images/thumbs/0039593_-minti-.jpeg'),
(6, 'Midi dress', 'Printed midi dress. Cruise neckline and inflatable sleeves with elastic at the end.', 47.9, 'https://www.helmi.gr/content/images/thumbs/0039073_-.jpeg');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`id`, `name`, `surname`, `email`, `password`) VALUES
(1, 'name', 'sur', 'email', '22ea1c649c82946aa6e479e1ffd321e4a318b1b0'),
(2, 'name2', 'sur2', 'mail2', '22ea1c649c82946aa6e479e1ffd321e4a318b1b0'),
(3, 'name3', 'sur3', 'mail3', '58e6b3a414a1e090dfc6029add0f3555ccba127f'),
(5, 'sssss', 'ssssss', 'jjj', 'c84c766f873ecedf75aa6cf35f1e305e095fec83');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `products`
--
ALTER TABLE `products`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
