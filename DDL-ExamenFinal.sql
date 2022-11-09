CREATE DATABASE examenfinaldb;

use examenfinaldb;

CREATE TABLE task(
id int primary key auto_increment,
titulo varchar(200),
descripcion TEXT,
fecha varchar(20),
responsable varchar(150)
);


INSERT INTO task(
titulo,
descripcion,
fecha,
responsable
) 
values(
'Hacer examen PrograII',
'Realizar el examen de Programacion II',
'11/07/2022',
'Juan Jose Carranza Rendon'
);



