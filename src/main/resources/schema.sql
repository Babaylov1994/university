DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS lecture;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS teacher;

CREATE TABLE schedule (
    id_schedule SERIAL PRIMARY KEY,
    date_schedule DATE
);

CREATE TABLE department (
    id_department SERIAL PRIMARY KEY,
    department_name VARCHAR(20) NOT NULL
);

CREATE TABLE teacher (
    id_teacher SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE groups (
    id_group SERIAL PRIMARY KEY,
    group_name VARCHAR(20) NOT NULL,
    id_department INT REFERENCES department(id_department) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE student (
    id_student SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    id_group INT REFERENCES groups(id_group) ON DELETE SET NULL ON UPDATE CASCADE
 );

CREATE TABLE lecture (
    id_lecture SERIAL PRIMARY KEY,
    lecture_name VARCHAR(20) NOT NULL,
    date_lecture DATE,
    start_lecture TIME,
    end_lecture TIME,
    id_teacher INT REFERENCES teacher(id_teacher) ON DELETE SET NULL ON UPDATE CASCADE
)
