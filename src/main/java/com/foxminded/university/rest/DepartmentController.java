package com.foxminded.university.rest;

import com.foxminded.university.entity.Department;
import com.foxminded.university.rest.exception_handling.IncorrectData;
import com.foxminded.university.rest.exception_handling.NoSuchEntityException;
import com.foxminded.university.service.department.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @ApiOperation(value = "Returns list of department")
    public List<Department> getAllDepartments() {
        return departmentService.getAll().orElse(null);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns department by id")
    public Department getDepartmentById(@PathVariable("id") int id) {
        Department department = departmentService.getById(id).orElse(null);
        if (department == null) {
            throw new NoSuchEntityException("There is no department with id = " +
                id + " in database");
        }
        return departmentService.getById(id).orElse(null);
    }

    @PostMapping
    @ApiOperation(value = "Create new department")
    public Department addNewDepartment(@RequestBody Department department) {
        departmentService.create(department);
        return department;
    }
}
