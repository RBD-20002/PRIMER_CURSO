/*a*/
insert into yacimiento values
("Irán",32,53),
("Arabia Saudí",23,45),
("Rusia",61,105);

/*b*/
alter table personal add column calle char(40) null;
alter table personal add column numero int null;
alter table personal add column localidad char(30) null;

insert into personal values
(1,"Antonio Rodríguez Pérez","1960/11/24","Irán","Plaza España",15,"Madrid"), 
(2,"María García López","1973/03/20","Irán","Castellana",37,"Madrid"),
(3,"Marcos Veiga López","1968/08/06","Arabia Saudí","Miraflores",8,"León"), 
(4,"María Estévez Ramos","1981/02/17","Rusia","Gran Vía",19,"Madrid"),
(5,"Javier Rodríguez Cabana","1974/12/21","Irán","Vallecas",109,"Madrid"), 
(6,"Lucía Graña Gómez","1985/09/15","Rusia","Progreso",70,"Zamora"),
(7,"Borja Valle Estévez","1977/10/02","Arabia Saudí","Principal",46,"Vigo");

/*c*/
alter table yacimiento add column tipo_yacimiento char(1) null;

update yacimiento set tipo_yacimiento = "Z";

alter table yacimiento modify column tipo_yacimiento char(1) default "X";

alter table yacimiento modify column tipo_yacimiento enum("W","X","Y","Z") default "X";

/*d*/
update personal set yacimiento = "Rusia" where numero_empleado = 2;

delete from personal where yacimiento = "Iran";

/*e*/
update personal set localidad = "Madrid" , calle = "Vallecas nº 109" where localidad != "Madrid";

/*f*/
create table if not exists personal_yacimiento(
numero_empleado int not null,
nombre_yacimiento char(40) not null,
primary key (numero_empleado,nombre_yacimiento),
foreign key (numero_empleado) references personal (numero_empleado),
foreign key (nombre_yacimiento) references yacimiento (nombre)
);

insert into personal_yacimiento values
(2,"Irán"),(2,"Rusia"),
(3,"Arabia Saudí"),(3,"Rusia"),
(4,"Rusia"),(4,"Arabia Saudí"),
(6,"Rusia"),(6,"Arabia Saudí"),
(7,"Arabia Saudí"),(7,"Rusia");