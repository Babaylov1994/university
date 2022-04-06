package com.foxminded.university.rest;

import com.foxminded.university.entity.Department;
import com.foxminded.university.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public List<Department> getAllDepartments() {
        return departmentService.getAll().orElse(null);
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") int id) {
        return departmentService.getById(id).orElse(null);
    }
}
