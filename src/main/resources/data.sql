INSERT INTO schedule (date_schedule) VALUES
    ('14.02.2022'),
    ('15.02.2022'),
    ('16.02.2022');

INSERT INTO teacher (first_name, last_name) VALUES
    ('Galina', 'Petrova'),
    ('Ekaterina', 'Volkova'),
    ('Irina', 'Ivanova');

INSERT INTO department (department_name) VALUES
    ('Gryffindor'),
    ('Slytherin'),
    ('Ravenclaw');

INSERT INTO lecture (lecture_name, id_teacher, date_lecture, start_lecture, end_lecture, id_schedule) VALUES
    ('Math', 1, '14.02.2022', '08:30:00', '10:00:00', 1),
    ('English', 2, '14.02.2022', '10:15:00', '11:45:00', 1);

INSERT INTO groups (id_department, group_name, id_lecture) VALUES
    (1, 'aa-11', 1),
    (2, 'bb-22', 1),
    (3, 'cc-33', 1);

INSERT INTO student (id_group, first_name, last_name) VALUES
    (2, 'Vova', 'Petrov'),
    (2, 'Petr', 'Volkov'),
    (1, 'Gosha', 'Dud')
