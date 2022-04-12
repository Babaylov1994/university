package com.foxminded.university.rest;

import com.foxminded.university.entity.Schedule;
import com.foxminded.university.entity.Teacher;
import com.foxminded.university.rest.exception_handling.IncorrectData;
import com.foxminded.university.rest.exception_handling.NoSuchEntityException;
import com.foxminded.university.service.teacher.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @ApiOperation(value = "Returns list of teacher")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll().orElse(null);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns teacher by id")
    public Teacher getTeacherById(@PathVariable("id") int id) {
        Teacher teacher = teacherService.getById(id).orElse(null);
        if (teacher == null) {
            throw new NoSuchEntityException("There is no student with id = " +
                id + " in database");
        }
        return teacherService.getById(id).orElse(null);
    }

    @PostMapping
    @ApiOperation(value = "Create new teacher")
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {
        teacherService.create(teacher);
        return teacher;
    }
}
