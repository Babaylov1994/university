package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.TeacherRowMapper;
import com.foxminded.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_TEACHERS = "SELECT * FROM teacher";
    private static final String SQL_GET_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id_teacher = ?";
    private static final String SQL_CREATE_NEW_TEACHER = "INSERT INTO teacher(first_name, last_name) VALUES (?, ?)";
    private static final String SQL_REMOVE_TEACHER = "DELETE FROM teacher WHERE id_teacher = ?";

    @Autowired
    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Teacher> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_TEACHERS, new TeacherRowMapper());
    }

    @Override
    public Optional<Teacher> getById(Integer idTeacher) {
        return Optional.ofNullable(jdbcTemplate.queryForObject
            (SQL_GET_TEACHER_BY_ID, new TeacherRowMapper(), idTeacher));
    }

    @Override
    public boolean create(Teacher teacher) {
        return jdbcTemplate.update(SQL_CREATE_NEW_TEACHER, teacher.getName(), teacher.getLastName()) > 0;
    }

    @Override
    public boolean delete(Integer idTeacher) {
        return jdbcTemplate.update(SQL_REMOVE_TEACHER, idTeacher) > 0;
    }
}
