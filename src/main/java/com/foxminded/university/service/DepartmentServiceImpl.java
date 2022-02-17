package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return departmentDao.getById(idDepartment);
    }

    @Override
    public boolean create(Department department) {
        return departmentDao.create(department);
    }

    @Override
    public boolean delete(Integer idDepartment) {
        return departmentDao.delete(idDepartment);
    }
}
