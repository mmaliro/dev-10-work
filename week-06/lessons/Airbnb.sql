use airbnb_nyc;

-- varchar, char, text
select * from listing where neighbourhood = 'Astoria';
select * from listing where neighbourhood = 'astoria'; -- not case sensitive
select * from listing where neighbourhood < 'M';
select * from listing where neighbourhood <= 'M';
select * from listing where neighbourhood > 'M';
select * from listing where neighbourhood >= 'M';

-- numbers (int, decimal...)
select  * from listing where price = 100.0;
select  * from listing where price < 100.0;
select  * from listing where price <= 100.0;
select  * from listing where price > 100.0;
select  * from listing where price >= 100.0;

-- dates and times
select * from listing where last_review = '2019-02-15'; -- string literal is converted to a date for comparison
select * from listing where last_review < '2019-02-15';
select * from listing where last_review <= '2019-02-15';
select * from listing where last_review > '2019-02-15';
select * from listing where last_review >= '2019-02-15';
