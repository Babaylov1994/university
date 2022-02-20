package com.foxminded.university;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.Department;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.service.DepartmentService;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.LectureService;
import com.foxminded.university.service.StudentService;
import com.foxminded.university.spring.config.SpringJdbcConfig;
import com.foxminded.university.util.TableCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(SpringJdbcConfig.class);

        TableCreator tableCreator = context.getBean(TableCreator.class);

        StudentService studentService = context.getBean(StudentService.class);
        GroupService groupService = context.getBean(GroupService.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        LectureService lectureService = context.getBean(LectureService.class);

        tableCreator.createTables();
        tableCreator.fillInData();

        System.out.println(groupService.addStudentInGroup(1,2));

    }
}
