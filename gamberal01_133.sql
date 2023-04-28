-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 28 avr. 2023 à 08:35
-- Version du serveur : 10.3.38-MariaDB-cll-lve
-- Version de PHP : 8.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gamberal01_133`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_avis`
--

CREATE TABLE `t_avis` (
  `PK_Avis` int(11) NOT NULL,
  `Avis` longtext NOT NULL,
  `IdFilm` int(11) NOT NULL,
  `FK_Users` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `t_avis`
--

INSERT INTO `t_avis` (`PK_Avis`, `Avis`, `IdFilm`, `FK_Users`) VALUES
(1, 'Jaime ce filme grosse chlague', 12, 1),
(3, 'va bz ta mère', 14, 1);

-- --------------------------------------------------------

--
-- Structure de la table `t_users`
--

CREATE TABLE `t_users` (
  `PK_Users` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `t_users`
--

INSERT INTO `t_users` (`PK_Users`, `Username`, `Password`) VALUES
(1, 'Matteo', '1'),
(2, 'admin', 'Pa$$w0rd'),
(3, 'luca', '123'),
(4, 'admin', 'Pa$$w0rd');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `t_avis`
--
ALTER TABLE `t_avis`
  ADD PRIMARY KEY (`PK_Avis`),
  ADD KEY `fk_T_Avis_T_Users_idx` (`FK_Users`);

--
-- Index pour la table `t_users`
--
ALTER TABLE `t_users`
  ADD PRIMARY KEY (`PK_Users`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `t_avis`
--
ALTER TABLE `t_avis`
  MODIFY `PK_Avis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `t_users`
--
ALTER TABLE `t_users`
  MODIFY `PK_Users` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `t_avis`
--
ALTER TABLE `t_avis`
  ADD CONSTRAINT `fk_T_Avis_T_Users` FOREIGN KEY (`FK_Users`) REFERENCES `t_users` (`PK_Users`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
