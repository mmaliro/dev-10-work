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
  `show`, 
  ticket_price, 
  `date`
from temp;

insert into theater_show (`name`, ticket_price, show_date, theater_id)
select distinct
  `show`, 
  ticket_price, 
  `date`
from temp;



-- insert into ticket (seat, customer_id, show_id)
select distinct
  t.seat, 
  c.customer_id, 
  ts.show_id
from temp t
inner join customer c on t.customer_email = c.email
join theater_show ts on t.`show` = ts.`name`
and t.ticket_price = ts.ticket_price;

  
insert into ticket (seat, customer_id, show_id)
select distinct
  t.seat, 
  c.customer_id, 
  ts.show_id
from temp t
inner join customer c on t.customer_email = c.email
inner join theater_show ts on t.`show` = ts.`name`
and t.ticket_price = ts.ticket_price;


  
-- Update the ticket price for The Sky Lit Up
select *
from theater_show;
update theater_show
set ticket_price = 22.25
where `name` = 'The Sky Lit Up'
  and show_date = '2021-03-01'
  and theater_id = (select theater_id from theater where `name` = 'The Little Fitz');
  
  
-- Adjust seating so all groups are seated together in a row.


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

delete from customer
where email = 'legleofgermanybh@blinklist.com';






  



	
	  
    
    


  
