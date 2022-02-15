package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    boolean addNewStudent(Student student);

    boolean removeStudent(int id);
}
