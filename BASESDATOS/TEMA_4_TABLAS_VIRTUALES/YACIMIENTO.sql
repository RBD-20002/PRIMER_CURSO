/*2*/

create database if not exists yacimiento;

use yacimiento;

create table if not exists yacimiento(
nombre char(40) not null,
latitud real unique not null,
longitud real unique not null,
primary key (nombre)
);

create table if not exists personal(
numero_empleado int not null,
nombre char(40) not null,
nacimiento date not null,
yacimiento char(40) not null,
primary key (numero_empleado),
foreign key (yacimiento) references yacimiento(nombre)
on delete cascade
on update cascade
);

create table if not exists personal_telefono(
numero_empleado int not null,
telefono char(9) not null,
primary key (numero_empleado,telefono),
foreign key (numero_empleado) references personal(numero_empleado)
on delete cascade
on update cascade
);

create table if not exists pozo(
yacimiento char(40) not null,
numero_pozo int not null,
produccion real not null,
primary key (yacimiento,numero_pozo),
foreign key (yacimiento) references yacimiento(nombre)
on delete cascade
on update cascade
);