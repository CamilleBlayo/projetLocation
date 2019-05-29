-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 29 mai 2019 à 13:39
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpa_hibernate_agence_location`
--
CREATE DATABASE IF NOT EXISTS `jpa_hibernate_agence_location` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jpa_hibernate_agence_location`;

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `id_agence` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `nbre_employe` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_ville` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_agence`),
  KEY `FK_i7da2j6p7c6ou2awoqsbieahv` (`id_ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `type` varchar(6) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `annee_permis` datetime DEFAULT NULL,
  `numero_permis` varchar(255) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `utilisateur` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`type`, `id`, `email`, `login`, `nom`, `password`, `prenom`, `annee_permis`, `numero_permis`, `telephone`, `utilisateur`, `admin`) VALUES
('Admin', 1, 'admin1@agence.fr', 'admin1', 'nom1', '123', 'prenom1', NULL, NULL, NULL, NULL, 1),
('Client', 2, 'client1@gmail.com', 'client1', 'nom2', '456', 'prenom2', NULL, NULL, 0, 0, NULL),
('Client', 3, 'client2@gmail.com', 'client2', 'nom3', '789', 'prenom3', '2018-11-05 00:00:00', 'A4785', 128575, 1, NULL),
('Client', 4, 'client3@gmail.fr', 'client3', 'nom4', '123', 'prenom4', '2018-11-05 00:00:00', 'A4785', 128575, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` bigint(20) NOT NULL AUTO_INCREMENT,
  `assurance` tinyint(1) DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `id_personne` bigint(20) DEFAULT NULL,
  `id_voiture` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `FK_3mxv9kk259e0jawtro871kl1l` (`id_personne`),
  KEY `FK_ef48cg152mjeqgivc8y9cb00m` (`id_voiture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `id_ville` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_postale` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `id_voiture` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie_vehicule` varchar(255) DEFAULT NULL,
  `couleur` varchar(255) DEFAULT NULL,
  `disponibilite` tinyint(1) DEFAULT NULL,
  `etat_voiture` tinyint(1) DEFAULT NULL,
  `immatriculation` varchar(255) DEFAULT NULL,
  `kilometrage` int(11) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `nombre_de_place` int(11) DEFAULT NULL,
  `prix_location` double DEFAULT NULL,
  `id_agence` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_voiture`),
  KEY `FK_bjewjqdgit1k3x5wwngyx4t2k` (`id_agence`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`id_voiture`, `categorie_vehicule`, `couleur`, `disponibilite`, `etat_voiture`, `immatriculation`, `kilometrage`, `marque`, `nombre_de_place`, `prix_location`, `id_agence`) VALUES
(35, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Citroen', 4, 80, NULL),
(31, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Citroen', 4, 80, NULL),
(18, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Renault', 4, 80, NULL),
(33, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Citroen', 4, 80, NULL),
(20, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Renault', 4, 80, NULL),
(21, 'citadine', 'verte', 0, 1, '494YRE44', 45000, 'Opel', 5, 80, NULL),
(23, 'citadine', 'verte', 0, 1, '494YRE44', 45000, 'Opel', 5, 80, NULL),
(24, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Renault', 4, 80, NULL),
(25, 'citadine', 'verte', 0, 1, '494YRE44', 45000, 'Opel', 5, 80, NULL),
(26, 'citadine', 'verte', 1, 1, '494YRE44', 45000, 'Renault', 4, 80, NULL),
(27, 'citadine', 'verte', 0, 1, '494YRE44', 45000, 'Opel', 5, 80, NULL),
(30, 'citadine', 'verte', 0, 1, '494YRE44', 45000, 'Opel', 5, 80, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
