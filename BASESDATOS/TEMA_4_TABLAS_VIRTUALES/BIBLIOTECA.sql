/*4*/

create database if not exists biblioteca character set latin1;

use biblioteca;

create table if not exists libros(
lib_codigo int not null,
lib_titulo char(40) not null,
lib_ejemplares_tot int not null,
lib_ejemplares_disp int not null,
lib_codigo_materia int not null,
primary key (lib_codigo)
);

create table if not exists autores(
aut_codigo int not null,
aut_nombre char(40) not null,
aut_nacionalidad char(20) null,
aut_nacimiento date not null,
aut_fallecimiento date null,
primary key (aut_codigo)
);

create table if not exists escritos(
esc_codigo_libro int not null,
esc_codigo_autor int not null,
primary key (esc_codigo_libro,esc_codigo_autor)
);

create table if not exists materia(
mat_codigo int not null,
mat_nombre char(25) not null,
primary key (mat_codigo)
);

create table if not exists usuarios(
usu_codigo int not null,
usu_nombre char(40) not null,
usu_direccion char(40) not null,
usu_cp char(5) null,
usu_ciudad char(20) null,
usu_nif char(9) not null,
primary key (usu_codigo)
);

create table if not exists prestamos(
pre_codigo_libro int not null,
pre_codigo_usuario int not null,
pre_fecha_prestamo date not null,
pre_fecha_devolucion date null,
primary key (pre_codigo_libro,pre_codigo_usuario,pre_fecha_prestamo)
);

alter table libros
modify column lib_codigo_materia int null;

alter table libros
add foreign key (lib_codigo_materia) references materia(mat_codigo)
on delete set null
on update restrict;

alter table escritos
add foreign (esc_codigo_libro) references libros(lib_codigo)
on delete cascade
on update restrict,
add foreign key (esc_codigo_autor) references autores(aut_codigo)
on delete cascade
on update restrict;

alter table prestamos
add foreign key (pre_codigo_libro) references libro(lib_codigo),
add foreign key (pre_codigo_usuario) references usuarios(usu_codigo);