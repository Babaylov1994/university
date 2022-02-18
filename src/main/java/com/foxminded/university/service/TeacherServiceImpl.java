package com.foxminded.university.service;

import com.foxminded.university.dao.TeacherDao;
import com.foxminded.university.entity.Teacher;
import com.foxminded.university.service.exceptions.DaoException;
import com.foxminded.university.service.exceptions.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            return teacherDao.getById(idTeacher);
        } catch (EmptyResultDataAccessException exception) {
            throw new DaoException("Teacher with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Teacher teacher) {
        try {
            return teacherDao.create(teacher);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("first_name and last_name of teacher cannot be empty", exception);
        }
    }

    @Override
    public boolean delete(Integer idTeacher) {
        return teacherDao.delete(idTeacher);
    }
}
