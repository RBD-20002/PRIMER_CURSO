/*a*/
insert into hotel values
("Hotel Rey","Avda. Principal",5,"35700","A Coruña"),
("Hotel Pazo Verde","Plaza de España",18,"35700","A Coruña"),
("Hotel Sta. María","Progreso",114,"35700","A Coruña");

/*b*/
insert into participante values
("12345678Z","Antonio Rodríguez Pérez","Hotel Rey"),
("11111111B","María García López","Hotel Rey"),
("22222222C","Marcos Veiga López","Hotel Pazo Verde"),
("33333333B","María Estévez Ramos","Hotel Pazo Verde"),
("44444444E","Javier Rodríguez Cabana","Hotel Sta. María"),
("55555555T","Lucía Graña Gómez","Hotel Sta. María"),
("66666666N","Borja Valle Estévez","Hotel Rey");

/*c*/
insert into arbitro (DNI,salario)
select DNI,500 from participante where nombreHotel = "Hotel Sta. María";

/*d*/
insert into jugador (DNI,nacimiento)
select DNI,date("1900/01/01") from participante where nombreHotel != "Hotel Sta. María";

/*e*/
update jugador set nacimiento = "1985/06/15" where dni = "11111111Z";
update jugador set nacimiento = "1980/09/23" where dni = "11111111B";
update jugador set nacimiento = "1979/10/03" where dni = "22222222C";
update jugador set nacimiento = "1986/12/17" where dni = "33333333B";
update jugador set nacimiento = "1977/01/30" where dni = "66666666N";

/*f*/
update arbitro set salario = 450 where dni = "44444444E";
update arbitro set salario = 600 where dni = "55555555T";

/*g*/
insert into hotel (nombreHotel) values ("Vigo 1800");
/*No me deja agregar un hotel solo con el nombre porque calle 
y localidad son datos que no se pueden dejar vacio*/

/*h*/
insert into partida_jugador values (01,"66666666N","B");
/*No deja agregar los datos porque hay foraneas en la tabla*/

/*i*/
insert into partida values (01,20.74,"44444444E");
insert into partida_jugador values (01,"11111111B","B");
insert into partida_jugador values (01,"22222222C","N");

/*j*/
delete from participante;
/*No me deja borrar los datos porque hay claves foraneas*/

/*k*/



/*i*/
update arbitro set salario = salario + 35;