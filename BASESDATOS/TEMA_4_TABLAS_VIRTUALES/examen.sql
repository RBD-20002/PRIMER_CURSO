create database if not exists examen character set UTF8;
use database examen;
create table if not exists proveedor (
pro_id int auto_increment primary key,
pro_cif char(9) not null,
pro_nombre char(50) not null,
pro_direccion char(50) not null,
pro_cp char(5) not null,
pro_cidade char(20) not null,
pro_telefono char(9) not null,
pro_fax char(9),
pro_email char(50),
pro_nconta char(20)
)engine = InnoDB, auto_increment = 5;
create table if not exists lineas_pedido (
lpe_idpedido int,
lpe_nlinea int,
lpe_art_referencia int not null,
lpe_unidades int not null,
lpe_precioud numeric(8,2) not null,
primary key (lpe_idpedido, lpe_nlinea)
)engine = InnoDB;
create table if not exists pedido (
ped_id int auto_increment primary key,
ped_idproveedor int not null,
ped_fecha_pedido date not null,
ped_fecha_entrega date,
ped_total_importe numeric(8,2) not null
)engine = InnoDB;
create table if not exists articulo (
art_referencia int primary key,
art_nombre char(50) not null,
art_pvp numeric(8,2) not null,
art_precio_compra numeric(8,2) not null,
art_stock int default 0 not null,
art_categoria char(4)
)engine = InnoDB;
create table if not exists categoria (
cat_codigo char(4) primary key,
cat_nombre char(50) not null
) engine = InnoDB;
alter table articulo add foreign key (art_categoria) references categoria(cat_codigo)
on delete set null
on update cascade;
alter table pedido add foreign key (ped_idproveedor) references proveedor(pro_id)
on delete restrict
on update restrict;
alter table lineas_pedido add foreign key (lpe_idpedido) references pedido(ped_id)
on delete cascade
on update cascade;
alter table lineas_pedido add foreign key (lpe_art_referencia) references articulo(art_referencia)
on delete restrict
on update restrict;
alter table pedido add column ped_estado char(2) not null after ped_fecha_entrega;
create unique index i_art on articulo(art_nombre);
show create table articulo\G;
show index from articulo;
alter table lineas_pedido drop constraint lineas_pedido_ibfk_2;
drop table articulo;
show tables;
alter table categoria drop primary key;
show create table categoria\G;
