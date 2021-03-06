-- You can use this file to load seed data into the database using SQL statements

-- UserRole
insert into user_role (id, name) values (1, 'ADMIN')
insert into user_role (id, name) values (2, 'USER')

-- User
insert into user (id, username, password, enabled, role_id) values (1, 'admin', '$2a$10$gMtobZ5kjfAdAQaE8jjJfOfO5VogHiX2.PeBUfh3qNb6F2b23itUK', 1, 1) -- admin/admin
insert into user (id, username, password, enabled, role_id) values (2, 'user@gmail.com', '$2a$10$UvpxrrHoXmlsVUHP8CKxWuweUcK6XoDU34ouBgr2Ztrb8jx0rSIJy', 1, 2) -- user@gmail.com/user

-- Patient
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (1, 'user', 'user', 'MALE', '1989-01-20', 'user@gmail.com', '2125551212')
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (2, 'John', 'Smith', 'MALE', '1989-01-20', 'john.smith@mailinator.com', '2125551212')
insert into patient (id, first_name, last_name, gender, birthday, email, phone_number) values (3, 'Juan', 'Perez', 'MALE', '1970-01-01', 'juan.perez@gmail.com', '19197543700')

-- Evaluation
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (1, '2015-01-01', 1.75, 87, 76, 101, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (2, '2015-01-10', 1.75, 86, 74, 98, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (3, '2015-01-20', 1.75, 85.5, 73, 96, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (4, '2015-01-30', 1.75, 83, 70, 92, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (5, '2015-02-09', 1.75, 83.2, 71, 93, 'El paciente tuvo varios cumpleaños.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (6, '2015-02-18', 1.75, 84, 72, 95, 'El paciente se ha desmotivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (7, '2015-02-25', 1.75, 82, 70, 93, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (8, '2015-03-06', 1.75, 80, 68, 86, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (9, '2015-03-15', 1.75, 78, 63, 80, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (10, '2015-03-25', 1.75, 77, 62, 77, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (11, '2015-04-05', 1.75, 76, 60, 73, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (12, '2015-04-15', 1.75, 76, 60, 73, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (13, '2015-04-23', 1.75, 75, 58, 70, 'El paciente se encuentra motivado.', 1)
insert into evaluation (id, date, height, weight, waist_circumference, hip_circumference, observation, patient_id) values (14, '2015-05-03', 1.75, 74, 55, 68, 'El paciente fue dado de alta.', 1)

