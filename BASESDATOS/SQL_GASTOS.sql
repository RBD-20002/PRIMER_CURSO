create database if not exists registro_gastos;

use registro_gastos;

create table if not exists RegistroPago(
id int not null auto_increment,
descripcion varchar(60) not null,
monto decimal(10,2) not null,
tipo_pago enum("tarjeta","efectivo") not null,
fecha_pago date not null default (curdate()),
primary key(id)
);

create table if not exists PagosConTarjeta(
id_referencia int not null,
descripcion varchar(60) not null,
monto decimal(12,2) not null,
tipo varchar(10) not null default "tarjeta",
fecha_pago date not null,
primary key (id_referencia),
foreign key (id_referencia) references RegistroPago(id)
);

create table if not exists PagosConEfectivo(
id_referencia int not null,
descripcion varchar(60) not null,
monto decimal(12,2) not null,
tipo varchar(10) not null default "efectivo",
fecha_pago date not null,
primary key (id_referencia),
foreign key (id_referencia) references RegistroPago(id)
);

create table if not exists GastosMensuales(
id int not null auto_increment,
mes int not null check(mes between 1 and 12),
monto_mensual decimal(12,2) not null default 0.00,
ano int not null,
primary key (id),
unique key uniq_mes_ano (mes,ano)
);

create table if not exists GastosAnuales(
id int not null auto_increment,
monto_anual decimal(12,2) not null default 0.00,
ano int not null,
primary key(id),
unique key uniq_ano(ano)
);

create trigger insert_registro after insert on RegistroPago
for each row
begin
	if new.tipo_pago = "tarjeta" then
		insert into PagosConTarjeta(id_referencia,descripcion,monto,tipo,fecha_pago)
		values(new.id,new.descripcion,new.tipo_pago,new.fecha_pago);
	elseif new.tipo_pago = "efectivo" then
		insert into PagosConEfectivo(id_referencia,descripcion,monto,tipo,fecha_pago)
		values(new.id,new.descripcion,new.tipo_pago,new.fecha_pago);
	end if;
end..

create trigger insert_gasto_mensual after insert on RegistroPago
for each row
begin
	insert into GastosMensuales(mes, ano, monto_mensual)
	values(month(new.fecha_pago), year(new.fecha_pago),new.monto)
	on duplicate key update monto_mensual = monto_mensual + new.monto;
end..

create trigger insert_gasto_anual after insert on RegistroPago
for each row
begin
	insert into GastosAnuales(ano,monto_anual)
	values(year(new.fecha_pago),new.monto)
	on duplicate key update monto_anual = monto_anual + new.monto;
end ..
