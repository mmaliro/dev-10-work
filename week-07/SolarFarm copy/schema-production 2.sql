drop database if exists solar;

create database solar;

use solar;

create table solar (
    solar_id int primary key auto_increment,
    solar_section,
    solar_material,
    `name` varchar(50) not null,
    `row`,
    `column`,
    year_installed,
    is_tracking,
    
    
    
);