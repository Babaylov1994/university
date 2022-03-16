INSERT INTO schedule (date_schedule) VALUES
    ('14.02.2022'),
    ('15.02.2022'),
    ('16.02.2022');

INSERT INTO department (department_name) VALUES
    ('Gryffindor'),
    ('Slytherin'),
    ('Ravenclaw');

INSERT INTO groups (id_department, group_name) VALUES
    (1, 'aa-11'),
    (2, 'bb-22'),
    (3, 'cc-33');

INSERT INTO student (id_group, first_name, last_name) VALUES
    (2, 'Vova', 'Petrov'),
    (2, 'Petr', 'Volkov'),
    (1, 'Gosha', 'Dud');

INSERT INTO teacher (first_name, last_name) VALUES
    ('Galina', 'Petrova'),
    ('Ekaterina', 'Volkova'),
    ('Irina', 'Ivanova');

INSERT INTO lecture (lecture_name, id_teacher, date_lecture, start_lecture, end_lecture) VALUES
    ('Math', 1, '14.02.2022', '08:30:00', '10:00:00'),
    ('English', 2, '14.02.2022', '10:15:00', '11:45:00')
