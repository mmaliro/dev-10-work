use rcttc;

select * from temp;
select * from customer;
select * from theater;
select * from theater_show;
select * from ticket;

    
-- insert into customer (first_name, last_name, email, phone, address)
    select distinct
	  customer_first,
	  customer_last,
	  customer_email,
	  customer_phone,
	  customer_address
	from temp;
    
    insert into customer (first_name, last_name, email, phone, address)
    select distinct
	  customer_first,
	  customer_last,
	  customer_email,
	  customer_phone,
	  customer_address
	from temp;

-- insert into theater (`name`, address, phone, email)
	select  distinct
		theater, 
		theater_address, 
		theater_phone, 
		theater_email
	from temp;
    
    insert into theater (`name`, address, phone, email)
    select  distinct
		theater, 
		theater_address, 
		theater_phone, 
		theater_email
	from temp;
    
-- insert into theater_show (show_name, ticket_price, show_date , theater_id)
select distinct
  t.`show`,
  t.ticket_price,
  t.`date`,
  th.theater_id
from temp t
inner join theater th on t.theater = th.name;

insert into theater_show (`name`, ticket_price, show_date, theater_id)
select distinct
  t.`show`,
  t.ticket_price,
  t.`date`,
  th.theater_id
from temp t
inner join theater th on t.theater = th.name;




-- insert into ticket (seat, customer_id, show_id)
select *
from temp t
left join customer c on t.customer_email = c.email
left join theater_show ts on t.`show` = ts.`name` and t.date = ts.show_date and t.ticket_price = ts.ticket_price
where c.customer_id is null or ts.show_id is null;

insert into ticket (seat, customer_id, show_id)
select distinct
  t.seat, 
  c.customer_id, 
  ts.show_id
from temp t
inner join customer c on t.customer_email = c.email
inner join theater_show ts on t.`show` = ts.`name` and t.date = ts.show_date
and t.ticket_price = ts.ticket_price;



  
-- Update the ticket price for The Sky Lit Up
select *
from theater_show;
update theater_show
set ticket_price = 22.25
where `name` = 'The Sky Lit Up'
  and show_date = '2021-03-01'
  and theater_id = (select theater_id from theater where `name` = 'The Little Fitz');
  
  
-- Adjust seating in the Little Fitz's 2021-03-01 performance of The Sky Lit Up so all groups are seated together in a row.
update ticket set
seat = 'A4'
where show_id = 76;

update ticket set
seat = 'A3'
where show_id = 77;

update ticket set
seat = 'A1'
where show_id = 78;



-- Update Jammie Swindles's phone number from "801-514-8648" to "1-801-EAT-CAKE"
select *
from customer
where last_name = 'Swindles';
update customer set
phone = '1-801-EAT-CAKE'
where email = 'jswindlesd9@studiopress.com';

-- Delete all single-ticket reservations at the 10 Pin.



-- Delete the customer Liv Egle of Germany.

select 
last_name,
email
from customer
where last_name = 'Egle of Germany';


delete from ticket
where seat = 'A5' and seat = 'A6'
and customer_id in (select customer_id from customer where email = 'legleofgermanybh@blinklist.com');

delete from customer 
where email = 'legleofgermanybh@blinklist.com';
 	





  



	
	  
    
    


  
