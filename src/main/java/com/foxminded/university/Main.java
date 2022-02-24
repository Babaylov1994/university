package com.foxminded.university;

import com.foxminded.university.service.department.DepartmentService;
import com.foxminded.university.service.group.GroupService;
import com.foxminded.university.service.lecture.LectureService;
import com.foxminded.university.service.student.StudentService;
import com.foxminded.university.spring.config.SpringJdbcConfig;
import com.foxminded.university.util.TableCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

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

        departmentService.getById(6);

    }
}
