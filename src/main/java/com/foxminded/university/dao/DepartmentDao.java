package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getAllDepartment();

    Department getDepartmentById(int idDepartment);

    boolean addNewDepartment(Department department);

    boolean removeDepartment(int idDepartment);

}
