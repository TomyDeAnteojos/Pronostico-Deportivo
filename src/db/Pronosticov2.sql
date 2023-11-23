CREATE DATABASE Pronostico;

USE Pronostico;

CREATE TABLE Pronosticos
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    Participante VARCHAR(255) NOT NULL,
    Equipo1 VARCHAR(255) NOT NULL,
    Gana1 BIT DEFAULT 0,
    Empate BIT DEFAULT 0,
    Gana2 BIT DEFAULT 0,
    Equipo2 VARCHAR(255) NOT NULL
);
CREATE TABLE Partidos
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    Ronda INT NOT NULL CHECK(Ronda >= 1),
    Equipo1 VARCHAR(255) NOT NULL,
    cantGoles1 INT DEFAULT 0 CHECK( cantGoles1 >= 0 ),
    cantGoles2 INT DEFAULT 0 CHECK(cantGoles2 >= 0),
    Equipo2 VARCHAR(255) NOT NULL
);

INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Mariana','Argentina',1,0,0,'Arabia Saudita');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Mariana','Polonia',0,0,1,'México');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Mariana','Argentina',1,0,0,'México');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Mariana','Arabia Saudita',0,0,1,'Polonia');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Pedro','Argentina',1,0,0,'Arabia Saudita');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Pedro','Polonia',0,0,1,'México');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Pedro','Argentina',1,0,0,'México');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Pedro','Arabia Saudita',0,1,0,'Polonia');
INSERT INTO Pronosticos(Participante, Equipo1, Gana1, Empate, Gana2, Equipo2)
VALUES('Juan','Argentina',0,0,1,'México');

INSERT INTO Partidos(Ronda, Equipo1, cantGoles1, cantGoles2, Equipo2)
VALUES(1,'Argentina',1,2,'Arabia Saudita'); 
INSERT INTO Partidos(Ronda, Equipo1, cantGoles1, cantGoles2, Equipo2)
VALUES(1,'Polonia',0,0,'México');
INSERT INTO Partidos(Ronda, Equipo1, cantGoles1, cantGoles2, Equipo2)
VALUES(2,'Argentina',2,0,'México');
INSERT INTO Partidos(Ronda, Equipo1, cantGoles1, cantGoles2, Equipo2)
VALUES(2,'Arabia Saudita',0,2,'Polonia');

select * from partidos;