CREATE TABLE Repas
(
	id int IDENTITY(1,1) CONSTRAINT PK_REPAS PRIMARY KEY,
	date Date NOT NULL,
	heure time NOT NULL
);	



CREATE TABLE Ingredient
(
	id int IDENTITY(1,1) CONSTRAINT PK_INGREDIENT PRIMARY KEY,
	nom varchar(150) NOT NULL,
	id_repas int NOT NULL,
	FOREIGN KEY (id_repas) REFERENCES Repas(id)
);	
