SET AUTOCOMMIT = 0;
START TRANSACTION;
CREATE DATABASE Eventos;

USE Eventos;
CREATE TABLE Usuario(
	ID_Usuario INT(11) AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
	Correo_Electronico VARCHAR(255)
);

CREATE TABLE Organizador(
	ID_Organizador INT(11) PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(255) NOT NULL,
    Telefono INT(11),
    Correo_Electronico VARCHAR(255)
);

CREATE TABLE Ubicacion(
	ID_Ubicacion INT(11) PRIMARY KEY AUTO_INCREMENT,
    Tipo ENUM("Presencial","Online"),
    Direccion VARCHAR(255)
);

CREATE TABLE Categoria(
	Nombre_Categoria VARCHAR(50) PRIMARY KEY
);

CREATE TABLE Evento(
	ID_Evento INT(11) PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100),
    Fecha DATE,
    Duracion TIME,
    Estado ENUM("Cancelado", "Activo"),
    Nombre_Categoria VARCHAR(50),
    ID_Ubicacion INT(11),
	ID_Organizador INT(11),
    CONSTRAINT fk_nombre_categoria FOREIGN KEY (Nombre_Categoria) REFERENCES Categoria(Nombre_Categoria) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_id_ubicacion FOREIGN KEY (ID_Ubicacion) REFERENCES Ubicacion(ID_Ubicacion) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_id_organizador FOREIGN KEY (ID_Organizador) REFERENCES Organizador(ID_Organizador) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE Inscripciones(
	ID_Usuario INT(11),
    ID_Evento INT(11),
    CONSTRAINT fk_id_usuario FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_id_evento FOREIGN KEY (ID_Evento) REFERENCES Evento(ID_Evento) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(ID_Usuario,ID_Evento)
);
COMMIT WORK;