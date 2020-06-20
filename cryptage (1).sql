-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  sam. 20 juin 2020 à 17:29
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cryptage`
--

-- --------------------------------------------------------

--
-- Structure de la table `covotant`
--

CREATE TABLE `covotant` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `datenaissance` varchar(100) NOT NULL,
  `iden` varchar(1000) NOT NULL,
  `bulltinvote` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `covotant`
--

INSERT INTO `covotant` (`id`, `nom`, `prenom`, `datenaissance`, `iden`, `bulltinvote`) VALUES
(4, 'aa', 'aa', '2020-05-21', 'AAA', '-----BEGIN PGP MESSAGE-----\nVersion: Didisoft OpenPGP Library for Java 3.2\n\nhQEMA5wyFClkXHfCAQf+MkE14d0U3WFP5qkZj3hBIvFj+L5VwNc97OeGXhnl5V+0\naj6JFt9rRmogdxrw1P30Rs/3RJaDXFuZvfXqExW/gkNDj5XRrlUJl1hW7Ytn0dQz\nXwih0CsqmrBP3FspJp2SfWIdWImYDLQbsmScipgGY7zqAgxwlG/jWl9ZfDX7v40+\n98705Oz1eTv+u8TI1DNtQ4pHjEfiPijoW62uhr4dSlijLeVh7cfkz/M7NcxT2sYz\ny5Vo/qzjDR1+b16DXwuKGbeCF1RNvAo7u6EnFQGzdxm/KzdVef8jvvq1YjtU4nWC\nkl9rzW2Q8Z2MKpGm9HkxjoRdn1t1n1wUp2p8hyNQ2dLBLwH7FsTrSGhHjtNW5mLt\nv6A/H7QBNjGiq07YZiSGEkOR7D4VhO6CzdnBRBdPyr/sxMUzlY3Cq+mXHFKl+t5M\n8vYNSswDr12AbLGiNSQ0/tI3ySK8o1hEj48ddlQW2M40sDDDCVlcNsikFncBu867\nWeVrqfZSdTFiQ1I5pOzHhfmAH5HL6Aw6I7bAK2cUBcnWiin5WZTRqsizPrR87M1h\nW6VZDrRUtS9PSHZPIwtotv9/8qx8y2GMfh0HtYj8m3SBPdtu7FVpdw9xj41SFwOz\nlVdLAPpz3YjpvmFTMUs1IDEorbMBMN16ZfiXAoo1KCnZUuLma1F/24+fi+1Cfzha\nnhe+bGNbB1wfTak49+G0eZ7K3FAUhVfGid9ItU8nVCSVaQeAOIei/1IAG0yOL4sI\nGfR1sEg1Bs6T+PdRxcR0996yIf6zBsiG5GlFeJoVTSdykzZmO22gwiutBrqa74ou\nY0tBC+KXQUnswoJpdvEUewyGa9g86IBA8KqIr2Mz40EiVTVD89vSaTM/gz7t3I01\nAbaP357T7lZZ+yudQgb4F2LRnleUUGLUv7Z9ovGKkSgYEmdxM/KEw2V/STiNCrmO\n1lh9hhvZeRxmDsGCINIQ5tIBad+jowj2dlYO3G4H1hNoh1yLW2m6I9V6GoMaiJky\nzA==\n=uLEO\n-----END PGP MESSAGE-----\n'),
(5, 'saad', 'Saad ', '2020-06-09', 'aa', '-----BEGIN PGP MESSAGE-----\nVersion: Didisoft OpenPGP Library for Java 3.2\n\nhQEMA5wyFClkXHfCAQf/en4Qiv0U42SGypb7k8SasIy72Z1yDoDow+RZvCAdECAo\nbgVlSsjhXGZ+4rz4dhKaFtLE6fQyblpMPsg7Nd1dLCF2AO4ThgFAAkpXAOK8RcvD\n0j0rkkT0I5nX1akXP5Y/2DoFZAIggP04h2cC1TmywjB5X+xLo+FjHZRaOlhrdVqe\nHdgEkQ5zTjw1EMi1yx24L4yBbRMV5o8gn+Cm+UkObLueU6zARSZRgMiuSwy7rZSn\nWanoLyhuDZgOytdz2HDJxWkg2Q0VTcLiHh/QT8gRlcKw9n8YbYvG1Yk4yLzADxPx\n3L3mfOBDXKAFDxweWsS+TgM/ANCbmYLKPSm2XiCyHdLBLQHnk/+gjDIK8122DiEM\nmwdLXdhvJLF5tdfTZbXnf2dLzJCWd5nW8JA3JC5gB7FT8Q9+vSvjBiLe4mMVwmPH\namS7x7XBrRduFZGhLryKkGuuXMAdawtl5NQSyktr6TR0xqLBJTJCaXwGaXF8G2q1\ndRV9abUQrPsmgKtsoVOwl1bV4ZbQ1N54EAS4IQq2tlZcnUrSt3BkvjQrZRlH/GJj\nCWdeniU7SwCV0fEwJQ2ABxaKEd+DigbRq/3UMDiX4z9kEIJ+/h8p3keqadeyuoF7\nn/hc63KBFej5msI35noA/Kqo3B5yQMP91o0BAA87RXr9S3y2MGcUI61gut+mFvBp\nU6IRpLGQd1kre6yPfMviJh/M5ENRec0lDgzqdTdpIVwn+9CJIyDCnMgKifPsdzlh\nGRJOPF3W2xyyvEfd8J9wtMqlBCk4hsKlon4UrDatuCXE4qosHZ1S6OjKIxFYIXxU\nXh0Z7DkLgXwv6O0jNpjpW9Jw+O+Fm3X4SjjgedGxZExK0/n2Y2S7lewASramEXYB\n9xJLdKZjijnOsSKkW6n79N6jlF3nfW38Vks51q2bNPrLwAPfwEfEBN0+0Fo7/OpK\n2ZtXoxnZHO3hfuZkbs+8iklFlXFGv/emtbTKvYN9fqLJnoAjwYBbz75jitry7uM=\n=ZBV4\n-----END PGP MESSAGE-----\n');

-- --------------------------------------------------------

--
-- Structure de la table `devotant`
--

CREATE TABLE `devotant` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `datenaissance` varchar(100) NOT NULL,
  `iden` varchar(1000) NOT NULL,
  `bulltinvote` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `devotant`
--

INSERT INTO `devotant` (`id`, `nom`, `prenom`, `datenaissance`, `iden`, `bulltinvote`) VALUES
(1, 'aa', 'aa', '2020-05-21', 'AAA', 'condidate1'),
(2, 'saad', 'Saad ', '2020-06-09', 'aa', 'condidate2');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `covotant`
--
ALTER TABLE `covotant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `devotant`
--
ALTER TABLE `devotant`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `covotant`
--
ALTER TABLE `covotant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `devotant`
--
ALTER TABLE `devotant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
