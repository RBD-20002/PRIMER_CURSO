create database if not exists restaurante character set latin1;

use restaurante;

create table if not exists empleados(
dni varchar(9) not null,
nombre char(20) not null,
apellido char(20) not null,
direccion varchar(15) not null,
ciudad char(10) not null,
telefono char(9) not null,
cp char(5) not null,
fechaAlta date not null,
categoria char(15) not null,
salario real not null,
primary key (dni)
);

create table if not exists cocineros(
dni_cocinero varchar(9) not null,
puesto char(10) not null,
especialidad char(20) not null,
primary key (dni_cocinero),
foreign key (dni_cocinero) references empleados(dni)
on delete cascade
on update cascade
);

create table if not exists administracion(
dni_administrador varchar(9) not null,
cargo char(10) not null,
primary key (dni_administrador),
foreign key (dni_administrador) references empleados(dni)
on delete cascade
on update cascade
);

create table if not exists camareros(
dni_camarero varchar(9) not null,
turno enum("mañana","tarde","noche") not null,
años int not null,
dni_encargado varchar(9) not null,
primary key (dni_camarero),
foreign key (dni_camarero) references empleados(dni)
on delete cascade
on update cascade,
foreign key (dni_encargado) references camareros(dni_camarero)
on delete cascade
on update cascade
);

create table if not exists comedores(
codigoC int not null,
nombre char(10) not null,
capacidad char(15) not null,
Nmesas int not null,
localizacion char(15) not null,
primary key (codigoC)
);

create table if not exists mesas(
codigoM int not null,
codigoC int not null,
Nasientos int default 4 not null,
dni_camarero varchar(9) not null,
primary key (codigoM,codigoC),
foreign key (codigoC) references comedores(codigoC)
on delete cascade
on update cascade,
foreign key (dni_camarero) references camareros(dni_camarero)
on delete cascade
on update cascade
);

create table if not exists reservas(
Nreserva int not null,
FHreserva date not null,
nombre char(20) not null,
FHreservada date not null,
comida set("comida","cena") not null,
Npersonas int not null,
varios char(40) not null,
primary key (Nreserva)
);

create table if not exists hacen(
codigoM int not null,
codigoC int not null,
Nreserva int not null,
NasientosR int not null,
primary key (codigoM,codigoC,Nreserva),
foreign key (codigoM,codigoC) references mesas(codigoM,codigoC)
on delete cascade
on update cascade,
foreign key (Nreserva) references reservas(Nreserva)
on delete cascade
on update cascade
);

create table if not exists facturas(
Nfactura int not null,
fechaF date not null,
codigoM int not null,
codigoC int not null,
primary key (Nfactura,codigoM,codigoC),
foreign key (codigoM,codigoC) references mesas(codigoM,codigoC)
on delete cascade
on update cascade
);

create table if not exists platos(
codigoPl int not null,
nombre char(20) not null,
descripcion char(30) not null,
tipo char(20) not null,
precio double not null,
primary key (codigoPl)
);

create table if not exists incluyen(
Nfactura int not null,
codigoPl int not null,
unidades int not null,
primary key (Nfactura,codigoPl),
foreign key (codigoPl) references platos(codigoPl)
on delete cascade
on update cascade
);

create table if not exists proveedores(
codigoPro int not null,
direccion char(20) not null,
cp char(5) not null,
telefono char(9) not null,
fax char(9) not null,
contacto char(9) not null,
primary key (codigoPro)
);

create table if not exists productos(
codigoPr int not null,
descripcion char(40) not null,
stock int check(stock between 0 and 999),
unidadBase int not null,
precioU int not null,
categoria char(30) not null,
codigoPro int not null,
primary key (codigoPr),
foreign key (codigoPro) references proveedores(codigoPro)
on delete cascade
on update cascade
);

create table if not exists contienen(
codigoPl int not null,
codigoPr int not null,
cantidad int not null,
primary key (codigoPl,codigoPr),
foreign key (codigoPl) references platos(codigoPl)
on delete cascade
on update cascade,
foreign key (codigoPr) references productos(codigoPr)
on delete cascade
on update cascade
);

create unique index idx_apellido_nombre
on empleados(apellido,nombre);

alter table empleados
modify column fechaAlta date check (fechaAlta >= "2010-7-15");

alter table camareros
modify column turno set in ("mañana","tarde","Noche");

alter table proveedores
add column apellido char(20)
after codigoPro,
add column nombre char(20)
after apellido;

alter table mesas 
modify column Nasientos int
default 5;

create index idx_categoria
on productos(categoria);

drop index idx_categoria;