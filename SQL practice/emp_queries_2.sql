-- Get all employees with a salary above 70,000.
select * from employee e 
where e.salary > 70000;

-- List all employees in the IT department.
select e.emp_name from employee e 
where e.department_id = (select d.dept_id from department d where d.dept_name = 'IT');

select e.emp_name from department d
join employee e
on d.dept_id  = e.department_id
where d.dept_name = 'IT';

-- Get the total number of employees in each department
select e.department_id, count(e.department_id) as no_of_employess from employee e
group by e.department_id;

select d.dept_name, count(e.department_id) from department d
join employee e on d.dept_id = e.department_id
group by d.dept_name;

select d.dept_name, count(e.department_id) from department d
left join employee e on d.dept_id = e.department_id
group by d.dept_name;

-- Find employees who joined after 2020.

select * from employee e 
where e.joining_date > 2020;

-- Sort employees by salary in descending order.

select * from employee e
order by e.salary desc;

-- Get the highest salary in each department.
select d.dept_name, max(e.salary) as max_salary from department d
left join employee e
on d.dept_id = e.department_id
group by d.dept_name;

select d.dept_name, coalesce(max(e.salary),0) as max_salary from department d
left join employee e
on d.dept_id = e.department_id
group by d.dept_name;

-- Find all employees working on the 'Website Redesign' project.
select ep.emp_id, p.project_name from project p
join employee_project ep
on p.project_id = ep.project_id
where p.project_name = 'Website Redesign';

select e.emp_name, p.project_name from project p
join employee_project ep
on p.project_id = ep.project_id
join employee e
on e.emp_id = ep.emp_id
where p.project_name = 'Website Redesign';

-- Show departments with more than 2 employees.
select e.department_id, count(*) from employee e
group by department_id
having count(*) > 2;

select d.dept_name, count(*) as emp_count from department d
join employee e on d.dept_id = e.department_id
group by e.department_id
having count(*) > 2;

-- Find employees who have had a salary change
select distinct(e.emp_name) from employee e
join salary_history sh
on e.emp_id = sh.emp_id;

-- Get average salary by department.
select d.dept_name, avg(e.salary) as avg_salary from department d
join employee e
on d.dept_id = e.department_id
group by department_id;   

-- Find employees earning more than the average salary.
select e.emp_name, e.salary from employee e
where salary > (select avg(salary) as avg_salary from employee e);

select avg(salary) as avg_salary from employee e;

-- Find the second highest salary.
select * from employee e
order by e.salary desc
limit 1 offset 1;

-- List employees along with their project roles (include those not assigned to a project)
select e.emp_name, p.project_name, ep.role from employee e
left join employee_project ep
join project p on ep.project_id = p.project_id
on e.emp_id = ep.emp_id;

-- Find employees whose salaries have increased.
select e.emp_name from employee e
join salary_history sh 
on e.emp_id = sh.emp_id
group by e.emp_name
having count(*) > 1;

-- Show top 3 highest-paid employees.
select * from employee e 
order by salary desc
limit 3;

-- Find employees whose names start with 'A'.
select * from employee e where e.emp_name like '%N%';

-- Get employees who are not assigned to any department.

-- Get the highest salary in each department.
select d.dept_name, avg(e.salary) as avg_salary from department d
left join employee e on e.department_id = d.dept_id
group by dept_name;

-- Find all employees working on the 'Website Redesign' project.
select e.emp_name, p.project_name from employee_project ep
join employee e on ep.emp_id = e.emp_id
join project p on p.project_id = ep.project_id
where p.project_name = 'Website Redesign';

-- Show departments with more than 2 employees.
select d.dept_name, count(*) from department d
join employee e
on d.dept_id = e.department_id
group by e.department_id
having count(*) > 2;

-- Find employees who have had a salary change.

select e.emp_name, count(*) from salary_history sh
join employee e on sh.emp_id = e.emp_id
group by sh.emp_id
having count(*) > 1;

-- Find employees working on multiple projects.
select e.emp_name, count(*) from employee_project em
join employee e
on em.emp_id = e.emp_id
group by em.emp_id
having count(*) > 1;

-- List employees who do not belong to any project.

select e.emp_name, ep.project_id from employee e
left join employee_project ep on e.emp_id = ep.emp_id
where ep.project_id is NULL;

-- Find projects that have more than 2 employees assigned.
select p.project_name, count(ep.project_id) from employee_project ep
join project p
on ep.project_id = p.project_id
group by ep.project_id
having count(ep.project_id) > 2;

-- Find employees earning more than the average salary.
select * from employee
where salary >(select avg(salary) from employee);

-- Find the total budget allocated to employees in each department.
select d.dept_name, sum(e.salary) from department d
join employee e on d.dept_id = e.department_id
group by e.department_id;

-- List employees and their managers (self-join).
select e1.emp_name as emp_name, e2.emp_name as manager_name from employee e1
left join employee e2 on e1.manager_id = e2.emp_id;


-- Get the latest salary of each employee from Salary_History.
select e.emp_name, max(sh.changed_date) as latest_salary_change_date from salary_history sh
join employee e
on sh.emp_id = e.emp_id
group by e.emp_id;

-- Find employees who are working under managers who earn less than them.
select * from employee e1 -- manager
join employee e2 -- employee
on e1.manager_id = e2.emp_id
where e2.salary < e1.salary;

-- Find the highest-paid employee in each department.
select e.emp_name, d.dept_name, e.salary  from department d
join employee e
on d.dept_id = e.department_id
where e.salary = (select max(e.salary) from employee where department_id = d.dept_id);

SELECT  * -- e.emp_name, d.dept_name, e.salary 
FROM department d 
JOIN employee e ON d.dept_id  = e.department_id
WHERE e.salary = (SELECT MAX(salary) FROM Employee WHERE department_id = d.dept_id);




































