package com.foxminded.university.service.student;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.entity.Student;
import com.foxminded.university.exception.DaoException;
import com.foxminded.university.exception.SqlException;
import com.foxminded.university.service.department.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public Optional<List<Student>> getAll() {
        logger.trace("Entered method getAll");
        return studentDao.getAll();
    }

    @Override
    @Transactional
    public Optional<Student> getById(Integer idStudent) {
        logger.trace("Entered method getById");
        try {
            logger.debug("Found student with id = " + idStudent);
            return studentDao.getById(idStudent);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Student with this id does not exist");
            throw new DaoException("Student with this id does not exist", exception);
        }
    }

    @Override
    @Transactional
    public void create(Student student) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create student: " + student);
            studentDao.create(student);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all student fields");
            throw new SqlException("Fill out all student fields", exception);
        }
    }

    @Override
    @Transactional
    public void delete(Integer idStudent) {
        logger.trace("Entered method delete");
        studentDao.delete(idStudent);
    }

    @Override
    @Transactional
    public void update(int idStudent, Student student) {
        logger.trace("Entered method update");
        studentDao.update(idStudent, student);
    }
}
