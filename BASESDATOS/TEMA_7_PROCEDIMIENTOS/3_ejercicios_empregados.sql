/*1*/
create procedure proce1()
begin
	select emp_num as numero ,emp_nome as nombre,emp_posto as puesto,emp_depnum as IdDep from emp;
end //

/*2*/
call proce1//

/*3*/
create procedure proce2(in numEmp decimal(4,0))
begin
	select emp_nome as nombre, emp_posto as puesto from emp where emp_num = numEmp;
end//

/*4*/
call proce2(7833)//

/*5*/
create procedure proce3(in numeroEmpleado int)
begin
	declare empleadoExiste int;
	select count(*) into empleadoExiste from emp where emp_num = numeroEmpleado;
	if empleadoExiste = 0 then
	select "El empleado no existe";
	else
	select emp_nome as nombre, emp_posto as puesto from emp where emp_num = numeroEmpleado;
	end if;
end//

/*6*/
call proce3(7728)//

/*7*/
create procedure proce4(in numDep int)
begin
	declare contador int;
	select count(*) into contador from emp where emp_depnum = numDep;
	if contador = 0 then
	select "Ese departamente no existe";
	else select emp_num as codigo, emp_nome as empleados from emp where emp_depnum = numDep;
	end if;
end//

/*8*/
call proce4("Vendas");
call proce4("Persoal");

/*9*/
create procedure proce5(nombreDepartamento char(20))
begin
	declare nombreExiste int;
	select count(*) into nombreExiste from dep where dep_nome = nombreDepartamento;

	if nombreExiste = 0 
	then 
	select concat("No existe el departamento ", nombreDepartamento);
	else 
		if (select count(*) from emp join dep on emp_depnum = dep_num where dep_nome = nombreDepartamento) = 0 
		then select concat("No departamento de ", nombreDepartamento, " non hai empregados");
		else 
		select emp_nome from emp join dep on emp_depnum = dep_num where dep_nome = nombreDepartamento;
	end if;
	end if;
end //

/*10*/
call proce5("Vendas");
call proce5("Finanzas");
call proce5("Prueba");


