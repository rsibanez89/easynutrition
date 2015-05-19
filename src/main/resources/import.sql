-- You can use this file to load seed data into the database using SQL statements

-- UserRole
insert into user_role (id, name) values (1, 'ADMIN')
insert into user_role (id, name) values (2, 'USER')

-- User
insert into user (id, username, password, enabled, role_id) values (1, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 1, 1) -- admin/admin
insert into user (id, username, password, enabled, role_id) values (2, 'user', '12dea96fec20593566ab75692c9949596833adc9', 1, 2) -- user/user

-- Patient
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (1, 'John', 'Smith', 'MALE', '1989-01-20', 'john.smith@mailinator.com', '2125551212')
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (2, 'Juan', 'Perez', 'MALE', '1970-01-01', 'juan.perez@gmail.com', '19197543700')

-- Evaluation
insert into evaluation (id, date, height, weight, patient_id) values (1, '2015-05-17', 1.70, 82, 1)

