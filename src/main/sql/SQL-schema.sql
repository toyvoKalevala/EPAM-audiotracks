create database audiotracks;

use audiotracks;

create table users(
id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
login varchar(50) not null,
password varchar(32) not null,
is_admin tinyint not null,
account decimal(5,2) not null default 0,
discount int not null default 0
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
price decimal(5,2) not null, 
Foreign Key(album_id) references albums(id)
);
 
create table orders(
id int primary key auto_increment,
user_id int not null,
track_id int not null,
is_paid tinyint not null default 0,
order_date datetime,
Foreign Key(user_id) references users(id),
Foreign Key(track_id) references tracks(id)
);

create table feedbacks(
id int primary key auto_increment,
user_id int not null,
track_id int not null,
feedback_date datetime,
feedback_text varchar(500),
Foreign Key(user_id) references users(id),
Foreign Key(track_id) references tracks(id)
);

create table tracks_assemblies(
id int primary key auto_increment,
track_id int not null,
assembly_id int not null,
Foreign Key(track_id) references tracks(id),
Foreign Key(assembly_id) references assemblies(id)
);
