package com.foxminded.university.service;

import com.foxminded.university.dao.TeacherDao;
import com.foxminded.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public Optional<Teacher> getById(Integer idTeacher) {
        return teacherDao.getById(idTeacher);
    }

    @Override
    public boolean create(Teacher teacher) {
        return teacherDao.create(teacher);
    }

    @Override
    public boolean delete(Integer idTeacher) {
        return teacherDao.delete(idTeacher);
    }
}
