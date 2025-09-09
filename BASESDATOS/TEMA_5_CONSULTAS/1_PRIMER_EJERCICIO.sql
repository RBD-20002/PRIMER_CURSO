/*1*/
select ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from titulos;

/*2*/
select au_nome as Autores
from autores;

/*3*/
select ed_cidade as Ciudades
from editoriais;

/*4*/
select distinct ed_cidade as Ciudades
from editoriais;

/*5*/
select ed_nome as Editorial, ed_nomeempresa as "Nombre de Empresa", ed_enderezo as Direccion, ed_telefono as Telefono
from editoriais
where ed_cidade = "New York";

/*6*/
select ti_titulo as Titulo, ti_materia as Materia, ti_anopub as "Año Publicacion"
from titulos
where ti_materia = "MySQL";

/*7*/
select ti_titulo as Titulo, ed_nome as Editorial
from editoriais join titulos
on ti_idedit = ed_id
and ed_nome = "Yourdon";

/*8*/
select ed_nome as Editorial, ti_materia as Materia
from titulos join editoriais
on ti_idedit = ed_id
and ti_materia = "C++";

/*9*/
select ti_titulo as Titulo, ed_nome as Editorial, ed_estado as Estado
from editoriais join titulos
on ti_idedit = ed_id
and ed_estado = "IL";

/*10*/
select ed_nome as Editorial, ed_cidade as Ciudad, ti_materia as Materia
from editoriais join titulos
on ti_idedit = ed_id
and ti_materia = "SQL"
and ed_cidade = "Berkeley";

/*12*/
select au_nome as Autores, ti_materia as Materia
from tituloautor join titulos
on ta_isbn = ti_isbn
join autores on ta_idautor = au_id
and ti_materia = "Visual Basic";

/*13*/
select au_nome as Autores, ti_materia as Materia
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and au_nome = "Bard, Dick";

/*14*/
select ti_titulo as Titulo, ti_materia as Materia
from tituloautor join titulos
on ta_isbn = ti_isbn
join autores on ta_idautor = au_id
and au_anon between 1940 and 1950;

/*15*/
select ed_nome as Editorial, ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from titulos join editoriais
on ti_idedit = ed_id
and ti_anopub > 1993;

/*16*/
select ed_nome as Editorial, ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from editoriais join titulos
on ti_idedit = ed_id
and ti_anopub = 1993;

/*17*/
select au_nome as Autor, ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and ti_anopub = 1993
and ti_materia = "SQL";

/*18*/
select ed_nome as Editorial, ed_cidade as Ciudad, ti_titulo as Titulo, ti_materia as Materia
from editoriais join titulos
on ti_idedit = ed_id
and ed_cidade = "Anchorage"
and ti_materia = "Visual Basic";

/*19*/
select ti_titulo as Titulo, ti_materia as Materia
from titulos
where ti_materia = "SQL"
or ti_materia = "Btrieve";

/*20*/
select ti_titulo as Titulo, ti_anopub as "Año Publicacion", au_nome as Autor, au_anon as "Fecha Nacimiento"
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and ti_anopub = au_anon - 48;

/*21*/
select au_nome as Autor, ti_titulo as Titulo
from tituloautor join titulos
on ta_isbn = ti_isbn
join autores on au_id = ta_idautor
and au_nome like "W%";

/*22*/
select au_nome as Autor, au_anon as "Fecha Nacimiento"
from autores
where au_nome like "%W%";

/*23*/
select au_nome as Autor
from autores
where au_nome like "%Z%" 
or au_nome like "%Y%";

/*24*/
select au_nome as Autor
from autores
where au_nome like "%C%"
or au_nome like "%K%"
or au_nome like "%Z%";

/*25*/
select au_nome as Autor
from autores
where au_nome like "%CKZ%";

/*26*/
select ti_titulo as Titulo, ed_nome as Editorial
from editoriais join titulos
on ti_idedit = ed_id
and ed_nome in ("Prentice Hall","Osborne");

/*27*/
select ti_titulo as Titulo, ti_materia as Materia
from titulos 
where ti_materia in ("Visual Basic","SQL","Prolog");

/*28*/
select ed_nome as Editorial
from editoriais
order by ed_nome;

/*29*/
select au_nome as Autores
from autores
order by au_nome desc;

/*30*/
select au_nome as Autor, ti_titulo as Titulo, ti_materia as Materia, ti_anopub as "Año Publicacion"
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and ti_anopub < 1990
order by ti_materia, au_nome;

/*31*/
select au_nome as Autor, ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and ti_anopub in (select ti_anopub from titulos where ti_titulo = "Guide to Oracle");

/*32*/
select au_nome as Autor, ti_titulo as Titulo, ti_anopub as "Año Publicacion"
from tituloautor join titulos
on ti_isbn = ta_isbn
join autores on ta_idautor = au_id
and ti_anopub in (select ti_anopub from titulos where ti_materia = "Visual Basic");