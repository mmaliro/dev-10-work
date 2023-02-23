use gravel_family;

-- Solve each task by writing a query below the task description.
-- Each task describes the expected result.
-- Unfortunately, tasks must be verified manually. :(

-- Example: 
-- Count the number of customers in Toronto
-- Expected: 14
select count(*)
from customer
where city = 'Toronto';

-- How many employees have the last_name 'Soyle'?
-- Expected: 12

select count(*) as employee_count
from employee 
where last_name = 'Soyle';

-- How many projects are there in the database?
-- Expected: 1121

select count(*) as project_count
from project;

-- What's the earliest project start_date?
-- Expected: 2017-09-23

select min(start_date) as earliest_start_date
from project;


-- What's the latest employee start_date?
-- Expected: 2020-08-25

select max(start_date) as latest_start_date
from employee;

-- Count customers per city.
-- Expected: 88 Rows

select city, count(*) as customer_count
from customer
group by city;


-- Count customers per postal_code.
-- Expected: 84 Rows

select postal_code, count(*) as customer_count
from customer
group by postal_code;

-- Count employees per last_name.
-- Expected: 3 Rows

select last_name, count(*) as employee_count
from employee
group by last_name;

-- Count the number of projects per city.
-- Expected: 88 Rows

select c.city, count(distinct p.project_id) as project_count
from project p
inner join customer c on p.customer_id = c.customer_id
group by c.city
order by c.city;


-- Count the number of projects per city.
-- Sort by the count descending and select the top 10 rows.
-- Expected: 10 Rows

select c.city, count(distinct p.project_id) as project_count
from project p
inner join customer c on p.customer_id = c.customer_id
group by c.city
order by project_count desc
limit 10;

-- Which postal_code has the most projects?
-- Expected: M3H

select postal_code, count(*) as project_count
from project
join customer on project.customer_id = customer.customer_id
group by postal_code
order by project_count DESC
limit 1;


-- Count the number of projects per start_date year.
-- Expected: 4 Rows

select year(start_date) as start_year, count(*) as project_count
from project
group by start_year;

-- Count the number of employees per project in the M3H postal_code.
-- Group by project_id, sort by count descending.
-- Expected: 39 Rows


select p.project_id, count(e.employee_id) as employee_count
from project p
join project_employee pe on p.project_id = pe.project_id
join employee e on pe.employee_id = e.employee_id
join customer c on p.customer_id = c.customer_id
where c.postal_code = 'M3H'
group by p.project_id
order by employee_count desc;


-- Calculate the total cost per project in the 'M3H' postal_code.
-- (Hint: sum a calculation)
-- Expected: 39 Rows

select p.project_id, sum(pi.quantity * i.price_per_unit) as total_cost
from project p
join project_item pi on p.project_id = pi.project_id
join item i on pi.item_id = i.item_id
join customer c on p.customer_id = c.customer_id
where c.postal_code = 'M3H'
group by p.project_id;



-- What's the most expensive project in the 'M3H' postal_code?
-- Expected: 18828.00

select p.project_id, sum(pi.quantity * i.price_per_unit) as total_cost
from project p
join project_item pi on p.project_id = pi.project_id
join item i on pi.item_id = i.item_id
join customer c ON p.customer_id = c.customer_id
where c.postal_code = 'M3H'
group by p.project_id
order by total_cost desc
limit 1;


-- How many projects did each employee work on?
-- Expected: 33 Rows

select pe.employee_id, count(distinct pe.project_id) as project_count
from project_employee pe
group by pe.employee_id;


-- How many employees worked on more than 140 projects?
-- Expected: 10 Rows

select employee_id, count(*) as num_projects
from project_employee
group by employee_id
having count(*) > 140;

-- How many projects cost more than $20,000?
-- Expected: 55 Rows

select p.project_id, sum(pi.quantity * i.price_per_unit) as total_cost
from project p
join project_item pi on p.project_id = pi.project_id
join item i on pi.item_id = i.item_id
group by p.project_id
having total_cost > 20000;

-- Across all projects, what are the total costs per item?
-- Select the item name and sum.
-- Sort by the sum desc;
-- Expected: 18 Rows

select i.name, sum(pi.quantity * i.price_per_unit) as total_cost
from project_item pi
join item i on pi.item_id = i.item_id
group by i.name
order by total_cost desc;

-- Across all projects, what are the total costs per item category?
-- Select the category name and sum.
-- Sort by the sum desc;
-- Expected: 7 Rows

select c.name as category_name, sum(pi.quantity * i.price_per_unit) as total_cost
from project p
join project_item pi on p.project_id = pi.project_id
join item i on pi.item_id = i.item_id
join category c on i.category_id = c.category_id
group by c.name
order by total_cost desc;

-- What's the average 'Standard Labor' cost per city?
-- Expected: 88 Rows

select c.city, avg(i.price_per_unit) as avg_standard_labor_cost
from customer c
left outer join project p on c.customer_id = p.customer_id
left outer join project_item pi on p.project_id = pi.project_id
left outer join item i on pi.item_id = i.item_id
left outer join category cat on i.category_id = cat.category_id and cat.name = 'Standard Labor'
group by c.city;

-- Challenge: Which customer has the first project of 2019?
-- (Requires a subquery.)
-- Expected: Starkie 2019-01-01
