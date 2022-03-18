package com.foxminded.university.dao.mappers;

import com.foxminded.university.entity.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {

        Department department = new Department();
        department.setIdDepartment(rs.getInt("id_department"));
        department.setName(rs.getString("department_name"));
        return department;
    }
}
