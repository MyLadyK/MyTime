CREATE DATABASE MyTime;

use MyTime;

CREATE TABLE usuario(
idUsuario INT AUTO_INCREMENT PRIMARY KEY,
puesto VARCHAR (25),
nombre VARCHAR (25) NOT NULL,
apellido1 VARCHAR (25) NOT NULL,
apellido2 VARCHAR (25),
correo VARCHAR (50) NOT NULL,
telefono VARCHAR (15),
contrasena VARCHAR (150),
permiso VARCHAR (15) NOT NULL
);

CREATE TABLE Turno (
    idTurno INT AUTO_INCREMENT PRIMARY KEY,
    año INT NOT NULL,
    mes VARCHAR (12) NOT NULL,
    diaInicio VARCHAR(10),
    diaFin VARCHAR(10),
    horaInicio VARCHAR (10),
    horaFin VARCHAR (10),
    tipoTurno VARCHAR (12),
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);

CREATE TABLE Solicitud (
    idSolicitud INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    fecha VARCHAR (12),
    idUsuario INT,
	FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
);
