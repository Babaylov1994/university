package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import com.foxminded.university.dao.mappers.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_STUDENTS = "SELECT * FROM student";
    private  static final String SQL_GET_STUDENT_BY_ID = "SELECT * FROM student WHERE id_student = ?";
    private  static final String SQL_ADD_NEW_STUDENT = "INSERT INTO student(first_name, last_name) VALUES (?,?)";
    private  static final String SQL_REMOVE_STUDENT = "DELETE FROM student WHERE id_student = ?";

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        return  jdbcTemplate.query(SQL_GET_ALL_STUDENTS, new StudentRowMapper());
    }

    @Override
    public Student getStudentById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_STUDENT_BY_ID, new StudentRowMapper(), id);
    }

    @Override
    public boolean addNewStudent(Student student) {
        return jdbcTemplate.update(SQL_ADD_NEW_STUDENT, student.getName(), student.getLastName()) > 0;
    }

    @Override
    public boolean removeStudent(int id) {
        return jdbcTemplate.update(SQL_REMOVE_STUDENT, id) > 0;
    }
}
