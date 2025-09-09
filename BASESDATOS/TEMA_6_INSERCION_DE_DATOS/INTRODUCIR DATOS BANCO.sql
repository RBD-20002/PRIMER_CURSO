/*a*/
create database if not exists banco;

use banco;

create table if not exists cliente(
DNI_cliente char(9) unique not null,
nombre char(40) not null,
calle char(20) null,
numero char(20) null,
CP char(5) null,
localidad char(20) null,
primary key (DNI_cliente)
);

create table if not exists cliente_telefono(
DNI_cliente char(9) not null,
telefono char(9) not null,
primary key (DNI_cliente,telefono),
foreign key (DNI_cliente) references cliente(DNI_cliente)
);

create table if not exists tipo(
id int auto_increment,
nombre char(40),
beneficios char(40),
primary key (id)
);

create table if not exists cuenta(
numero_cuenta char(24),
saldo double not null,
tipo int,
primary key (numero_cuenta),
foreign key (tipo) references tipo(id)
);

create table if not exists cliente_cuenta(
DNI_cliente char(9),
numero_cuenta char(24),
primary key (DNI_cliente,numero_cuenta),
foreign key (DNI_cliente) references cliente(DNI_cliente),
foreign key (numero_cuenta) references cuenta(numero_cuenta)
);

create table if not exists movimiento(
numero_cuenta char(24) not null,
numero_movimiento int not null,
fecha date not null,
cantidad double not null,
importe_final double not null,
descripcion char(255) not null default "Movimiento",
primary key (numero_cuenta,numero_movimiento),
);

/*b*/

insert into cliente values
("11111111A","Marta","Principal",5,"32852","Lugo"),
("11111111B","Pedro",null,null,null,null),
("11111111C","Luis","Plaza España",50,"30500","Ourense"),
("11111111D","Ana",null,null,null,null);

insert into tipo (nombre,beneficios) values 
("Ahorro",null),("Inversion",null); 

insert into cliente_telefono (DNI_cliente,telefono) values
("11111111A","666666666"),
("11111111B","666666667"),
("11111111B","666666668"),
("11111111D","666666669");

insert into cuenta values
("C1",1000,1),
("C2",2000,2),
("C3",1800,1),
("C4",3000,2),
("C5",750,1);

insert into cliente_cuenta values
("11111111A","C1"),
("11111111C","C2"),
("11111111D","C3"),
("11111111D","C4"),
("11111111C","C4"),
("11111111B","C5");

insert into Movimiento values
("C1",1,"2017/01/01",800,800,"Ingreso inicial"),
("C1",2,"2017/01/14",-300,500,"Cajero Autom."),
("C1",3,"2017/02/05",500,1000,"Ingreso"),
("C2",1,"2017/01/01",1000,1000,"Nomina"),
("C2",2,"2017/01/04",1000,2000,"Nomina"),
("C3",1,"2017/01/09",2100,2100,"Ingreso inicial"),
("C3",2,"2017/01/18",-300,1800,"Compra TPV"),
("C4",1,"2017/01/14",1500,1500,"Ingreso"),
("C4",2,"2017/01/23",1500,3000,"Ingreso"),
("C5",1,"2017/01/01",750,750,"Ingreso inicial");

/*c*/
select c.nombre,c.DNI_cliente,cu.numero_cuenta,cu.saldo from cliente_cuenta as cc
join cliente as c on cc.DNI_cliente = c.DNI_cliente
join cuenta as cu on cc.numero_cuenta = cu.numero_cuenta;

start transaction;

update cuenta set saldo = saldo - 100 where numero_cuenta = "C3"; /*ANA*/
update cuenta set saldo = saldo - 100 where numero_cuenta = "C2"; /*LUIS*/
update cuenta set saldo = saldo + 200 where numero_cuenta = "C4"; /*CUENTA COMUN*/

insert into movimiento values
("C3",3,"2025/03/15",-100,1700,"Transf. a cuenta comun");
insert into movimiento values
("C2",3,"2025/03/15",-100,1900,"Transf. a cuenta comun");
insert into movimiento values
("C4",3,"2025/03/15",+100,3100,"Ingreso de Luis");
insert into movimiento values
("C4",4,"2025/03/15",+100,3200,"Ingreso de Ana");

commit;

/*d*/
start transaction;

update cuenta set saldo = saldo - 50 where numero_cuenta = "C4";
update cuenta set saldo = saldo + 50 where numero_cuenta = "C5";
 
insert into movimiento values
("C4",5,"2025/03/16",-50,3150,"Transf. a Pedro");
insert into movimiento values
("C5",2,"2025/03/16",+50,800,"Ingreso de Luis y Ana");

commit;
/*Si realizo al final un rollback no se guarada nada de los cambios*/
/*Si realizo al final un commit se guardan todos los cambios si no hubo problemas*/

/*e*/



/*f*/
delete from cliente_telefono where telefono = "666666668";