package com.foxminded.university.service;

import com.foxminded.university.dao.LectureDao;
import com.foxminded.university.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
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
        return lectureDao.getById(idLecture);
    }

    @Override
    public boolean create(Lecture lecture) {
        return lectureDao.create(lecture);
    }

    @Override
    public boolean delete(Integer idLecture) {
        return lectureDao.delete(idLecture);
    }

    @Override
    public boolean updateTeacherOfLecture(int idTeacher, int idSchedule) {
        return lectureDao.updateTeacherOfLecture(idTeacher,idSchedule);
    }
}
