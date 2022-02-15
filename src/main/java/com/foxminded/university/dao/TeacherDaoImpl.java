package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.TeacherRowMapper;
import com.foxminded.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_TEACHERS = "SELECT * FROM teacher";
    private static final String SQL_GET_TEACHER_BY_ID = "SELECT * FROM teacher WHERE id_teacher = ?";
    private static final String SQL_ADD_NEW_TEACHER = "INSERT INTO teacher(first_name, last_name) VALUES (?, ?)";
    private static final String SQL_REMOVE_TEACHER = "DELETE FROM teacher WHERE id_teacher = ?";

    @Autowired
    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return jdbcTemplate.query(SQL_GET_ALL_TEACHERS, new TeacherRowMapper());
    }

    @Override
    public Teacher getTeacherById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_TEACHER_BY_ID, new TeacherRowMapper(), id);
    }

    @Override
    public boolean addNewTeacher(Teacher teacher) {
        return jdbcTemplate.update(SQL_ADD_NEW_TEACHER, teacher.getName(), teacher.getLastName()) > 0;
    }

    @Override
    public boolean removeTeacher(int id) {
        return jdbcTemplate.update(SQL_REMOVE_TEACHER, id) > 0;
    }
}
