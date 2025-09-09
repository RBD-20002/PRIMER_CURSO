delimiter..

/*1*/
create function dias(numero int)
returns varchar(50)
deterministic
	begin
		declare dia varchar(50);

		case numero
			when 1 then set dia="Lunes";
			when 2 then set dia="Martes";
			when 3 then set dia="Miercoles";
			when 4 then set dia="Jueves";
			when 5 then set dia="Viernes";
			when 6 then set dia="Sabado";
			when 7 then set dia="Domingo";
			else set dia="Numero invalido";
		end case;
	return dia;
end..

/*2*/
create function factorial(numero int)
returns int
deterministic
	begin
		declare resultado int;
		declare i int default 1;
		
		while i < n do
			set resultado = resultado * i;
			set i = i + 1;
		end while;
	return resultado;
end..

/*3*/
create function hipotenusa(lado1 float, lado2 float)
returns float
deterministic
	begin
		declare resultado float;
		set resultado = sqrt(pow(lado1,2) + pow(lado2,2));
	return resultado;
end..

/*4*/
create function mayor(num1 int, num2 int, num3 int)
returns int
deterministic
	begin
		declare mayor float;
		set mayor = num1;

		if(num2>mayor) then 
			set mayor=num2;
		end if;
		if(num3>mayor) then
			set mayor=num3;
		end if;
	return mayor;
end..

/*5*/
create function sumaNumeros(numero int)
returns int
deterministic
	begin
		declare resultado int default 0;
		declare i int default 1;
		while i<numero do
			set resultado = resultado + i;
			set i = i + 1;
		end while;
	return resultado + numero;
end..

/*6*/

/*7*/
create function obtenerFecha(tipo char(20))
returns int
deterministic
begin
	declare resultado int;
	case upper(tipo)
		when "A" then set resultado = year(now());
		when "M" then set resultado = month(now());
		when "D" then set resultado = day(now());
		when "H" then set resultado = hour(now());
		when "N" then set resultado = minute(now());
		when "S" then set resultado = second(now());
		else set resultado = null;
	end case;
	return resultado;
end..