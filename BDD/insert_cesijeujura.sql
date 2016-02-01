
INSERT INTO `client` (`ID`, `NOM`, `PRENOM`, `ADRESSE`, `CP`, `VILLE`, `MAIL`, `TEL`, `REF`, `CIVILITE`) VALUES
(1, 'Chaignepain', 'Jennifer', '177 La Mainguisière', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '1', 3);

INSERT INTO `devis` (`ID`, `ID_PROJET`, `DATE_CREATION`, `REF`, `ETAT`, `PRIX`) VALUES
(1, 1, '2016-01-26 23:00:00', '1', 'A_TRAITER', 120.5);

INSERT INTO `projet` (`ID`, `NOM`, `REF`, `SURFACE`, `FORME`, `HAUTEUR`, `NBETAGE`, `COM`, `MAQUETTE`, `FK_IDCLIENT`, `FK_IDCOMMERCIAL`) VALUES
(1, 'Projet Coiffeur', '1', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 1, 1);

INSERT INTO `utilisateur` (`ID`, `NOM`, `PRENOM`, `TEL`, `MAIL`, `PASSWORD`) VALUES
(1, 'Chauvet', 'Ludivine', '0000000000', 'mail@mail.com', 'test');
