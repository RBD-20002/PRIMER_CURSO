/*EJERCICIO-1*/

delimiter //

create procedure SumaDeNumero(inout valor int)
begin
	set valor = valor + 1;
end //
delimiter ;

set @valor = 5;
call SumaDeNumero(@valor)
select @valor;

/*EJERCICIO-2*/

delimiter //
create procedure MostrarDia(numero int)
begin
	case numero
		when 1 then select "Lunes" as Dia;
		when 2 then select "Martes" as Dia;
		when 3 then select "Miercoles" as Dia;
		when 4 then select "Jueves" as Dia;
		when 5 then select "Viernes" as Dia;
		when 6 then select "Sabado" as Dia;
		when 7 then select "Domingo" as Dia;
		else select "Ese numero no corresponde a ningun dia" as mensaje;
	end case;
end //
delimiter ;