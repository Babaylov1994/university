package com.foxminded.university.service;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
        return studentDao.getById(idStudent);
    }

    @Override
    public boolean create(Student student) {
        return studentDao.create(student);
    }

    @Override
    public boolean delete(Integer idStudent) {
        return studentDao.delete(idStudent);
    }
}
