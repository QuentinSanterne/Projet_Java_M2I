use logements;
  
-- Création de la table Categorie
CREATE TABLE Categorie (
id int NOT NULL,
typeL varchar(50) NOT NULL,
PRIMARY KEY (id)
);
  
-- Création de la table Logement
CREATE TABLE Logement (
id int NOT NULL,
adresse varchar(50) NOT NULL,
surface float NOT NULL,
nbPieces int NOT NULL,
hasGarden bool DEFAULT FALSE,
chauffage varchar(50) NOT NULL,
hasPool bool DEFAULT FALSE,
etage int DEFAULT 1,
id_categorie int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_categorie) REFERENCES Categorie(id));
  
-- Insertion dans la table Categorie
-- INSERT INTO Categorie(typeL) VALUES ('Maison');
-- INSERT INTO Categorie(typeL) VALUES ('Appartement');
