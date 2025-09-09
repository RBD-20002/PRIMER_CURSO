/*1*/ -> 40
select emp_nome as Empleado, dep_loc as Localidad
from emp join dep 
on dep_num = emp_depnum;

/*2*/ -> 2
select emp_nome as Empleado, emp_posto as Puesto, (emp_salario * 2) as "Salario por dos"
from dep join emp
on dep_num = emp_depnum
and emp_posto = "Contable";

/*3*/ -> 17
select distinct emp_posto as Puestos
from emp
where emp_posto not in ("Contable","Programador");

/*4*/ -> 10
create view Monforte as 
select emp_nome as Empleados 
from emp join dep
on dep_num = emp_depnum
and dep_loc = "Monforte"
order by emp_nome;

/*5*/ -> 9
select dep_loc as Localidad, count(emp_depnum) as "Empleado por Localidad"
from emp join dep
on dep_num = emp_depnum
group by dep_num;

/*6*/ -> 9
select e1.emp_nome as "Empleado-1" , e1.emp_salario as "Salario-1", e2.emp_nome as "Empleado-2", e2.emp_salario as "Empleado-2"
from emp as e1 join emp as e2
on (2*e1.emp_salario) = e2.emp_salario
and e1.emp_nome != e2.emp_nome; 

/*7*/ -> 6
select dep_nome as Departamento, sum(emp_salario) as Salarios
from dep join emp
on dep_num = emp_depnum
group by emp_depnum
having sum(emp_salario) > 5000;

/*8*/ -> 5
select emp_nome as Empleados, emp_dataing as "Fecha Alta"
from emp
where emp_dataing > (select emp_dataing from emp where emp_nome = "Navia");

/*9*/ -> 5
select dep_nome as Departamento, avg(emp_salario) as "Media Salarial"
from dep join emp
on dep_num = emp_depnum 
and dep_nome like "%D%"
group by emp_depnum;

/*10*/ -> 1
select emp_nome as Empleado
from emp 
order by emp_dataing desc limit 1;