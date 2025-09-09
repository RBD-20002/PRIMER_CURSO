
/*1*/
select *
from emp
where emp_posto = "ADMINISTRATIVO";

/*2*/
select *
from dep
order by dep_nome desc;

/*3*/
select emp_nome as Empleado, emp_posto as Puesto, emp_salario as Salario
from emp
order by emp_salario;

/*4*/
select emp_nome as Empleado, emp_salario as Salario, emp_comm as Comisiones
from emp join dep
on dep_num = emp_depnum
and dep_nome = "VENDAS";

/*5*/
select emp_nome as Empleado, emp_comm as Comisiones
from emp
where emp_comm is not null;

/*6*/
select emp_nome as Empleado, emp_salario + 1000
from emp
where emp_depnum = 30;

/*7*/
select emp_nome as Empleado, emp_salario as Salario, emp_comm as Comision
from emp
where emp_comm > (emp_salario / 2);

/*8*/
select emp_nome as Empleado, emp_salario as Salario, ifnull(emp_comm,0) as Comision, emp_salario + ifnull(emp_comm,0) as "Salario Total"
from emp
order by emp_num;

/*9*/
select *
from emp
where emp_salario > 1000
and emp_xefe = 7698;

/*10*/
select *
from emp
where emp_salario < 1000
and emp_xefe != 7698;

/*11*/
select emp_nome as Empleado, (emp_comm / (emp_comm + emp_salario)) * 100 as "Porcentaje diferencial"
from emp
where emp_comm is not null
order by emp_nome;

/*12*/
select *
from emp
where emp_xefe is null;

/*13*/
select *
from dep
where dep_nome not in ("VENDAS", "I+D")
order by dep_loc;

/*14*/
select emp_nome as Empleado, emp_salario as Salario, ifnull(emp_comm,0) as Comision
from emp
where emp_salario between (select avg(emp_salario) from emp) and (select max(emp_salario) from emp);

/*15*/
select *
from emp 
where emp_num in (7844, 7900, 7521, 7782, 7934, 7678, 7369);

/*16*/
select *
from emp join dep
on dep_num = emp_depnum
order by dep_nome, emp_num desc;

/*17*/
select max(emp_salario) as "Salario mas alto", min(emp_salario) as "Salario mas bajo", max(emp_salario) - min(emp_salario) as "Diferencia de ambos salarios"
from emp;

/*18*/
select emp_nome
from emp
where emp_salario in ((select max(emp_salario) from emp), (select min(emp_salario) from emp));

/*19*/
select emp_nome as Empleado, emp_posto as Puesto, emp_salario as Salario
from emp
where emp_salario > (select emp_salario from emp where emp_nome = "FOXO")
or emp_nome = "FOXO";

/*20*/
select *
from emp
order by emp_num desc
limit 1;

/*21*/
select dep_num as "Numero Departamento", dep_nome as "Nombre Departamento", round(avg(emp_salario),2) as "Media Salarial"
from dep join emp
on dep_num = emp_depnum
group by dep_nome
having min(emp_salario) > 900;

/*22*/
select *
from emp
where emp_salario >= (select avg(emp_salario) from emp);

/*23*/
select count(distinct emp_posto)
from emp
where emp_depnum = 20;

/*24*/
select count(emp_nome)
from emp join dep
on dep_num = emp_depnum
and dep_num = 30;

/*25*/
select dep_nome as "Nombre Departamento", count(emp_nome) as "Cantidad Empleados"
from dep join emp
on emp_depnum = dep_num
group by emp_depnum
having count(emp_nome) >= 3;

/*26*/
select emp_nome
from emp
where emp_num in (select distinct emp_xefe from emp);

/*27*/
select emp_posto as Puesto, count(emp_nome) as Cantidad
from emp
group by emp_posto order by emp_posto;

/*28*/
select dep_nome as "Nombre Departamento", sum(emp_salario) as "Suma de Salarios"
from emp join dep
on dep_num = emp_depnum
group by emp_depnum;

/*29*/
select emp_nome
from emp
where emp_num not in (select ifnull(emp_xefe,1) from emp);

/*30*/
select e1.emp_nome , e2.emp_nome, (e2.emp_salario - e1.emp_salario)
from emp as e1 join emp as e2
on e1.emp_xefe = e2.emp_num;

/*31*/
select e1.emp_nome, e1.emp_depnum , e2.emp_nome, e2.emp_depnum
from emp as e1 join emp as e2
on e1.emp_depnum = e2.emp_depnum
and e1.emp_num < e2.emp_num;

/*32*/
select e1.emp_nome, e1.emp_salario, e2.emp_nome, e2.emp_salario, e2.emp_xefe
from emp as e1 join emp as e2
on e1.emp_xefe = e2.emp_xefe
and e1.emp_salario > e2.emp_salario;

/*33*/
select emp_nome as Empleado
from emp
where emp_xefe in (select emp_num from emp where emp_nome = "Saco");

/*34*/
select emp_nome as Empleado
from emp join dep
on emp_depnum = dep_num
where emp_xefe in (select emp_num from emp where emp_nome in( "Saco","Rei"));

/*35*/
select e1.emp_nome, e1.emp_salario, e1.emp_depnum, e2.emp_nome, e2.emp_salario, e2.emp_depnum
from emp as e1 join emp as e2
on e1.emp_salario = e2.emp_salario
and e1.emp_depnum <> e2.emp_depnum;

/*36*/
select e1.emp_nome, e1.emp_posto, e2.emp_nome, e2.emp_posto
from emp as e1 join emp as e2
on e1.emp_posto = e2.emp_posto
and e1.emp_num < e2.emp_num;

/*37*/
select e1.emp_num, e1.emp_nome, e2.emp_nome as JEFE
from emp as e1 join emp as e2
on e1.emp_xefe = e2.emp_num
and e1.emp_num != e2.emp_xefe;

/*38*/


/*39*/


/*40*/