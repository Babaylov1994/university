package com.foxminded.university.service.group;

import com.foxminded.university.dao.GroupDao;
import com.foxminded.university.entity.Group;
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

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAll() {
        logger.trace("Entered method getAll");
        return groupDao.getAll();
    }

    @Override
    public Optional<Group> getById(Integer idGroup) {
        logger.trace("Entered method getById");
        try {
            logger.debug("Found group with id = " + idGroup);
            return groupDao.getById(idGroup);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Group with this id does not exist");
            throw new DaoException("Group with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Group group) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create group: " + group);
            return groupDao.create(group);
        } catch (DataIntegrityViolationException exception){
            logger.error("Fill out all group fields");
            throw new SqlException("Fill out all group fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idGroup) {
        logger.trace("Entered method delete");
        return groupDao.delete(idGroup);
    }

    @Override
    public List<Student> getListStudentFromGroup(int idGroup) {
        logger.trace("Entered method getListStudentFromGroup");
        return groupDao.getListStudentFromGroup(idGroup);
    }

    @Override
    public boolean addStudentInGroup(int idGroup, int idStudent) {
        logger.trace("Entered method addStudentInGroup");
        try {
            logger.debug("Found group with id = " + idGroup + "Found student with id = " + idStudent);
            return groupDao.addStudentInGroup(idGroup, idStudent);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Group or student with this id does not exist");
            throw new SqlException("Group or student with this id does not exist", exception);
        }
    }
}
