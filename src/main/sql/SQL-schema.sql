create database audiotracks;

use audiotracks;

create table users(
id int primary key auto_increment,
firstname varchar(50) not null,
lastname varchar(50) not null,
login varchar(50) not null,
password varchar(32) not null,
is_admin tinyint not null,
useraccount decimal(5,2) not null default 0,
userdiscount int not null default 0
);

create table albums(
id int primary key auto_increment,
name varchar(50)  not null
);

create table assemblies(
id int primary key auto_increment,
name varchar(50)  not null
);

create table tracks(
id int primary key auto_increment,
name varchar(50) not null,
album_id int not null,
assembly_id int not null,
price decimal(5,2) not null, 
Foreign Key(album_id) references albums(id),
Foreign Key(assembly_id) references assemblies(id)
);
 
create table orders(
id int primary key auto_increment,
user_id int not null,
track_id int not null,
is_paid tinyint not null default 0,
Foreign Key(user_id) references users(id),
Foreign Key(track_id) references tracks(id)
);
