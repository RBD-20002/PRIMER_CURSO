/*1*/
select *
from cliente;

/*2*/
select cl_nome as Cliente, cl_telefono as Telefono
from cliente;

/*3*/
select *
from cliente
order by cl_cidade,cl_nome;

/*4*/
select *
from cliente
order by cl_cidade,cl_nome desc;

/*5*/
select *
from cliente
where cl_cidade = "Lugo"
order by cl_codpostal;

/*6*/
select *
from cliente
where cl_codpostal is null;

/*7*/
select ar_descricion as Articulo, ar_prezo as Precio
from artigo
where ar_prezo > 150
and ar_stock < 100;

/*8*/
select pe_numped as "Numero Pedido",cl_nome as Cliente, pe_dataped as "Fecha Pedido"
from pedido join cliente
on pe_idcliente = cl_id
and pe_dataped > "2001-01-01";

/*9*/
select ar_descricion as Articulo, ar_prezo as Precio
from artigo
where ar_prezo between 100 and 200;

/*10*/
select cl_nome as Cliente, pe_numped as "Numero Pedido"
from pedido join cliente
on pe_idcliente = cl_id
and year(pe_dataped) = 2001;

/*11*/
select ar_descricion as Articulo, ar_prezo as Precio
from artigo
where ar_prezo in (10,99,1000);

/*12*/
select cl_nome as Cliente
from cliente
where cl_nome like "%E";

/*13*/
select ar_descricion as Articulo
from artigo
where ar_descricion like "%PLUMA%";

/*14*/
select ar_descricion as Articulo
from artigo
where cl_nome like "__LI%";

/*15*/
select cl_nome as Cliente, cl_cidade as Ciudad
from pedido join cliente
on pe_idcliente = cl_id
and cl_cidade = "LUGO"
and pe_dataped between "2001-01-01" and curdate();

/*16*/
select ar_descricion as Articulo, ar_stockmax - (ar_stockpend + ar_stock)
from artigo
where ar_stockmin > (ar_stock + ar_stockpend);

/*17*/
select ar_descricion as Articulo, pe_dataped as "Fecha Pedido"
from linea_ped join artigo
on lp_idartigo = ar_id
join pedido on pe_numped = lp_numped
and pe_dataped not between "2002-01-01" and curdate();

/*18*/
select a1.ar_descricion as "Articulo 1", a1.ar_stock as Stock, a2.ar_descricion as "Articulo 2", a2.ar_stock as Stock
from artigo as a1 join artigo as a2
on a1.ar_descricion > a2.ar_descricion
and a1.ar_stock = 5 * (a2.ar_stock);

/*19*/
select c1.cl_nome as Cliente, c1.cl_cidade as Ciudad, c2.cl_nome as Cliente, c2.cl_cidade as Ciudad
from cliente as c1 join cliente as c2
on c1.cl_nome > c2.cl_nome
and c1.cl_cidade = c2.cl_cidade;

/*20*/
select c1.cl_nome as Cliente, p1.pe_dataped as "Fecha Pedido", c2.cl_nome as Cliente, p2.pe_dataped as "Fecha Pedido"
from pedido as p1 join pedido as p2
on p1.pe_dataped = p2.pe_dataped
and p1.pe_numped < p2.pe_numped
join cliente as c1
on c1.cl_id = p1.pe_idcliente
join cliente as c2
on c2.cl_id = p2.pe_idcliente;

/*21*/


/*22*/
select max(ar_prezo) as "Precio Maximo", min(ar_prezo) as "Precio Minimo", avg(ar_prezo) as "Precio Media"
from artigo;

/*23*/
select count(ar_descricion)
from artigo
where ar_stock > 1;

/*24*/
select cl_cidade as Ciudad, count(cl_cidade)
from cliente
group by cl_cidade;

/*25*/
select pe_dataped as "Fecha Pedido", count(pe_dataped)
from pedido
group by pe_dataped;

/*26*/
select pe_idcliente as "Numero Cliente", count(pe_dataped)
from pedido
group by pe_idcliente;

/*27*/
select lp_numped as "Numero Pedido", count(lp_numlinea)
from linea_ped
group by lp_numped;

/*28*/
select lp_numped, lp_numlinea, lp_canped, ar_prezo, lp_canped*ar_prezo
from linea_ped join artigo
on ar_id = lp_idartigo;

/*29*/
select lp_numped as "Numero Pedido", sum(lp_canped)
from linea_ped
group by lp_numped;

/*30*/
select lp_numped as "Numero Pedido", round(sum(lp_canped * ar_prezo),2)
from linea_ped join artigo
on lp_idartigo = ar_id
group by lp_numped
having count(lp_numlinea) > 2;

/*31*/
select distinct count(cl_cidade)
from cliente;

/*32*/
select *
from artigo as a1
where a1.ar_stock >=
(select coalesce(sum(lp1.lp_canped),0) from linea_ped as lp1 where lp1.lp_idartigo = a1.ar_id);

/*33*/
select lp1.lp_idartigo, a1.ar_descricion, sum(lp1.lp_canped)
from linea_ped as lp1 join pedido as p1
on lp1.lp_numped = p1.pe_numped
join artigo as a1
on lp1.lp_idartigo = a1.ar_id
and p1.pe_enviado = false
group by lp1.lp_idartigo, a1.ar_descricion;

/*34*/
select lp1.lp_idartigo, lp1.lp_canped, pe1.pe_numped, pe1.pe_dataped, pe2.pe_numped, pe2.pe_dataped
from linea_ped as lp1 join linea_ped as lp2
on lp1.lp_idartigo = lp2.lp_idartigo
and lp1.lp_canped = lp2.lp_canped
and lp1.lp_numped < lp2.lp_numped
join pedido as pe1 on lp1.lp_numped = pe1.pe_numped
join pedido as pe2 on lp2.lp_numped = pe2.pe_numped;

/*35*/
select p.pe_numped, day(p.pe_dataped) as Dia, month(p.pe_dataped) as Mes, year(p.pe_dataped) as Año
from pedido as p;select lp1.lp_idartigo, lp1.lp_canped, pe1.pe_numped, pe1.pe_dataped, pe2.pe_numped, pe2.pe_dataped
from linea_ped as lp1 join linea_ped as lp2
on lp1.lp_idartigo = lp2.lp_idartigo
and lp1.lp_canped = lp2.lp_canped
and lp1.lp_numped < lp2.lp_numped
join pedido as pe1 on lp1.lp_numped = pe1.pe_numped
join pedido as pe2 on lp2.lp_numped = pe2.pe_numped;