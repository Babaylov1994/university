package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        student.setIdStudent(rs.getInt("id_student"));
        student.setIdGroup(rs.getInt("id_group"));
        student.setName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        return student;
    }
}
