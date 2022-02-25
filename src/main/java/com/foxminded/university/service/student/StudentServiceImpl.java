package com.foxminded.university.service.student;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.entity.Student;
import com.foxminded.university.exceptions.DaoException;
import com.foxminded.university.exceptions.SqlException;
import com.foxminded.university.service.department.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAll() {
        logger.trace("Entered method getAll");
        return studentDao.getAll();
    }

    @Override
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
    public boolean create(Student student) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create student: " + student);
            return studentDao.create(student);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all student fields");
            throw new SqlException("Fill out all student fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idStudent) {
        logger.trace("Entered method delete");
        return studentDao.delete(idStudent);
    }
}
