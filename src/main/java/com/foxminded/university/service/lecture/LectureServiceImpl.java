package com.foxminded.university.service.lecture;

import com.foxminded.university.dao.LectureDao;
import com.foxminded.university.entity.Lecture;
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
public class LectureServiceImpl implements LectureService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private LectureDao lectureDao;

    @Override
    @Transactional
    public Optional<List<Lecture>> getAll() {
        logger.trace("Entered method getAll");
        return lectureDao.getAll();
    }

    @Override
    @Transactional
    public Optional<Lecture> getById(Integer idLecture) {
        logger.trace("Entered method getById");
        try {
            logger.debug("Found lecture with id = " + idLecture);
            return lectureDao.getById(idLecture);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Lecture with this id does not exist");
            throw new DaoException("Lecture with this id does not exist", exception);
        }
    }

    @Override
    @Transactional
    public void create(Lecture lecture) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create lecture: " + lecture);
            lectureDao.create(lecture);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all lecture fields");
            throw new SqlException("Fill out all lecture fields", exception);
        }
    }

    @Override
    @Transactional
    public void delete(Integer idLecture) {
        logger.trace("Entered method delete");
        lectureDao.delete(idLecture);
    }
}
