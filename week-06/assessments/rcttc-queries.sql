use rcttc;

-- Find all performances in the last quarter of 2021 (Oct. 1, 2021 - Dec. 31 2021).

select
show_date,
`name`
from theater_show
where show_date between '2021-10-01' and '2021-12-31';

-- List customers without duplication.
select *
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
select 
  c.first_name,
  c.last_name,
  c.email,
  ts.name show_name
from customer c
inner join ticket t on c.customer_id = t.customer_id
inner join theater_show ts on t.show_id = ts.show_id;


-- List customer, show, theater, and seat number in one query.

select 
c.first_name, 
c.last_name, 
ts.name as show_name, 
th.name, 
t.seat
from customer c
join ticket t on c.email = t.customer_id
join theater_show ts on ts.show_date = ts.show_date and ts.name = ts.name
join theater th on ts.theater_id = th.theater_id;



-- Find customers without an address.
select *
from customer
where address is null or address = '';



-- Recreate the spreadsheet data with a single query.


-- Count total tickets purchased per customer.
select c.customer_id, c.last_name, count(t.ticket_id) as total_tickets_purchased
from customer c
left join ticket t on c.customer_id = t.customer_id
group by c.customer_id;


-- Calculate the total revenue per show based on tickets sold.

select ts.name, count(*) as tickets_sold, sum(ts.ticket_price) as total_revenue
from theater_show ts 
inner join ticket t on ts.show_date = ts.show_date and ts.theater_id = ts.theater_id and ts.name = ts.name
group by ts.name;




-- Calculate the total revenue per theater based on tickets sold.
select th.`name` as theater_name, sum(ts.ticket_price) as total_revenue
from ticket t
inner join theater_show ts on t.show_id = ts.show_id
inner join theater th on ts.theater_id = th.theater_id
group by ts.theater_id;


-- Who is the biggest supporter of RCTTC? Who spent the most in 2021?








