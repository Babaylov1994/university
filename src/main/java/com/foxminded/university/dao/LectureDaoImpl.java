package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.LectureRowMapper;
import com.foxminded.university.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LectureDaoImpl implements LectureDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_LECTURE = "SELECT * FROM lecture";
    private static final String SQL_GET_LECTURE_BY_ID = "SELECT * FROM lecture WHERE id_lecture = ?";
    private static final String SQL_CREATE_NEW_LECTURE = "INSERT INTO lecture(lecture_name, id_teacher, "
        + "date_lecture, start_lecture, end_lecture) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_REMOVE_LECTURE = "DELETE FROM lecture WHERE id_lecture = ?";
    private static final String SQL_UPDATE_TEACHER_OF_LECTURE = "UPDATE FROM lecture SET id_teacher = ? " +
        "WHERE id_lecture = ?";

    @Autowired
    public LectureDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lecture> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_LECTURE, new LectureRowMapper());
    }

    @Override
    public Optional<Lecture> getById(Integer idLecture) {
        return Optional.ofNullable(jdbcTemplate.queryForObject
            (SQL_GET_LECTURE_BY_ID, new LectureRowMapper(), idLecture));
    }

    @Override
    public boolean create(Lecture lecture) {
        return jdbcTemplate.update(SQL_CREATE_NEW_LECTURE, lecture.getName(),
            lecture.getIdTeacher(), lecture.getDate(), lecture.getStartLecture(),
            lecture.getEndLecture()) > 0;
    }

    @Override
    public boolean delete(Integer idLecture) {
        return jdbcTemplate.update(SQL_REMOVE_LECTURE, idLecture) > 0;
    }

    @Override
    public boolean updateTeacherOfLecture(int idTeacher, int idLecture) {
        return jdbcTemplate.update(SQL_UPDATE_TEACHER_OF_LECTURE, idTeacher, idLecture) > 0;
    }
}
