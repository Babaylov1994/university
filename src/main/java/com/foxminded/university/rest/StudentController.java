package com.foxminded.university.rest;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import com.foxminded.university.rest.exception_handling.IncorrectData;
import com.foxminded.university.rest.exception_handling.NoSuchEntityException;
import com.foxminded.university.service.group.GroupService;
import com.foxminded.university.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll().orElse(null);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        Student student = studentService.getById(id).orElse(null);
        if (student == null) {
            throw new NoSuchEntityException("There is no student with id = " +
                id + " in database");
        }
        return studentService.getById(id).orElse(null);
    }

    @PostMapping()
    public Student addNewStudent(@RequestBody Student student) {
        studentService.create(student);
        return student;
    }

    @PutMapping()
    public Student update(@RequestBody Student student) {
       Student updatingStudent = studentService.getById(student.getIdStudent()).orElse(null);
       if (updatingStudent == null) {
           throw new NoSuchEntityException("There is no student with id = " +
               student.getIdStudent() + " in database");
       }
       studentService.update(student.getIdStudent(), student);
       return student;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        Student student = studentService.getById(id).orElse(null);
        if (student == null) {
            throw new NoSuchEntityException("There is no student with id = " +
                id + " in database");
        }
        studentService.delete(id);
        return "Student with id = " + id + " was deleted";
    }
}
