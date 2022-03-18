package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import com.foxminded.university.dao.mappers.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_STUDENTS = "SELECT * FROM student";
    private static final String SQL_GET_STUDENT_BY_ID = "SELECT * FROM student WHERE id_student = ?";
    private static final String SQL_CREATE_NEW_STUDENT = "INSERT INTO student(first_name, last_name) VALUES (?,?)";
    private static final String SQL_REMOVE_STUDENT = "DELETE FROM student WHERE id_student = ?";

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAll() {
        return  jdbcTemplate.query(SQL_GET_ALL_STUDENTS, new StudentRowMapper());
    }

    @Override
    public Optional<Student> getById(Integer idStudent) {
        return Optional.ofNullable(jdbcTemplate.queryForObject
            (SQL_GET_STUDENT_BY_ID, new StudentRowMapper(), idStudent));
    }

    @Override
    public boolean create(Student student) {
        return jdbcTemplate.update(SQL_CREATE_NEW_STUDENT, student.getName(), student.getLastName()) > 0;
    }

    @Override
    public boolean delete(Integer idStudent) {
        return jdbcTemplate.update(SQL_REMOVE_STUDENT, idStudent) > 0;
    }
}
