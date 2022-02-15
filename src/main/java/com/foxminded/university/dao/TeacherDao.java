package com.foxminded.university.dao;

import com.foxminded.university.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(int id);

    boolean addNewTeacher(Teacher teacher);

    boolean removeTeacher(int id);
}
