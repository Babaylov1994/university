package com.foxminded.university.service;

import com.foxminded.university.dao.LectureDao;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.service.exceptions.DaoException;
import com.foxminded.university.service.exceptions.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    private LectureDao lectureDao;

    @Override
    public List<Lecture> getAll() {
        return lectureDao.getAll();
    }

    @Override
    public Optional<Lecture> getById(Integer idLecture) {
        try {
            return lectureDao.getById(idLecture);
        } catch (EmptyResultDataAccessException exception) {
            throw new DaoException("Lecture with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Lecture lecture) {
        try {
            return lectureDao.create(lecture);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("Fill out all lecture fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idLecture) {
        return lectureDao.delete(idLecture);
    }

    @Override
    public boolean updateTeacherOfLecture(int idTeacher, int idLecture) {
        try {
            return lectureDao.updateTeacherOfLecture(idTeacher, idLecture);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("Teacher with this id does not exist", exception);
        }

    }
}
