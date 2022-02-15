package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Student.class)
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDAO;

    @Test
    public void getAllStudent_ShouldReturnListAllStudents() {
        System.out.println(studentDAO);
    }


}
