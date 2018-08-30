create table users(
    id int not null primary key auto_increment,
    name varchar(100) not null,
    sex int,
    birthday date,
    mail varchar(100),
    mobile varchar(30),
    nation varchar(100),
    married int
);