/*1*/
create database if not exists AJEDREZ;

use AJEDREZ;

create table if not exists hotel(
nombreHotel char(40) not null,
calle char(40) not null,
numero int not null,
CP char(5) not null,
localidad char(40) not null,
primary key (nombreHotel)
);

create table if not exists hotel_telefono(
nombreHotel char(40) not null,
telefono char(9) not null,
primary key (nombreHotel,telefono),
foreign key (nombreHotel) references hotel(nombreHotel)
);

create table if not exists participante(
DNI char(9) not null,
nombre char(40) not null,
nombreHotel char(40) not null,
primary key (DNI),
foreign key (nombreHotel) references hotel(nombreHotel)
);

create table if not exists arbitro(
DNI char(9) not null,
salario real not null,
primary key (DNI),
check (salario > 0),
foreign key (DNI) references participante(DNI)
);

create table if not exists partida(
codigo int not null,
duracion real not null,
DNI_arbitro char(9) not null,
primary key (codigo),
foreign key (DNI_arbitro) references participante(DNI)
);

create table if not exists jugador(
DNI char(9) not null,
nacimiento date not null,
primary key (DNI),
foreign key (DNI) references participante(DNI)
);

create table if not exists partida_jugador(
codigo_partida int not null,
DNI_jugador char(9) not null,
color enum("B","N") not null,
primary key (codigo_partida,DNI_jugador),
foreign key (codigo_partida) references partida(codigo),
foreign key (DNI_jugador) references jugador(DNI)
);