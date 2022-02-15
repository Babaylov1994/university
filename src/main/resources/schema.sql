DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS group_student;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS lecture;

CREATE TABLE student (
    id_student SERIAL PRIMARY KEY,
    id_group INT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL
 );

CREATE TABLE teacher (
    id_teacher SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE group_student (
    id_group SERIAL PRIMARY KEY,
    id_department INT,
    group_name VARCHAR(20) NOT NULL
);

CREATE TABLE department (
    id_department SERIAL PRIMARY KEY,
    department_name VARCHAR(20) NOT NULL
);

CREATE TABLE lecture (
    id_lecture SERIAL PRIMARY KEY,
    lecture_name VARCHAR(20) NOT NULL,
    id_teacher INT,
    date_lecture date,
    start_lecture time,
    end_lecture time
);

INSERT INTO student (id_group, first_name, last_name) VALUES
    (2, 'Vova', 'Petrov'),
    (2, 'Petr', 'Volkov'),
    (1, 'Gosha', 'Dud');

INSERT INTO teacher (first_name, last_name) VALUES
    ('Galina', 'Petrova'),
    ('Ekaterina', 'Volkova'),
    ('Irina', 'Ivanova');

INSERT INTO group_student (id_department, group_name) VALUES
    (1, 'aa-11'),
    (2, 'bb-22'),
    (3, 'cc-33');

INSERT INTO department (department_name) VALUES
    ('Gryffindor'),
    ('Slytherin'),
    ('Ravenclaw');

INSERT INTO lecture (lecture_name, id_teacher, date_lecture, start_lecture, end_lecture) VALUES
    ('Math', 1, '14.02.2022', '08:30:00', '10:00:00')
