package com.foxminded.university.controller;

import com.foxminded.university.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("departments", departmentService.getAll().orElse(null));
        return "department/departmentIndex";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", departmentService.getById(id).orElse(null));
        return "department/departmentShow";
    }
}
