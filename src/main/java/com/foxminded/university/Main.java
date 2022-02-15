package com.foxminded.university;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Student;
import com.foxminded.university.entity.Teacher;
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
        TeacherDao teacherDao = context.getBean(TeacherDao.class);
        GroupDao groupDao = context.getBean(GroupDao.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        LectureDao lectureDao = context.getBean(LectureDao.class);

        tableCreator.createTables();
        Lecture lecture = new Lecture.LectureBuilder().setIdTeacher(2)
            .setName("Bio").setDate(LocalDate.of(2022, 02, 15))
            .setStartLecture(LocalTime.of(10, 00))
            .setEndLecture(LocalTime.of(11,30)).build();

        System.out.println(lectureDao.getAllLectures());
        lectureDao.createNewLecture(lecture);
        System.out.println(lectureDao.getAllLectures());


    }
}
