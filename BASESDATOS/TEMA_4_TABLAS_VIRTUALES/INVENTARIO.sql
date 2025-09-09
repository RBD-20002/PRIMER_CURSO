/*5*/

create database if not exists inventario character set latin1;

use inventario;

create table if not exists categoria(
cat_id int not null auto_increment,
cat_nombre char(40) not null,
primary key (cat_id)
);

create table if not exists situacion(
sit_id int not null auto_increment,
sit_nombre char(40) not null,
primary key (sit_id)
);

create table if not exists componente(
com_idpai int not null,
com_idfillo int not null,
primary key (com_idpai,com_idfillo)
);

create table if not exists material(
mat_id int not null auto_increment,
mat_descripcion char(40) not null,
mat_fecha_alta date not null,
mat_observaciones text null,
mat_idcategoria int null,
mat_idsituacion int null,
primary key (mat_id)
);

create table if not exists averia(
ave_id int not null auto_increment,
ave_id_material int not null,
ave_fecha_salida date not null,
ave_descripcion text not null,
ave_fecha_entrada date null,
ave_descripcion_rep text null,
primary key (ave_id)
);

create table if not exists baja(
baja_id int not null auto_increment,
baja_id_material int not null,
baja_motivo text not null,
baja_fecha date not null,
primary key (baja_id)
);

alter table material
add foreign key (mat_idcategoria) references categoria(cat_id),
add foreign key (mat_idsituacion) references situacion(sit_id);

alter table averia
add foreign key (ave_id_material) references material(mat_id)
on delete cascade
on update restrict;

alter table baja
add foreign key (baja_id_material) references material(mat_id)
on delete cascade
on update restrict;

create index idx_material_descripcion on material(mat_descripcion(15));

create index idx_ave_fecha_entrada on averia(ave_fecha_entrada);

create index idx_baja_fecha on baja(baja_fecha);

create unique index idx_cat_nombre on categoria(cat_nombre);

create unique index idx_sit_nombre on situacion(sit_nombre);