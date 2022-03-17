package com.foxminded.university.service.department;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.exception.DaoException;
import com.foxminded.university.entity.Department;
import com.foxminded.university.exception.SqlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAll() {
        logger.trace("Entered method getAll");
        return departmentDao.getAll();
    }

    @Override
    public Optional<Department> getById(Integer idDepartment) {
        logger.trace("Entered method getByI");
        try {
            logger.debug("Found department with id = " + idDepartment);
            return departmentDao.getById(idDepartment);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Department with this id does not exist");
            throw new  DaoException("Department with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Department department) {
        logger.trace("Entered method create");
        try {
            logger.debug("Create department: " + department);
            return departmentDao.create(department);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all department fields");
            throw new SqlException("Fill out all department fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idDepartment) {
        logger.trace("Entered method delete");
        return departmentDao.delete(idDepartment);
    }
}
