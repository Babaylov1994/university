package com.foxminded.university.service;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.exceptions.DaoException;
import com.foxminded.university.service.exceptions.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Optional<Student> getById(Integer idStudent) {
        try {
            return studentDao.getById(idStudent);
        } catch (EmptyResultDataAccessException exception) {
            throw new DaoException("Student with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Student student) {
        try {
            return studentDao.create(student);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("first_name and last_name of student cannot be empty", exception);
        }
    }

    @Override
    public boolean delete(Integer idStudent) {
        return studentDao.delete(idStudent);
    }
}
