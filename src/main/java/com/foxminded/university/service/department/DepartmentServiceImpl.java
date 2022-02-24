package com.foxminded.university.service.department;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.exceptions.DaoException;
import com.foxminded.university.entity.Department;
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
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAll() {
        logger.debug("Collect all departments to list");
        return departmentDao.getAll();
    }

    @Override
    public Optional<Department> getById(Integer idDepartment) {
        try {
            logger.debug("Search department with id = " + idDepartment);
            return departmentDao.getById(idDepartment);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Department with this id does not exist");
            throw new  DaoException("Department with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Department department) {
        try {
            logger.debug("start creating");
            return departmentDao.create(department);
        } catch (DataIntegrityViolationException exception) {
            logger.error("Fill out all department fields");
            throw new SqlException("Fill out all department fields", exception);
        }
    }

    @Override
    public boolean delete(Integer idDepartment) {
        logger.debug("start deleting");
        return departmentDao.delete(idDepartment);
    }
}
