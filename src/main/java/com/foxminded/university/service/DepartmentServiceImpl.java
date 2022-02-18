package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.service.exceptions.DaoException;
import com.foxminded.university.entity.Department;
import com.foxminded.university.service.exceptions.SqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    @Override
    public Optional<Department> getById(Integer idDepartment) {
        try {
            return departmentDao.getById(idDepartment);
        } catch (EmptyResultDataAccessException exception) {
            throw new  DaoException("Department with this id does not exist", exception);
        }
    }

    @Override
    public boolean create(Department department) {
        try {
            return departmentDao.create(department);
        } catch (DataIntegrityViolationException exception) {
            throw new SqlException("Name of department cannot be empty", exception);
        }
    }

    @Override
    public boolean delete(Integer idDepartment) {
        return departmentDao.delete(idDepartment);
    }
}
