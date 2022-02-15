package com.foxminded.university.dao;

import com.foxminded.university.dao.mappers.DepartmentRowMapper;
import com.foxminded.university.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDaoImpl implements DepartmentDao{
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_DEPARTMENTS = "SELECT * FROM department";
    private static final String SQL_GET_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id_department = ?";
    private static final String SQL_ADD_NEW_DEPARTMENT = "INSERT INTO department(department_name) VALUES (?)";
    private static final String SQL_REMOVE_DEPARTMENT = "DELETE FROM department WHERE id_department = ?";


    @Autowired
    public DepartmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> getAllDepartment() {
        return jdbcTemplate.query(SQL_GET_ALL_DEPARTMENTS, new DepartmentRowMapper());
    }

    @Override
    public Department getDepartmentById(int idDepartment) {
        return jdbcTemplate.queryForObject(SQL_GET_DEPARTMENT_BY_ID, new DepartmentRowMapper(), idDepartment);
    }

    @Override
    public boolean addNewDepartment(Department department) {
        return jdbcTemplate.update(SQL_ADD_NEW_DEPARTMENT, department.getName()) > 0;
    }

    @Override
    public boolean removeDepartment(int idDepartment) {
        return jdbcTemplate.update(SQL_REMOVE_DEPARTMENT, idDepartment) > 0;
    }

}
