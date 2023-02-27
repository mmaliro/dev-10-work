drop database if exists rcttc;
create database rcttc;

use rcttc;

create table customer (
	customer_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(260) not null unique,
    phone varchar(15) not null unique,
    address varchar(255) null
    
);

create table theater (
	theater_id int primary key auto_increment,
    `name` varchar(50) not null,
	address varchar(255) null,
    phone varchar(15) not null,
    email varchar(260) not null
);

create table theater_show (
	show_id int primary key auto_increment,
    `name` varchar(50) not null,
    ticket_price decimal(4,2) not null,
    show_date date not null,
    theater_id int not null,
	constraint fk_theater_show_theater_id
		foreign key (theater_id)
		references theater(theater_id)
);

create table ticket (
	ticket_id int primary key auto_increment,
    seat varchar(2) not null,
    customer_id int not null,
    show_id int not null,
	constraint fk_ticket_customer_id
		foreign key (customer_id)
		references customer(customer_id),
	constraint fk_ticket_show_id
		foreign key (show_id)
		references theater_show(show_id)
);