drop table ers_users;
drop table ers_user_roles;
drop table ers_reimbursement;
drop table ers_reimbursement_type;
drop table ers_reimbursement_status;

create table ers_user_roles(
	ers_user_role_id int primary key,
	user_role varchar(10) not null unique
);

create table ers_reimbursement_type(
	reimb_type_id int primary key,
	reimb_type varchar(10) not null unique
);

create table ers_reimbursement_status(
	reimb_status_id int primary key,
	reimb_status varchar(10) not null unique
);


create table ers_users(
	ers_user_id serial primary key,
	ers_username varchar(50) unique,
	ers_password varchar(50) not null,
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150),
	user_role_id int references ers_user_roles(ers_user_role_id)

);

create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_author int references ers_users(ers_user_id) not null,
	reimb_resolver int references ers_users(ers_user_id),
	reimb_status_id int references ers_reimbursement_status(reimb_status_id) default(0),
	reimb_amount float8 not null,
	reimb_receipt bytea,
	reimb_submitted timestamp not null,
	reimb_resolved timestamp,
	reimb_type_id int references ers_reimbursement_type(reimb_type_id) not null,
	reimb_description text
	
);

insert into ers_user_roles (ers_user_role_id, user_role) values (1, 'Employee'), (2, 'Manager');
insert into ers_reimbursement_status (reimb_status_id, reimb_status) values (0, 'Pending'), (1, 'Accepted'), (2, 'Rejected');
insert into ers_reimbursement_type (reimb_type_id, reimb_type) values (1, 'Lodging'), (2, 'Food'), (3, 'Travel');
insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) 
	values 
	('AnotherEmp', '123', 'Emp', 'Test', 'test2@rev.com', 1);
--	('TestEmployee', '123', 'Test', 'Emp', 'tester@rev.com', 1), 
--	('TestManager', '321', 'Test', 'Mana', 'test@rev.com', 2);
insert into ers_reimbursement(reimb_author, reimb_status_id, reimb_amount, reimb_submitted, reimb_type_id, reimb_description)
	values (1,0,99.99,CURRENT_TIMESTAMP,2,'Another test');


select * from ers_users where ers_username = 'TestEmployee';
update ers_reimbursement set reimb_amount = 19.99 where reimb_id = 5;