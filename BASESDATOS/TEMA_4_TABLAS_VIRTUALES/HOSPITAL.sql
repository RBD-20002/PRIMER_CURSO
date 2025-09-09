/*3*/

create database if not exists hospital;

use hospital;

create table if not exists persona(
DNI char(9) not null,
telefono char(12) not null,
nombre char(40) not null,
nacimiento date not null,
primary key (DNI)
);

create table if not exists medico(
DNI char(9) not null,
salario real not null,
primary key (DNI),
foreign key (DNI) references persona(DNI)
on delete cascade
on update cascade
);

create table if not exists paciente(
DNI char(9) not null,
num_SS char(15) unique not null,
primary key (DNI),
foreign key (DNI) references persona(DNI)
on delete cascade
on update cascade
);

create table if not exists planta(
numero int not null,
nombre char(40) not null,
primary key (numero)
);

create table if not exists cama(
numero_planta int not null,
numero_cama int not null,
primary key (numero_planta,numero_cama),
foreign key (numero_planta) references planta(numero)
on delete cascade
on update cascade
);

create table if not exists reconocimiento(
codigo char(20) not null,
fecha date not null,
duracion int not null,
DNI_medico char(9) not null,
DNI_paciente char(9) not null,
primary key (codigo),
foreign key (DNI_medico) references medico(DNI)
on delete cascade
on update cascade,
foreign key (DNI_paciente) references paciente(DNI)
on delete cascade
on update cascade
);

create table if not exists ingreso(
codigo char(20) not null,
fecha_entrada date not null,
fecha_alta date null,
DNI_paciente char(9) not null,
numero_planta int not null,
numero_cama int not null,
primary key (codigo),
foreign key (DNI_paciente) references paciente(DNI)
on delete cascade
on update cascade,
foreign key (numero_planta,numero_cama) references cama(numero_planta,numero_cama)
on delete cascade
on update cascade
);