package com.foxminded.university.controllers;

import com.foxminded.university.service.group.GroupService;
import com.foxminded.university.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("groups", groupService.getAll());
        return "student/studentIndex";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getById(id).orElse(null));
        return "student/studentShow";
    }


}
