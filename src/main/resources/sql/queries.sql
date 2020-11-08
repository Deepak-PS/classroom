create database notes;

insert into staff(id, staffName, password, active, roles) values(1, "John", "abc", true, "ROLE_USER");
insert into staff(id, staffName, password, active, roles) values(2, "Doe", "def", true, "ROLE_ADMIN");
insert into staff(id, staffName, password, active, roles) values(3, "Jason", "ghi", false, "ROLE_ADMIN");

SELECT * FROM staff;
