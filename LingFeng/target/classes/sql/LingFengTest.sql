select * from user 
desc user

insert into user(login_name,pwd ,privilege,lister_id) values('aaa',123,1,1);
insert into user(login_name,pwd ,privilege,lister_id) values('bbb',123,2,2);
insert into user(login_name,pwd ,privilege,lister_id) values('ccc',123,3,2);
insert into user(login_name,pwd ,privilege,lister_id) values('ddd',123,5,2);

select * from employee

insert into employee values(2,1,"朱矛宇",1);
insert into employee values(null,1,"朱矛宇",1);
insert into employee values(1,1,"朱矛宇1",1);
insert into employee values(null,3,"哈哈哈",1);
insert into employee values(null,4,"呜呜乌",1);

show tables

select * from card

desc employee

desc employee_info
select * from employee left join employee_info on employee.employee_id=employee_info.employee_id; 

select e.employee_id,job_number,name,state,gender,age,id_card_no,e.department_id,department_name,post,
phone,phone_other,native_place,address,politics_status,remark
from employee left join employee_info as e
on employee.employee_id=e.employee_id 
left join department 
on e.department_id= department.department_id;

desc employee_info

insert into employee_info( employee_id , gender ,  age , id_card_no , department_id  , post , phone , phone_other , native_place , address          
,  politics_status , remark ) value(1,1,11,1,1,60066,12345678901,18555555555,'柳市','柳秦路','群众','备注');

desc department;
select * from department

insert into department(department_id ,department_name) value(null,'临时指挥部');


select employee.employee_id,job_number,name,state,gender,age,id_card_no,e.department_id,department_name,post,phone,phone_other,native_place,address,politics_status,remark from employee left join employee_info as e on employee.employee_id=e.employee_id  left join department  on e.department_id= department.department_id order by e.employee_id desc limit 0,2
		

select count(*) from (select * from employee order by employee_id ASC) t
