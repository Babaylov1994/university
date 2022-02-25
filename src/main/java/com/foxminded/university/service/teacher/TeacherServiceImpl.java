package com.foxminded.university.service.teacher;

import com.foxminded.university.dao.TeacherDao;
import com.foxminded.university.entity.Teacher;
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
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAll() {
        logger.trace("Entered method getAll");
        return teacherDao.getAll();
    }

    @Override
    public Optional<Teacher> getById(Integer idTeacher) {
        logger.trace("Entered method getById");
        try {
            logger.debug("Found teacher with id = " + idTeacher);
            return teacherDao.getById(idTeacher);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Teacher with this id does not exist");
            throw new DaoException("Teacher with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Teacher teacher) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create teacher: " + teacher);
            return teacherDao.create(teacher);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all teacher fields");
            throw new SqlException("Fill out all teacher fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idTeacher) {
        logger.trace("Entered method delete");
        return teacherDao.delete(idTeacher);
    }
}
