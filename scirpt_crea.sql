use logements;
  
-- Création de la table Categorie
  
CREATE TABLE categorie (
id int NOT NULL AUTO_INCREMENT,
typeL varchar(50) NOT NULL,
PRIMARY KEY (id)
);
  
-- Création de la table Logement
CREATE TABLE logement (
id int NOT NULL AUTO_INCREMENT,
adresse varchar(50) NOT NULL,
surface float NOT NULL,
nbPieces int DEFAULT NULL,
hasGarden bool DEFAULT FALSE,
chauffage varchar(50) NOT NULL,
hasNeighbour bool DEFAULT NULL,
hasPool bool DEFAULT NULL,
etage int DEFAULT NULL,
id_categorie int DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_categorie) REFERENCES Categorie(id));
  
-- Insertion dans la table Categorie
INSERT INTO categorie(typeL) VALUES ('Maison');
INSERT INTO categorie(typeL) VALUES ('Appartement');