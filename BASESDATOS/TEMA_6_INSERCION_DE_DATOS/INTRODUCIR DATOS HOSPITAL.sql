/*3*/
insert into persona values
("11111111A","600102030","Antonio Rodríguez Pérez","1960/11/24"),
("11111112B","600102031","María García López","1973/03/20"),
("11111113C","600102032","Marcos Veiga López","1968/08/06"),
("11111114D","600102033","María Estévez Ramos","1981/02/17"),
("11111115E","600102034","Javier Rodríguez Cabana","1974/12/21"),
("11111116F","600102035","Lucía Graña Gómez","1985/09/15"),
("11111117G","600102036","Borja Valle Estévez","1977/10/02");

insert into medico (DNI,salario) values ("11111111A",2500.15),("11111114D",1750.50),("11111117G",1930.45);

alter table paciente modify DNI char(9) not null, modify num_SS char(15) null;

insert into paciente (DNI,num_SS) 
select DNI,null from persona where DNI not in ("11111111A","11111114D","11111117G");

/*b*/
insert into planta values
(1,"Medicina Humana"),
(2,"Oftalmologia"),
(3,"Traumatologia");

insert into cama values
(1,1),(1,2),(1,3),(1,4),(1,5),
(2,1),(2,2),(2,3),(2,4),(2,5),
(3,1),(3,2),(3,3),(3,4),(3,5);

/*c*/
insert into reconocimiento values
("R01","2020/01/15",30,"11111111A","11111112B"),
("R02","2020/02/26",40,"11111114D","11111113C"),
("R03","2020/01/20",20,"11111117G","11111115E");

insert into ingreso values
("I01","2020/01/15","2020/01/20","11111112B",1,5),
("I02","2020/02/26",null,"11111113C",3,3),
("I03","2020/01/20","2020/01/22","11111115E",2,1);

/*d*/
delete from medico where DNI = "11111111A";

/*e*/
update medico set salario = salario + (salario * 0.05);

/*f*/
create table medico_reconocimeinto(
DNI char(9) not null,
codigo char(20) not null,
primary key (DNI,codigo),
foreign key (DNI) references persona (DNI)
on delete cascade
on update cascade,
foreign key (codigo) references reconocimiento(codigo)
on delete cascade
on update cascade
);

