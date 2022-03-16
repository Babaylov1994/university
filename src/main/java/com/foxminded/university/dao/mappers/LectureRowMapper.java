package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Lecture;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LectureRowMapper implements RowMapper<Lecture> {
    @Override
    public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

        Lecture lecture = new Lecture.LectureBuilder().setIdLecture(rs.getInt("id_lecture"))
            .setIdTeacher(rs.getInt("id_teacher"))
            .setName(rs.getString("lecture_name"))
            .setDate(rs.getDate("date_lecture").toLocalDate())
            .setStartLecture(rs.getTime("start_lecture").toLocalTime())
            .setEndLecture(rs.getTime("end_lecture").toLocalTime()).build();

        return lecture;
    }
}
