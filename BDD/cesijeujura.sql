-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 25 Janvier 2016 à 20:40
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cesijeujura`
--

-- --------------------------------------------------------

--
-- Structure de la table `carac_fenetre`
--

CREATE TABLE IF NOT EXISTS `carac_fenetre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TYPE_FENETRE` int(11) NOT NULL,
  `ID_PIECE` int(11) NOT NULL,
  `LARGEUR` int(11) NOT NULL,
  `HAUTEUR` int(11) NOT NULL,
  `FORME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TYPE_FENETRE` (`ID_TYPE_FENETRE`),
  KEY `FK_PIECE` (`ID_PIECE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(100) NOT NULL,
  `PRENOM` varchar(100) NOT NULL,
  `ADRESSE` varchar(255) NOT NULL,
  `CP` varchar(5) NOT NULL,
  `VILLE` varchar(150) NOT NULL,
  `MAIL` varchar(100) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `REF` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `composant`
--

CREATE TABLE IF NOT EXISTS `composant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

CREATE TABLE IF NOT EXISTS `devis` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROJET` int(11) NOT NULL,
  `REF` varchar(255) NOT NULL,
  `ETAT` varchar(255) NOT NULL,
  `PRIX` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PROJET` (`ID_PROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `devis_gamme`
--

CREATE TABLE IF NOT EXISTS `devis_gamme` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_GAMME` int(11) NOT NULL,
  `ID_DEVIS` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_devis` (`ID_DEVIS`),
  KEY `FK_GAMME` (`ID_GAMME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE IF NOT EXISTS `droit` (
  `ID` int(11) NOT NULL,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `droit_utilisateur`
--

CREATE TABLE IF NOT EXISTS `droit_utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DROIT` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DROIT` (`ID_DROIT`),
  KEY `FK_UTILISATEUR` (`ID_UTILISATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(255) NOT NULL,
  `ID_DEVIS` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DEVIS` (`ID_DEVIS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `gamme`
--

CREATE TABLE IF NOT EXISTS `gamme` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `gamme_module`
--

CREATE TABLE IF NOT EXISTS `gamme_module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MODULE` int(11) NOT NULL,
  `ID_GAMME` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MODULE` (`ID_MODULE`),
  KEY `FK_GAMME` (`ID_GAMME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `main_oeuvre`
--

CREATE TABLE IF NOT EXISTS `main_oeuvre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(255) NOT NULL,
  `PRIX` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

CREATE TABLE IF NOT EXISTS `piece` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SURFACE` int(255) NOT NULL,
  `NB_PORTE` int(11) NOT NULL,
  `NB_FENETRE` int(11) NOT NULL,
  `FORME` varchar(255) NOT NULL,
  `FINITION` varchar(255) NOT NULL,
  `NUM_ETAGE` int(11) NOT NULL,
  `FK_ID_PROJET` int(11) NOT NULL,
  `FK_ID_TYPE_PIECE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PROJET` (`FK_ID_PROJET`),
  KEY `FK_TYPE_PIECE` (`FK_ID_TYPE_PIECE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `REF` varchar(50) NOT NULL,
  `SURFACE` double NOT NULL,
  `FORME` varchar(255) NOT NULL,
  `HAUTEUR` int(11) NOT NULL,
  `NBETAGE` int(11) NOT NULL,
  `COM` text NOT NULL,
  `MAQUETTE` varchar(255) NOT NULL,
  `FK_IDCLIENT` int(11) NOT NULL,
  `FK_IDCOMMERCIAL` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENT` (`FK_IDCLIENT`),
  KEY `FK_COMMERCIAL` (`FK_IDCOMMERCIAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `quantite_composant_module`
--

CREATE TABLE IF NOT EXISTS `quantite_composant_module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMPOSANT` int(11) NOT NULL,
  `ID_MODULE` int(11) NOT NULL,
  `QUANTITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COMPOSANT` (`ID_COMPOSANT`),
  KEY `FK_MODULE` (`ID_MODULE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `ressource`
--

CREATE TABLE IF NOT EXISTS `ressource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DEVIS` int(11) NOT NULL,
  `ID_MAIN_OEUVRE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DEVIS` (`ID_DEVIS`),
  KEY `FK_MAIN_OEUVRE` (`ID_MAIN_OEUVRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `type_fenetre`
--

CREATE TABLE IF NOT EXISTS `type_fenetre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `type_piece`
--

CREATE TABLE IF NOT EXISTS `type_piece` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(150) NOT NULL,
  `PRENOM` varchar(150) NOT NULL,
  `TEL` varchar(15) NOT NULL,
  `MAIL` varchar(150) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `carac_fenetre`
--
ALTER TABLE `carac_fenetre`
  ADD CONSTRAINT `carac_fenetre_ibfk_2` FOREIGN KEY (`ID_PIECE`) REFERENCES `piece` (`ID`),
  ADD CONSTRAINT `carac_fenetre_ibfk_1` FOREIGN KEY (`ID_TYPE_FENETRE`) REFERENCES `type_fenetre` (`ID`);

--
-- Contraintes pour la table `devis`
--
ALTER TABLE `devis`
  ADD CONSTRAINT `devis_ibfk_1` FOREIGN KEY (`ID_PROJET`) REFERENCES `projet` (`ID`);

--
-- Contraintes pour la table `devis_gamme`
--
ALTER TABLE `devis_gamme`
  ADD CONSTRAINT `devis_gamme_ibfk_2` FOREIGN KEY (`ID_DEVIS`) REFERENCES `devis` (`ID`),
  ADD CONSTRAINT `devis_gamme_ibfk_1` FOREIGN KEY (`ID_GAMME`) REFERENCES `gamme` (`ID`);

--
-- Contraintes pour la table `droit_utilisateur`
--
ALTER TABLE `droit_utilisateur`
  ADD CONSTRAINT `droit_utilisateur_ibfk_2` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `droit_utilisateur_ibfk_1` FOREIGN KEY (`ID_DROIT`) REFERENCES `droit` (`ID`);

--
-- Contraintes pour la table `fichier`
--
ALTER TABLE `fichier`
  ADD CONSTRAINT `fichier_ibfk_1` FOREIGN KEY (`ID_DEVIS`) REFERENCES `devis` (`ID`);

--
-- Contraintes pour la table `gamme_module`
--
ALTER TABLE `gamme_module`
  ADD CONSTRAINT `gamme_module_ibfk_2` FOREIGN KEY (`ID_GAMME`) REFERENCES `gamme` (`ID`),
  ADD CONSTRAINT `gamme_module_ibfk_1` FOREIGN KEY (`ID_MODULE`) REFERENCES `module` (`ID`);

--
-- Contraintes pour la table `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `piece_ibfk_2` FOREIGN KEY (`FK_ID_TYPE_PIECE`) REFERENCES `type_piece` (`ID`),
  ADD CONSTRAINT `piece_ibfk_1` FOREIGN KEY (`FK_ID_PROJET`) REFERENCES `projet` (`ID`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`FK_IDCOMMERCIAL`) REFERENCES `utilisateur` (`ID`),
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`FK_IDCLIENT`) REFERENCES `client` (`ID`);

--
-- Contraintes pour la table `quantite_composant_module`
--
ALTER TABLE `quantite_composant_module`
  ADD CONSTRAINT `quantite_composant_module_ibfk_2` FOREIGN KEY (`ID_MODULE`) REFERENCES `module` (`ID`),
  ADD CONSTRAINT `quantite_composant_module_ibfk_1` FOREIGN KEY (`ID_COMPOSANT`) REFERENCES `composant` (`ID`);

--
-- Contraintes pour la table `ressource`
--
ALTER TABLE `ressource`
  ADD CONSTRAINT `ressource_ibfk_2` FOREIGN KEY (`ID_MAIN_OEUVRE`) REFERENCES `main_oeuvre` (`ID`),
  ADD CONSTRAINT `ressource_ibfk_1` FOREIGN KEY (`ID_DEVIS`) REFERENCES `devis` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
