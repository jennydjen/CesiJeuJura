INSERT INTO `utilisateur` (`ID`, `NOM`, `PRENOM`, `TEL`, `MAIL`, `PASSWORD`) VALUES
(1, 'Chauvet', 'Ludivine', '0000000000', 'mail@mail.com', 'test');

INSERT INTO `client` (`NOM`, `PRENOM`, `ADRESSE`, `CP`, `VILLE`, `MAIL`, `TEL`, `REF`, `CIVILITE`) VALUES
('Toto', 'Tutu', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '543543', 3),
('Tutu', 'Albert', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '654354', 3),
('Walter', 'Toto', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '444454', 3),
('Noob', 'Jean', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '25452', 3),
('Henri', 'Tutu', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '82254', 3),
('Toto', 'Roger', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '2545', 3),
('Chaignepain', 'Bob', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '25488', 3),
('Tutu', 'Toto', '177 La Mainguisi√®re', '85000', 'La Roche Sur Yon', 'mail@mail.com', '0000000000', '17787', 3);

INSERT INTO `projet` (`NOM`, `REF`, `SURFACE`, `FORME`, `HAUTEUR`, `NBETAGE`, `COM`, `MAQUETTE`, `FK_IDCLIENT`, `FK_IDCOMMERCIAL`) VALUES
( 'Projet Coiffeur', '578687', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 3, 1),
( 'Projet Ecole', '587587', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 2, 1),
( 'Projet Commerce', '5875', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 5, 1),
( 'Projet Rien', '58757', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 7, 1),
( 'Projet Hopital', '85785', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 6, 1),
( 'Projet Wood', '857857', 50, 'Rectangle', 1, 0, 'Commentaire', 'Maquette', 4, 1);

INSERT INTO `devis` (`ID_PROJET`, `DATE_CREATION`, `REF`, `ETAT`, `PRIX`) VALUES
(4, '2016-01-26 23:00:00', '578527', 'A_TRAITER', 120.5),
(7, '2016-01-26 23:00:00', '5574278', 'A_TRAITER', 120.5),
(6, '2016-01-26 23:00:00', '5427', 'A_TRAITER', 120.5),
(5, '2016-01-26 23:00:00', '43784', 'A_TRAITER', 120.5),
(2, '2016-01-26 23:00:00', '1783', 'A_TRAITER', 120.5);

INSERT INTO `cesijeujura`.`type_piece` (`ID`, `NOM`) VALUES 
('1', 'Chambre'), 
('2', 'Salle de Bain'), 
('3', 'Salon'), 
('4', 'Cuisine'), 
('5', 'Salle ‡ manger'), 
('6', 'Chambre'), 
(NULL, 'Garage');


INSERT INTO `cesijeujura`.`type_fenetre` (`ID`, `NOM`) VALUES 
(NULL, 'Ronde'), (NULL, 'Carre'), (NULL, 'Rectangle');

INSERT INTO `cesijeujura`.`piece` (`ID`, `SURFACE`, `NB_PORTE`, `NB_FENETRE`, `FORME`, `FINITION`, `NUM_ETAGE`, `PROJET_ID`, `TYPE_PIECE_ID`) VALUES 
(NULL, '20', '2', '2', 'CarrÈ', 'vide', '0', '1', '2'), 
(NULL, '10', '1', '1', 'rectangle', 'vide', '0', '1', '1');

INSERT INTO `composant` (`ID`, `NOM`, `PRIX`) VALUES
(NULL, 'CrÈpi minÈral - 3mm', 23),
(NULL, 'Gypse-phaser - 12mm', 13),
(NULL, 'EPS/XPS - 10mm', 25),
(NULL, 'OSB - 10mm', 60),
(NULL, 'Chassis de bois - 120mm', 12.52),
(NULL, 'Ouate minÈral - 100mm', 34.5),
(NULL, 'Folio isolÈ sur vapeur - 1mm', 85.5),
(NULL, 'Carton de pl‚tre - 12,5mm', 40.99),
(NULL, 'Peinture - 1mm', 41.5),
(NULL, 'Ouate - 100mm', 6.8),
(NULL, 'Parquet laminÈe - 10mm', 9.7),
(NULL, 'Tuiles', 17.9),
(NULL, 'Folio - 1mm', 25.85),
(NULL, 'Poutre - 160mm', 42.5),
(NULL, 'Phaser - 3mm', 69.59),
(NULL, 'Folio d''aluminium', 60.23),
(NULL, 'Ossature 45mm x 120 mm', 5.63),
(NULL, 'Isolation laine minÈrale - 120mm', 50.65),
(NULL, 'Contre littelage 22mm x 45 mm', 25.99),
(NULL, 'Tasseau 22mm x 45mm', 12.99);
