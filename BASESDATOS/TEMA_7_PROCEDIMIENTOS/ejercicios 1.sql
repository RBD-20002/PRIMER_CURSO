delimiter ..

/*1*/
create procedure ejer1(inout numero int)
begin
	set numero = numero + 1;
end ..

/*2*/
create procedure ejer2(numero int)
begin
	case numero
		when 1 then select "Lunes" as DIA;
		when 2 then select "Martes" as DIA;
		when 3 then select "Miercoles" as DIA;
		when 4 then select "Jueves" as DIA;
		when 5 then select "Viernes" as DIA;
		when 6 then select "Sabado" as DIA;
		when 7 then select "Domingo" as DIA;
		else select "NUMERO INVALIDO" as RESPUESTA;
	end case;
end..

/*3*/
create procedure ejer3(palabra varchar(20))
begin
	select upper(substring(palabra,1,3)) as resultado;
end..

/*4*/
create procedure ejer4(pb1 varchar(20), pb2 varchar(20))
begin
	select upper(concat(pb1,pb2)) as resultado;
end..

/*5*/
create function ejer5(ld1 float, ld2 float)
returns float
deterministic
begin
	declare resultado float;
	set resultado = sqrt(pow(ld1,2)+pow(ld2,2));
	return resultado;
end..

/*6*/


/*7*/
create function ejer7(numero int)
returns int
deterministic
begin
	if numero % 2 = 0 then
		return 1;
	else
		return 0;
	end if;
end..

/*8*/
create function ejer8(num1 int, num2 int, num3 int)
returns int
deterministic
begin
	declare mayor int;
	set mayor = num1;

	if(num2 > mayor) then
		set mayor = num2;
	end if;

	if(num3 > mayor) then
		set mayor = num3;
	end if;
	
	return mayor;
end..

/*9*/
create function ejer9(resultado varchar(7))
returns int
deterministic
begin
	declare equipo1 int;
	declare equipo2 int;

	set equipo1 = substring_index(resultado,"-",1);
	set equipo2 = substring_index(resultado,"-",-1);

	if(equipo1 > equipo2) then
		return 0;
	else return 1;
	end if;

end..

/*10*/
create procedure ejer10(palabra varchar(50))
begin
	declare reversa varchar(50);
	set reversa = reverse(palabra);

	if(reversa = palabra) then
		select "La palabra es un palindromo" as respuesta;
	else select "La palabra no es un palindromo" as respuesta;
	end if;
end..

/*12*/
create function ejer12(fecha date, cantidad double(10,2), dniEntrada int, codigoCuenta int)
returns int
deterministic
begin
	if fecha > curdate() then
		if (select saldo+cantidad from contas where cod_cliente = codigoCuenta)>0 then
			insert into movementos (datahora,cantidade,dni,cod_conta) values (fecha,cantidad,dniEntrada,codigoCuenta);
			update contas set saldo = saldo + cantidad where cod_conta = codigoCuenta;
			return 1;
		end if;
	else return 0;
	end if;
end..

/*13*/
create procedure ejer13(numero int)
begin
	declare resultado int default 0;
	declare i int default 1;

	while i <= numero do
		set resultado = resultado + i;
		set i = i + 1;
	end while;
	select resultado;
end..

/*14*/
create procedure ejer14(numero int)
begin
	declare resultado float default 0;
	declare i int default 1;

	while i <= numero do
		set resultado = resultado + (1/i);
		set i = i + 1;
	end while;
	select resultado;
end..

/*15*/
create function ejer15(numero int)
returns int
deterministic
begin
	declare contador int default 0;
	declare i int default 1;

	while i <= numero do
		if numero % i = 0 then
			set contador = contador + 1;
		end if;
		set i = i + 1;
	end while;

	if contador = 2 then return 1;
	else return 0;
	end if;
end..

/*18*/
create procedure ejer18(n int)
begin
	declare i int default 1;
	declare cantidad float;
	declare random_dni int;
	declare random_cod_conta int;
	declare max_dni int;
	declare max_cod_contra int;
	
	select max(dni) into max_dni from movementos;
	select max(cod_conta) into max_cod_contra from movementos;

	while i <= n do
		set random_dni = floor(1 + rad()*max_dni);
		set cantidad = floor(rand()*1000)+1;
		set random_cod_conta = floor(1 + rad()*max_cod_contra);
		insert into movementos (datahora,cantidade,dni,cod_conta) values (curdate(),cantidad,random_dni,random_cod_conta);
		set i = i + 1;
	end while;
end..

/*19*/
create procedure ejer19(autor varchar(20))
begin
	declare contador int default 0;
	select count(publicacion)