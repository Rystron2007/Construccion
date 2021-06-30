CREATE TABLE Persona(
id_persona NUMBER GENERATED ALWAYS AS IDENTITY,
cedula INTEGER,
edad INTEGER,
dirección VARCHAR(60),
email VARCHAR(40),
PRIMARY KEY (id_persona)
);

CREATE TABLE ActaNacimiento(
id_acta_nacimiento NUMBER GENERATED ALWAYS AS IDENTITY,
nombres VARCHAR(40),
apellidos VARCHAR(40),
nacionalidad VARCHAR(20),
PRIMARY KEY (id_acta_nacimiento),
ActaNacimiento_Persona_FK INT NOT NULL,
CONSTRAINT fkactanacimiento_personas
FOREIGN KEY (ActaNacimiento_Persona_FK)
REFERENCES Persona(id_persona)
);

CREATE TABLE Arbitro(
partidos_arbitrados INTEGER,
Persona_id_persona INTEGER,
PRIMARY KEY (Persona_id_persona),
Arbitro_Persona_FK INTEGER,
CONSTRAINT fkarbitro_persona
FOREIGN KEY (Arbitro_Persona_FK)
REFERENCES Persona(id_persona)
);

CREATE TABLE DirectorTecnico(
equipos_dirigidos INTEGER,
Persona_id_persona INTEGER,
id_contrato INTEGER,
PRIMARY KEY (Persona_id_persona),
DirectorTecnico_Persona_FK INTEGER,
CONSTRAINT fkdirectortecnico_persona
FOREIGN KEY (DirectorTecnico_Persona_FK)
REFERENCES Persona(id_persona)
);

CREATE TABLE Equipo(
id_equipo NUMBER GENERATED ALWAYS AS IDENTITY,
nombre_equipo VARCHAR (30),
pais_origen VARCHAR(20),
PRIMARY KEY (id_equipo)
);

CREATE TABLE Contrato(
id_contrato NUMBER GENERATED ALWAYS AS IDENTITY,
codigo_contrato VARCHAR(10),
fecha_inicio DATE,
fecha_fin DATE,
estado VARCHAR(15),
Equipo_id_equipo INTEGER,
DirectorTecnico_Persona_id_persona INTEGER,
PRIMARY KEY (id_contrato),
Contrato_DirectorTecnico_FK INTEGER,
CONSTRAINT fkcontrato_directortecnico
FOREIGN KEY(Contrato_DirectorTecnico_FK)
REFERENCES DirectorTecnico(Persona_id_persona),
Contrato_Equipo_FK INTEGER,
CONSTRAINT fkcontrato_Equipo
FOREIGN KEY(Contrato_Equipo_FK)
REFERENCES Equipo(id_equipo)
);

