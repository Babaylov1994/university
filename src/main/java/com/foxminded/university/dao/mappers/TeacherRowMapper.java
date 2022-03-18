package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {

        Teacher teacher = new Teacher();
        teacher.setIdTeacher(rs.getInt("id_teacher"));
        teacher.setName(rs.getString("first_name"));
        teacher.setLastName(rs.getString("last_name"));
        return teacher;
    }
}
