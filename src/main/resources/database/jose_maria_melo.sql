DROP DATABASE IF EXISTS jose_maria_melo;
CREATE DATABASE jose_maria_melo;
USE jose_maria_melo;

CREATE TABLE estudiante (
id  INT PRIMARY KEY AUTO_INCREMENT,
identificacion_estudiante INT(20),
nombre_completo VARCHAR (500),
grado ENUM('Primero', 'Segundo', 'Tercero', 'Cuarto', 'Quinto', 'Sexto', 'Septimo', 'Octavo', 'Noveno', 'Decimo', 'Once'),
calificacion DECIMAL(2,1),
estado_nota ENUM("Aprobado","Reprobado"),
estado BIT(1) DEFAULT 1

);

