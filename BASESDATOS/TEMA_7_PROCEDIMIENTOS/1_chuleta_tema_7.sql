/*0*/
delimiter //  /*<- ya no se usa el ;*/

/*1*/
create procedure listado1()
begin
	select * from emp;
end //  /*<- crea el procedimineto*/

/*2*/
show procedure status where db = "empregados"// /*<- ver los procedimientos creados*/
drop procedure if exists salario1 //  /*<- borrar un procedimiento*/

show function status where db= "empregados"// /*<- ver las funciones creadas*/
drop function if exists funcion //

/*3*/
call listado1()//  /*<- llama al procedimiento*/
select funcion(parametro 1).. /*<- llama a un funcion*/

/*4*/
create procedure salario1(in nombre char(40)) 
begin
	select emp_salario from emp where emp_nome = nombre;
end //  /*<- crear procedimiento con un parametro*/

/*5*/
create procedure salario2(in nombre char(20), out salario decimal(8,2)) 
begin 
	select emp_salario from emp where emp_nome = nombre into salario; 
end//  /*<- crear procedimiento con una salida*/

/*6*/
create procedure doble(inout dato int)
begin
	set dato=dato*2;
end //  /*<- procedimiento declarado con entrada y donde meter la salida*/

set @dato = 3//  /*<- declaro primero la variable para despues poder invocarla con CALL*/
call doble(@dato)//