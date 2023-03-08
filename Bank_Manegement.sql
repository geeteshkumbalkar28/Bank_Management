create database Bank_Management;

use Bank_Management;
show databases;
drop database Bank_Management;
create database bank_management_system;
use bank_management_system;

create table customerDetails(CustomerID int auto_increment primary key,
FirstName varchar(30),
MiddleName varchar(30),
LastName varchar(30),
MobileNumber bigint(12) unique );
insert into customerDetails(CustomerID,FirstName,MiddleName,LastName,MobileNumber) values ('1','Geetesh','Gajanan','Kumbalkar',7447376717),
('2','Dipak','Rohan','Khaprde',9822564471),
('3','Somya','Sourabh','Sharma',7549654895),
('4','Vinayak','Suresh','Gormule',84425645785);
drop table customerdetails;
select * from customerDetails;

create table accountDetails(Customer_Id int auto_increment primary key, Account_Number int (15), Account_Type varchar(10), Account_Balance int (10), Branch_Code int (10),foreign key (Customer_Id) references customerDetails (CustomerId));
drop table accountDetails;
insert into accountDetails(Customer_Id, Account_Number,Account_Type,Account_Balance,Branch_Code) values ('001','11111','savings','10000','78'),
('2','22222','savings','20000','78'),
('3','33333','current','30000','78'),
('4','44444','current','40000','78');
select * from accountDetails;
select * from accountDetails where Account_Number ='22222';
#update accountdetails set Account_Balance = 70000 where Customer_Id= 1;
#drop table accountDetails;

#select * from customerdetails , accountDetails;


