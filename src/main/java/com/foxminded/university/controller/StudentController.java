package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.group.GroupService;
import com.foxminded.university.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", studentService.getAll().orElse(null));
        model.addAttribute("groups", groupService.getAll().orElse(null));
        return "student/studentIndex";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getById(id).orElse(null));
        return "student/studentShow";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("group", new Group());
        model.addAttribute("groups", groupService.getAll().orElse(null));
        return "student/newStudent";
    }

    @PostMapping()
    public String create(Student student, Group group) {
        student.setGroup(groupService.getById(group.getIdGroup()).orElse(null));
        studentService.create(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentService.getById(id).orElse(null));
        return "student/editStudent";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student, @PathVariable("id") int id) {
       studentService.update(id, student);
       return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}
