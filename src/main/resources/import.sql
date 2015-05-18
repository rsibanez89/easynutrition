-- You can use this file to load seed data into the database using SQL statements
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (1, 'John', 'Smith', 'MALE', '1989-01-20', 'john.smith@mailinator.com', '2125551212')
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (2, 'Juan', 'Perez', 'MALE', '1970-01-01', 'juan.perez@gmail.com', '19197543700')

insert into evaluation (id, date, height, weight, patient_id) values (1, '2015-05-17', 1.70, 82, 1)

insert into patient_evaluation (patient_id, evaluations_id) values (1, 1)
