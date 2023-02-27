use rcttc;

-- Find all performances in the last quarter of 2021 (Oct. 1, 2021 - Dec. 31 2021).

select
show_date,
`name`
from theater_show
where show_date between '2021-10-01' and '2021-12-31';

-- List customers without duplication.
select distinct *
from customer;

-- Find all customers without a .com email address.
select * 
from customer
where email not like '%.com';

-- Find the three cheapest shows.
select `name`, ticket_price
from theater_show
order by ticket_price asc
limit 3;

-- List customers and the show they're attending with no duplication.
select distinct 
c.first_name,
c.last_name,
c.email,
ts.name show_name
from customer c
inner join theater_show ts on c.email = ts.email;



-- List customer, show, theater, and seat number in one query.


-- Find customers without an address.
select * 
from customer 
where address is null;


-- Recreate the spreadsheet data with a single query.

-- Count total tickets purchased per customer.
select c.customer_id, c.last_name, COUNT(t.ticket_id) AS total_tickets_purchased
from customer c
left join ticket t on c.customer_id = t.customer_id
group by c.customer_id;


-- Calculate the total revenue per show based on tickets sold.


-- Calculate the total revenue per theater based on tickets sold.

-- Who is the biggest supporter of RCTTC? Who spent the most in 2021?








